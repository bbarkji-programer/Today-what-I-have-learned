<%@page import="java.util.Date"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/ch05_jsp/css/ex03.css" rel="stylesheet">
</head>
<body>
<%	int[] iArr = {10,20,30};
	out.println(Arrays.toString(iArr));
	System.out.println(Arrays.toString(iArr));
%>
<hr>
<%@ include file="../member/footer.jsp" %>
<hr>
<% Date now = new Date(); %>
현재는 <%=now %> 입니다.
</body>
</html>