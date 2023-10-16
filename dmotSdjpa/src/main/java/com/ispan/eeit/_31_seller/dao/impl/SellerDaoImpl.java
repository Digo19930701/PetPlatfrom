package com.ispan.eeit._31_seller.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ispan.eeit._31_seller.dao.SellerDao;
import com.ispan.eeit._31_seller.model.Seller;

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
