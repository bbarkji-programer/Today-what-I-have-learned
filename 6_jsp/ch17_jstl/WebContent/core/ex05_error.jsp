<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="conPath/style.css" rel="stylesheet">
</head>
<body>
	<h2> 예외 처리 </h2>
	<c:catch var="error"> <!-- catch 절에서 예외가 발생할 경우 예외 타입과 예외 메시지를 error에 저장한다. -->
		<h2>
			테스트
		</h2>
		<%=8/0 %>
		<p>
			예외가 발생되면 즉시 catch 절을 빠져나간다.
		</p>
	</c:catch>
	예외 타입과 메시지 : <c:out value="${error }" default="예외발생 안됨" />
</body>
</html>