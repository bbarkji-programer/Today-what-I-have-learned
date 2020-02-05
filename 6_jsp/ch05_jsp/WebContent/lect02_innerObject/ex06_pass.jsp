<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% // age.html -> age.jsp -> pass.jsp 로 왔지만, 
	int age = Integer.parseInt(request.getParameter("age"));
%>
	<h2><%=age %>세 - 성인 인증 완료. 주류 구매 가능합니다.</h2>
	<button onclick="history.back()">뒤로가기</button>
</body>
</html>