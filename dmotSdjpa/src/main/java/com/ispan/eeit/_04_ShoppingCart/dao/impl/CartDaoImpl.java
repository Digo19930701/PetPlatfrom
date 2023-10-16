package com.ispan.eeit._04_ShoppingCart.dao.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.ispan.eeit._04_ShoppingCart.dao.CartDao;
import com.ispan.eeit._04_ShoppingCart.dto.CartQueryParams;
import com.ispan.eeit._04_ShoppingCart.model.Cart;
import com.ispan.eeit._04_ShoppingCart.rowmapper.CartRowMapper;

@Repository
public class CartDaoImpl implements CartDao{
	@PersistenceContext
	EntityManager  entityManager;
	
	@Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Cart> getshoppingCart(CartQueryParams cartQueryParams){

		String sql = "SELECT * FROM shoppingcart WHERE 1=1";
		Map<String, Object> map = new HashMap<>();

		if (cartQueryParams.getUserEmail() != null) {
			sql = sql + " AND userEmail = :userEmail"; // 一定要留空白
			map.put("userEmail", cartQueryParams.getUserEmail());
		}

		List<Cart>shoppingCartList = namedParameterJdbcTemplate.query(sql, map, new CartRowMapper());
		return shoppingCartList;
	}

	@Override
	public Cart getUserEmail(String shoppingCartId) {		
		Cart shoppingCart = entityManager.find(Cart.class, shoppingCartId);
		return shoppingCart;
	}

}