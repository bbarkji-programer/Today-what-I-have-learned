<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<%-- <% request.setCharacterEncoding("utf-8"); %> --%>
	<fmt:requestEncoding value="utf-8"/>
	<h1>
		이름 : ${param.name }
	</h1>
</body>
</html>