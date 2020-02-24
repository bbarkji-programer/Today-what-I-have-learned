<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<%
		for(int i=1; i<=5; i++){
			out.print("<p>"+i+" : 안녕하세요</p>");
		} // 자바에서 이렇게 하던걸 이제는 아래와 같이.
	%>
	<hr>
	<c:forEach var="i" begin="1" end="${param.su }"> 
	 <p>
	 	${i } : ${param.id }님 안녕하세요.
	 </p>
	</c:forEach>
	<hr>	
</body>
</html>