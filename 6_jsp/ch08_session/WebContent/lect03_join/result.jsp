<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
<style>
a{
	text-decoration:none;
	color:black;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<%
	String msg = request.getParameter("msg");
	if(msg.equals("success")){%>
		<h1>가입이 완료되었습니다.</h1>
		<hr>
		<button onclick="location.href='../lect02_login/login.jsp'">로그인</button>
	<%}else if(msg.equals("fail")){%>
		<h1>회원가입이 되지 않았습니다.</h1>
		<a href="join.jsp">회원가입으로 ㄱㄱ</a>
		<hr>
		<button onclick="location.href='../lect02_login/login.jsp'">로그인</button>
	<%}%>

</body>
</html>