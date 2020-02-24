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
	<c:if test="${visitNum==0}">
		<h2>첫 방문 감사합니다.</h2>
	</c:if>
	<c:if test="${visitNum eq 1}">
		<h2>두 번 째 방문 감사합니다.</h2>
	</c:if>
	<c:if test="${visitNum < 5 && visitNum >= 0}">
		<h2>몇 번 오셨군요. 감사합니다.</h2>
	</c:if>
	<c:if test="${visitNum >= 5}">
		<h2>자주 오시네요. 감사합니다.</h2>
	</c:if>
	<c:if test="${visitNum < 0}">
		<h2>? 방문 횟수 다시 입력하세요.</h2>
	</c:if>
</body>
</html>