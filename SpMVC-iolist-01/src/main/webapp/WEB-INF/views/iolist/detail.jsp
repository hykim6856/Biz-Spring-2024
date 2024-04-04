<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<script > const onDelete = ()=>{
	if(confirm("정말삭제할까요?")){
		document.location.replace("${rootPath}/iolist/delete/${IO.io_seq}")
	}
}
</script>

<div class="iolist detail">
 <div><strong>거래일자</strong><span>${IO.io_date}</span></div>
 <div><strong>거래시각</strong><span>${IO.io_time}</span></div>
 <div><strong>상품명</strong><span>${IO.io_pname}</span></div>
 <div><strong>거래구분</strong><span>${IO.io_inout}</span></div>
 
 <div>
 <strong>${IO.io_inout}단가</strong>
 <span>${IO.iprice ne 0 ? IO.iprice : IO.oprice}</span>
 </div>
 
 <div>
 <strong>합계</strong>
 <span>${IO.itotal ne 0 ? IO.itotal : IO.ototal}</span>
 </div>
 
 <div>
 	<strong></strong>
 	<span>
 		<a href="${rootPath}/iolist">리스트로</a>
 		<a href="${rootPath}/iolist/update/${IO.io_seq}">수정</a>
 		<a href="javascript:onDelete()">삭제</a>
 		
 	</span>
 </div>
</div>