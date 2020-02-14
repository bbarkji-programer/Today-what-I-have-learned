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
<table>
	<caption>글 내용 상세</caption>
	<tr>
		<th>
			글 번호
		</th>
		<td>
			<%=dto.getNum() %>
		</td>
	</tr>
	<tr>
		<th>
			글 제목
		</th>
		<td>
			<%=dto.getSubject() %>
		</td>
	</tr>
	<tr>
		<th>
			조회수
		</th>
		<td>
			<%=dto.getHit() %>
		</td>
	</tr>
	<tr>
		<th>
			메일
		</th>
		<td>
			<%=dto.getEmail()==null? "-" : dto.getEmail() %>
		</td>
	</tr>
		<tr>
		<th>
			ip
		</th>
		<td>
			<%=dto.getIp() %>
		</td>
	</tr>
	<tr>
		<th>
			글쓴시점
		</th>
		<td>
			<%=dto.getRdate() %>
		</td>
	</tr>
	<tr>
		<th>
			본문	
		</th>
		<td>
			<pre><%=dto.getContent() %></pre>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button onclick="location.href='updateForm.jsp?num=<%=num %>'">수정</button>
			<button onclick="location.href='deleteForm.jsp?num=<%=num %>'">삭제</button>
			<button>답변</button>
			<button onclick="location.href='list.jsp'">목록</button>
		</td>
	</tr>
</table>
</body>
</html>