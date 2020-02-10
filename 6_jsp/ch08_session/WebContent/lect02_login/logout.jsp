<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../lect03_join/header.jsp"/>
<%
	String name = (String)session.getAttribute("name");
	if(name!=null){
/* 	session.removeAttribute("id");
	session.removeAtrribute("name"); */
		session.invalidate();
		out.println("<h2>&#128694; 성공적으로 로그아웃하였습니다. </h2>");
	}else{
		out.println("<h2>로그인 상태가 아닌디요? &#129335; </h2>");
	} 
%>
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='sessionTest.jsp'">세션 들여다보기</button>
</body>
</html>