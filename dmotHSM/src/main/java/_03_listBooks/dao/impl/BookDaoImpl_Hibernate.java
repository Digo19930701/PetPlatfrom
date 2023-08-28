package _03_listBooks.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import _00_init.util.GlobalService;
import _03_listBooks.dao.BookDao;
import _03_listBooks.dao.CompanyDao;
import _03_listBooks.model.BookBean;
import _03_listBooks.model.CompanyBean;

// 本類別使用Hibernate的技術來存取資料庫。
@Repository
public class BookDaoImpl_Hibernate implements Serializable, BookDao {

	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(BookDaoImpl_Hibernate.class);

	public static final int recordsPerPage = GlobalService.RECORDS_PER_PAGE; // 預設值：每頁三筆
	private int totalPages = -1;
	
	SessionFactory factory;

	CompanyDao companyDao;
	@Autowired
	public BookDaoImpl_Hibernate(SessionFactory factory, CompanyDao companyDao) {
		this.factory = factory;
		this.companyDao = companyDao;
	}

	// 計算販售的商品總共有幾頁
	@Override
	public int getTotalPages() {
		// 注意下一列敘述的每一個型態轉換
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));
		log.info("totalPages=" + totalPages);
		return totalPages;
	}

	// 查詢某一頁的商品(書籍)資料，執行本方法前，一定要先設定實例變數pageNo的初值
	@Override
	public Map<Integer, BookBean> getPageBooks(int pageNo) {

		log.info("新增書籍之顯示書籍功能之Dao，讀取一頁商品資料之 pageNo=" + pageNo);

		Map<Integer, BookBean> map = new LinkedHashMap<>();
		List<BookBean> list = new ArrayList<BookBean>();
		String hql = "FROM BookBean";
		Session session = factory.getCurrentSession();

		int startRecordNo = (pageNo - 1) * recordsPerPage;

		list = session.createQuery(hql, BookBean.class)
					  .setFirstResult(startRecordNo)
					  .setMaxResults(recordsPerPage)
					  .getResultList();
		
		for (BookBean bean : list) {
			map.put(bean.getBookId(), bean);
		}
		
		log.info("新增書籍之顯示書籍功能之Dao，存放商品資料之map=" + map);
		return map;
	}

	@Override
	public long getRecordCounts() {
		long count = 0; // 必須使用 long 型態
		String hql = "SELECT count(*) FROM BookBean";
		Session session = factory.getCurrentSession();
		List<Long> list = session.createQuery(hql, Long.class)
				                 .getResultList();
		if (list.size() > 0) {
			count = list.get(0);
		}
		log.info("RecordCounts=" + count);
		return count;
	}

	@Override
	public List<String> getCategory() {
		String hql = "SELECT DISTINCT category FROM BookBean";
		Session session = factory.getCurrentSession();
		List<String> list = null;
		list = session.createQuery(hql, String.class)
				      .getResultList();
		log.info("list=" + list);
		return list;
	}

	@Override
	public String getCategoryTag(String selected) {
		String ans = "";
		List<String> list = getCategory();
		ans += "<SELECT name='category'>";
		for (String cate : list) {
			if (cate.equals(selected)) {
				ans += "<option value='" + cate 
					   + "' selected>" + cate + "</option>";
			} else {
				ans += "<option value='" + cate + "'>" 
			           + cate + "</option>";
			}
		}
		ans += "</SELECT>";
		log.info("ans=" + ans);
		return ans;
	}

	// 修改一筆書籍資料
	@Override
	public void updateBook(BookBean bean, long sizeInBytes) {
		Session session = factory.getCurrentSession();

		if (bean.getCompanyBean() == null) {
			CompanyBean cb = companyDao.findById(bean.getCompanyId());
			bean.setCompanyBean(cb);
		}
		if (sizeInBytes == -1) { // 不修改圖片
			updateBook(bean);
			return;
		}
		session.saveOrUpdate(bean);
	}

	// 修改一筆書籍資料，不改圖片
	public void updateBook(BookBean bean) {
		Session session = factory.getCurrentSession();
		BookBean b0 = null;
		b0 = session.get(BookBean.class, bean.getBookId());
		bean.setStock(b0.getStock());
		bean.setPriceStr(b0.getPriceStr());
		bean.setCoverImage(b0.getCoverImage());
		bean.setFileName(b0.getFileName());
		session.evict(b0);
		session.saveOrUpdate(bean);
		return;
	}

	// 依bookId來刪除單筆記錄
	@Override
	public void deleteById(int bookId) {
		log.info("刪除書籍功能之Dao, 書籍主鍵值：" + bookId);
		Session session = factory.getCurrentSession();
		BookBean bb = new BookBean();
		bb.setBookId(bookId);
		session.delete(bb);
	}

	// 新增一筆記錄---
	@Override
	public void save(BookBean bean) {
		Session session = factory.getCurrentSession();
		if (bean.getCompanyBean() == null) {
			CompanyBean cb = companyDao.findById(bean.getCompanyId());
			bean.setCompanyBean(cb);
		}
		session.save(bean);
		log.info("維護書籍資料功能之Dao: 資料新增成功, BookBean=" + bean);
		
	}

	@Override
	public BookBean findById(int bookId) {
		BookBean bean = null;
		Session session = factory.getCurrentSession();
		bean = session.get(BookBean.class, bookId);
		log.info("更新書籍之前置作業之Dao, 書籍主鍵值：" + bookId + ", bean=" + bean);
		return bean;
	}

}