package com.ispan.eeit._01_register.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.eeit._01_register.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	@Modifying
	@Query("UPDATE MemberEntity SET unpaid_amount = unpaid_amount + :totalAmount "
	 	 + " WHERE memberId = :mid")
    public void updateUnpaidAmount(@Param("totalAmount") Double totalAmount, 
    		                 @Param("mid") String mid);
	
//	Member save(Member member) ;
	
	Member findByMemberId(String memberId);
	
//	Member findByMemberIdAndPassword(String memberId, String password);	
}