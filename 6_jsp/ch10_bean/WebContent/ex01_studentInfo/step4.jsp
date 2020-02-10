<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean class="com.tj.studentinfo.StudentInfo" id="pi" scope="request"/>
	<jsp:setProperty name="pi" property="studentNum" value='<%=request.getParameter("studentNum") %>'/>
	<jsp:setProperty name="pi" property="name" value='<%=request.getParameter("name") %>'/>
	<jsp:setProperty name="pi" property="grade" value='<%=Integer.parseInt(request.getParameter("grade")) %>'/>
	<jsp:setProperty name="pi" property="className" value='<%=request.getParameter("className").charAt(0) %>'/>
	<jsp:setProperty name="pi" property="score" value='<%=Integer.parseInt(request.getParameter("score")) %>'/>
	
	<jsp:forward page="siView.jsp"/>
</body>
</html>