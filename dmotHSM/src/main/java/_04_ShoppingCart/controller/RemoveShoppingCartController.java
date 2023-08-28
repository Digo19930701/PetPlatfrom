package _04_ShoppingCart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/_04_ShoppingCart")
// 由於要執行status.setComplete();來移除Session範圍的ShoppingCart物件，所以
// @SessionAttributes({ "ShoppingCart" }) 只能單讀編寫該物件的識別字串。
@SessionAttributes({ "ShoppingCart", "MemberName_ThanksForOrdering" })
public class RemoveShoppingCartController {
	private static Logger log = LoggerFactory.getLogger(RemoveShoppingCartController.class);
	
	@RequestMapping("/removeShoppingCart")
	public String removeCart(Model model, WebRequest webRequest, 
			SessionStatus status, RedirectAttributes ra) {
		status.setComplete();
		webRequest.removeAttribute("ShoppingCart", WebRequest.SCOPE_SESSION);
		log.info("已經移除購物車");
		return "redirect:" + "/_04_ShoppingCart/ThanksForOrdering";
	}
	
	@RequestMapping("/ThanksForOrdering")
	public String thanksForOrdering(Model model, WebRequest webRequest, 
			SessionStatus status, RedirectAttributes ra) {
		ra.addFlashAttribute("MemberName_ThanksForOrdering", model.getAttribute("MemberName_ThanksForOrdering"));
		log.info("謝謝訂購");
		return "ThanksForOrdering";
	}
}
