<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.wrap{
	margin: 0 auto;
	width:400px;
	text-align:center;
}
input[type=button]{
	border:1px solid grey;
	outline:0;
	padding: 15px 30px;
	text-align:center;
	font-size: 1.5em;	
	margin:100px 10px;
}
h2:nth-child(1){
	color: red
}
</style>
<body>
<% 
	Random rand = new Random();
	int randomSu = 1 + rand.nextInt(3);
	int su = Integer.parseInt(request.getParameter("su"));

	if(randomSu!=su){		
		response.sendRedirect("08_yaba.jsp?su="+su+"&rsu="+randomSu);
	}
%>
	<h3>동전이 있는 곳을 맞춰봐</h3>
	<hr>
	<div class=wrap>
		<h2>정답입니다.</h2>
		<h2>동전이 있던 곳은 <%=su %></h2>
		<input type="button" value="다시도전" onclick="location.href='08_yaba.jsp'">
	</div>
</body>
</html>