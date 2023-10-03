package com.ispan.eeit._20_productMaintain.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.eeit._00_common.AbstractController;
import com.ispan.eeit._03_listBooks.model.Book;
import com.ispan.eeit._03_listBooks.model.Publisher;
import com.ispan.eeit._03_listBooks.service.BookService;
import com.ispan.eeit._03_listBooks.service.PublisherService;
import com.ispan.eeit._20_productMaintain.validator.BookInsertValidator;
@Controller
@RequestMapping("/_20_productMaintain")
@SessionAttributes({ "LoginOK", "pageNo" })
public class BookUpdateController extends AbstractController{

	private static Logger log = LoggerFactory.getLogger(BookUpdateController.class);

	PublisherService publisherService;
	
	BookService bookService;

	ServletContext  servletContext;
	
	@Autowired
	BookUpdateController(PublisherService publisherService, BookService bookService, ServletContext servletContext) {
		log.info("建構BookInsertController物件");
		this.publisherService = publisherService;
		this.bookService = bookService;
		this.servletContext = servletContext;
	}

	@GetMapping("/BookUpdate/{bookId}")
	public String showUpdateForm(Model model) {
		
		return "_20_productMaintain/BookUpdateForm";
	}
	
	@PutMapping("BookUpdate/{bookId}/{pageNo}")
	public String updateForm(@ModelAttribute("book") Book book,  
			Model model, BindingResult result, 
			RedirectAttributes redirectAttributes
			) {
		BookInsertValidator  bookInsertValidator = new BookInsertValidator();
		bookInsertValidator.validate(book, result);
		if (result.hasErrors()) {
				System.out.println("======================");
				List<ObjectError> list = result.getAllErrors();
				for(ObjectError error : list) {
					System.out.println("有錯誤：" + error);
				}
				System.out.println("======================");
			return "_20_productMaintain/BookUpdate";
		}

		String filename = book.getCoverImage();
		book.setMimeType(servletContext.getMimeType(filename));
		book.setFileName(filename);
		book.setCoverImage(book.getImage());
		
		// Step3
		Publisher publisher = book.getPublisher();
		bookService.detachBook(book);
		bookService.detachPublisher(publisher);
//		bookService.clear();
//		System.out.println("publisher=" + publisher);
		Long id = publisher.getId();
		Optional<Publisher> optional = publisherService.findById(id);
		if (optional.isPresent()) {
			publisher = optional.get();
		}
		book.setPublisher(publisher);
		bookService.save(book);
		redirectAttributes.addFlashAttribute("SUCCESS", "修改成功!!!");
		return "redirect:/_20_productMaintain/DisplayPageProducts";
	}
	
	@ModelAttribute("book")
	public Book getBook(Model model, 
			@PathVariable(value="bookId") Long bookId
		) {
		Optional<Book> optional = null;
		Book book = null;
		
		optional = bookService.findById(bookId);
		if (optional.isPresent()) {
			book = optional.get();
			model.addAttribute("image", book.getCoverImage());
		} 
		return book;
	}
	@ModelAttribute // publisherList
	public List<Publisher> getPublisher() {
		return publisherService.findAll();
	}

	@ModelAttribute("categoryList")
	public List<String> getCategory() {
		return bookService.findAllByCategory();
	}
}
