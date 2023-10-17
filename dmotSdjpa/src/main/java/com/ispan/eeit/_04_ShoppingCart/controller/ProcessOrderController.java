package com.ispan.eeit._04_ShoppingCart.controller;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.eeit._01_register.model.Member;
import com.ispan.eeit._04_ShoppingCart.model.OrderBean;
import com.ispan.eeit._04_ShoppingCart.model.OrderItemBean;
import com.ispan.eeit._04_ShoppingCart.model.ShoppingCart;
import com.ispan.eeit._04_ShoppingCart.service.OrderService;

// OrderConfirm.jsp 呼叫本程式。

@Controller
@RequestMapping("/_04_ShoppingCart")
@SessionAttributes({ "LoginOK", "ShoppingCart", "OrderErrorMessage"})
public class ProcessOrderController {
	private static Logger log = LoggerFactory.getLogger(ProcessOrderController.class);
	
	OrderService orderService;
	
	@Autowired
	public ProcessOrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/processOrder")
	protected String processOrder(Model model, 
			@RequestParam("ShippingAddress") String shippingAddress,
			@RequestParam("BNO") String bNO,
			@RequestParam("finalDecision") String finalDecision,
			@RequestParam("InvoiceTitle") String invoiceTitle, 
			WebRequest webRequest, SessionStatus status, RedirectAttributes ra
	) {
		
		Member member = (Member) model.getAttribute("LoginOK");
		if (member == null) {
			return "redirect:/_02_login/login";
		}
		
		ShoppingCart sc = (ShoppingCart) model.getAttribute("ShoppingCart");
		if (sc == null) {
			// 處理訂單時如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			return "redirect:/_02_login/login";
		}
		// 如果使用者取消訂單
		if (finalDecision.equalsIgnoreCase("CANCEL")) {
			log.info("客戶最終決定取消訂單");
			return "forward:/_04_ShoppingCart/abort";
		}
		String memberId = member.getMemberId();   						// 取出會員代號
		double totalAmount = Math.round(sc.getSubtotal() * 1.05);  	// 計算訂單總金額 
		Date today = new Date();   									// 新增訂單的時間
		// 新建訂單物件。OrderBean:封裝一筆訂單資料的容器，包含訂單主檔與訂單明細檔的資料。目前只存放訂單主檔的資料。
		OrderBean orderBean = new OrderBean(null, memberId, totalAmount, shippingAddress, 
				bNO, invoiceTitle, today, null, null);
		
		// 取出存放在購物車內的商品，放入Map型態的變數cart，準備將其內的商品一個一個轉換為OrderItemBean，
		
		Map<Long, OrderItemBean> content = sc.getContent();
		
		Set<OrderItemBean> items = new LinkedHashSet<>();
		Set<Long> set = content.keySet();
		for(Long i : set) {
			OrderItemBean oib = content.get(i);
			oib.setOrderBean(orderBean);
			items.add(oib);
		}
		
		// 執行到此，購物車內所有購買的商品已經全部轉換為為OrderItemBean物件，並放在Items內
		orderBean.setItems(items);  
		try {
			orderService.save(orderBean);
//			status.setComplete();
//			webRequest.removeAttribute("ShoppingCart", WebRequest.SCOPE_SESSION);
			log.info("訂單已經成功寫入表格");
			model.addAttribute("MemberName_ThanksForOrdering", member.getName()) ;
			return "forward:" + "/_04_ShoppingCart/removeShoppingCart";
		} catch(RuntimeException ex){
			String message = ex.getMessage();
			String shortMsg = "" ;   
			System.out.println("message=" + message);
			shortMsg =  message.substring(message.indexOf(":") + 1);
			log.info("處理訂單時發生異常: " + shortMsg);
			model.addAttribute("OrderErrorMessage", "處理訂單時發生異常: " + shortMsg  + "，請調正訂單內容" );
			ex.printStackTrace();
			return "redirect:/_04_ShoppingCart/ShowCartContent";
		}
	}
}