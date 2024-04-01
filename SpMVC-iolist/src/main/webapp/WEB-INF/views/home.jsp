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
<script>
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/iolist.js?2024-04-01"></script>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<section class="w3-container w3-padding-16">
		<div class="23-container w3-padding-24 w3-center">
			<table class="w3-table-all w3-hoverable">
				<thead>
					<tr>
						<th>No.</th>
						<th>일자</th>
						<th>시각</th>
						<th>상품명</th>
						<th>매입단가</th>
						<th>판매단가</th>
						<th>수량</th>
						<th>매입합계</th>
						<th>판매합계</th>
					</tr>
				</thead>
				<tbody class="iolist_body">
					<tr>
						<c:forEach items="${IO_LIST}" var="IOLIST" varStatus="VAR">
							<tr data-pcode=${IOLIST.io_seq} >
								<td>${IOLIST.io_seq}</td>
								<td>${IOLIST.io_date}</td>
								<td>${IOLIST.io_time}</td>
								<td>${IOLIST.io_pname}</td>
								<td>${IOLIST.io_input == 1 ? IOLIST.io_price : ""}</td>
								<td>${IOLIST.io_input == 2 ? IOLIST.io_price : ""}</td>
								<td>${IOLIST.io_quan}</td>
								<td></td>
								<td></td>
							</tr>
						</c:forEach>
				</tbody>
				<tr>
					<td colspan="7"><strong>합계</strong></td>
					<td>${iTotal}</td>
					<td>${oTotal}</td>
				</tr>
			</table>
			<div class="w3-container btn_box">
				<a href="${rootPath}/insert"
					class="w3-button w3-blue w3-round">입력</a>
			</div>

		</div>

	</section>
</body>
</html>

