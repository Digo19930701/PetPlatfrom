package com.ispan.eeit._03_listBooks.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ispan.eeit._03_listBooks.model.Book;
import com.ispan.eeit._03_listBooks.model.Publisher;

public interface BookService {
	// 依bookId來刪除單筆記錄
	void deleteById(Long bookId);
	
	// 依bookId來查詢單筆記錄
	Optional<Book> findById(Long bookId);

//	String getCategoryTag(String selected);
	
	// 依照頁碼來讀取一頁的商品資料
	Map<Long, Book> getPageBooks(int pageNo);
	// 讀取的商品總數量
//	long getRecordCounts();
	// 讀取的商品總頁數
	int getTotalPages();
	
	// 新增一筆記錄
	void save(Book bean);

	// 更新商品資料
//	void updateBook(Book bean, long sizeInBytes) ;

	// 取出所有的類型
	List<String> findAllByCategory();
	
	void  detachBook(Book book);
	
	void  detachPublisher(Publisher publisher);
	
	void  clear();
}
