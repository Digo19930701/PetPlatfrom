package com.ispan.eeit._04_ShoppingCart.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._04_ShoppingCart.dao.CartDao;
import com.ispan.eeit._04_ShoppingCart.model.Cart;
import com.ispan.eeit._04_ShoppingCart.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	CartDao shoppingCartDao;
	
//	@Autowired
	public CartServiceImpl(CartDao shoppingCarDao) {
		this.shoppingCartDao = shoppingCarDao;
	}	

	@Override
	public Cart getUserName(String shoppingCartId) {
		return shoppingCartDao.getUserName(shoppingCartId);
	}

}