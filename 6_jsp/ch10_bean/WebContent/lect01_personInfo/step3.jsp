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
	<jsp:useBean class="com.tj.personinfo.PersonInfo" id="pi" scope="page"></jsp:useBean> <!-- 이 페이지에서만 쓰는 pi 객체 생성. 매개변수 없는 생성자를 쓴다. -->
	<jsp:setProperty property="name" name="pi" value='<%=request.getParameter("name") %>'/> <!-- 이렇게 가져와야 되니까 java class에 setter getter 필요. -->
	<jsp:setProperty property="age" name="pi" value='<%=Integer.parseInt(request.getParameter("age")) %>'/>
	<jsp:setProperty property="gender" name="pi" value='<%=request.getParameter("gender").charAt(0) %>'/>
	<jsp:setProperty property="address" name="pi" value='<%=request.getParameter("address") %>'/>

	<h2>입력된 개인정보</h2>
	<p>이름 : <jsp:getProperty name="pi" property="name"/></p>
	<p>나이 : <jsp:getProperty name="pi" property="age"/></p>
	<p>성별 : <jsp:getProperty name="pi" property="gender"/></p>
	<p>주소 : <jsp:getProperty name="pi" property="address"/></p>
</body>
</html>