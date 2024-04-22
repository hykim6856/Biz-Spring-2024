# Spring 이미지 갤러리 프로젝트
- MySQL, Mybatis, Tiles 를 이용한 갤러리 프로젝트

## 프로젝트 개요
- 이미지 갤러리 프로젝트는 한개의 게시물에 한개의 이미지만 있는 형태로 구현한다. 
- 갤러리 작성에서 날짜, 시각, 작성자, 제목, 간략한 소개, 그리고 한개의 이미지를 첨부하여 게시물을 작성한다.
- 작성된 게시물은 tbl_gallerys 에 추가한다. 
- 처음에는 날짜와 시간 시스템에서 자동으로 생성하고, 작성자는 임의로 입력한다.
- 로그인 기능이 완성되면 로그인한 사용자 username 을 작성자 이름으로 자동 설정한다.
- 이미지를 파일로 저장하지 않고, db table 의 한 칼럼으로 저장하는 방법을 시도 해보자.

## Mysql 문자열 type
- 권장하지는 않지만, 이미지를 별도의 파일로 업로드 하지 않고, table의 한 칼럼에 저장하는 방법이 있따.
- 이미지를 테이블의 칼럼에 저장하는 방법에는 이미지 그대로 값을 저장하는 방법이 있고, 이미지를 `Base64` 라고 하는 문자열로 치환하여 저장하는 방법이 있다.
- 여기에서는 이미지를 `Base62`방식으로 치환하여 테이블에 저장한다.
- 이미지와 같은 큰 데이터를 table 에  저장하는 것은 dBMS 성능을 매우 좋지 않게 한다.
- 일반적인 방법은 이미지를 파일로 업로드하고, 파일에 대한 정보만 간단히 table 에 보관하는 것이 좋다.
- 하지만 이 방법도 파일을 별도로 관리해야하고, table 의 정보와 링크가 어긋나는 경우가 발생하여 불필요한 파일이 서버에 남게되는 원인이 되기도한다.

- 이미지를 `Base64` 방식으로  저장하기 위해서는 칼럼을 특별한 문자열 type으로 변환해야한다.

- MySQL 의 문자열 Type
- `VARCHAR()` : 가변문자열 방식으로 1 ~ 65536 개의 문자열을 저장하는 보편적인 문자열 저장 칼럼, 최대 저장문자열을 제한하여 불필요한 낭비를 방지하기 위한 칼럼, 최대 지정한 칼럼 크기를 벗어난 문자열은 아예 저장이 안되도록 한다.
- `Text` : 가변문자열 방식으로 최대 65566 개의 문자열을 저장하는 칼럼, 최대 제한 크기가 65566으로 임의로 크기를 제한 할수 없다.
- `TinyText` : 최대 256 byte 크기의 문자열만 허용
- `MEDIUMTEXT` : 최대 16 MB 크기의 문자열까지 허용, 16 * 2^20개의 문자열



## Tiles 를 이용한 Layout 설정
```xml
<properties>
		<java-version>11</java-version>
	
		<org.apache.tiles-version>3.0.8</org.apache.tiles-version>
	</properties>

```

## `tiles-context.xml` 에 `Resolver` 설정

```xml
<bean
		class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
		<list>
			<value>/WEB-INF/spring/appServlet/tiles-layout/*-layout.xml</value>
		</list>
		</property>
	</bean>


	<bean
		class="org.springframework.web.servlet.view.UrlBasedViewResolver">
		<property name="viewClass"
			value="org.springframework.web.servlet.view.tiles3.TilesView" />
		<property name="order" value="1"></property>

	</bean>

```

- `layout.xml` 위치 설정
- `order` 값을 반드시 1로 설정

## `*-layout.xml` 에 `viewResolver`를 받아서 `Rendering` 하는 방법 설정
- `default` definition 설정
- 전체 layout을 감쌀 box-layout
- 여기에는 모든 페이지에 공통으로 include 할 파일을 설정해 둔다.

```xml

	<definition name="default" template="/WEB-INF/views/home.jsp">
		<put-attribute name="head" value="/WEB-INF/views/includes/include-head.jsp" />
		<put-attribute name="header" value="/WEB-INF/views/includes/include-headers.jsp" />
		<put-attribute name="nav" value="/WEB-INF/views/includes/include-main-nav.jsp" />
	</definition>


  
```

- `Controller` 에서 `return` 된 문자열을 받아서 처리하는 부분
```xml
<tiles-definitions>
<!--  컨트롤러에서 리턴 홈이 요청되면.-->
	<definition name="home" extends="default">
	<put-attribute name="content" value="" />
</definition>
</tiles-definitions>

```

- 다중 경로 Resolver
- 만약 return 값이 `user/login`, `user/join`, `user/mypage` 등과 같이 다중 경로의 Resolver가 필요한 경우 와일드 카드인 애스터리스크 `(*)` 를 사용하여 경로 응답을 받고, include 를 할때 `{1}`,와 같이 위치 기호를 사용하여 처리 할 수 있다.
```xml
<tiles-definitions>
	<definition name="user/*" extends="default">
		<put-attribute name="content" value="/WEB-INF/views/user/{1}.jsp" />
	</definition>
	
	<definition name="user/*/*" extends="default">
		<put-attribute name="content" value="/WEB-INF/views/user/{1}/{2}.jsp" />
	</definition>

</tiles-definitions>
```