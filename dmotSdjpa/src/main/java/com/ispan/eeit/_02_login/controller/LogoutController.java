package com.ispan.eeit._02_login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.eeit._01_register.model.Member;

@Controller
@RequestMapping("/_02_login")
@SessionAttributes({"LoginOK"}) 
public class LogoutController {
	
	private static Logger log = LoggerFactory.getLogger(LogoutController.class);
	
	@GetMapping("/logout")
	public String logout(HttpSession session,  Model model, SessionStatus status,
			RedirectAttributes redirectAtt
			) {
		String name = "";
		Member member = (Member) model.getAttribute("LoginOK");
		if (member != null) {
			name = member.getName();
		} else {
			name = "訪客";
		}
		log.info(name + "已登出");
		String farewellMessage = name + "您已登出，期待您再次蒞臨本網站";
		redirectAtt.addFlashAttribute("logoutMessage", farewellMessage);
		// 登出時執行下列兩敘述
		status.setComplete();		// 移除@SessionAttributes({"LoginOK"}) 標示的屬性物件
		session.invalidate();		// 此敘述不能省略		
		return "redirect:/";		// 跳轉回http://localhost:8080/Context_Path/
		
	}
}
