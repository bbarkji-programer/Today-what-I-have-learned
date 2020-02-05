<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8"); // post 방식으로 보내는 경우
	String writer = request.getParameter("writer");
	String memo = request.getParameter("memo");
	String ip = request.getRemoteAddr(); // ip 주소를 받아옴 .getRemoteAddr()
	Date date = new Date(System.currentTimeMillis());
%>
	<h2>글쓴이 : <%=writer %></h2>
	<h2>한 줄 메모 : <%=memo %></h2>
	<h2>글쓴이 IP주소 : <%=ip %></h2>
	<h2>글쓴 날짜 : <%=date %></h2>
</body>
</html>