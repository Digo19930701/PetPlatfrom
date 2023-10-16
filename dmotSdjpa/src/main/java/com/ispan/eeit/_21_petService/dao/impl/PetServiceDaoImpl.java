package com.ispan.eeit._21_petService.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ispan.eeit._21_petService.dao.PetServiceDao;
import com.ispan.eeit._21_petService.model.PetService;
import com.ispan.eeit._21_petService.model.PetServiceDetail;
import com.ispan.eeit._21_petService.rowmapper.PetServiceDetailRowMapper;
import com.ispan.eeit._30_HomeService.model.HomeServiceType;
import com.ispan.eeit._30_HomeService.rowmapper.HomeServiceTypeRowMapper;

@Repository
public class PetServiceDaoImpl implements PetServiceDao{
	Logger log = LoggerFactory.getLogger(PetServiceDaoImpl.class);
	@PersistenceContext
	EntityManager  entityManager;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public PetService getServiceById(String serviceId) {
		PetService petService = entityManager.find(PetService.class, serviceId);
		return petService;
	}

	@Override
	public PetServiceDetail getPSDByServiceId(String serviceId) {
		log.info("read all PSD of " + serviceId + ": Dao (start).");
		String hql = "SELECT s.serviceName, s.serviceId, s.sellerId , s.category, s.serviceDesc, s.servicePeriod, s.upperLimit, " 
				+ "s.availTime1, s.availTime2, s.acceptDay1, s.acceptDay2, s.serviceImage1, s.serviceImage2, s.serviceImage3, "
				+ "s.serviceImage4, s.serviceImage5, s.monday, s.tuesday, s.wednesday, s.thursday, s.friday, s.saturday, s.sunday "
				+ "FROM services AS s WHERE s.serviceId = :serviceId ";
		Map<String, Object> map = new HashMap<>();
		map.put("serviceId", serviceId);
		List<PetServiceDetail> PSD = namedParameterJdbcTemplate.query(hql, map, new PetServiceDetailRowMapper());

		log.info("read all PSD of " + serviceId + ": Dao (done).");
		if(PSD.size() > 0){
			log.info("read all PSD of " + serviceId + ": Dao (PSD.size() > 0).");
            return PSD.get(0);
        }else{
        	log.info("read all PSD of " + serviceId + ": Dao (PSD.size() = 0).");
            return null;
        }
	}

	@Override
	public List<HomeServiceType> getHstListByServiceId(String serviceId) {
		log.info("read all PSD of " + serviceId + ": Dao (start).");
		String sql = "SELECT * FROM servicetypes WHERE serviceId = :serviceId ";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceId", serviceId);
		List<HomeServiceType> hst = namedParameterJdbcTemplate.query(sql, map, new HomeServiceTypeRowMapper());

		log.info("read all hst of " + serviceId + ": Dao (done).");
		if(hst.size() > 0) {
			log.info("got orders of seller(" + serviceId + ").");
			return hst;			
		}else {
			log.info("order of seller(" + serviceId + ") not found.");
			return null;
		}
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
