package com.ispan.eeit._04_ShoppingCart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.eeit._04_ShoppingCart.model.OrderBean;

public interface OrderRepository extends JpaRepository<OrderBean, Long>{

//	void save(OrderBean ob);

	Optional<OrderBean> findById(Long orderNo);

	List<OrderBean> findByMemberId(String memberId);

}