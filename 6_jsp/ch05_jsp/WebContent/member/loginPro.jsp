<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/login2.css" rel="stylesheet">
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id"); // id
	String pw = request.getParameter("pw"); // pw
	if(!id.equals("aaa") || !pw.equals("111")){
		response.sendRedirect("login.jsp?msg=no");
	}
%>
	<div id="loginForm_wrap">
	<div id="login_title">
		로그인  결과
	</div>
		<p id="login_join">로그인  성공</p>
	</div>
</body>
</html>