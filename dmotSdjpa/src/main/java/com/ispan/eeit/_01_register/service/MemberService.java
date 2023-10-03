package com.ispan.eeit._01_register.service;

import com.ispan.eeit._01_register.model.Member;
import com.ispan.eeit._04_ShoppingCart.model.OrderBean;

public interface MemberService {
	
	void save(Member mb);
	
	void checkUnpaidAmount(OrderBean ob);
	
	Member findByMemberId(String id);
	
	Member findByMemberIdAndPassword(String memberId, String password) ;

	boolean existsByMemberId(String memebrId);
}
