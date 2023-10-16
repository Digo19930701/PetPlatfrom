package com.ispan.eeit._31_seller.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit._31_seller.dao.SellerDao;
import com.ispan.eeit._31_seller.dao.SellerRepository;
import com.ispan.eeit._31_seller.model.Seller;
import com.ispan.eeit._31_seller.service.SellerService;

@Service
@Transactional
public class SellerServiceImpl implements SellerService{
	
	SellerDao sellerDao;
	SellerRepository sellerRepository;
	
//	@Autowired
	public SellerServiceImpl(SellerDao sellerDao, SellerRepository sellerRepository) {
		this.sellerDao = sellerDao;
		this.sellerRepository = sellerRepository;
	}	

	@Override
	public Seller getSellerById(String sellerId) {
		return sellerDao.getSellerById(sellerId);
	}

	@Override
	public void save(Seller seller) {
		sellerRepository.save(seller);
		
	}

	@Override
	public void update(Seller seller) {
		sellerRepository.save(seller);
		
	}
	
	

}
