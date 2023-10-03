package com.ispan.eeit._00_init.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.ispan.eeit._00_common.GlobalService;
import com.ispan.eeit._00_init.dao.BaseRepository;
import com.ispan.eeit._01_register.model.Member;
import com.ispan.eeit._03_listBooks.model.Book;
import com.ispan.eeit._03_listBooks.model.Publisher;

@Repository
public class BaseRepositoryImpl implements BaseRepository {
	public static final String UTF8_BOM = "\uFEFF"; // 定義BOM字元

	private static Logger log = LoggerFactory.getLogger(BaseRepositoryImpl.class);

	@PersistenceContext
	EntityManager entityManager;  
	
	ServletContext servletContext;

	@Autowired
	public BaseRepositoryImpl(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public void loadInitData() {

		String line = "";
		int count = 0;
		try {
			// 1. Publisher表格
			// 1-1 由"/WEB-INF/data/publisher.dat"逐筆讀入Publisher表格內的初始資料，
			// 然後依序新增到Publisher_Table表格中
			ClassPathResource cpr = new ClassPathResource("/data/publisher.dat");	
			try (
				InputStream is = cpr.getInputStream();
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
					Publisher cb = new Publisher(null, name, address, url);
					entityManager.persist(cb);
					count++;
				}
				log.info("Publisher 資料新增成功，紀錄個數: " + count);
			}
		} catch(Exception e) {
			log.info("新建Publisher資料時發生IO例外: " + e.getMessage());
			e.printStackTrace();
		}
		entityManager.flush();
			// 2. Book表格
			count = 0;
//			String realPath = servletContext.getRealPath("/WEB-INF/");
//			log.info("realPath=" + realPath);
			// 2-1 由"/WEB-INF/data/book.dat"逐筆讀入Book表格內的初始資料，然後依序新增到Book表格中
			ClassPathResource cpr = new ClassPathResource("/data/book.dat");	
			try (
				InputStream is = cpr.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is))
			) {
				while ((line = br.readLine()) != null) {
					log.info("line=" + line);
					// 去除 UTF8_BOM: \uFEFF
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					Book book = new Book();
					book.setTitle(token[0]);
					book.setAuthor(token[1]);
					book.setListPrice(Double.parseDouble(token[2].trim()));
					book.setDiscount(Double.parseDouble(token[3].trim()));
//					
					Long publisherId = Long.parseLong(token[4].trim());
					Publisher publisher = entityManager.find(Publisher.class, publisherId);
					book.setPublisher(publisher);
					book.setFileName(GlobalService.extractFileName(token[5].trim()));
					String mimeType = servletContext.getMimeType(book.getFileName()); 
					book.setMimeType(mimeType);
					// 讀取圖片檔
					ClassPathResource imageCPR = new ClassPathResource(token[5].trim());
					String dataUri = GlobalService.classPathResourceToDataUri(imageCPR, mimeType);
					book.setCoverImage(dataUri);
					book.setBookNo(token[6].trim());
					book.setStock(Integer.parseInt(token[7].trim()));
					book.setCategory(token[8].trim());
					entityManager.persist(book);
					count++;
				}
				// 印出資料新增成功的訊息
				log.info("Book資料新增成功，紀錄個數: " + count);
			} catch (Exception e) {
				log.info("新建Book資料時發生IO例外: " + e.getMessage());
				e.printStackTrace();
			}
			entityManager.flush();
			// 3. Member表格
			// 3-1由"data/Input.txt"逐筆讀入Member表格內的初始資料，
			// 然後依序新增到Member表格中
			count = 0;
			cpr = new ClassPathResource("/data/Input.txt");
			try (
				InputStream is = cpr.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			) {
				while ((line = br.readLine()) != null) {
					String[] sa = line.split("\\|");
					Member member = new Member();
					member.setMemberId(sa[0]);
					member.setName(sa[1]);
					String password = GlobalService.encodeBCryptPassword(sa[2]);
					member.setPassword(password);
					member.setAddress(sa[3]);
					member.setEmail(sa[4]);
					member.setPhone(sa[5]);
					member.setUserType(sa[6]);
					member.setTotalAmt(Double.parseDouble(sa[7]));
					member.setTs(new java.sql.Timestamp(System.currentTimeMillis()));
					// --------------處理Clob(圖片)欄位----------------
					ClassPathResource imageCPR = new ClassPathResource(sa[8].trim());
					
//					String mimeType = servletContext.getMimeType(sa[8].trim());
					
					byte[] b = GlobalService.classPathResourceToByteArray(imageCPR);
					
//					Clob clobMember = new SerialClob(dataUri.toCharArray());
					
					member.setMemberImage(b);
					String imageFileName = sa[8].substring(sa[8].lastIndexOf("/") + 1);
					member.setFileName(imageFileName);
					ClassPathResource commentCPR = new ClassPathResource(sa[9].trim());
//					Clob clob = GlobalService.classPathResourceToClob(commentCPR);
					String clob = GlobalService.classPathResourceToString(commentCPR);
					member.setComment(clob);
					member.setUnpaid_amount(0.0);
					member.setMimeType(servletContext.getMimeType(member.getFileName()));
					entityManager.persist(member);
					count++;
				}
				log.info("新增Member紀錄，計" + count + "筆記錄");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
	}

	@Override
	public void rebuildTableAndIndex() {

		String fileOfSqlCommand = "";
		if (GlobalService.DB_TYPE.equals(GlobalService.DB_MYSQL)) {
			fileOfSqlCommand = "data/ResetTableSchemaMySQL.txt";
		} else if (GlobalService.DB_TYPE.equals(GlobalService.DB_SQLSERVER)) {
			fileOfSqlCommand = "data/ResetTableSchemaSQLServer.txt";
		}
		ClassPathResource  classPathResource = new ClassPathResource(fileOfSqlCommand);
		try (
			InputStream is = classPathResource.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
			String line = "";
			String sql = "";
			while ((line = br.readLine()) != null) {
				if (line.indexOf("Hibernate") >= 0 || line.trim().length() == 0) {
					if (sql.length() > 0) {
						log.info("sql=" + sql);
						try {
							Query query = entityManager.createNativeQuery(sql);
							query.executeUpdate();
						} catch (Exception e) {
							log.info("已攔截例外:" + e.getMessage());
							e.printStackTrace();
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
					Query query = entityManager.createNativeQuery(sql);
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
		
	}

}
