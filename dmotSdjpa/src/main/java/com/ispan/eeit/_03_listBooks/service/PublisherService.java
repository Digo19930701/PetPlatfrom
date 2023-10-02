package com.ispan.eeit._03_listBooks.service;

import java.util.List;
import java.util.Optional;

import com.ispan.eeit._03_listBooks.model.Publisher;

public interface PublisherService {

	List<Publisher> findAll() ;

	Optional<Publisher> findById(Long id) ;

	String getSelectTag(String tagName, int selected);
	
}