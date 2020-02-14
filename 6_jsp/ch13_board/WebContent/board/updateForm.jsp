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
	String num = request.getParameter("num");
	BoardDao bDao = BoardDao.getInstance(); // dao 메소드 쓰겠음
	bDao.hitUp(num); // 조회수도 하나 올림
	BoardDto dto = bDao.getBoardOneLine(num); // num 기준으로 글 가져옴
%>
<form action="updatePro.jsp" method="post">
	<input type="hidden" name="num" value="<%=num %>">
	<table>
		<caption>
			<%=num %>번 글 수정
		</caption>
		<tr>
			<th>
				작성자
			</th>
			<td>
				<input type="text" name="writer" required="required" autofocus="autofocus" value="<%=dto.getWriter()%>">
			</td>
		</tr>
		<tr>
			<th>
				제목
			</th>
			<td>
				<input type="text" name="subject" required="required" value="<%=dto.getSubject()%>">
			</td>
		</tr>
		<tr>
			<th>
				메일
			</th>
			<td>
				<input type="email" name="email" value="<%=dto.getEmail()!=null? dto.getEmail():""%>">
			</td>
		</tr>
		<tr>
			<th>
				본문
			</th>
			<td>
				<textarea rows="5" cols="5" name="content"><%=dto.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<th>
				비밀번호
			</th>
			<td>
				<input type="password" name="pw" required="required" value="<%=dto.getPw()%>">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정하기" class="btn">
				<input type="button" value="수정취소" class="btn" onclick="history.back()">
				<input type="button" value="삭제" class="btn" onclick="location.href='deleteForm.jsp">
				<input type="button" value="목록" class="btn" onclick="location.href='list.jsp'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>