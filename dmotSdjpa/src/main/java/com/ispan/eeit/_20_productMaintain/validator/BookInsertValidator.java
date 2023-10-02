package com.ispan.eeit._20_productMaintain.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ispan.eeit._03_listBooks.model.Book;

public class BookInsertValidator implements Validator {

	private static Logger log = LoggerFactory.getLogger(BookInsertValidator.class);
	
	public BookInsertValidator() {
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Book book = (Book) target;
		log.info("BookValidator：檢查物件: " + book);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "book.title.empty.error", "書名欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "book.author.empty.error", "作者欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listPrice", "book.listprice.empty.error", "價格欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookNo", "book.bookno.empty.error", "書號欄不能空白");
		
		if (book.getCoverImage().trim().length() == 0 && book.getImage().trim().length() == 0) {
			errors.rejectValue("coverImage","book.image.empty.error", "必須挑選書籍圖片");
		}
		
		
		if (book.getCategory().equals("-1")) {
			errors.rejectValue("category","book.category.empty.error", "必須挑選分類欄");
		}
		if (book.getPublisher().getId() == -1) {
			errors.rejectValue("publisher","book.publisher.empty.error", "必須挑選出版社");
		}
	}
}
