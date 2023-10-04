package com.example.ECPayDemo.service;

import java.util.List;

import com.example.ECPayDemo.bean.SellerOrder;

public interface SellerOrderService {

	SellerOrder getOrders(String orderId);

	List<SellerOrder> getSellerOrders(String sellerId);


}
