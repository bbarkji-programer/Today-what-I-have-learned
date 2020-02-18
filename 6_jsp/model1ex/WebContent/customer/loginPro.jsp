<%@page import="java.net.URLEncoder"%>
<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="com.tj.model1ex.dao.CustomerDao"%>
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
	request.setCharacterEncoding("utf-8");
	String cid = request.getParameter("cid");
	String cpw = request.getParameter("cpw");
	String msg = "";
	
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.loginCheck(cid, cpw);
	
	if(result==CustomerDao.LOGIN_SUCCESS){
		CustomerDto customer = cDao.getCustomer(cid);
		session.setAttribute("customer",customer);
		response.sendRedirect("../main/main.jsp");
	}else{
		msg = URLEncoder.encode("ㅇㅇㅇ","utf-8");
		response.sendRedirect("login.jsp?msg="+msg);	
	} %>
	
</body>
</html>