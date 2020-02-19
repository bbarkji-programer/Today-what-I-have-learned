<%@page import="com.tj.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.book.BookDao"%>
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
<table>
	<tr>
<%
	BookDao bDao = BookDao.getInstance();
	ArrayList<BookDto> books = bDao.bookList();
	for(int i=0 ; i<books.size() ; i++){%>
		<td>
			<p>
				<img src="../bookImg/<%=books.get(i).getBook_image1() %>">
			</p>
			<p>
					<%=books.get(i).getBook_title() %>
			</p>
			<p>
				<del>
					<%=books.get(i).getBook_price() %> 원
				</del>
			</p>
			<p>
				<%=books.get(i).getBook_price()*(100-books.get(i).getBook_discount())/100 %> 원
				(<%=books.get(i).getBook_discount() %>% 할인)
			</p>
		</td>
		<%if(i%3 == 2){
			out.print("</tr><tr>");
		}
	}%>
	</tr>
</table>
</body>
</html>