package _03_listBooks.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _03_listBooks.dao.BookDao;
import _03_listBooks.model.BookBean;
import _03_listBooks.service.BookService;
@Service
public class BookServiceImpl implements BookService {

	private static Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

	BookDao bookDao;
	
	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	@Transactional
	@Override
	public int getTotalPages() {
		log.info("BookServiceImpl#getTotalPages");
		int n = 0;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			n = bookDao.getTotalPages();
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//			throw new RuntimeException(ex);
//		}
		return n;
	}
	@Transactional
	@Override
	public Map<Integer, BookBean> getPageBooks(int pageNo) {
		log.info("維護書籍資料之顯示書籍功能之Service，讀取一頁商品資料之 pageNo=" + pageNo);
		Map<Integer, BookBean> map = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			map = bookDao.getPageBooks(pageNo);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//			throw new RuntimeException(ex);
//		}
		return map;
	}
	@Transactional
	@Override
	public long getRecordCounts() {
		log.info("BookServiceImpl#getRecordCounts");
		long count = 0; // 必須使用 long 型態
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			count = bookDao.getRecordCounts();
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//			throw new RuntimeException(ex);
//		}
		return count;
	}
	@Transactional
	@Override
	public BookBean findById(int bookId) {
		log.info("更新書籍資料之前置作業之Service, 書籍主鍵值：" + bookId);
		BookBean bean = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			bean = bookDao.findById(bookId);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//			throw new RuntimeException(ex);
//		}
		return bean;
	}
	@Transactional
	@Override
	public void updateBook(BookBean bean, long sizeInBytes) {
		log.info("更新書籍資料之Service, bean=" + bean 
									+ ", sizeInBytes=" + sizeInBytes);
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			bookDao.updateBook(bean, sizeInBytes);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//			throw new RuntimeException(ex);
//		}
	}
	@Transactional
	@Override
	public void deleteById(int bookId) {
		log.info("刪除書籍功能之Service, 書籍主鍵值：" + bookId);
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			bookDao.deleteById(bookId);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//			throw new RuntimeException(ex);
//		}
	}
	@Transactional
	@Override
	public void save(BookBean bean) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			bookDao.save(bean);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//			throw new RuntimeException(ex);
//		}
		log.info("新增書籍功能之Service: 資料新增成功, BookBean=" + bean);
	}
	@Transactional
	@Override
	public String getCategoryTag(String selected) {
		log.info("新增與更新書籍之前置作業之Service, 參數selected=" 
									+ selected + "*****");
		String ans = "";
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			ans = bookDao.getCategoryTag(selected);
//			tx.commit();
//		} catch (Exception ex) {
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//			throw new RuntimeException(ex);
//		}
		return ans;
	}
	@Transactional
	@Override
	public List<String> findAllCategories() {
		return bookDao.getCategory();
	}
}
