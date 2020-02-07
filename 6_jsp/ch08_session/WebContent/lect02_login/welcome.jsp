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
	String id = (String)session.getAttribute("id");
%>
<%
	if(name!=null){ // 로그인 상태%>
		<h2><%=name %>(<%=id %>)님 어서오세요. &#128587;</h2>
		<button onclick="location.href='logout.jsp'">로그아웃</button>
	<%}else{ // 비로그인 상태%>
		<h2>손님 반값습니다. 로그인해주세요. &#128129;</h2>
		<button onclick="location.href='login.jsp'">로그인</button>
	<%} %>
		<button onclick="location.href='sessionTest.jsp'">세션 들여다보기</button>
</body>
</html>