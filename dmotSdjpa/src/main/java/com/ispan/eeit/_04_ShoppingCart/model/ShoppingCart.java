package com.ispan.eeit._04_ShoppingCart.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
public class ShoppingCart {   
	
	private Map<Long, OrderItemBean> cart = new LinkedHashMap< >();
	
	public ShoppingCart() {
	}
	
	public Map<Long, OrderItemBean>  getContent() { // ${ShoppingCart.content}
		return cart;
	}
	public void addToCart(Long bookId, OrderItemBean  oib) {
		if (oib.getQuantity() <= 0 ) {
			return;
		}
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if ( cart.get(bookId) == null ) {
		    cart.put(bookId, oib);
		} else {
	        // 如果客戶在伺服器端已有此項商品的資料，則客戶『加購』此項商品
			OrderItemBean oiBean = cart.get(bookId);
			// 加購的數量：bean.getQuantity()
			// 原有的數量：oBean.getQuantity()			
			oiBean.setQuantity(oib.getQuantity() + oiBean.getQuantity());
		}
	}

	public boolean modifyQty(Long bookId, int newQty) {
		if ( cart.get(bookId) != null ) {
		   OrderItemBean  bean = cart.get(bookId);
		   bean.setQuantity(newQty);
	       return true;
		} else {
		   return false;
		}
	}
	// 刪除某項商品
	public int deleteBook(Long bookId) {
		if ( cart.get(bookId) != null ) {
	       cart.remove(bookId);  // Map介面的remove()方法
	       return 1;
		} else {
		   return 0;
		}
	}
	public int getItemNumber(){   // ShoppingCart.itemNumber
		return cart.size();
	}
	//計算購物車內所有商品的合計金額(每項商品的單價*數量的總和)
	public double getSubtotal(){
		double subTotal = 0 ;
		Set<Long> set = cart.keySet();
		for(Long n : set){
			OrderItemBean oib = cart.get(n);
			double price    = oib.getUnitPrice();
			double discount = oib.getDiscount();
			int qty      = oib.getQuantity();
			subTotal +=  price * discount * qty;
		}
		return subTotal;
	}
}
