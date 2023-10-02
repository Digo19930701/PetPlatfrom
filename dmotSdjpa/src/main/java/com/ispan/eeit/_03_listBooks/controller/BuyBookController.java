package com.ispan.eeit._03_listBooks.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ispan.eeit._01_register.model.Member;
import com.ispan.eeit._03_listBooks.model.Book;
import com.ispan.eeit._04_ShoppingCart.model.OrderItemBean;
import com.ispan.eeit._04_ShoppingCart.model.ShoppingCart;
// 當使用者按下『加入購物車』時，瀏覽器會送出請求到本程式
@Controller
@RequestMapping("_03_listBooks")
@SessionAttributes({ "LoginOK", "pageNo", "products_DPP", "ShoppingCart"})
public class BuyBookController {
	private static Logger log = LoggerFactory.getLogger(BuyBookController.class);

	@SuppressWarnings("unchecked")
	@PostMapping("/buyBook")
	protected String buyBook(Model model,
			@RequestParam("bookId") Long bookId,
			@RequestParam("qty") Integer qty
	) throws ServletException, IOException {
		Member member = (Member) model.getAttribute("LoginOK");
		if (member == null) {
			return "redirect:/_02_login/login";
		}
		// 取出存放在session物件內的ShoppingCart物件
		ShoppingCart cart = (ShoppingCart) model.getAttribute("ShoppingCart");
		// 如果找不到ShoppingCart物件
		if (cart == null) {
			log.info("新建ShoppingCart物件");
			// 就新建ShoppingCart物件
			cart = new ShoppingCart();
			// 並將此新建ShoppingCart的物件放到session物件內，成為它的屬性物件
			model.addAttribute("ShoppingCart", cart);   
		}
		Map<Long, Book> bookMap = (Map<Long, Book>) model.getAttribute("products_DPP");
		Book bean = bookMap.get(bookId);
		// 將訂單資料(價格，數量，折扣與BookBean)封裝到OrderItemBean物件內
		OrderItemBean oib = new  OrderItemBean(null, null, bookId, bean.getDescription(), qty, 
	    		bean.getListPrice(), bean.getDiscount(), bean.getTitle(), bean.getAuthor(), bean.getPublisher().getName());
		// 將OrderItem物件內加入ShoppingCart的物件內
		cart.addToCart(bookId, oib);
		log.info("執行ShoppingCart物件的addToCart(), oib=" + oib);
		return  "_03_listBooks/listBooks";
	}
}