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
	<jsp:useBean class="com.tj.personinfo.PersonInfo" id="pi" scope="request"></jsp:useBean> <!-- 새로운 request가 들어오기 전까지 유지하는 pi 객체 생성. 매개변수 없는 생성자를 쓴다. -->
	<jsp:setProperty name="pi" property="name" value='<%=request.getParameter("name") %>'/> <!-- 이렇게 가져와야 되니까 java class에 setter getter 필요. -->
	<jsp:setProperty name="pi" property="age" value='<%=Integer.parseInt(request.getParameter("age")) %>'/>
	<jsp:setProperty name="pi" property="gender" value='<%=request.getParameter("gender").charAt(0) %>'/>
	<jsp:setProperty name="pi" property="address" value='<%=request.getParameter("address") %>'/>

	<jsp:forward page="piView.jsp"></jsp:forward> <!-- 주소창을 바꾸지 않으면서 foward = 새로운 request가 들어오지 않는다. = pi 유지 --> 
</body>
</html>