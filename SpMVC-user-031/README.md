# Spring Security Project
- Spring Security 를 사용하여 로그인, 세션관리를 수행하는 프로젝트

## 환경설정
- 필수 dependency

```xml
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-web</artifactId>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-config -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-config</artifactId>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-taglibs -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-taglibs</artifactId>
		</dependency>
```

## MyBatis DBMS 연동 설정
- 필수 dependency
```
mybatis
mybatis-spring 3.0.0
dbcp2 : common-dbcp2
mysql : mysql-connect/j
spring-jdbc
```