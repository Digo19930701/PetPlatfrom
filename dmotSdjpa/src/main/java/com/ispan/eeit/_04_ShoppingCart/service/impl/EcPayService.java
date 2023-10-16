package com.ispan.eeit._04_ShoppingCart.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

import com.ispan.eeit._04_ShoppingCart.model.Cart;

@Service
public class EcPayService {

	public String ecpayCheckout() {
		
		String uuId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
		
		Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formattedTime = sdf.format(currentTime);

		
		AllInOne all = new AllInOne("");
		
		AioCheckOutALL obj = new AioCheckOutALL();
		obj.setMerchantTradeNo(uuId);
		obj.setMerchantTradeDate(formattedTime);
		obj.setTotalAmount("1000");
		obj.setTradeDesc("4a2b寵物服務");
		obj.setItemName("4a2b寵物服務");
		obj.setReturnURL("http://211.23.128.214:5000");
		obj.setNeedExtraPaidInfo("N");
		obj.setClientBackURL("http:/localhost:5173");

		String form = all.aioCheckOut(obj, null);
		
		return form;
	}

	public String ecpayCheckout_by_cars(String price) {
			
			String uuId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
			
			Date currentTime = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String formattedTime = sdf.format(currentTime);

			
			AllInOne all = new AllInOne("");
			
			// int total = 0;
			// for (Cart cart : carts) {
			// 	total += cart.getPrice();
			// }


			AioCheckOutALL obj = new AioCheckOutALL();
			obj.setMerchantTradeNo(uuId);
			obj.setMerchantTradeDate(formattedTime);
			obj.setTotalAmount(price);
			obj.setTradeDesc("4a2b寵物服務");
			obj.setItemName("4a2b寵物服務");
			obj.setReturnURL("http://211.23.128.214:5000");
			obj.setNeedExtraPaidInfo("N");
			obj.setClientBackURL("http:/localhost:5173");
			String form = all.aioCheckOut(obj, null);
			
			return form;
		}	
}