package com.ispan.eeit._31_seller.service;

import com.ispan.eeit._31_seller.model.Seller;

public interface SellerService {

	Seller getSellerById(String sellerId);

	void save(Seller seller);

	void update(Seller seller);
}
