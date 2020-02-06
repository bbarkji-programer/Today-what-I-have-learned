<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ex01_forward.jsp 파일입니다.</h1>
	<!-- jsp:forward는 (1)파라미터 값을 갖고(?n=1) 전달가능 (2)주소창 변경 X -->
	<jsp:forward page="ex02_forward.jsp"></jsp:forward>
	<!-- sendRedirect는 (1)파라미터 값 전달 불가능(전달하고 싶으면 따로 추가해야함 (2)주소창 변경됨. -->
	<%-- <% response.sendRedirect("ex02_forward.jsp"); %> --%>
</body>
</html>