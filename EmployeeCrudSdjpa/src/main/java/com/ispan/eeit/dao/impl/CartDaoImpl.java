package com.ispan.eeit.dao.impl;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import com.ispan.eeit.dao.CartDao;
import com.ispan.eeit.model.Cart;

@Repository
public class CartDaoImpl implements CartDao{
	@PersistenceContext
	EntityManager  entityManager;
	
////	@Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public Cart getUserName(String userName) {
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
		
		Cart seller = entityManager.find(Cart.class, userName);
		return seller;
	}

}