package com.callor.gallery.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;



@Configuration
@MapperScan(basePackages = {"com.callor.gallery.dao"})
public class MyBatisContextConfig {
	
	
	private ApplicationContext context;
	
	/*
	 * 자바 코드에서 /web-inf 또는 src/main/resoruce 등의 폴더에 있는 xml파일을 팢기 위함
	 * 
	 */
	
	public MyBatisContextConfig(ApplicationContext context) {
		super();
		this.context = context;
	}

	@Bean
	public DataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/galleryDB2");
		ds.setUsername("root");
		ds.setPassword("!Biz8080");
		return ds;
	}
	
	@Bean
	public SqlSessionFactoryBean sessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		
		
		/*
		 * 톰캣 서버의 저장소 에서  /WEB-IMF/spring/mapper 폴드에서 
		 * /*-mapper.xml 파일들의 정보를 가져와서 Mapperlocatuion
		 */
		try {
														   
			bean.setMapperLocations(context.getResources("/WEB-INF/spring/mapper/*-mapper.xml"));
//			~~/src/main/resources 폴더의 mapper 폴더에서 xml을 참조하고 싶을때
//			context.getResources("classpath:/**/mapper/*-mapper.xml");
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bean.setDataSource(this.ds());
		bean.setTypeAliasesPackage("com.callor.gallery.models");
		return bean;
	}
	
	
	public AbstractPlatformTransactionManager transactionManager() {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(this.ds());
		return manager;
	}
}

