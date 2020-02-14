<%@page import="com.tj.dto.BoardDto"%>
<%@page import="com.tj.dao.BoardDao"%>
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
	int num = Integer.parseInt(request.getParameter("num")); // dao를 int로 받게만 만듦
	String pw = request.getParameter("pw");
	BoardDao bDao = BoardDao.getInstance();
	int result = bDao.deleteBoard(num,pw);
	if(result==BoardDao.SUCCESS){%>
		<script>
			alert('<%=num%>번 글 삭제 성공');
			location.href='list.jsp';
		</script>
	<%}else{%>
		<script>
			alert('<%=num%>번 글 삭제 실패. 비밀번호를 확인하세요.');
			history.go(-1);
		</script>
	<%}%>

</body>
</html>