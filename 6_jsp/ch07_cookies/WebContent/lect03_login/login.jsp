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
<%
	Cookie[] cs = request.getCookies();
	if(cs!=null){
		for(Cookie c : cs){
			if(c.getName().equals("id")){ // id 쿠키가 있다면, 로그인을 이미 한거니까
				response.sendRedirect("welcome.jsp"); // welcome.jsp 로 sendRedirect
			}
		}
	}
%>
<body>
<jsp:include page="header.jsp"/>
<form action="loginOK.jsp" method="post">
	<table>
			<caption>로그인 &#128524;</caption>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" autofocus="autofocus"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" autofocus="autofocus"></td>
		</tr>
		<tr>
			<td colspan="2"> </td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="로그인 "></td>
		</tr>	
	</table>
	</form>
	<br>
<%
	String msg = request.getParameter("msg");
	if(msg!=null){
		out.print("<p>아이디와 비밀번호가 유효하지 않습니다.</p>");
	}
%>
</body>
</html>