<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<f:form class="iolist input" modelAttribute="IO">
<fieldset>
<legend>매입매출 ${empty IO.io_seq ? '등록' : '수정' }</legend>
	<div><label>거래일자</label><f:input path="io_date" placeholder="거래일자" type="date" /></div>
	<div><label>거래시각</label><f:input path="io_time" placeholder="거래시각" type="time" /></div>
	<div><label>상품명</label><f:input path="io_pname" placeholder="상품명" /></div>
	
	<div><label>거래구분</label>
	<f:select path="io_input">
		<f:option value="1"  >매입</f:option>
		<f:option value="2" >매출</f:option>
	</f:select></div>
	<div><label>단가</label><f:input path="io_price" placeholder="단가"/></div>
	<div><label>수량</label><f:input path="io_quan" placeholder="수량" /></div>
	<div><label>합계</label><f:input path="io_total" placeholder="합계" /></div>
		
	<div><label></label><input type="submit" value="저장"/></div>
</fieldset>
</f:form>