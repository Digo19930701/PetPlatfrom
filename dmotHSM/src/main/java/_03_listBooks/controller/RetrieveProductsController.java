package _03_listBooks.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import _03_listBooks.model.BookBean;
import _03_listBooks.service.BookService;

@Controller
@RequestMapping("_03_listBooks")
@SessionAttributes({ "LoginOK", "pageNo", "products_DPP", "totalPages" })
public class RetrieveProductsController {
	private static Logger log = LoggerFactory.getLogger(RetrieveProductsController.class);

	BookService service;

	@Autowired
	public RetrieveProductsController(BookService service) {
		this.service = service;
	}

	@GetMapping("/DisplayPageProducts")
	public String getPageProduct(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		MemberBean memberBean = (MemberBean) model.getAttribute("LoginOK");
		if (memberBean == null) {
			return "redirect:/_02_login/login";
		}
		String memberId = memberBean.getMemberId();
		if (pageNo == null) {
			pageNo = 1;
			// 讀取瀏覽器送來的所有 Cookies
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				// 逐筆檢視Cookie內的資料
				for (Cookie c : cookies) {
					if (c.getName().equals(memberId + "pageNo")) {
						try {
							pageNo = Integer.parseInt(c.getValue().trim());
						} catch (NumberFormatException e) {
							;
						}
						break;
					}
				}
			}
		}
		log.info("讀取商品資訊，pageNo=" + pageNo);
		model.addAttribute("baBean", service);
		Map<Integer, BookBean> bookMap = service.getPageBooks(pageNo);
		model.addAttribute("pageNo", String.valueOf(pageNo));
		model.addAttribute("totalPages", service.getTotalPages());
		// 將讀到的一頁資料放入request物件內，成為它的屬性物件
		model.addAttribute("products_DPP", bookMap);
		// 使用Cookie來儲存目前讀取的網頁編號，Cookie的名稱為memberId + "pageNo"
		// -----------------------
		Cookie pnCookie = new Cookie(memberId + "pageNo", String.valueOf(pageNo));
		// 設定Cookie的存活期為30天
		pnCookie.setMaxAge(30 * 24 * 60 * 60);
		// 設定Cookie的路徑為 Context Path
		pnCookie.setPath(request.getContextPath());
		// 將Cookie加入回應物件內
		response.addCookie(pnCookie);

		return "_03_listBooks/listBooks";
	}
}
