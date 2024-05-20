package com.callor.gallery.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
/*
 * @Configuration
 * 지금부터 이 클래스는 contextBeanconfig 설정을 하는 클래스다. 라는 선언이다.
 */
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class RootContextConfig {

	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getfilResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSizePerFile(1024 * 1024 * 2);
		resolver.setMaxUploadSize(1024 * 1024 * 20);
		resolver.setUploadTempDir(new FileSystemResource("c:/temp"));
		resolver.setDefaultEncoding("UTF-8");
		
		return resolver;

	};

	@Bean(name="upLoadPath")
	public String upLoadPath() {
		return "c:/app/upload";
	}
	
}
