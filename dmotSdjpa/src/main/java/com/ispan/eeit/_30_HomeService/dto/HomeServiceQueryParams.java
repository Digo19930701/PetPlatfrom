package com.ispan.eeit._30_HomeService.dto;

import com.ispan.eeit._30_HomeService.constant.HomeServiceCategory;

public class HomeServiceQueryParams {
	private HomeServiceCategory category;
	private String search;
	public HomeServiceCategory getCategory() {
		return category;
	}
	public void setCategory(HomeServiceCategory category) {
		this.category = category;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
