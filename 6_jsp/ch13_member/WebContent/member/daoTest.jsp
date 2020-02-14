<%@page import="java.sql.Date"%>
<%@page import="com.tj.member.MemberDto"%>
<%@page import="com.tj.member.MemberDao"%>
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
<h1>테스트 페이지</h1>
<%
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.confirmId("BBB");
	if(result==MemberDao.MEMBER_EXIST){
		out.println("<h3>1. confirmId 테스트 : BBB는 있는(중복) id</h3>");
	}else{
		out.println("<h3>1. confirmId 테스트 : BBB는 없는(사용가능한) id</h3>");
	}
	out.println("<hr><h3>2. insertMember테스트</h3>");
	MemberDto dto = new MemberDto("aaa","111","가가가","aaa@bbb.ccc",Date.valueOf("1990-01-08"),null,"서울시 종로구");	
	result = mDao.insertMember(dto);
	if(result==MemberDao.SUCCESS){
		out.println("가입 성공한 멤버 : "+dto.toString());
	}else{
		out.print("가입 실패");
	}
	out.println("<hr><h3>3. 로그인 loginCheck</h3>");
	result = mDao.loginChk("aaa","111");
	if(result == MemberDao.LOGIN_SUCCESS){
		out.println("aaa/111 로그인 성공");
	}else if(result==MemberDao.LOGIN_FAIL_PW){
		out.println("aaa/111 비밀번호 오류");
	}else if(result==MemberDao.LOGIN_FAIL_ID){
		out.println("aaa/111 아이디 오류");
	}
	out.println("<br>");
	result = mDao.loginChk("sdsd","222");
	if(result == MemberDao.LOGIN_SUCCESS){
		out.println("sdsd/222 로그인 성공");
	}else if(result==MemberDao.LOGIN_FAIL_PW){
		out.println("sdsd/222 비밀번호 오류");
	}else if(result==MemberDao.LOGIN_FAIL_ID){
		out.println("sdsd/222 아이디 오류");
	}
	out.println("<hr><h3>4. id로 dto 가져오기</h3>");
	dto = mDao.getMember("aaa");
	out.println("aaa아이디인 사람의 정보 : "+dto);
	
	out.println("<hr><h3>5. aaa 회원 정보 수정하기 </h3>");
	dto = new MemberDto("aaa","111","갹갹갹","aaa@bbb.ccc",Date.valueOf("1990-01-08"),null,"서울시 종로구");
	result = mDao.UpdateMember(dto);
	if(result==MemberDao.SUCCESS){
		out.println("수정 후 데이터 : "+mDao.getMember("aaa"));
	}else{
		out.println("수정실패 : "+dto);
	}

%>
</body>
</html>