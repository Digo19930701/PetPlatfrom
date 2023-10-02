package com.ispan.eeit._00_init.controller;

import java.util.Optional;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.eeit._00_common.GlobalService;
import com.ispan.eeit._00_init.service.BaseService;
import com.ispan.eeit._01_register.model.Member;
import com.ispan.eeit._01_register.service.MemberService;
import com.ispan.eeit._03_listBooks.model.Book;
import com.ispan.eeit._03_listBooks.service.BookService;



@Controller
public class BaseController {
	
	private static Logger log = LoggerFactory.getLogger(BaseController.class);

	BaseService  baseService;

	BookService  bookService;

	MemberService  memberService;

	ServletContext servletContext;

//	@Autowired
	public BaseController(BaseService baseService, BookService bookService, MemberService memberService, ServletContext servletContext) {
		this.baseService = baseService;
		this.bookService = bookService;
		this.memberService = memberService;
		this.servletContext = servletContext;
	}
	
	@GetMapping("/")
        public String index() {
		return "index";
	}

	
	@GetMapping("/initData")
	public String initData(Model model, RedirectAttributes ra) {
		String responseMessage;
		try {
			baseService.initData();
			responseMessage = "新建資料成功";
		} catch (Exception ex) {
			ex.printStackTrace();
			responseMessage = "新建資料失敗";
		}
		log.info(responseMessage);
		ra.addFlashAttribute("initDataResult", responseMessage);
		return "redirect:/";
	}

	// 本方法讀取格式為Data URI的圖片
	@GetMapping("/_00_init/getBookImage")
	public ResponseEntity<String> getBookImage(@RequestParam("id") Long id) {
		String noImagefileName = null;
		String mimeType = null;
		String media = null;
		ResponseEntity<String> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = null;
		Book book = null;
		try {
			Optional<Book>  optional = bookService.findById(id); 
			if (optional.isPresent()) {
				book = optional.get();
				media = book.getCoverImage();
			}
			if (media == null) {
				  noImagefileName = "NoImage.png";
				  mimeType = servletContext.getMimeType(noImagefileName);
				  ClassPathResource classPathResource = 
						  new ClassPathResource("/images/" + noImagefileName);
				  media = GlobalService.classPathResourceToDataUri(classPathResource, mimeType);
			}
			mediaType = MediaType.valueOf("text/plain");
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			headers.setContentType(mediaType);
			responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("_00_init.util.RetrieveBookImageServlet#doGet()發生Exception: " + ex.getMessage());
		} 
		return responseEntity;
	}

	// 本方法與getBookImage()方法極為類似，由於兩方法之參數的型態不同，所以無法合而為一
	@GetMapping("/_00_init/getMemberImage")
	public ResponseEntity<byte[]> getMemberImage(@RequestParam("id") String memberId) {
		String fileName = null;
		String mimeType = null;
		byte[] media = null;
		ResponseEntity<byte[]> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = null;
		try {
			Member member = memberService.findByMemberId(memberId);
			if (member != null) {
				media = member.getMemberImage();
				fileName = member.getFileName();
			}
			// 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)
			if (media == null || media.length == 0) {
				fileName = "NoImage.png";
				ClassPathResource classPathResource = 
						new ClassPathResource("/data/images/" + fileName);
				media = classPathResource.getInputStream().readAllBytes();
			}
			// 由圖片檔的檔名來得到檔案的MIME型態
			mimeType = member.getMimeType();
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			mediaType = MediaType.valueOf(mimeType);
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			headers.setContentType(mediaType);
			responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("_00_init.util.RetrieveBookImageServlet#doGet()發生Exception: " + ex.getMessage());
		} 
		return responseEntity;
	}
}
