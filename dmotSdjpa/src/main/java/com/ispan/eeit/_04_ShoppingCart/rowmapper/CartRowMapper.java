package com.ispan.eeit._04_ShoppingCart.rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ispan.eeit._04_ShoppingCart.model.Cart;


public class CartRowMapper implements RowMapper<Cart>{
    
    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		cart.setShoppingCarId(rs.getString("shoppingCarId"));
		cart.setUserEmail(rs.getString("userEmail"));
		cart.setPhoneNumber(rs.getString("phoneNumber"));
		cart.setServiceImg(rs.getString("serviceImg"));
		cart.setServiceName(rs.getString("serviceName"));
		cart.setServicePeriod(rs.getDate("servicePeriod"));
		cart.setPrice(rs.getInt("price"));
		cart.setVariety(rs.getString("variety"));
		cart.setPayment(rs.getInt("payment"));

		return cart;
    }

}
