<%@page import="java.net.URLEncoder"%>
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
	String msg = "";
	
	if(id!=null && id.equals("aaa")){ // 유효한 id와
		if(pw!=null && pw.equals("111")){ // 유효한 pw인 경우
			session.setAttribute("id",id);
			session.setAttribute("name","박지영");
			response.sendRedirect("main.jsp");
		}else{ // pw 틀린 경우
			msg = URLEncoder.encode("pw를 체크하세요", "utf-8");
			response.sendRedirect("login.jsp?msg="+msg);
		}
	}else{ // 유효하지 않은 아이디인 경우
		msg = URLEncoder.encode("아이디를 체크하세요.","utf-8");
		response.sendRedirect("login.jsp?msg="+msg);
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