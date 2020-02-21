<%@page import="com.tj.model1ex.dao.FileboardDao"%>
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
	String pageNum = request.getParameter("pageNum");
	int fnum = Integer.parseInt(request.getParameter("fnum"));
	String fpw = request.getParameter("fpw");
	FileboardDao dao = FileboardDao.getInstance();
	int result = dao.delete(fnum, fpw);
	if(result==FileboardDao.SUCCESS){%>
		<script>
			alert('<%=fnum%>번 글 삭제 성공');
			location.href='fboardlist.jsp?pageNum=<%=pageNum %>';
		</script>
	<%}else{ %>
		<script>
			alert('<%=fnum%>번 글 삭제 실패');
			history.go(-1);
		</script>
	<%} %>
</body>
</html>