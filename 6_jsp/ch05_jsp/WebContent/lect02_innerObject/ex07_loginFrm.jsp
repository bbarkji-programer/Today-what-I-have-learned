<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/login.css" rel="stylesheet">
</head>

<%
	String msg = request.getParameter("msg");
	if(msg!=null){
%>
<script>
	alert('아이디와 비번을 확인하세요.');
</script>
<%} %>
<body>
	<h1>로그인 화면</h1>
	<hr>
	<form action="loginCertification02.jsp" method="get">
	<!-- <form action="loginCertification.jsp" method="get"> -->
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name=id required="required"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name=pw required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인">
			</tr>
		</table>
	</form>
	<div id="msg">
	<%-- <% String msg = request.getParameter("msg"); %> --%>
	<%-- <h2><%if(msg!=null) out.print(msg); %></h2> --%>
	<h2><%if(msg!=null) out.print("비밀번호와 아이디를 확인하세여"); %></h2>
	</div>
</body>
</html>