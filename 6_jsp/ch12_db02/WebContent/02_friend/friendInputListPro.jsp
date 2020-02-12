<%@page import="com.tj.dao.FriendDao"%>
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
<%-- <%
	request.setCharacterEncoding("utf-8"); 
%> --%>
<jsp:useBean id="dto" class="com.tj.dto.FriendDto"/>
<jsp:setProperty name="dto" property="*"/>
<%
	FriendDao friendDao = FriendDao.getInstance();
	int result = friendDao.insertFriend(dto);
	if(result>0){
		response.sendRedirect("friendInputList.jsp?result=success");
	}else{
		response.sendRedirect("friendInputList.jsp?result=fail");
	}
%>
</body>
</html>