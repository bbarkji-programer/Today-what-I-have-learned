<%@page import="java.sql.Date"%>
<%@page import="com.tj.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%String conPath = request.getContextPath(); %>
<jsp:useBean id="dto" class="com.tj.member.MemberDto"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>
<%
	String tempBirth = request.getParameter("tempBirth"); // 1991-12-12
	dto.setBirth(Date.valueOf(tempBirth));
	out.println(dto.toString());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
<%
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.confirmId(dto.getId()); // ID 중복체크
	if(result == MemberDao.MEMBER_NONEXIST){ // 사용 가능한 아이디
		result = mDao.insertMember(dto); // 회원가입
		if(result == MemberDao.SUCCESS){ // 회원가입 성공
			session.setAttribute("id", dto.getId());%>
		<script>
			alert('회원가입 감사합니다. 로그인 후 서비스 이용가능합니다.');
			location.href='join.jsp';
		</script>			
		<%}else{ // 회원가입 실패 %>
		<script>
			alert('회원가입 실패. 처음부터 다시 진행해주세요.');
			location.href='login.jsp';
		</script>	
		<%}
	}else{ // 중복된 아이디 %>
		<script>
			alert('중복된 아이디 입니다.');
			history.back();
		</script>
	<%}%>
</body>
</html>