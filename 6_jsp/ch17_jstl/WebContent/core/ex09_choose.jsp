<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<c:set var="visitNum" value="${param.visitNum }"/>
	<c:choose> 
		<c:when test="${visitNum eq 0 }">
			<h2>첫 방문 감사합니다.</h2>
		</c:when>
		<c:when test="${visitNum eq 1 }">
			<h2>두 번째 방문 감사합니다.</h2>
		</c:when>
		<c:when test="${visitNum < 5 && visitNum>=0 }">
			<h2>종종 오시는 군요. 자주 오세요~</h2>
		</c:when>
		<c:when test="${visitNum >= 5 }">
			<h2>자주 오시는 군요. 감사합니다.</h2>
		</c:when>
		<c:otherwise>
			<h2>제대로 된 방문 횟수를 받지 못했습니다. </h2> 
		</c:otherwise>
	</c:choose>
</body>
</html>