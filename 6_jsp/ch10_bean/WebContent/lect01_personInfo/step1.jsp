<%@page import="com.tj.personinfo.PersonInfo"%>
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
<%
	// 객체 생성
	PersonInfo pi = new PersonInfo();	
	// 파라미터 값 가져와서 넣기
	pi.setName(request.getParameter("name"));
	pi.setAge(Integer.parseInt(request.getParameter("age")));
	pi.setGender(request.getParameter("gender").charAt(0)); // 0번째 문자 하나만 가져온다. = 한 글자만 가져온다.
	pi.setAddress(request.getParameter("address"));
%>
	<h2>입력된 개인정보</h2>
	<p>이름 : <%=pi.getName() %></p>
	<p>나이 : <%=pi.getAge() %></p>
	<p>성별 : <%=pi.getGender() %></p>
	<p>주소 : <%=pi.getAddress() %></p>
</body>
</html>