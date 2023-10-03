package com.ispan.eeit._04_ShoppingCart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.eeit._01_register.model.Member;
import com.ispan.eeit._04_ShoppingCart.model.ShoppingCart;

@Controller
@CrossOrigin("http://localhost:5173")
@RequestMapping("/_04_ShoppingCart")
@SessionAttributes({ "LoginOK", "ShoppingCart"})
public class ShoppingCartController {
	private static Logger log = LoggerFactory.getLogger(ShoppingCartController.class);
	
	private final static String SHOW_CART_CONTENT = "_04_ShoppingCart/ShowCartContent"; 
	@GetMapping("/ShowCartContent")
	protected String showCartContent(Model model, SessionStatus status) {
		Member member = (Member) model.getAttribute("LoginOK");
		if (member == null) {
			status.setComplete();
			return "redirect:/_02_login/login";
		}
		return  "_04_ShoppingCart/ShowCartContent";
	}
	
	@GetMapping("/checkout")
	protected String checkout(Model model, SessionStatus status) {
		Member member = (Member) model.getAttribute("LoginOK");
		if (member == null) {
			status.setComplete();
			return "redirect:/_02_login/login";
		}
		log.info("訂單確認");
		return  "_04_ShoppingCart/OrderConfirm";
	}
	@PostMapping("/UpdateItem.do")
	protected String UpdateItem(
			@RequestParam("cmd")   String cmd,  
			@RequestParam(value = "bookId", required = false) Long  bookId, 
			@RequestParam(value = "newQty", required = false) Integer  newQty, 
			Model model, 
			RedirectAttributes ra, 
			HttpSession session, SessionStatus status
	) {
		ShoppingCart sc = (ShoppingCart) model.getAttribute("ShoppingCart");
		if (sc == null) {
			status.setComplete();
			return "redirect:/_02_login/login";
		}
		Member member = (Member) model.getAttribute("LoginOK");
		if (member == null) {
			status.setComplete();
			return "redirect:/_02_login/login";
		}
		log.info("cmd=" + cmd);
		if (cmd.equalsIgnoreCase("DEL")) {
	        sc.deleteBook(bookId); // 刪除購物車內的某項商品
		    return SHOW_CART_CONTENT;
		} else if (cmd.equalsIgnoreCase("MOD")) {
			sc.modifyQty(bookId, newQty);   // 修改某項商品的數項
		    return SHOW_CART_CONTENT;
		} else {
			return SHOW_CART_CONTENT;
		}
	}
}
