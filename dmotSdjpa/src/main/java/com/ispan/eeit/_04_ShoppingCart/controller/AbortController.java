package com.ispan.eeit._04_ShoppingCart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@Controller
//@RequestMapping("/_04_ShoppingCart")
//@SessionAttributes({"ShoppingCart"})
public class AbortController {
	private static Logger log = LoggerFactory.getLogger(AbortController.class);
	
	// 執行『結帳』功能時，選擇『放棄購物』
	@RequestMapping(value="/abort", method = {RequestMethod.GET, RequestMethod.POST})
	protected String abort(HttpSession session, Model model, 
			WebRequest webRequest, SessionStatus status, RedirectAttributes ra)  {
		status.setComplete();    // 移除所有被@SessionAttributes({"ShoppingCart"})標示的物件
		log.info("執行『結帳』功能時，選擇『放棄購物』");
		String cancelOrder = "您已經取消訂單，期待您再次光臨" ;
		ra.addFlashAttribute("cancelOrder", cancelOrder);
		return  "redirect:/";
	}
}
