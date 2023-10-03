package com.ispan.eeit._01_register.controller;

import java.io.File;
import java.sql.Timestamp;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.eeit._00_common.GlobalService;
import com.ispan.eeit._01_register.model.Member;
import com.ispan.eeit._01_register.service.MemberService;
import com.ispan.eeit._01_register.validator.MemberValidator;

@Controller
@RequestMapping("/_01_register")
public class PersistMemberController {
	
	private static Logger log = LoggerFactory.getLogger(PersistMemberController.class);
	
	String rootDirectory = GlobalService.IMAGE_FILE_FOLDER_MEMBER;
	String inputDataForm = "_01_register/registerForm"; 
	
	MemberService memberService;
	
	ServletContext servletContext;
	
//	@Autowired
	public PersistMemberController(MemberService memberService, ServletContext servletContext) {
		this.memberService = memberService;
		this.servletContext = servletContext;
	}

	@GetMapping("/register")
	public String sendingEmptyForm(Model model) {
		Member member = new Member();
		member.setName("王麗莎" );
		member.setPassword("Do!ng456");
		member.setPassword1("Do!ng456");
		member.setMemberId("a1011");
		member.setAddress("新竹市大同路100號");
		member.setPhone("0919-123456");
		member.setEmail("scwang39165@outlook.com");
		model.addAttribute("member", member);
		return inputDataForm;
	}
	
	@PostMapping("/register")
	public String processFormData(
			@ModelAttribute Member member,
			BindingResult result, Model model,
			RedirectAttributes ra
		) {
		MemberValidator validator = new MemberValidator();
		validator.validate(member, result);
		if (result.hasErrors()) {
//          下列敘述可以理解Spring MVC如何處理錯誤			
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError error : list) {
//				System.out.println("有錯誤：" + error);
//			}
			return inputDataForm;
		}
		MultipartFile multipartFile = member.getMultipartFile();
		String originalFilename = multipartFile.getOriginalFilename();
		
		if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
			member.setFileName(originalFilename);
		}
		
		String ext = "";
		if (originalFilename.lastIndexOf(".") > -1) {
			ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		}
		
		// 建立Blob物件，交由 Hibernate 寫入資料庫
		if (multipartFile != null && !multipartFile.isEmpty()) {
			try {
				byte[] b = multipartFile.getBytes();
				member.setMemberImage(b);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
        String mimeType = servletContext.getMimeType(originalFilename); 
        member.setMimeType(mimeType);
		
		// 檢查 memberId是否重複
		if (memberService.existsByMemberId(member.getMemberId())) {
			result.rejectValue("memberId", "", "帳號已存在，請重新輸入");
			return inputDataForm;
		}
		
		member.setPassword(GlobalService.encodeBCryptPassword(member.getPassword()));
		try {
			memberService.save(member);
			log.info("新增MemberBean成功：" + member);
			ra.addFlashAttribute("SUCCESS", "會員: " + member.getName() +  "資料新增成功");
		} 
		catch (Exception ex) {
			System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());
			result.rejectValue("memberId", "", "發生異常，請通知系統人員..." + ex.getMessage());
			return inputDataForm;
		}
//		
		try {
			File imageFolder = new File(rootDirectory);
			if (!imageFolder.exists())
				imageFolder.mkdirs();
			File file = new File(imageFolder, "MemberImage_" + member.getMemberId() + ext);
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
		}
		return "redirect:/";
	}
	
	@ModelAttribute
	public Member prepareMemberBean() {
		Member member = new Member();
		Timestamp registerTime = new Timestamp(System.currentTimeMillis());
		member.setRegisterTime(registerTime);
		member.setTotalAmt(0.0);
		member.setUnpaid_amount(0.0);
		member.setUserType("M");
		return member;
	}
	
}
