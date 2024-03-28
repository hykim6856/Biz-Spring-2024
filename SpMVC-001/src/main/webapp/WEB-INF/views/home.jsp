<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<section class="w3-container w3-padding-16">
		<article class="w3-container w3-cell w3-purple">상품정보</article>
		<article class="w3-container w3-cell w3-teal">주문정보</article>
		<article class="w3-container w3-cell w3-yellow">거래처정보</article>
	</section>
</body>
</html>