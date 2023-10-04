package com.ispan.eeit._31_seller.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._31_seller.dao.SellerDao;
import com.ispan.eeit._31_seller.model.Seller;
import com.ispan.eeit._31_seller.service.SellerService;

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
