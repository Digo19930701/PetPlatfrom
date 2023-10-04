package com.ispan.eeit._06_order.service;

import java.util.List;

import com.ispan.eeit._06_order.model.Order;

public interface OrdersService {

	List<Order> getBySellerId(String sellerId);
	
	Order getOrder(String orderId) ;

	List<Order> getOrdersBySellerId(String sellerId);

}
