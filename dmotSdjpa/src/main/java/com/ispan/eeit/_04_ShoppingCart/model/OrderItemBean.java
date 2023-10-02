package com.ispan.eeit._04_ShoppingCart.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//本類別封裝單筆訂單資料
@Entity
@Table(name = "OrderItems")
public class OrderItemBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Integer orderNo;
	Long bookId;
	String description;
	Double unitPrice;
	Integer quantity;
	Double discount;

	private String title;
	private String author;
	private String publisherName;
	
	@ManyToOne
	@JoinColumn(name = "FK_OrderBean_orderNo", foreignKey = @ForeignKey(name="FK_OrderBean_orderNo") )
	OrderBean orderBean;

	public OrderItemBean(Long id, Integer orderNo, Long bookId, String description, Integer quantity,
			Double unitPrice, Double discount, String title, String author, String publisherName) {
		this.id = id;
		this.orderNo = orderNo;
		this.bookId = bookId;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.title = title;
		this.author = author;
		this.publisherName = publisherName;
	}

	public OrderItemBean(Integer orderNo, Long bookId, String description, Integer quantity, Double unitPrice,
			Double discount) {
		this.orderNo = orderNo;
		this.bookId = bookId;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discount = discount;
	}

	public OrderItemBean() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
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

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public OrderBean getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}

}