package com.callor.gallery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/*
 * @Configuration이 붙는순간 bean-context.xml과 동일한 역할 수행
 * 
 * @EnableWebMvc는 annotation-driven 을 대신하는 설정
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.callor.gallery.controller","com.callor.gallery.service"})
public class ServletContextConfig implements WebMvcConfigurer{
	
	// resource-mapping을 대신하는 코드

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		

		registry.addResourceHandler("/css/**").addResourceLocations("/static/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/static/js/");
		
		registry.addResourceHandler("/images/**").addResourceLocations("file:///app/upload/","/static/images/");
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
	}

	//view 를 렌더링하는 빈 생성
	@Bean
	public ViewResolver viewResolver() {
		//js 파일을 렌더링
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	
}
