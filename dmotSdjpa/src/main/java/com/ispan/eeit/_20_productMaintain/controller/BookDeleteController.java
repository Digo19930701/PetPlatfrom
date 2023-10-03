package com.ispan.eeit._20_productMaintain.controller;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.eeit._00_common.AbstractController;
import com.ispan.eeit._03_listBooks.service.BookService;
import com.ispan.eeit._03_listBooks.service.PublisherService;
@Controller
@RequestMapping("/_20_productMaintain")
@SessionAttributes({ "LoginOK", "pageNo" })
public class BookDeleteController extends AbstractController{

	private static Logger log = LoggerFactory.getLogger(BookDeleteController.class);

	BookService bookService;
//
	@Autowired
	public BookDeleteController(PublisherService publisherService, BookService bookService, ServletContext servletContext) {
		log.info("建構BookDeleteController物件");
		this.bookService = bookService;
	}

	@DeleteMapping(value="/BookDelete/{bookId}")
	public String deleteBook(@PathVariable Long bookId,
			RedirectAttributes redirectAttributes
		) {
		bookService.deleteById(bookId);
		redirectAttributes.addFlashAttribute("SUCCESS", "刪除成功!!!");
		return "redirect:/_20_productMaintain/DisplayPageProducts";
	}
	
}
