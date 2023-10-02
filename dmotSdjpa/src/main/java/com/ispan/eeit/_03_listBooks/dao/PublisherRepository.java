package com.ispan.eeit._03_listBooks.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.eeit._03_listBooks.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

	List<Publisher> findAll();

	Optional<Publisher> findById(Long id) ;
	
}