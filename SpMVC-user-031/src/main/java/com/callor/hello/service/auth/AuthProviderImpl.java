package com.callor.hello.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.hello.dao.RoleDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.RoleVO;
import com.callor.hello.models.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider {
	
	/*
	 * @Autowired 
	 * 기본 생성자를 통하여 UserDao type 의 userDao 객체를 주입받는 형태
	 * Autowired 를 사용하여 생성자 주입을 하게되면 
	 * 		userDao 객체에 final 을 사용할 수 없다
	 * 클래스영역, 필드영역에 선언되는 객체(클래스를 이용하여 선언한 변수들)
	 * 가급적 final 을 부착시키는 것이 메모리 관리에서 좋다고 한다
	 * final 을 부착하면 사용이 종료된 객체들이 자동으로 
	 * 	GC( Garbage Collection, 객체 메모리 제거 ) 가 된다.
	 * final 을 부착하지 않으면 GC 가 지연되는 현상이 있다고 한다.
	 * 메모리가 낭비되는 현상(Memory Leak)이 있을 수 있다.
	 */
	private final PasswordEncoder passwordEncoder;

	private final UserDao userDao;
	private final RoleDao roleDao;
	
	public AuthProviderImpl(
			@Qualifier("passEncorderV1") PasswordEncoder passwordEncoder, 
			UserDao userDao, RoleDao roleDao) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userDao = userDao;
		this.roleDao = roleDao;
	}

	// 로그인 과정을 가로채서 Custom 하는 곳 
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		log.debug("로그인한 사용자 정보 {},{}", username, password);
		
		UserVO userVO = userDao.findById(username);
		if(userVO == null) {
			/*
			 * 사용자 id(username) 이 DB 에서 조회가 안될 경우
			 * UsernameNotFoundException 을 강제 발생시켜
			 * 코드의 진행을 중단하고 method 를 deep 호출한 곳까지 되돌리기
			 * 결국 Front 까지 메시지를 전달하기 위한 방법 
			 */
			throw new UsernameNotFoundException(String.format("USERNAME 확인 : %s 는 없음",username));
		}
		
		boolean passOK = passwordEncoder.matches(password, userVO.getPassword() );
		if(!passOK) {
			throw new BadCredentialsException("비밀번호를 다시 확인하세요");
		}
		
		
		// 로그인 후 role 정보가져오기
		List<RoleVO> roles = roleDao.findByUserName(username);
		List<GrantedAuthority>grantList = new ArrayList<GrantedAuthority>();
		
		//문자열로 되어 있는 권한 정보를 GrantedAuthority type 으로 변화하기
		for(RoleVO r : roles) {
			grantList.add(new SimpleGrantedAuthority(r.getR_role()));
		}
		
		// DB로 부터 조회된 사용자 정보(userVO) 와
		// 권한 정보 (grantList) 를 사용하여 token(통행증) 발생하기
		Authentication token = new UsernamePasswordAuthenticationToken(userVO, password,grantList);
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
