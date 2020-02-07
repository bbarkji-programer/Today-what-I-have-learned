<%@page import="java.util.Enumeration"%>
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
	Enumeration<String> sAttNames = session.getAttributeNames(); // 열거하다
	int cnt = 0;
	while(sAttNames.hasMoreElements()){
		cnt++;
		String sname = sAttNames.nextElement();
		String svalue = session.getAttribute(sname).toString(); // (String) 하면 안됨. null 이 아니니까 toString()쓰면 됨...
		out.println("<p>"+sname+"(세션명) : "+svalue+"(세션값)</p>");
	}
	if(cnt==0){
		out.println("<p>유효한 세션이 없습니다.</p>");
	}
%>
	<button onclick="location.href='history.back()'">이전페이지</button>
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='logout.jsp'">로그아웃</button>
</body>
</html>