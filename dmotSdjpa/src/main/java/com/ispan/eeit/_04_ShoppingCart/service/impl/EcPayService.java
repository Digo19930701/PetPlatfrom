package com.ispan.eeit._04_ShoppingCart.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;



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
		obj.setTotalAmount("2000");
		obj.setTradeDesc("舒舒服服");
		obj.setItemName("洗澡&SPA");
		obj.setReturnURL("http://211.23.128.214:5000");
		obj.setNeedExtraPaidInfo("N");
		obj.setClientBackURL("http:/localhost:5173");
		String form = all.aioCheckOut(obj, null);
		
		return form;
	}
}