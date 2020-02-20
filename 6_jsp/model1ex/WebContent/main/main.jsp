<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.model1ex.dao.CustomerDao"%>
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
	<jsp:include page="header.jsp"/>
	<div id="content_form">
	<% // main.jsp -> main.jsp?pageNum=1 
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 5, BLOCKSIZE = 3;
		int startrow = (currentPage - 1) * PAGESIZE + 1;
		int endrow = startrow + PAGESIZE - 1;
		
		CustomerDao cDao = CustomerDao.getInstance();
		ArrayList<CustomerDto> customers = cDao.getCustomerList(startrow, endrow);
	%>
		<table>
			<caption>
				회원 리스트
			</caption>
			<tr>
				<td>
					회원 ID
				</td>
				<td>
					비밀번호
				</td>
				<td>
					이름
				</td>
				<td>
					메일
				</td>
				<td>
					주소
				</td>
			</tr>
			<%if(customers.size()==0){ %>
			<tr>
				<td colspan="5">
					가입한 회원이 없습니다.
				</td>
			</tr>
			<%}else{
				for(CustomerDto c : customers){
					out.print("<tr><td>"+c.getCid()+"</td>");
					out.print("<td>"+c.getCpw()+"</td>");
					out.print("<td>"+c.getCname()+"</td>");
					out.print("<td>"+(c.getCemail()==null? "" : c.getCemail())+"</td>");
					out.print("<td>"+(c.getCaddress()==null? "" : c.getCaddress())+"</td></tr>");
				}
			} %>
		</table>
		<div class="paging">
			<%
				int totCnt = cDao.getCusTotCnt(); // 회원수
				int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); // 페이지 수 
				int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
				int endPage = startPage + BLOCKSIZE - 1;
				if(endPage > pageCnt) endPage = pageCnt;
				if(startPage > BLOCKSIZE){
			%>				
				[<a href="main.jsp?pageNum=<%=startPage-1 %>"> 이전 </a>]
			<%}
			for(int i=startPage; i<=endPage; i++){
				if(i==currentPage){%>
					[<b> <%=i %> </b>]
				<%}else{%>
					[<a href="main.jsp?pageNum=<%=i %>"> <%=i %> </a>]
				<%}
			}
			if(endPage < pageCnt){%>
				[<a href="main.jsp?pageNum=<%=endPage+1 %>"> 다음 </a>]
			<%} %>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>