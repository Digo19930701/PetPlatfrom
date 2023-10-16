package com.ispan.eeit._06_order.dao;

import java.util.List;

import com.ispan.eeit._06_order.model.Order;

public interface OrdersDao {

	List<Order> getBySellerId(String sellerId);

	Order getOrder(String orderId);

	List<Order> getOrdersBySellerId(String sellerId);
}
