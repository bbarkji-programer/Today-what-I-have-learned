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
			if(c.getName().equals("id")){
				c.setMaxAge(0);
				response.addCookie(c);
			}else if(c.getName().equals("name")){
				c.setMaxAge(0);
				response.addCookie(c);
			}
		} // 로그 아웃 했다면
	}
	out.print("<h1>로그아웃 완료. 안녕히 가세여~~ &#128075</h1>");
%>
	<p>
		<button onclick="location.href='login.html'">로그인</button>
		<button onclick="location.href='cookiesList.jsp'">쿠키 확인</button>
	</p>
</body>
</html>