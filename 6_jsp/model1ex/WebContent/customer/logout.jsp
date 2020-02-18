<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<script>
	setTimeout(function(){
		location.href='../main/main.jsp';
	},2000);
</script>
<body>
<%
	session.invalidate();
%>
	<h2>로그아웃 완료. 잠시 후 메인 페이지 이동</h2>
</body>
</html>