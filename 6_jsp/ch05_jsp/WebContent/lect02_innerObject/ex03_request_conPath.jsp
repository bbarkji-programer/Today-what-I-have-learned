<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %> <!-- 이렇게 위에 써주면, 앞에 conPath만 써주면 된당.. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex03.css" rel="stylesheet">
</head>
<body> <!-- ch05_jsp (context root) / /ch05_jsp (context path) -->
	<h2>컨텍스트 path : <%=request.getContextPath() %></h2>
	<hr>
	<a href="../index.jsp">INDEX.JSP</a>
	<hr>
	<a href="/ch05_jsp/index.jsp">INDEX.JSP</a>
	<hr>
	<a href="<%=conPath %>/index.jsp">INDEX.JSP</a>
	<hr>
	<button onclick="location.href='<%=conPath %>/Ex03'">Ex03 servlet</button>
</body>
</html>