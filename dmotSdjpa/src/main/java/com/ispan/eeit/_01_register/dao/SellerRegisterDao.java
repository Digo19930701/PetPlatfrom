package com.ispan.eeit._01_register.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.eeit._31_seller.model.Seller;

public interface SellerRegisterDao extends JpaRepository<Seller, Integer>{

	@Query(value = "SELECT COUNT(*) FROM sellerinfo WHERE sellerId = :sellerId", nativeQuery = true)
	int countByUserEmail(@Param("sellerId") String sellerId);
	  
	//SQL語法
	@Query(value = "SELECT COUNT(*) FROM sellerinfo WHERE sellerPassword = :sellerPassword", nativeQuery = true)
	int countByPassword(@Param("sellerPassword") String sellerPassword);

}
