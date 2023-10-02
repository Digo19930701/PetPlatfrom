package com.example.ECPayDemo.dao;

import java.util.List;

import com.example.ECPayDemo.bean.SellerOrder;

public interface SellerOrderDao {

	SellerOrder getOrders(String orderId);

	List<SellerOrder> getSellerOrders(String sellerId);
	
}
