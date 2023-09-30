package com.example.ECPayDemo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ECPayDemo.bean.Seller;
import com.example.ECPayDemo.dao.SellerDao;
import com.example.ECPayDemo.rowmapper.SellerRowMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class SellerDaoImpl implements SellerDao{
	@PersistenceContext
	EntityManager  entityManager;
	
////	@Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public Seller getSellerById(String sellerId) {
//		Seller result = null;
//		String sql = "FROM sellerinfo WHERE sellerId = :sellerId";
//		
//		Map<String, Object> map = new HashMap<>();
//		map.put("sellerId", sellerId);
//		List<Seller> seller = namedParameterJdbcTemplate.query(sql,map,new SellerRowMapper());
//		List<Seller> seller = entityManager.createQuery(sql, Seller.class)
//			                           		.setParameter("sellerId", sellerId)
//		                           			.getResultList();
//		if (seller.size() > 0) {
//			result = seller.get(0);
//		}
//		return result;
		
		Seller seller = entityManager.find(Seller.class, sellerId);
		return seller;
	}

}
