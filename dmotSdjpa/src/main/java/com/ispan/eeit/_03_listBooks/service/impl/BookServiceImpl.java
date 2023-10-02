package com.ispan.eeit._03_listBooks.service.impl;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._00_common.GlobalService;
import com.ispan.eeit._03_listBooks.dao.BookDetachRepository;
import com.ispan.eeit._03_listBooks.dao.BookRepository;
import com.ispan.eeit._03_listBooks.model.Book;
import com.ispan.eeit._03_listBooks.model.Publisher;
import com.ispan.eeit._03_listBooks.service.BookService;
@Service
@Transactional
public class BookServiceImpl implements BookService {

	private static Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
	
	BookRepository bookRepository;
	
	BookDetachRepository  bookDetachRepository;
	
	@Autowired
	BookServiceImpl(BookRepository bookRepository, BookDetachRepository bookDetachRepository) {
		super();
		this.bookRepository = bookRepository;
		this.bookDetachRepository = bookDetachRepository;
	}
	
	
	@Override
	public int getTotalPages() {
		int totalPages = (int) (Math.ceil(getRecordCounts() / (double) GlobalService.RECORDS_PER_PAGE));
		log.info("BookServiceImpl#getTotalPages,  totalPages=" + totalPages);
		return totalPages;
	}
	 

	@Override
	public Map<Long, Book> getPageBooks(int pageNo) {
		Map<Long, Book> map = new LinkedHashMap<>();
		log.info("in BookService, 維護書籍資料之顯示書籍功能之Service，讀取一頁商品資料之 pageNo=" + pageNo);
		int startPageNo = pageNo - 1;
//		MySort mySort = new MySort();
//		Pageable pageable = PageRequest.of(startPageNo, GlobalService.RECORDS_PER_PAGE);
		Pageable pageable = PageRequest.of(startPageNo, GlobalService.RECORDS_PER_PAGE, Sort.by("id").ascending());
		Page<Book> page = bookRepository.findAll(pageable);
		List<Book> pageBooks = page.getContent();
		for (Book book : pageBooks) {
			 log.info("in BookService, book=" + book);
		     map.put(book.getId(), book);
		}
		return map;
	}
	
	public long getRecordCounts() {
		log.info("BookServiceImpl#getRecordCounts");
		// 必須使用 long 型態
		long count =  bookRepository.count();
		return count;
	}
	
	@Override
	public Optional<Book> findById(Long bookId) {
		log.info("更新書籍資料之前置作業之Service, 書籍主鍵值：" + bookId);
		Optional<Book> optional = bookRepository.findById(bookId);
		return optional;
	}
	
//	@Override
//	public void updateBook(Book bean, long sizeInBytes) {
////		log.info("更新書籍資料之Service, bean=" + bean 
////									+ ", sizeInBytes=" + sizeInBytes);
////		    bookRepository.updateBook(bean, sizeInBytes);
//	}
	
	@Override
	public void deleteById(Long id) {
		log.info("刪除書籍功能之Service, 書籍主鍵值：" + id);
		Optional<Book> optional = bookRepository.findById(id);
		Book book = null;
		if (optional.isPresent()) {
			book = optional.get();
			book.setPublisher(null);
		}
		bookRepository.deleteById(id);
	}
	
	@Override
	public void save(Book bean) {
		bookRepository.save(bean);
		log.info("新增書籍功能之Service: 資料新增成功, BookBean=" + bean);
	}

//	@Override
//	public String getCategoryTag(String selected) {
//		log.info("新增與更新書籍之前置作業之Service, 參數selected=" 
//									+ selected + "*****");
//		String ans = "";
//		ans = bookRepository.getCategoryTag(selected);
//		return ans;
//	}

	@Override
	public List<String> findAllByCategory() {
		return bookRepository.findAllByCategory();
	}
	
	public class MySort implements Comparator<Book> {

		@Override
		public int compare(Book o1, Book o2) {
			long id1 = o1.getId();
			long id2 = o2.getId();
			return ((int)id1 - (int)id2);
		}
		
	}

	@Override
	public void detachPublisher(Publisher publisher) {
		bookDetachRepository.detachPublisher(publisher);
		
	}


	@Override
	public void detachBook(Book book) {
		bookDetachRepository.detachBook(book);
	}


	@Override
	public void clear() {
		bookDetachRepository.clear();
	}
}
