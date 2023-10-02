package com.ispan.eeit.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit.dao.ShoppingCartDao;
import com.ispan.eeit.model.ShoppingCart;
import com.ispan.eeit.service.ShoppingCartService;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	ShoppingCartDao shoppingCartDao;
	
//	@Autowired
	public ShoppingCartServiceImpl(ShoppingCartDao shoppingCarDao) {
		this.shoppingCartDao = shoppingCarDao;
	}	

	@Override
	public ShoppingCart getUserName(String userName) {
		return shoppingCartDao.getUserName(userName);
	}

}