package com.ispan.eeit._01_register.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ispan.eeit._01_register.model.Member;
@Component
public class MemberValidator implements Validator {
	
	private static Logger log = LoggerFactory.getLogger(MemberValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		    Member member = (Member) target;    // space, tab, enter
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberId", 	"", "帳號欄不能空白");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", 		"", "姓名欄不能空白");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", 	"", "密碼欄不能空白");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password1", 	"", "確認密碼欄不能空白");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", 	"", "地址欄不能空白");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", 		"", "電子郵件欄不能空白");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", 		"", "電話欄不能空白");
			ValidationUtils.rejectIfEmpty(errors, "multipartFile",    "", "必須挑選圖片");
			
			if ( !errors.hasFieldErrors("memberId")) {
				if (member.getMemberId().length() < 5) {
					errors.rejectValue("memberId","", "帳號欄不能小於五個字元");
				}
			}
			
			if (! member.getPassword().equals(member.getPassword1())) {
				errors.rejectValue("password","", "密碼欄與確認密碼不一致");
			}
			log.info("MemberValidator.validate()");
			if (member.getMultipartFile().getSize() == 0) {
				errors.rejectValue("multipartFile", "", "必須挑選圖片");
			}
		
	}

}
