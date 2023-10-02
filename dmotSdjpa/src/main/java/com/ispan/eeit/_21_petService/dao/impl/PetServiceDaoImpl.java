package com.ispan.eeit._21_petService.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ispan.eeit._21_petService.dao.PetServiceDao;
import com.ispan.eeit._21_petService.model.PetService;

@Repository
public class PetServiceDaoImpl implements PetServiceDao{
	@PersistenceContext
	EntityManager  entityManager;

	@Override
	public PetService getServiceById(String serviceId) {
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
