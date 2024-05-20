package com.callor.gallery.config;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class RootContextConfig {

	public CommonsMultipartResolver getfilResolver() throws IOException{
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSizePerFile(1024*1024*2);
		return resolver;
	}
	
}
