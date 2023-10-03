package com.ispan.eeit._04_ShoppingCart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ispan.eeit._04_ShoppingCart.model.OrderItemBean;

public interface OrderItemRepository extends JpaRepository<OrderItemBean, Long> {
	
//	double findItemAmount(OrderItemBean oib);
	@Modifying
	@Query("UPDATE BookEntity SET stock = stock - :orderAmount WHERE id = :id")
	void updateProductStock(Integer orderAmount, Long id);
	
}
