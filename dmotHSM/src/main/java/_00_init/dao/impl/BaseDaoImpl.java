package _00_init.dao.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import _00_init.dao.BaseDao;
import _00_init.util.DBService;
import _00_init.util.GlobalService;
import _01_register.model.MemberBean;
import _03_listBooks.model.BookBean;
import _03_listBooks.model.CompanyBean;

@Repository
public class BaseDaoImpl implements BaseDao {
	public static final String UTF8_BOM = "\uFEFF"; // 定義BOM字元

	private static Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);

	SessionFactory factory;

	ServletContext servletContext;

	@Autowired
	public BaseDaoImpl(SessionFactory factory, ServletContext servletContext) {
		this.factory = factory;
		this.servletContext = servletContext;
	}

	@Override
	public void loadInitData() {

		String line = "";
		int count = 0;

		Session session = factory.getCurrentSession();
		try {
			// 1. BookCompany表格
			// 1-1 由"/WEB-INF/data/bookCompany.dat"逐筆讀入BookCompany表格內的初始資料，
			// 然後依序新增到BookCompany表格中
			try (
				InputStream is = servletContext.getResourceAsStream("/WEB-INF/data/bookCompany.dat");
				BufferedReader br = new BufferedReader(new InputStreamReader(is))
			) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					String name = token[0];
					String address = token[1];
					String url = token[2];
					CompanyBean cb = new CompanyBean(null, name, address, url);
					session.save(cb);
					count++;
				}
				log.info("BookCompany 資料新增成功，紀錄個數: " + count);
			} catch (IOException e) {
				log.info("新建BookCompany資料時發生IO例外: " + e.getMessage());
				e.printStackTrace();
			}
			session.flush();
			// 2. Book表格
			count = 0;
			String realPath = servletContext.getRealPath("/WEB-INF/");
			log.info("realPath=" + realPath);
			// 2-1 由"/WEB-INF/data/book.dat"逐筆讀入Book表格內的初始資料，然後依序新增到Book表格中
			try (
				InputStream is = servletContext.getResourceAsStream("/WEB-INF/data/book.dat");
				BufferedReader br = new BufferedReader(new InputStreamReader(is))
			) {
				while ((line = br.readLine()) != null) {
					log.info("line=" + line);
					// 去除 UTF8_BOM: \uFEFF
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					BookBean book = new BookBean();
					book.setTitle(token[0]);
					book.setAuthor(token[1]);
					book.setListPrice(Double.parseDouble(token[2].trim()));
					book.setDiscount(Double.parseDouble(token[3].trim()));
					book.setCompanyId(Integer.parseInt(token[4].trim()));
					int companyId = Integer.parseInt(token[4].trim());
					CompanyBean cb = session.get(CompanyBean.class, companyId);
					book.setCompanyBean(cb);
					// 讀取圖片檔
					Blob blob = GlobalService.fileToBlob(realPath + "/" + token[5].trim());
					book.setCoverImage(blob);
					book.setFileName(GlobalService.extractFileName(token[5].trim()));
					book.setBookNo(token[6].trim());
					book.setStock(Integer.parseInt(token[7].trim()));
					book.setCategory(token[8].trim());
					book.setMimeType(servletContext.getMimeType(book.getFileName()));
					session.save(book);
					count++;
				}
				// 印出資料新增成功的訊息
				log.info("Book資料新增成功，紀錄個數: " + count);
			}
			session.flush();
			// 3. Member表格
			// 3-1由"data/Input.txt"逐筆讀入Member表格內的初始資料，
			// 然後依序新增到Member表格中
			count = 0;
			try (
				InputStream is = servletContext.getResourceAsStream("/WEB-INF/data/Input.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			) {
				while ((line = br.readLine()) != null) {
					String[] sa = line.split("\\|");
					MemberBean bean = new MemberBean();
					bean.setMemberId(sa[0]);
					bean.setName(sa[1]);
					String pswd = GlobalService.getMD5Endocing(GlobalService.encryptString(sa[2]));
					bean.setPassword(pswd);
					bean.setAddress(sa[3]);
					bean.setEmail(sa[4]);
					bean.setTel(sa[5]);
					bean.setUserType(sa[6]);
					bean.setTotalAmt(Double.parseDouble(sa[7]));
					bean.setTs(new java.sql.Timestamp(System.currentTimeMillis()));
					// --------------處理Blob(圖片)欄位----------------
					Blob sb = GlobalService.fileToBlob(realPath + "/" + sa[8]);
					bean.setMemberImage(sb);
					String imageFileName = sa[8].substring(sa[8].lastIndexOf("/") + 1);
					bean.setFileName(imageFileName);
					Clob clob = GlobalService.fileToClob(realPath + "/" + sa[9]);
					bean.setComment(clob);
					bean.setUnpaid_amount(0.0);
					bean.setMimeType(servletContext.getMimeType(bean.getFileName()));
					session.save(bean);
					count++;
				}
				log.info("新增Member紀錄，計" + count + "筆記錄");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			System.err.println("新增Member紀錄時發生SQL例外: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("新增Member紀錄時發生IO例外: " + e.getMessage());
		}
	}

	@Override
	public void rebuildTableAndIndex() {
		Session session = factory.getCurrentSession();

		String realPath = servletContext.getRealPath("/");

		String fileOfSqlCommand = "";
		if (DBService.DB_TYPE.equals(DBService.DB_MYSQL)) {
			fileOfSqlCommand = "/WEB-INF/data/ResetTableSchemaMySQL.txt";
		} else if (DBService.DB_TYPE.equals(DBService.DB_SQLSERVER)) {
			fileOfSqlCommand = "/WEB-INF/data/ResetTableSchemaSQLServer.txt";
		}
		try (FileInputStream fis = new FileInputStream(realPath + fileOfSqlCommand);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));) {
			String line = "";
			String sql = "";
			while ((line = br.readLine()) != null) {
				if (line.indexOf("Hibernate") >= 0 || line.trim().length() == 0) {
					if (sql.length() > 0) {
						log.info("sql=" + sql);
						try {
							NativeQuery<?> query = session.createNativeQuery(sql);
							query.executeUpdate();
						} catch (Exception e) {
							log.info("已攔截例外:" + e.getMessage());
							// e.printStackTrace();
						}
						sql = "";
					}
					continue;
				}
				sql += line.trim() + " ";
			}
			if (sql.length() > 0) {
				log.info("Last SQL=" + sql);
				try {
					NativeQuery<?> query = session.createNativeQuery(sql);
					query.executeUpdate();
				} catch (Exception e) {
					log.info("已攔截例外:" + e.getMessage());
				}
				sql = "";
			} else {
				log.info("Last SQL is Empty.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		String sqlyPrefix = "ALTER TABLE Member AUTO_INCREMENT = 1";
//		
//		String sqlsPrefix = "DBCC CHECKIDENT ('dbo.Member', RESEED, 0);";
	}

}
