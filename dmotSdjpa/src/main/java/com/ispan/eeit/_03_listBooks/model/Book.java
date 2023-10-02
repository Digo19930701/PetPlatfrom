package com.ispan.eeit._03_listBooks.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

// 本類別封裝單筆書籍資料
@Entity(name="BookEntity")
@Table(name="Book_Table")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private Double listPrice;
	private Double discount;
	@Lob
	private String coverImage;
	private String fileName;
	private String mimeType;
	private String bookNo;
	private String category;
	private Integer stock;
	
	@Transient
	private String discountStr;
	
	@Transient
	private String image;
	
	
	@Transient
	private Long publisherId;
	
	@ManyToOne(cascade=CascadeType.ALL)    // javax.persistence.CascadeType;
	@JoinColumn(name="FK_Publisher_Id", foreignKey = @ForeignKey(name="FK_Publisher_Id") ) 
	private Publisher publisher;  	
	
	@Transient
	MultipartFile multipartFile;
	
		
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public Book(Long id, String title, String author, Double listPrice, Double discount, String fileName, String bookNo, String coverImage,
			String category, String  mimeType) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.listPrice = listPrice;
		this.discount = discount;
		this.fileName = fileName;
		this.bookNo = bookNo;
		this.coverImage = coverImage;
		this.category = category;
		this.mimeType = mimeType;
		this.stock = 0;
	}

	public Book() {
	}

	public Long getId() { 
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	@Transient
	private String priceStr = null;

	public String getPriceStr() {
		return priceStr;
	}

	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getListPrice() {
		return listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	
	public void setDiscount(Double discount) {   //0.8, 0.75
		this.discount = discount;
		if (discount == 1) {
			discountStr = "";
		} else {
			int dnt = (int)(discount * 100);
			if (dnt % 10 == 0) {
				discountStr = (dnt / 10) + "折";
			} else {
				discountStr = " "  + dnt + "折";
			} 
		}
	}
	public String getDiscountStr() {
		setDiscount(discount);
		return discountStr;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return getPublisher().getName().substring(0, 2) + " "
				+ getAuthor().substring(0, Math.min(3, getAuthor().length())) + " " 
				+ getTitle();
	}

	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", listPrice=" + listPrice + ", discount="
				+ discount + ", coverImage=" + coverImage + ", fileName=" + fileName + ", mimeType=" + mimeType
				+ ", bookNo=" + bookNo + ", category=" + category + ", stock=" + stock + ", discountStr=" + discountStr
				+ ", publisher=" + publisher + ", multipartFile=" + multipartFile + ", priceStr=" + priceStr + "]";
	}
	
}
