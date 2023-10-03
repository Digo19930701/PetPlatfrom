package com.ispan.eeit.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit.dao.CartDao;
import com.ispan.eeit.model.Cart;
import com.ispan.eeit.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	CartDao shoppingCartDao;
	
//	@Autowired
	public CartServiceImpl(CartDao shoppingCarDao) {
		this.shoppingCartDao = shoppingCarDao;
	}	

	@Override
	public Cart getUserName(String userName) {
		return shoppingCartDao.getUserName(userName);
	}

}