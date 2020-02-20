<%@page import="com.tj.model1ex.dto.BookDto"%>
<%@page import="com.tj.model1ex.dao.BookDao"%>
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
<jsp:include page="../main/header.jsp"/>
<div id="content_form">
<%
	int book_id = Integer.parseInt(request.getParameter("book_id"));
	String pageNum = request.getParameter("pageNum");
	BookDao bDao = BookDao.getInstance();
	BookDto book = bDao.getBook(book_id);
%>
<table>
	<caption> 도서 상세 소개 </caption>
	<tr>
		<td rowspan="4">
			<img src="../bookImg/<%=book.getBook_image1()%>">
		</td>
		<td>
			<%=book.getBook_id() %>번 도서 상세보기
		</td>
	</tr>
	<tr>
		<td>
			<%=book.getBook_title() %>
		</td>
	</tr>
	<tr>
		<td>
			<del>
				<%=book.getBook_price() %>원
			</del>
			<%=book.getBook_price()*(100-book.getBook_discount())/100 %>원 
			<br>
				<b>
					<%=book.getBook_discount() %>% 할인
				</b>
		</td>
	</tr>
	<tr>
		<td>
			<button>
				구매하기
			</button>
			<button onclick="location='bookList.jsp?pageNum=<%=pageNum%>'">
				책 목록
			</button>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<img src="../bookImg/<%=book.getBook_image2() %>">
			<br>
			<pre><%=book.getBook_content() %></pre>
		</td>
	</tr>
</table>
</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>