package com.ispan.eeit.dao.impl;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import com.ispan.eeit.dao.ShoppingCartDao;
import com.ispan.eeit.model.ShoppingCart;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao{
	@PersistenceContext
	EntityManager  entityManager;
	
////	@Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public ShoppingCart getUserName(String userName) {
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
		
		ShoppingCart seller = entityManager.find(ShoppingCart.class, userName);
		return seller;
	}

}