//package com.ispan.eeit._04_ShoppingCart.dao.impl;
//
//import java.sql.Connection;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import _04_ShoppingCart.dao.OrderItemDao;
//import _04_ShoppingCart.model.OrderItemBean;
///*
// * 一張合格的訂單必須經過下列檢查 
// * 
// * 	1.	檢查訂購之商品的數量是否足夠。
// *      此功能寫在本類別的updateProductStock()方法內，參考該方法的說明。
// */
//@Repository
//public class OrderItemDaoImpl_Hibernate implements OrderItemDao {
//
//	private static Logger log = LoggerFactory.getLogger(OrderItemDaoImpl_Hibernate.class);
//
//	SessionFactory factory;
//	
//	@Autowired
//	public OrderItemDaoImpl_Hibernate(SessionFactory factory) {
//		this.factory = factory;
//	}
//
//	/*
//	 * 計算客戶欲購買之某項商品(以OrderItemBean物件oib來表示)的小計金額(subtotal)， 計算公式為: 商品的數量 * 商品的單價 *
//	 * 商品的折扣
//	 */
//	@Override
//	public double findItemAmount(OrderItemBean oib) {
//		double subtotal = oib.getQuantity() * oib.getUnitPrice() * oib.getDiscount();
//		return subtotal;
//	}
//
//	@Override
//	public void updateProductStock(OrderItemBean orderItemBean) {
//		log.info("OrderItemDaoImpl_Hibernate: 更新商品數量：" + orderItemBean.getQuantity());
//		String hql1 = "UPDATE BookBean SET stock = stock - :orderAmount WHERE bookId = :bookId";
//		Session session = factory.getCurrentSession();
//		
//		session.createQuery(hql1)
//				.setParameter("bookId", orderItemBean.getBookId())
//				.setParameter("orderAmount", orderItemBean.getQuantity())
//				.executeUpdate();
//	}
//
//	@Override
//	public void setConnection(Connection conn) {
//		throw new RuntimeException("OrderItemDaoImpl_Hibernate類別未實作此方法");
//	}
//}
