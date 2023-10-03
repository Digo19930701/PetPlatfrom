package com.ispan.eeit._06_order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ispan.eeit._01_register.model.Member;
import com.ispan.eeit._04_ShoppingCart.service.OrderService;
import com.ispan.eeit._06_order.model.Order;
import com.ispan.eeit._31_seller.model.Seller;



@Controller
@SessionAttributes({"LoginOK"})
public class OrderListController {

	private static Logger log = LoggerFactory.getLogger(OrderListController.class);
	
	OrderService orderService;
	
//	@Autowired
	public OrderListController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/orderList")
	protected String orderList(Model model) {
		Seller seller = (Seller) model.getAttribute("LoginOK");
//		if (seller == null) {
//			Member memberBean = (Member) model.getAttribute("LoginOK");
//		}
		List<Order> sellerOrders = orderService.findBySellerId(seller.getSellerId());
		model.addAttribute("memberOrders", sellerOrders);
		log.info("會員:" + seller.getSellerId() + "的訂單: " + sellerOrders);
		System.out.println(seller.getSellerId());
		System.out.println(sellerOrders);
		return "_05_orderProcess/OrderList";
	}
	
}
