package com.example.ECPayDemo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ECPayDemo.bean.Seller;
import com.example.ECPayDemo.dao.SellerDao;
import com.example.ECPayDemo.service.SellerService;

@Service
@Transactional
public class SellerServiceImpl implements SellerService{
	
	SellerDao sellerDao;
	
//	@Autowired
	public SellerServiceImpl(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
	}	

	@Override
	public Seller getSellerById(String sellerId) {
		return sellerDao.getSellerById(sellerId);
	}

}
