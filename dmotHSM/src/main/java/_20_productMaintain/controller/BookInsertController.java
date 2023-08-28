package _20_productMaintain.controller;

import java.sql.Blob;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import _00_init.util.SystemUtils2018;
import _03_listBooks.model.BookBean;
import _03_listBooks.model.CompanyBean;
import _03_listBooks.service.BookService;
import _03_listBooks.service.CompanyService;
import _20_productMaintain.validator.BookValidator;
@Controller
@RequestMapping("/_20_productMaintain")
                
@SessionAttributes({ "LoginOK", "pageNo" })
public class BookInsertController {

	private static Logger log = LoggerFactory.getLogger(BookInsertController.class);

	CompanyService companyService;
	
	BookService bookService;
	
	@Autowired
	public BookInsertController(CompanyService companyService, BookService bookService) {
		log.info("建構BookInsertController物件");
		this.companyService = companyService;
		this.bookService = bookService;
	}
	
	@GetMapping("BookInsert")
	public String getForm(Model model) {
		return "_20_productMaintain/BookInsert";
	}
	

	@GetMapping("BookUpdate/{bookId}/{pageNo}")
	public String showUpdateForm(Model model) {
		return "_20_productMaintain/BookUpdate";
	}
	
	
	@PostMapping("BookUpdate/{bookId}/{pageNo}")
	public String updateForm(@ModelAttribute("bookBean") BookBean bean,  
			Model model, BindingResult result, 
			RedirectAttributes redirectAttributes
			) {
		long sizeInBytes = -1;
		BookValidator  validator = new BookValidator(false);
		validator.validate(bean, result);
		if (result.hasErrors()) {
				System.out.println("======================");
				List<ObjectError> list = result.getAllErrors();
				for(ObjectError error : list) {
					System.out.println("有錯誤：" + error);
				}
				System.out.println("======================");
			return "_20_productMaintain/BookUpdate";
		}
		
		if (bean.getProductImage().getSize() == 0) {
			sizeInBytes = -1;
		} else {
			sizeInBytes = bean.getProductImage().getSize();
			// Step1
			String imageOriginalFilename = bean.getProductImage().getOriginalFilename();
			bean.setFileName(imageOriginalFilename);
			// Step2		
			Blob coverImage = null;
			try {
				byte[] b = bean.getProductImage().getBytes();
				coverImage = new SerialBlob(b);
			} catch(Exception e) {
				e.printStackTrace();
			}
			bean.setCoverImage(coverImage);
		}
		// Step3
		CompanyBean companyBean = companyService.findById(bean.getCompanyBean().getId());
		bean.setCompanyBean(companyBean);
		bookService.updateBook(bean, sizeInBytes);
		redirectAttributes.addFlashAttribute("SUCCESS", "修改成功!!!");
		return "redirect:/_20_productMaintain/DisplayPageProducts";
	}
	
	@PostMapping(value="/BookDelete/{bookId}")
	public String deleteBook(@PathVariable Integer bookId,
			RedirectAttributes redirectAttributes
		) {
		bookService.deleteById(bookId);
		redirectAttributes.addFlashAttribute("SUCCESS", "刪除成功!!!");
		return "redirect:/_20_productMaintain/DisplayPageProducts";
	}
	
	@PostMapping("BookInsert")
	public String saveForm(Model model, @Valid BookBean bean, BindingResult result, 
			RedirectAttributes redirectAttributes
			) {
		
		BookValidator  validator = new BookValidator();
		validator.validate(bean, result);
		if (result.hasErrors()) {
			System.out.println("======================");
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			System.out.println("======================");
			return "_20_productMaintain/BookInsert";
		}

		// 存檔前需要執行：
		// 1. 設定fileName屬性
		// 2. 將圖片由 productImage屬性轉換為Blob後存入 coverImage屬性
		// 3. 依照companyBean.id的值讀取 CompanyBean，然後存入 companyBean屬性
		
		// Step1
		String imageOriginalFilename = bean.getProductImage().getOriginalFilename();
		bean.setFileName(imageOriginalFilename);
		// Step2		
		Blob coverImage = null;
		try {
			byte[] b = bean.getProductImage().getBytes();
			coverImage = new SerialBlob(b);
		} catch(Exception e) {
			e.printStackTrace();
		}
		bean.setCoverImage(coverImage);
		// Step3
		CompanyBean companyBean = companyService.findById(bean.getCompanyBean().getId());
		bean.setCompanyBean(companyBean);
		if (bean.getDiscount() == null) {
			bean.setDiscount(1.0);
		}
		
		if (bean.getStock() == null) {
			bean.setStock(0);
		}
		bookService.save(bean);
		redirectAttributes.addFlashAttribute("SUCCESS", "新增成功!!!");
		return "redirect:/_20_productMaintain/DisplayPageProducts";
	}
	
	@ModelAttribute("bookBean")
	public BookBean getBookBean(
			@PathVariable(value="bookId", required = false) Integer bookId, 
			@PathVariable(value="pageNo", required = false) Integer pageNo
			) {
		
		BookBean bean = null;
		if (bookId == null) {
			bean = new BookBean();
		} else {
			System.out.println("bookId=" + bookId);
			System.out.println("pageNo=" + pageNo);
			bean = bookService.findById(bookId);
		}
		return bean;
	}
	@ModelAttribute // companyBeanList
	public List<CompanyBean> getCompany() {
		return companyService.findAll();
	}

	@ModelAttribute("category")
	public List<String> getCategory() {
		return bookService.findAllCategories();
	}
}
