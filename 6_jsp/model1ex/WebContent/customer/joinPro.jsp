<%@page import="com.tj.model1ex.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/customer.css" rel="stylesheet">
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.tj.model1ex.dto.CustomerDto"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>
<%
	String tempbirth = request.getParameter("tempbirth");
	dto.setCbirth(Date.valueOf(tempbirth));
	out.println(dto.toString());
	
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.confirmId(dto.getCid());
	
	if(result == CustomerDao.CUSTOMER_NONEXISTENT){
		result = cDao.insertCustomer(dto);
		if(result == CustomerDao.SUCCESS){
			session.setAttribute("cid", dto.getCid());%>
		<script>
			alert('회원가입 감사합니다. 로그인 후 서비스 이용 가능합니다.');
			location.href='login.jsp';
		</script>
		<%}else{%>
		<script>
			alert('회원가입 실패. 처음부터 다시 진행해주세요.');
			location.href='join.jsp';
		</script>
		<%}%>	
	<%}else{%>
		<script>
			alert('중복된 아이디 입니다.');
			history.back();
		</script>
	<%} %>
</body>
</html>