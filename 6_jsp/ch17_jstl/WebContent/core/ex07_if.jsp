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
	if(1+2==3){
		out.print("1 더하기 2는 3<br>");
	}else{
		out.print("1 더하기 2는 3이 아닙니다.<br>");
	}
%>
	<c:if test="${1+2 eq 3 }" >
		1+2 ==3<br>
	</c:if>
	<!-- if 태그는 else가 없다. -->
	<c:if test="${1+2 != 3 }" var="result" scope="page" > <!-- result=test 결과. 여기서는 result=false -->
		1 더하기 2는 3이 아닙니다. <br>
	</c:if>
	두 번째 if문 조건에 대한 결과는 ${result } 입니다.
</body>
</html>