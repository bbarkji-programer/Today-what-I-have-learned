<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:useBean id="pi" class="com.tj.studentinfo.StudentInfo" scope="request"/>
	<h2>입력된 학생 정보</h2>
	<p> 학번 : <jsp:getProperty name="pi" property="studentNum" /></p>
	<p> 이름 : <jsp:getProperty name="pi" property="name" /></p>
	<p> 학년 : <jsp:getProperty name="pi" property="grade" /></p>
	<p> 반이름 : <jsp:getProperty name="pi" property="className" /></p>
	<p> 점수 : <jsp:getProperty name="pi" property="score" /></p>
</body>
</html>