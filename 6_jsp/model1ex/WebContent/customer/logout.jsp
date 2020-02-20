<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/customer.css" rel="stylesheet">
</head>
<script>
	setTimeout(function(){
		location.href='../main/main.jsp';
	},2000);
</script>
<body>
<%
	session.invalidate();
	response.sendRedirect("../main/main.jsp");
%>
</body>
</html>