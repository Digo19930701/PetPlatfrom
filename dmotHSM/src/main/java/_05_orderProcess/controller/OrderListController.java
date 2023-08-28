package _05_orderProcess.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import _01_register.model.MemberBean;
import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.service.OrderService;

@Controller
@RequestMapping("/_05_orderProcess")
@SessionAttributes({ "LoginOK", "pageNo", "products_DPP", "ShoppingCart"})
public class OrderListController {

	private static Logger log = LoggerFactory.getLogger(OrderListController.class);
	
	OrderService orderService;
	
	@Autowired
	public OrderListController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/orderList")
	protected String orderList(Model model) {
		MemberBean memberBean = (MemberBean) model.getAttribute("LoginOK");
		if (memberBean == null) {
			return "redirect:/_02_login/login";
		}
		List<OrderBean> memberOrders = orderService.findByMemberId(memberBean.getMemberId());
		model.addAttribute("memberOrders", memberOrders);
		log.info("會員:" + memberBean.getMemberId() + "的訂單: " + memberOrders);
		return "_05_orderProcess/OrderList";
	}
	
	@GetMapping("/orderDetail")
	protected String orderDetail(Model model, 
			@RequestParam("orderNo") Integer orderNo 
			) {
		MemberBean memberBean = (MemberBean) model.getAttribute("LoginOK");
		if (memberBean == null) {
			return "redirect:/_02_login/login";
		}
		OrderBean ob = orderService.findById(orderNo);
		model.addAttribute("OrderBean", ob);
		log.info("訂單編號:" + orderNo + "的內容: " + ob);
		return "_05_orderProcess/ShowOrderDetail";
	}
}
