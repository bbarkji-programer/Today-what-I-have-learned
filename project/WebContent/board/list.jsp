<%@page import="com.tj.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<caption>
			게시판
		</caption>
		<tr>
			<td>
				<a href="writeForm.jsp">
					글쓰기
				</a>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>
				글 번호
			</th>
			<th>
				작성자
			</th>
			<th>
				이메일
			</th>
			<th>
				제목
			</th>
			<th>
				작성일
			</th>
			<th>
				IP
			</th>
			<th>
				조회수
			</th>			
		</tr>
		<%
			BoardDao bDao = BoardDao.getInstance();
			int totCnt = bDao.totCnt();
			if(totCnt==0){%>
			<tr>
				<td colspan="7">
					등록된 글이 없습니다.
				</td>
			</tr>					
			<%}else{
				ArrayList<BoardDto> dtos = bDao.list();
				for(BoardDto dto : dtos){%>
			<tr>
				<td>
					<%=dto.getNum() %>
				</td>
				<td>
					<%=dto.getWriter() %>
				</td>
				<td>
					<%=dto.getEmail()!=null? dto.getEmail():"-" %>
				</td>
				<td>
					<%=dto.getSubject() %>
				</td>
				<td>
					<%=dto.getWrite_date() %>
				</td>
				<td>
					<%=dto.getIp() %>
				</td>
				<td>
					<%=dto.getHit() %>
				</td>
			</tr>
		<%}%>
	<%}%>
	</table>
</body>
</html>