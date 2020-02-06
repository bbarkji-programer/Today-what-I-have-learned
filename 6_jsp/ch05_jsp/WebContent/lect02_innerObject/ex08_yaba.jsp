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
}
input[type=button]{
	border:1px solid grey;
	outline:0;
	padding: 15px 30px;
	text-align:center;
	font-size: 1.5em;	
	margin:100px 10px;
}
h2{
	color: red;
	text-align:center;
}
</style>
<body>
	<h3>동전이 있는 곳을 맞춰봐</h3>
	<hr>
	<div class="wrap">
			<input type="button" value="1번" onclick="location.href='08_yabaCertification.jsp?su=1'">
			<input type="button" value="2번" onclick="location.href='08_yabaCertification.jsp?su=2'">
			<input type="button" value="3번" onclick="location.href='08_yabaCertification.jsp?su=3'">			
	<% String su =  request.getParameter("su"); %>
	<% String rsu = request.getParameter("rsu"); %>
	<%if(su!=null){%>
		<h2>Wrong! Try Again!</h2>
		<h2>(<%=su%>은(는) 아니고 정답은  <%=rsu %>)</h2>
	<%} %>
	</div>
</body>
</html>