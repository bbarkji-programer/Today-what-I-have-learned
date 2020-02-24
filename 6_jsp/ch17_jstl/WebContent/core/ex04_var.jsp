<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>
		변수선언
	</h2>
	<c:set var="varName" value="varValue"></c:set> <!-- String이 들어간거에여 -->
	varName : ${varName }
	<br>
	varName : <c:out value="${varName }"/>
	<br>
	<c:set var="varName" value="<varValue>"/>
	varName : ${varName }
	<br>
	varName : <c:out value="${varName }" escapeXml="true"/> <!-- 특수문자 출력하고 싶으면 이렇게 해야한다. <>를 특수문자로 인식 -->
	<h2>
		변수삭제
	</h2>
	<c:remove var="varName"/> <!-- varName 변수가 있으면 삭제 -->
	varName : ${empty varName ? "삭제됨" : "남아있음" }
	<br>
	varName : ${varName }
	<br>
	varName : <c:out value="${varName }" default="지웠어"></c:out>
</body>
</html>