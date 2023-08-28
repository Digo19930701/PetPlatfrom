package _20_productMaintain.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import _03_listBooks.model.BookBean;

public class BookValidator implements Validator {

	private static Logger log = LoggerFactory.getLogger(BookValidator.class);
	
	boolean insertMode = true;
	
	public BookValidator() {
	}

	public BookValidator(boolean insertMode) {
		this.insertMode = insertMode;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return BookBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookBean bean = (BookBean) target;
		log.info("BookValidator：檢查物件: " + bean);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "", "書名欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "", "作者欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listPrice", "", "價格欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookNo", "", "書號欄不能空白");
		
//		Double price = Double.parseDouble(bean.getListPrice());
		
		if (bean.getCategory().equals("0")) {
			errors.rejectValue("category","", "必須挑選分類欄");
		}
		if (insertMode) {
			if (bean.getProductImage().isEmpty()) {
				errors.rejectValue("productImage","", "必須挑選圖片");
			}
		}
		if (bean.getCompanyBean().getId() == -1) {
			errors.rejectValue("companyBean","", "必須挑選出版社");
		}
	}
}
