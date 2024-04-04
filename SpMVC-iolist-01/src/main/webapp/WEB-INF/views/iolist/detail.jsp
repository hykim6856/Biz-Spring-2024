<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<div class="iolist detail">

 <div><strong>거래일자</strong><span>${IO.io_date}</span></div>
 <div><strong>거래시각</strong><span>${IO.io_time}</span></div>
 <div><strong>상품명</strong><span>${IO.io_pname}</span></div>
 <div><strong>거래구분</strong><span>${IO.io_input}</span></div>
 <div><strong>단가</strong><span>${IO.io_quan}</span></div>
 <div><strong>합계</strong><span>${IO.io_total}</span></div>
 <div>
 	<strong></strong>
 	<span>
 		<a href="${rootPath}/iolist">리스트로</a>
 		<a href="${rootPath}/iolist/update/${IO.io_seq}">수정</a>
 		<a href="javascript:void(0)">삭제</a>
 		
 	</span>
 </div>
</div>