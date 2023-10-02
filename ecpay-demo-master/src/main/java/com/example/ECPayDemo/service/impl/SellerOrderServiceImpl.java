package com.example.ECPayDemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ECPayDemo.bean.SellerOrder;
import com.example.ECPayDemo.dao.SellerOrderDao;
import com.example.ECPayDemo.service.SellerOrderService;

@Service
@Transactional
public class SellerOrderServiceImpl implements SellerOrderService{
	
	SellerOrderDao sellerOrderDao;
	
//	@Autowired
	public SellerOrderServiceImpl(SellerOrderDao sellerOrderDao) {
		this.sellerOrderDao = sellerOrderDao;
	}

	@Override
	public SellerOrder getOrders(String orderId) {
		return sellerOrderDao.getOrders(orderId);
	}

	@Override
	public List<SellerOrder> getSellerOrders(String sellerId) {
		return sellerOrderDao.getSellerOrders(sellerId);
	}




}
