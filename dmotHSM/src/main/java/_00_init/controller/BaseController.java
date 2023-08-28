package _00_init.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import _00_init.service.BaseService;
import _01_register.model.MemberBean;
import _01_register.service.MemberService;
import _03_listBooks.model.BookBean;
import _03_listBooks.service.BookService;

@Controller
public class BaseController {
	
	private static Logger log = LoggerFactory.getLogger(BaseController.class);

	BaseService  baseService;

	BookService  bookService;

	MemberService  memberService;

	ServletContext servletContext;

	@Autowired
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

	// 本方法與getMemberImage()方法極為類似，由於兩方法之參數 id 的型態不同，所以無法合而為一
	@GetMapping("/_00_init/getBookImage")
	public ResponseEntity<byte[]> getBookImage(@RequestParam("id") Integer id) {
		InputStream is = null;
		OutputStream os = null;
		String fileName = null;
		String mimeType = null;
		byte[] media = null;
		ResponseEntity<byte[]> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = null;
		Blob blob = null;
		try {
			BookBean bean = bookService.findById(id);
			if (bean != null) {
				blob = bean.getCoverImage();
				if (blob != null) {
					is = blob.getBinaryStream();
				}
				fileName = bean.getFileName();
			}
			// 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)
			if (is == null) {
				fileName = "NoImage.png";
				is = servletContext.getResourceAsStream("/images/" + fileName);
			}
			// 由圖片檔的檔名來得到檔案的MIME型態
			mimeType = servletContext.getMimeType(fileName);
			if (mimeType == null) {
				if (fileName.endsWith("jfif")) {
					mimeType = "image/jfif";
				}
			}
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// 由InputStream讀取位元組，然後由OutputStream寫出
			int len = 0;
			byte[] bytes = new byte[8192];

			while ((len = is.read(bytes)) != -1) {
				baos.write(bytes, 0, len);
			}
			media = baos.toByteArray();
			mediaType = MediaType.valueOf(mimeType);
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			headers.setContentType(mediaType);
			responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("_00_init.util.RetrieveBookImageServlet#doGet()發生Exception: " + ex.getMessage());
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				;
			}
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				;
			}
		}
		return responseEntity;
	}

	// 本方法與getBookImage()方法極為類似，由於兩方法之參數 id 的型態不同，所以無法合而為一
	@GetMapping("/_00_init/getMemberImage")
	public ResponseEntity<byte[]> getMemberImage(@RequestParam("id") String id) {
		InputStream is = null;
		OutputStream os = null;
		String fileName = null;
		String mimeType = null;
		byte[] media = null;
		ResponseEntity<byte[]> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = null;
		Blob blob = null;
		try {
			MemberBean bean = memberService.findByMemberId(id);
			if (bean != null) {
				blob = bean.getMemberImage();
				if (blob != null) {
					is = blob.getBinaryStream();
				}
				fileName = bean.getFileName();
			}
			// 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)
			if (is == null) {
				fileName = "NoImage.png";
				is = servletContext.getResourceAsStream("/images/" + fileName);
			}
			// 由圖片檔的檔名來得到檔案的MIME型態
			mimeType = servletContext.getMimeType(fileName);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// 由InputStream讀取位元組，然後由OutputStream寫出
			int len = 0;
			byte[] bytes = new byte[8192];

			while ((len = is.read(bytes)) != -1) {
				baos.write(bytes, 0, len);
			}
			media = baos.toByteArray();
			mediaType = MediaType.valueOf(mimeType);
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			headers.setContentType(mediaType);
			responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("_00_init.util.RetrieveBookImageServlet#doGet()發生Exception: " + ex.getMessage());
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				;
			}
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				;
			}
		}
		return responseEntity;
	}
}
