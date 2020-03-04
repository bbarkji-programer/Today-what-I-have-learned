<%@page import="com.tj.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String mId = request.getParameter("mId");
	MemberDao dao = MemberDao.getInstance();
	int result = dao.mIdChk(mId);
	if(result==MemberDao.EXIST){
		out.print("중복된 ID 입니다.");
	}else{
		out.print("사용 가능한 ID입니다.");
	}
%>
</body>
</html>