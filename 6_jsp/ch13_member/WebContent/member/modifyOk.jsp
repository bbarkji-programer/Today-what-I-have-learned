<%@page import="com.tj.member.MemberDao"%>
<%@page import="com.tj.member.MemberDto"%>
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
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id ="dto" class="com.tj.member.MemberDto"/>
<jsp:setProperty name="dto" property="*"/>
<%
	String tempBirth = request.getParameter("tempBirth"); // 1991-12-12
	dto.setBirth(Date.valueOf(tempBirth));
	out.println(dto.toString());
	String oldPw = request.getParameter("oldPw");
	MemberDto member = (MemberDto)session.getAttribute("member");
	String sessionPw = null;
	if(member!=null){
		sessionPw = member.getPw();
	}
	// 새 비밀번호를 수정하지 않을 때 (pw가 null이 들어옴)
	if(dto.getPw()==null){
		dto.setPw(sessionPw);
	}
	if(oldPw.equals(sessionPw)){ // 현 비밀번호를 제대로 침
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.updateMember(dto);
		if(result == MemberDao.SUCCESS){ // db에 정보를 바꾼다.
			session.setAttribute("member",dto); // 세션에도 바뀐 정보를 set 해준다
		%>		
			<script>
				alert('회원정보 수정 완료');
				location.href = 'main.jsp';
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