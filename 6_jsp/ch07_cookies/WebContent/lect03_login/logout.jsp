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
<jsp:include page="header.jsp"/>
<%	
	Cookie[] cs = request.getCookies();
	if(cs!=null){
		for(Cookie c : cs){
			if(c.getName().equals("id")){
				c.setMaxAge(0);
				response.addCookie(c);
			}else if(c.getName().equals("name")){
				c.setMaxAge(0);
				response.addCookie(c);
			}
		} 
	}
	response.sendRedirect("welcome.jsp"); // 로그 아웃(=쿠키 다 지우면)하면, welcome.jsp로 ㄱㄱ
%>
	<p>
		<button onclick="location.href='login.jsp'">로그인</button>
		<button onclick="location.href='cookiesList.jsp'">쿠키 확인</button>
	</p>
</body>
</html>