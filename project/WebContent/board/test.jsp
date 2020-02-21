<%@page import="com.tj.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	BoardDao bDao = BoardDao.getInstance();

	out.print("<h1>1. DB 글 개수 : </h1>");
	out.print(bDao.totCnt()+"개");
	
	out.print("<hr><h1>2. 글 목록  : </h1>");
	ArrayList<BoardDto> dtos = bDao.list();
	for(int idx = 0 ; idx<dtos.size() ; idx++){
		out.println(dtos.get(idx).toString()+"<br>");
	}
%>
</body>
</html>