<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<style>
table.w3-table-all {
	width: 70%;
	margin: 10px auto;
}

div.btn_box {
	display: block;
	width: 70%;
	margin: 5px auto;
	text-align: right;
	padding: 0;
}
}
</style>
<script >
//모든 js 에서 사용할 수 있도록 변수를 선언해둔다.
var rootPath = "${rootPath}"</script>
<script src="${rootPath}/static/js/customer.js?2024-03-29-001"></script>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="23-container w3-padding-24 w3-center]">
		<table class="w3-table-all w3-hoverable">
			<thead>
				<tr>
					<th>SEQ</th>
					<th>고객코드</th>
					<th>고객이름</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody class="cust_body">
				<c:forEach items="${CUST_LIST}" var="CUST" varStatus="VAR">
					<tr data-ccode="${CUST.c_code}">
						<td>${VAR.index},${VAR.count}</td>
						<td>${CUST.c_code}</td>
						<td>${CUST.c_name}</td>
						<td>${CUST.c_tel}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="w3-container btn_box">
			<a href="${rootPath}/customer/insert"
				class="w3-button w3-blue w3-round">고객추가</a>
		</div>
		<ul>
			<%
			/* for(int VAr =1 ; )*/
			%>
			<c:forEach begin="1" end="100" step="2" var="VAR">
				<li>${VAR}</li>
			</c:forEach>
		</ul>

	</div>

</body>
</html>