package com.ispan.eeit._21_petService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.eeit._21_petService.model.PetService;

public interface PetServiceRepository extends JpaRepository<PetService, String>{

//	void save(PetService petService);
	
	

}
