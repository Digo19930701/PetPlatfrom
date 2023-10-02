package com.ispan.eeit._03_listBooks.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// 本類別封裝單筆出版社資料
@Entity(name="PublisherEntity")
@Table(name="Publisher_Table")
public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String  name;
	private String  address;
	private String  url;
	@OneToMany(mappedBy="publisher")
	private Set<Book> books = new LinkedHashSet<>();
	
	public Publisher(Long id, String name, String address, String url) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.url = url;
	}
	public Publisher() {
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
	
	public Set<Book> getBooks() {
		return books;
	}
	
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", address=" + address + ", url=" + url + "]";
	}
	
}