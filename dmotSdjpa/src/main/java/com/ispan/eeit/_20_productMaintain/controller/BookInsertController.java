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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.eeit._03_listBooks.model.Book;
import com.ispan.eeit._03_listBooks.model.Publisher;
import com.ispan.eeit._03_listBooks.service.BookService;
import com.ispan.eeit._03_listBooks.service.PublisherService;
import com.ispan.eeit._20_productMaintain.validator.BookInsertValidator;
@Controller
@RequestMapping("/_20_productMaintain")
@SessionAttributes({ "LoginOK", "pageNo" })
public class BookInsertController {

	private static Logger log = LoggerFactory.getLogger(BookInsertController.class);

	PublisherService publisherService;
	
	BookService bookService;
	ServletContext  servletContext;
	@Autowired
	public BookInsertController(PublisherService publisherService, BookService bookService, ServletContext  servletContext) {
		log.info("建構BookInsertController物件");
		this.publisherService = publisherService;
		this.bookService = bookService;
		this.servletContext = servletContext;
	}
	
	@GetMapping("/BookInsert")
	public String getForm(Model model) {
		return "_20_productMaintain/InsertBookForm";
	}
	
	@PostMapping("/BookInsert")
	public String saveForm(Model model, @ModelAttribute Book book, BindingResult result, 
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
			
			model.addAttribute("image", book.getImage());
			
			return "_20_productMaintain/InsertBookForm";
		}

		// 存檔前需要執行：
		// 1. 設定fileName屬性
		// 2. 將圖片由 productImage屬性轉換為Blob後存入 coverImage屬性
		// 3. 依照Publisher.id的值讀取 Publisher，然後存入 Publisher屬性
		
		// Step1
		String filename = book.getCoverImage();
		book.setMimeType(servletContext.getMimeType(filename));
		book.setFileName(filename);
//		String imageOriginalFilename = bean.getProductImage().getOriginalFilename();
		book.setFileName(filename);
		// Step2		

		book.setCoverImage(book.getImage());

		// Step3
		Optional<Publisher> optional =  publisherService.findById(book.getPublisher().getId());
		Publisher publisher = null;
		if (optional.isPresent()) {
			publisher = optional.get();
		}
		book.setPublisher(publisher);
		if (book.getDiscount() == null) {
			book.setDiscount(1.0);
		}
		
		if (book.getStock() == null) {
			book.setStock(0);
		}
		bookService.save(book);
		redirectAttributes.addFlashAttribute("SUCCESS", "新增成功!!!");
		return "redirect:/_20_productMaintain/DisplayPageProducts";
	}
	
	@ModelAttribute("book")
	public Book getBook(
			) {
		Book book = new Book();
//			book.setTitle("Spring框架");
//            book.setAuthor("黃曉芳");
//            book.setListPrice(500.0);
//            book.setBookNo("UU001");
//            Publisher publisher = new Publisher();
//            publisher.setId(1L);
//            book.setPublisher(publisher);
		
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
