package com.ispan.eeit._04_ShoppingCart.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._04_ShoppingCart.dao.CartDao;
import com.ispan.eeit._04_ShoppingCart.dto.CartQueryParams;
import com.ispan.eeit._04_ShoppingCart.model.Cart;
import com.ispan.eeit._04_ShoppingCart.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	private CartDao shoppingCartDao;
	
//	@Autowired
	public CartServiceImpl(CartDao shoppingCarDao) {
		this.shoppingCartDao = shoppingCarDao;
	}
	

	@Override
	public List<Cart> getshoppingCart(CartQueryParams cartQueryParams) {
		// TODO Auto-generated method stub
		return shoppingCartDao.getshoppingCart(cartQueryParams);
	}

	@Override
	public Cart getUserEmail(String shoppingCartId) {
		return shoppingCartDao.getUserEmail(shoppingCartId);
	}

}