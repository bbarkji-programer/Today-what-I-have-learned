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
	int age = Integer.parseInt(request.getParameter("age"));
	// 입력 값을 조건에 따라 해당하는 페이지로 sendRedirect 해줌
	if(age>=19){
		// 파라미터 정보를 더해서 다시 요청
		response.sendRedirect("ex06_pass.jsp?age="+age); 
	}else{
		response.sendRedirect("ex06_ng.jsp?age="+age);
	}
%>
</body>
</html>