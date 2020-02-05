<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 	boolean isValid = false;
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id!=null && id.equals("aaa")){
		if(pw!=null && pw.equals("111")){
			isValid = true;
		}		
	}
	if(!isValid){
		String msg = "Check the ID and PW!";
		response.sendRedirect("loginFrm.jsp");
	}
%>
</body>
</html>