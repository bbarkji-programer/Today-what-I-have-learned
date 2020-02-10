<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> <!-- exception 내부 객체를 쓰기 위해서 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	consol.log('예외 타입 : '+'<%=exception.getClass().getName()%>');
	consol.log('예외 메시지 : '+'<%=exception.getMessage()%>');
</script>
</head>
<body>
	<h2>본 페이지는 공사중입니다.</h2>
	(error500.jsp)
</body>
</html>