<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<html>
<section>
	<aside><tiles:insertAttribute name="aside-left"></tiles:insertAttribute></aside>
	<aside><tiles:insertAttribute name="aside-right"></tiles:insertAttribute></aside>
	
</section>

</html>