package com.callor.hello.service.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authorProviderImpl")
public class AuthorProviderImpl implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String u_name = authentication.getName();
		String u_password = authentication.getCredentials().toString();
		
		//로그인한 사용자 id 를 검사하여
		//허가받은 사용자인가 확인하여 아니면 익셉션을 발생하여알려주기
		if(u_name == null || u_name.isBlank() || !u_name.equalsIgnoreCase("callor")) {
			throw new UsernameNotFoundException("USERNAME없음");
		}
		
		if(u_password == null || u_password.isBlank() || !u_password.equals("12345")) {
			throw new BadCredentialsException("비밀번호가틀림");
		}
		
		Map<String, String> user = new HashMap<>();
		user.put("username", u_name);
		user.put("email", "callor@callor.com");
		
		List<GrantedAuthority> grantList = new ArrayList<>();
//		grantList.add(new SimpleGrantedAuthority("ADMIN"));
		grantList.add(new SimpleGrantedAuthority("USER"));
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, u_password, grantList);
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return true;
	}
	

}
