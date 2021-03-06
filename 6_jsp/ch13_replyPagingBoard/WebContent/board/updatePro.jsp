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
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.tj.dto.BoardDto"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/> <!-- 다 String 형이라 한 번에 받음. 생일 이런거 있으면 따로 받아야.. -->
<%
	// pageNum 추가
	String pageNum = request.getParameter("pageNum");
	dto.setIp(request.getRemoteAddr()); // ip 수정
	BoardDao bDao = BoardDao.getInstance();
	int result = bDao.updateBoard(dto);
	if(result==BoardDao.SUCCESS){%>
	<script>
		alert('글 수정 성공~');
		location.href='list.jsp?pageNum=<%=pageNum%>';
		<%-- location.href='content.jsp?num=<%=dto.getNum()%>'; --%>
	</script>
	<%}else{ %>
	<script>
		alert('글 수정 실패!');
		history.go(-1);
	</script>
	<%}%>	

</body>
</html>