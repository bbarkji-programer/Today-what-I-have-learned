<%@page import="com.tj.model1ex.dao.CustomerDao"%>
<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="java.sql.Date"%>
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
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.tj.model1ex.dto.CustomerDto"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>
<%
	String tempbirth = request.getParameter("tempbirth");
	dto.setCbirth(Date.valueOf(tempbirth));
	out.println(dto.toString());
	String oldPw = request.getParameter("oldPw");
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
	String sessionPw = null;
	
	if(customer!=null){
		sessionPw = customer.getCpw();
	}
	if(dto.getCpw()==null){
		dto.setCpw(sessionPw);
	}
	if(oldPw.equals(sessionPw)){
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.updateCustomer(dto);
		if(result == CustomerDao.SUCCESS){
			session.setAttribute("customer", dto);
			%>		
			<script>
				alert('회원정보 수정 완료');
				location.href = '../main/main.jsp';
			</script>
		<%}else{%>
			<script>
				alert('회원정보 수정 실패. 정보가 너무 깁니다.');
				location.href = 'modify.jsp';
			</script>
		<%}
	}else{ // 현 비밀번호를 틀리게 입력한 경우 뭐라 하고 돌려보냄
%>
	<script>
		alert('현 비밀번호가 바르지 않습니다. 확인하세요.');
		history.back();
	</script>		
	<%}%>
</body>
</html>