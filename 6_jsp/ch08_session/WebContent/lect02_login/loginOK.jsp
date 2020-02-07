<%@page import="java.net.URLEncoder"%>
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
<%
	String msg = "";
	// 파라미터 값 가져오기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	//DB연결을 통해 id와 pw 검색 -> 다음주에 ^^~
	if(id!=null && id.equals("bbarkji")){ // 유효한 아이디인 경우
		if(pw!=null && pw.equals("1234")){ // pw가 맞는 경우
			session.setAttribute("id", id);
			session.setAttribute("name", "박지영");
			response.sendRedirect("welcome.jsp");
		}else{ //pw 틀린 경우
			msg = URLEncoder.encode("pw를 체크하세욧","utf-8");
			response.sendRedirect("login.jsp?msg="+msg);
		}
	}else{ // 유효하지 않은 아이디인 경우
		msg = URLEncoder.encode("id를 체크하세욧","utf-8");
		response.sendRedirect("login.jsp?msg="+msg);
	}
%>	
</body>
</html>