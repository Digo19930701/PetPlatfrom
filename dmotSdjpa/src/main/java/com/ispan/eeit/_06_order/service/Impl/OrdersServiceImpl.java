package com.ispan.eeit._06_order.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._04_ShoppingCart.service.impl.OrderServiceImpl;
import com.ispan.eeit._06_order.dao.OrdersDao;
import com.ispan.eeit._06_order.dao.impl.OrdersRepository;
import com.ispan.eeit._06_order.model.Order;
import com.ispan.eeit._06_order.service.OrdersService;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService{
	
	private static Logger log = LoggerFactory.getLogger(OrdersServiceImpl.class);
			
	OrdersDao orderdao;
//	OrdersRepository ordersRepository;
	
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
		return orderdao.getOrder(orderId);
	}

	@Override
	public List<Order> getOrdersBySellerId(String sellerId) {
		log.info("依照sellerId編號讀取某位商家所有訂單: sellerId=" + sellerId);
		return orderdao.getOrdersBySellerId(sellerId);

	}
	
	

}
