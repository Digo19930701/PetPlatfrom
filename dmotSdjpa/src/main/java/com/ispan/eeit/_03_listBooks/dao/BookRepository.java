package com.ispan.eeit._03_listBooks.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ispan.eeit._03_listBooks.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	// 依bookId來刪除單筆記錄\
//	void deleteById(Long bookId);

	// 依bookId來查詢單筆記錄
//	Optional<Book> findById(Long bookId);

//	@Override
	@Query("SELECT DISTINCT category FROM BookEntity")
	List<String> findAllByCategory();
	
//	String getCategoryTag(String selected);
	
	Page<Book> findAll(Pageable pageable);

//	int getTotalPages();
	
	// 新增一筆記錄
//	Book save(Book bean);
	


}