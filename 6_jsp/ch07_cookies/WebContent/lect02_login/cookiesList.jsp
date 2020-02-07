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
	Cookie[] cs = request.getCookies();
	if(cs!=null){
		for(Cookie c : cs){
			String cName = c.getName();
			String cValue = c.getValue();
			out.println(cName+"(쿠키이름): "+cValue+"(쿠키 값)<br>");
		}
	}else{
		out.print("존재하는 쿠키가 없습니다.<br>");
	}
%>
<br>
<button onclick="history.go(-1);">이전페이지</button>
<button onclick="location.href='welcome.jsp'">welcome 페이지</button>
</body>
</html>