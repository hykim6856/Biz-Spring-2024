<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<body>
<h1>매입 매출 입력</h1>
<h3>${MSG}</h3>
<form method="POST">

<div><input placeholder="No." name="io_seq" value="${IOLIST.io_seq}"></div>
<div><input placeholder="일자" name="io_date" value="${IOLIST.io_date}"></div>
<div><input placeholder="시각" name="io_time" value="${IOLIST.io_time}"></div>
<div><input placeholder="구분" name="io_input" value="${IOLIST.io_input}"></div>
<div><input placeholder="상품명" name="io_pname" value="${IOLIST.io_pname}"></div>
<div><input placeholder="단가" name="io_price" value="${IOLIST.io_price}"></div>
<div><input placeholder="수량" name="io_quan" value="${IOLIST.io_quan}"></div>
<div><input type="submit" value="저장"></div>

</form>

</body>
</html>