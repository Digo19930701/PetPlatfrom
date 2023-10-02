package com.ispan.eeit._03_listBooks.dao;

import com.ispan.eeit._03_listBooks.model.Book;
import com.ispan.eeit._03_listBooks.model.Publisher;

public interface BookDetachRepository {
	void detachBook(Book book);
	
	void detachPublisher(Publisher publisher);
	
	void clear();
}
