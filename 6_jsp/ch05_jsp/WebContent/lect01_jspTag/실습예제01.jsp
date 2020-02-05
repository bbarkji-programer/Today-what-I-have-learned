<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% String color = request.getParameter("color"); %> <!-- 어디든 들어갈 수 있다. -->
<style>
	body{
		background-color: <%=color%>;
	}
</style>
<body>
	<h2>배경색은 <%=color %> 입니다.</h2>
</body>
</html>