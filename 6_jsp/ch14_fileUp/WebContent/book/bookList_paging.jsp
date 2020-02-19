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
	// bookListPaging.jsp -> bookListPaging.jsp?pageNum=1 
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null){
		pageNum = "1";
	}
	int currentPage = Integer.parseInt(pageNum); // 밑에서 계산해야 하니까.
	final int PAGESIZE = 3, BLOCKSIZE = 5;
	
	int startRow = (currentPage-1) * PAGESIZE + 1;
	int endRow = startRow + PAGESIZE - 1;
	
	BookDao bDao = BookDao.getInstance();
	ArrayList<BookDto> books = bDao.bookList(startRow, endRow);
	%>
	<table>
		<caption> 도서 리스트 </caption>
		<tr>
			<th>
				책 ID
			</th>
			<th>
				책 이름
			</th>
			<th>
				표지
			</th>
			<th>
				가격
			</th>
			<th>
				할인율
			</th>
		</tr>	
	<%for(BookDto b : books){%>
		<tr>
			<td>
				<%=b.getBook_id() %>
			</td>
			<td>
				<%=b.getBook_title() %>
			</td>
			<td>
				<img src="../bookImg/<%=b.getBook_image1() %>" width="30">
			</td>
			<td>
				<%=b.getBook_price() %>
			</td>
			<td>
				<%=b.getBook_discount() %>
			</td>
		</tr>		
	<%}%>
	</table>
	<div class="paging">
		<%
			int bookCnt = bDao.getBookCnt();
			int pageCnt = (int)Math.ceil((double)bookCnt/PAGESIZE);
			int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
			int endPage = startPage + BLOCKSIZE - 1;
			if(endPage > pageCnt){
				endPage = pageCnt;
			}
		%>
		<%if(startPage>BLOCKSIZE){ %>
			[ <a href="bookList_paging.jsp?pageNum=<%=startPage-1 %>">이전</a>]
		<%} %>	
		<%for(int i=startPage ; i<=endPage ; i++){
			if(i==currentPage){
				out.print("[<b>"+i+"</b>]");
			}else{
				out.print("[<a href='bookList_paging.jsp?pageNum="+i+"'>"+i+"</a>]");
			}
		} 
		if(endPage<pageCnt){%>
			[<a href="bookList_paging.jsp?pageNum=<%=endPage+1 %>">다음</a>]	
		
		<%}%>
	</div>
</body>
</html>