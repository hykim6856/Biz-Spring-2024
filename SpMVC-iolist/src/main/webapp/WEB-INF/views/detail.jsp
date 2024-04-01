<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<style>
div.w3-card-4 {
	width: 50%;
	margin: 20px auto;
}
</style>
<script>
	const msg = "${MSG}"
	if (msg === "NOT") {
		alert("msg not 상태")
	} else if (msg === "FK") {
		alert("msg fk 상태")
	}
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/iolist.js?2024-04-01"></script>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<main class="w3-container">
		<div class="w3-card-4 w3-whight">
			<div class="w3-container w3-center">
				<p>${IOLIST.io_seq}</p>
				<p>${IOLIST.io_date}</p>
				<p>${IOLIST.io_time}</p>
				<p>${IOLIST.io_input}</p>
				<p>${IOLIST.io_pname}</p>
				<p>${IOLIST.io_price}</p>
				<p>${IOLIST.io_quan}</p>
			</div>
			<div class="w3-section w3-center">
				<input data-ioseq="${IOLIST.io_seq}" type="button" value="수정"
					class="btn_update w3-button w3-green" /> <input
					data-ioseq="${IOLIST.io_seq}" type="button" value="삭제"
					class="btn_delete w3-button w3-red" />
			</div>
		</div>
	</main>


</body>
</html>