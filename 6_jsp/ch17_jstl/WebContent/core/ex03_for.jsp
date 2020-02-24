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
	String[] names = {"홍길동", "망이", "망소이"};
	for(String name : names){
		out.print("<p>"+name+"</p>");
	}
	out.print("<hr>");
	for(int idx=0; idx<names.length; idx++){
		out.print("<p>"+idx+"번째 : "+names[idx]+"</p>");
	}
%>
<hr>
<c:set var="names" value="<%=names %>"/> <!-- 자바에서 선언한 변수를 바로 쓸 수 없다. 새로 변수 선언 -->
<c:forEach var="name" items="${names }" > <!-- var="name" : 임시변수 ; 확장 for문 같이 -->
	<p>
		${name }
	</p>
</c:forEach>
<hr>
<c:set var="idx" value="0" scope="page"/> <!-- idx 변수 선언 -->
<c:forEach var="name" items="${names }">
	<p>
		${idx }번째 : ${name }
	</p>
	<c:set var="idx" value="${idx+1 }"/> <!-- idx 변수 idx+1로 재 선언 -->
</c:forEach>
<p>
	최종 idx 값은 ${idx }
</p>
</body>
</html>