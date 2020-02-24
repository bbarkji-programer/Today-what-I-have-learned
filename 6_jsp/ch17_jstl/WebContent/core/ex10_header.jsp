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
	<c:if test="${empty customer && empty admin }">
		<!-- 사용자 및 관리자 로그인 전 메뉴 -->
		<ul>
			<li>
				<a href="">고객센터</a>
			</li>
		</ul>
	</c:if>
	<c:if test="${not empty customer && empty admin }">
		<!-- 사용자 모드 로그인 후 -->
		<ul>
			<li>
				<a href="">마이페이지</a>
			</li>
		</ul>
	</c:if>
	<c:if test="${empty customer && not empty admin }">
		<!-- 관리자 모드 로그인 후  -->
		<ul>
			<li>
				<a href="">관리자페이지</a>
			</li>
		</ul>
	</c:if>
</body>
</html>