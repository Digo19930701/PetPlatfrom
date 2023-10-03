package com.ispan.eeit._06_order.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._06_order.dao.OrdersDao;
import com.ispan.eeit._06_order.model.Order;
import com.ispan.eeit._06_order.service.OrdersService;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService{
	
	OrdersDao orderdao;
	
//	@Autowired
	public OrdersServiceImpl(OrdersDao orderdao) {
		this.orderdao = orderdao;
	}

	@Override
	public List<Order> getBySellerId(String sellerId) {
		return orderdao.getBySellerId(sellerId);
	}

	@Override
	public Order getOrder(String orderId) {
		return orderdao.getOrders(orderId);
	}

}
