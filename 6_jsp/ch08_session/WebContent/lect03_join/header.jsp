<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header{
	width:1000px;
	margin:0 auto
}
header #nav ul{
	overflow:hidden;
}
header #nav ul li{
	list-style:none;
	float:right;
	padding: 10px;
}
header #nav ul li a{
	text-decoration:none;
	color:black;
}
</style>
</head>
<body>
	<header>
		<div id="nav">
		<%if(session.getAttribute("name")==null) { // 로그인 전(=id란 이름의 쿠키가 없어서 변수 id 값이 null인 경우%>
			<ul>
				<li><a href="join.jsp">회원가입</a></li>
				<li><a href="../lect02_login/login.jsp">로그인</a></li>
				<li><a href="../lect02_login/welcome.jsp">홈</a></li>
			</ul>
		<%}else{ // 로그인 후(=id란 이름의 쿠키가 있어서 변수 id 값이 id value인 경우%>
			<ul>
				<li><a href="../lect02_login/logout.jsp">로그아웃</a></li>
				<li><a href="modify.jsp">정보수정</a></li>
				<li><a href="mypage.jsp"><%=session.getAttribute("name") %>님 </a></li>
			</ul>
		
		<%} %>

		</div>

	</header>
</body>
</html>