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
<%
	BookDao bDao = BookDao.getInstance();
	ArrayList<BookDto> books = bDao.bookList();
%>
<table>
	<caption>
		책 리스트
	</caption>
	<tr>
		<th>
			책 ID
		</th>
		<th>
			책 이름
		</th>
		<th>
			책 표지
		</th>
		<th>
			가격
		</th>
		<th>
			할인율
		</th>
	</tr>
	<%
		if(books.size()==0){
			out.print("<tr><td colspan='5'>등록된 책이 없습니다.</td></tr>");
		}else{
			for(BookDto book : books){ // for(타입 임시변수 : 변수)
				out.print("<tr><td>"+book.getBook_id()+"</td><td>"
						+book.getBook_title()+"</td><td>"
						+"<img src='../bookImg/"+book.getBook_image1()+"' width='50'></td><td>"
						+book.getBook_price()+"</td><td>"+book.getBook_discount()+"</td></tr>");
			}
		}
	%>
</table>
</body>
</html>