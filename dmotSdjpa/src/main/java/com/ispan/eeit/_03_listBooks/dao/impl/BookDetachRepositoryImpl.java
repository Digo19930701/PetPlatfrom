package com.ispan.eeit._03_listBooks.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ispan.eeit._03_listBooks.dao.BookDetachRepository;
import com.ispan.eeit._03_listBooks.model.Book;
import com.ispan.eeit._03_listBooks.model.Publisher;
@Repository
public class BookDetachRepositoryImpl implements BookDetachRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void detachBook(Book book) {
		System.out.println("book=" + book);
		entityManager.detach(book);

	}

	@Override
	public void detachPublisher(Publisher publisher) {
		System.out.println("publisher=" + publisher);
		entityManager.detach(publisher);
		
	}

	@Override
	public void clear() {
		entityManager.clear();
	}

}
