package com.callor.gallery.service.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class AuthUtils {
	
	/*
	 * PasswordEncoder 는 비밀번호 등을 일방 통행(단방향)으로 
	 * 암호화를 하기 위한 도구이다.
	 * 이 클래스 type encoder객체를 통하여 회원가입을 할때 비밀번호를 암호화하고
	 * 로그인을 할때 다시 한번 암호문과 비교하는 method 를 사용하게 된다.
	 * 결국 프로젝트 전체로 보면 encoder 라는 객체를 두번 생성하고 사용하게 된다.
	 * 그때는 다음과 같은 코드를 사용하여 객체를 생성하여 사용하면 된다.
	 * PasswordEncoder encoder = new BCryptPasswordEncoder();
	 * 
	 * 하지만, spring project 는 다수의 client 가 접근하는 서버 어플리케이션 이다.
	 * 프로젝트 전체에서는 객체가 2번만 생성하면되지만
	 * 사용자가 접근을 할 경우 사용자 마다 2번씩 생성되는 결과가 만들어진다.
	 * 이런 상황이 되면 spring project의 원칙은 객체를 singletone 으로 만들고 
	 * 필요한 곳에 DI(의존성주입)을 하여 사용하도록 하고 잇다.
	 * 
	 * 그래서 번거롭지만 Bean 으로 생성해 두는 코드를 미리 만든다.
	 * Bean 생성코드는 보통 *-context.xml에서 만들지만
	 * @Bean Annotation 을 사용하여 Java code 로 만들 수 있다.
	 * 
	 * 현재 AuthUtils 클래스는 @Component 가 선언되어있고 
	 * 프로젝트가 실행될때 현재 
	 * 패키지가 스캔되고 @빈 이 설정된 메소드가 실행되면서 
	 *  passwordEncoder 객체가 만들어지고 spring container 에 보관된다.
	 */
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
