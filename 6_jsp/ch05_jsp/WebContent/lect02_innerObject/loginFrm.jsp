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
<body>
	<h1>로그인 화면</h1>
	<hr>
	<form action=" " method="post">
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
	<% String msg = request.getParameter("msg"); %>
	<h2><%=msg %></h2>
	</div>
</body>
</html>