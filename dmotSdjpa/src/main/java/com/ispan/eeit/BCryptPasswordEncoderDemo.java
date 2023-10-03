package com.ispan.eeit;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderDemo {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pswd = "L!st@1span";
		
		String  encrypted1 =  passwordEncoder.encode(pswd);
		String  encrypted2 =  passwordEncoder.encode(pswd);
		String  encrypted3 =  passwordEncoder.encode(pswd);
		
		System.out.println(encrypted1);
		System.out.println(encrypted2);
		System.out.println(encrypted3);
		
		System.out.println(passwordEncoder.matches(pswd, encrypted1));
		System.out.println(passwordEncoder.matches(pswd, encrypted2));
		System.out.println(passwordEncoder.matches(pswd, encrypted3));

	}

}
