<%@page import="com.tj.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
<%
	MemberDto member = (MemberDto)session.getAttribute("member"); // 로그인을 하면 member로 session에 저장! 
	if(member!=null){
		out.println("<h2>"+member.getName()+"님 어서오세요.</h2>"); //세션에서 이름 가져옴
		out.println("<button onclick=\"location.href='modify.jsp'\">정보수정</button>");
		out.println("<button onclick=\"location.href='logout.jsp'\">로그아웃</button>");
	}else{ // 로그인 안함
		out.println("<h2>손님 어서오세요.</h2>");
		out.println("<button onclick=\"location.href='join.jsp'\">회원가입</button>");
		out.println("<button onclick=\"location.href='login.jsp'\">로그인</button>");
	}
%>
</body>
</html>