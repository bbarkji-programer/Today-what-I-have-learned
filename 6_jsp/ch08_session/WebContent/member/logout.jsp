<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/login.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<%
	String name = (String)session.getAttribute("name");
	if(name!=null){
		session.invalidate();%>
	<script>
		alert("성공적으로 로그아웃하였습니다.");
		location.href="main.jsp";
	</script>

	<%}else{%>
	<script>
		alert("로그인이 되어있지 않았는데?");
		location.href="main.jsp";
	</script>
	<%} %>

</body>
</html>