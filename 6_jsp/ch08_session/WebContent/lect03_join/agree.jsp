<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
<style>
h2{
	color:magenta;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<%
	// [1] 입력 값(파라미터)을 가져오고
	request.setCharacterEncoding("utf-8"); // 파라미터 값 중 한글이 있으므로
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	
	// [2] 세션에 파라미터 값 저장
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	session.setAttribute("name", name);	
%>
	<h2><%=name %>님 아래 약관에 동의하십니까?</h2>
	<hr>
	<ol>
		<li>
			회원 정보는 웹사이트 운영을 위해서만 활용할게여.
		</li>
		<li>
			본 사이트의 정상적인 운영을 방해한다면 탈퇴처리할거에여.
		</li>
	</ol>
	<hr>
	<fieldset>
		<legend>
			약관 동의
		</legend>
		<form action="joinOK.jsp">
			<input type="radio" name="agree" value="y">동의	
			<input type="radio" name="agree" value="n" checked="checked">거부	
			<input type="submit" value="확인">		
		</form>
	</fieldset>
</body>
</html>