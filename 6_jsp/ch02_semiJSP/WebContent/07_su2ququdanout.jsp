<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<h1><%=su1 %>단</h1>
	
	<%for(int i=1; i<10; i++){ %>
		<p>
		<%for(int j=su1; j<=su2; j++){%>
		<p><%=j %> * <%=i %> = <%=j*i %></p>
	<% } %>
	<%} %>
</body>
</html>