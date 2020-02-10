<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/join.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<%
	request.setCharacterEncoding("utf-8");
	
	// 값 가져오기
	String hidden = (String)request.getParameter("hiddenParam"); // 히든값
	String id = request.getParameter("id"); // 아이디
	String name = request.getParameter("name"); // 이름
	String birth = (String)request.getParameter("birth"); // 생일
	String[] hobby = request.getParameterValues("hobby"); // {1,2,3,4,5}
	String gender = request.getParameter("gender"); // w or m
	String email = request.getParameter("email");
	String[] mailSend = request.getParameterValues("mailSend");// {1,2,3}
	String pw = request.getParameter("pw"); // 비밀번호
		String star ="";
		for(int i=1; i<pw.length(); i++) {
		star += "*";
		}
	
	//  세션에 값 저장
	session.setAttribute("sessionId",id);
	session.setAttribute("sessionName",name);
	
	// 로그인 페이지로 보내기
	response.sendRedirect("login.jsp");

%>
<div id="joinForm_wrap">
	<div id="join_title">회원가입정보</div>
	<h2>hiddenParam : <%=hidden %></h2>
	<h2>이름 : <%=name %></h2>
	<h2>아이디 : <%=id %></h2>
	<h2>패스워드 : <%=star %></h2>
	<h2>생년월일 : <%=birth %></h2>
	<h2>취미 : <% for(int i=0; i<hobby.length; i++) {
					if(i!=hobby.length-1) {
						out.print(hobby[i]+", ");			
					}else {
						out.print(hobby[i]);
					}
			}%></h2>
	<h2>성별 : <%=gender %></h2>
	<h2>이메일 : <%=email %> </h2>
	<h2>메일수신 : <%if(mailSend!=null) {
					for(int i=0; i<mailSend.length; i++) {
						if(i!=mailSend.length-1) {
							out.print(mailSend[i]+", ");					
						}else {
							out.print(mailSend[i]);
						}
					}
				}else {
				out.print("모두 거부"); }%></h2>
</div>
<%@include file="footer.jsp" %>
</body>
</html>