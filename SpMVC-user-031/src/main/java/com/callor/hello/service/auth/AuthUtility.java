package com.callor.hello.service.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUtility {
	
	/*
	 * Spring Security 에서 주로 비밀번호 암호화를 하기 위한 
	 * 일방향 암호화 도구
	 * 
	 * 회원정보를 추가할때 비밀번호를 암호화 하기 위한 도구 
	 */
	@Bean(name="passEncorderV1")
	public PasswordEncoder passwordEncoder() {
		/*
		 * SHA-1 * 무작위적인 8byte Salt 를 버물려서 문자열을 암호화한다
		 * 똑같은 값을 입력해도 비번은 다르게 생성된다
		 */
		// passwordEncorder type 을 만들어줌
		return new BCryptPasswordEncoder();
	}

}
