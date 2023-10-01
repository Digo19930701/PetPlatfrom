package com.example.ECPayDemo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ECPayDemo.bean.PetService;
import com.example.ECPayDemo.dao.PetServiceDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class PetServiceDaoImpl implements PetServiceDao{
	@PersistenceContext
	EntityManager  entityManager;

	@Override
	public PetService getServiceById(Integer serviceId) {
		PetService petService = entityManager.find(PetService.class, serviceId);
		return petService;
	}
	
	

//	@Override
//	public Service getSellerServices(String SellerId) {
//		Service result = null;
//		String hql = "FROM services WHERE SellerId = :sellerId";
//		List<Service>  Services = entityManager.createQuery(hql, Service.class)
//			                           			 .setParameter("sellerId", SellerId)
//		                           			 	 .getResultList();
//		if (Services.size() > 0) {
//			result = Services.get(0);
//		}
//		return result;
//	}
	
}
