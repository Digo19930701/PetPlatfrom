package com.ispan.eeit._21_petService.model;

import java.util.List;

import com.ispan.eeit._30_HomeService.model.HomeServiceType;

public class PetServiceDetail extends PetService{

	private List<HomeServiceType> hst; 

	public PetServiceDetail(){
		super();
	}
	public PetServiceDetail(List<HomeServiceType> hst) {
		super();
		this.hst = hst;
	}
	
	public List<HomeServiceType> getHst() {
		return hst;
	}
	public void setHst(List<HomeServiceType> hst) {
		this.hst = hst;
	}

}
