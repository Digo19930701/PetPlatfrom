package com.ispan.eeit._04_ShoppingCart.dao;

import java.util.List;

import com.ispan.eeit._04_ShoppingCart.dto.CartQueryParams;
import com.ispan.eeit._04_ShoppingCart.model.Cart;

public interface CartDao {
	
	List<Cart> getshoppingCart(CartQueryParams cartQueryParams);
	Cart getUserEmail(String shoppingCartId);
}