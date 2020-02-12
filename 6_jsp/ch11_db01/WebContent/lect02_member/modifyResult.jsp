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
<%
	if(request.getParameter("result").equals("success")){
		out.println("<h2>회원정보 수정 완료</h2>");
	}else{ // fail인 경우
		out.println("<h2>회원정보 수정 실패</h2>");
	}
%>
	<button onclick="history.go(-1)">이전페이지</button> <!-- 기존에 수정한 정보가 남아있음 -->
	<button onclick="location.href='modify.jsp'">정보수정</button>
	<button onclick="location.href='logout.jsp'">로그아웃</button>
</body>
</html>