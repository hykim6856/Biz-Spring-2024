package com.callor.gallery.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

@Configuration
@MapperScan(basePackages = { "com.callor.gallery.dao" })
public class MyBatisContextConfig {
	
	private ApplicationContext context;

	public MyBatisContextConfig(ApplicationContext context) {
		super();
		this.context = context;
	}

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
		
//		try {
//			bean.setMapperLocations(context.getResources("/WEB-INF/spring/mapper/*-mapper.xml"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		bean.setDataSource(this.ds());
		bean.setTypeAliasesPackage("com.calloer.gallery.models");
		
		Resource resource = context.getResource("classpath:/**/mapper/*-mapper.xml");
		bean.setMapperLocations(resource);
		return bean;
	
	}
	
	public AbstractPlatformTransactionManager transactionManager() {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		/*
		 * 매니저 객체는 plat..manager 인터페이스를 사용하여 선언하였다,.
		 * 이 인터페이스는 다양한 transaction 을 실행하기 위한 설계도이다.
		 * datasource manager 는 plantfor...manager 인터페이스를 사용하여 구현된 구현체 클래스
		 *  datasource manager 는 plantfor...manager 인터페이스를 implements 하였지만
		 *  자체적으로 코드를 구현하면서 여러가지 method 를 별도로  가지고 잇다.
		 *  우리는 datasource..manager 에게 datasource ds 를 알려주고 datasource 차원에서 tranaction 을 수행하도록 하려고한다.
		 *  그런데 platform... 에는 datasource 를 주입하는 method가 정의되지 않았다.
		 *  결국 platfor 에는 없짐ㅏㄴ datasource maner 에만 있는 set datasource()method를 사용하여야 한다.
		 *  이럴때 platfor 에는 없지만 , datasour..manager 애만 있는 set 
		 */
		manager.setDataSource(this.ds());
		return manager;
	}

}
