<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>여기는 제목</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<h1>상품 정보 등록</h1>
<form method="POST">

<div><input placeholder="상품코드" name="p_code" value="${PRODUCT.p_code}"></div>
<div><input placeholder="상품이름" name="p_name" value="${PRODUCT.p_name}"></div>
<div><input placeholder="품목" name="p_item" value="${PRODUCT.p_item}"></div>
<div><input placeholder="가격" name="p_price" value="${PRODUCT.p_price}"></div>
<div><input type="submit" value="저장"></div>

</form>

</body>
</html>