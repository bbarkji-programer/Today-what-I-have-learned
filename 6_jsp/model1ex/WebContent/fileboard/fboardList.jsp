<%@page import="com.tj.model1ex.dto.FileboardDto"%>
<%@page import="java.util.ArrayList"%>
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
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<table>
		<caption>
			Q&A
		</caption>
		<tr>
			<th colspan="7">
				<%if(session.getAttribute("customer")==null){ // 로그인전%>
					글쓰기는 로그인 후 가능합니다.
				<%}else{ //로그인 후 %>
					<a href="fboardWriteForm.jsp">
						글쓰기
					</a>
				<%} %>
			</th>
		</tr>
		<tr>
			<th>
				글 번호
			</th>
			<th>
				작성자
			</th>
			<th>
				글 제목
			</th>
			<th>
				메일
			</th>
			<th>
				IP
			</th>
			<th>
				작성일
			</th>
			<th>
				조회수
			</th>
		</tr>
		<%
			String pageNum = request.getParameter("pageNum"); // 사용자가 누른 페이지
			if(pageNum==null) pageNum = "1"; // 페이지 값이 없다면, 첫 페이지라는 뜻
			int currentPage = Integer.parseInt(pageNum); // for 사칙연산
			final int PAGESIZE = 10, BLOCKSIZE = 10;
			int startRow = (currentPage - 1) * PAGESIZE + 1;
			int endRow = startRow + PAGESIZE - 1;
			FileboardDao fDao = FileboardDao.getInstance();
			int totCnt = fDao.getFileboardTotCnt();
			if(totCnt==0){ // 글이 하나도 없으면? %>
		<tr>
			<td colspan="7">
				등록된 글이 없습니다.
			</td>
		</tr> 
		<%}else{ // 등록된 글이 있으면?
			ArrayList<FileboardDto> fdtos = fDao.fileboardList(startRow, endRow);
			for(FileboardDto fd : fdtos){%>
		<tr>
			<td>
				<%=fd.getFnum() %>
			</td>
			<td>
				<%=fd.getcId() %>
			</td>
			<td class='left'>
				<!-- 답변글일 경우 : 들여쓰기 처리 + re.gif 출력 -->
				<%if(fd.getFre_level()>0){
					int width = fd.getFre_level()*10;%>
					<img src = "../img/level.gif" alt="" width="<%=width %>" height="10">
					<img src = "../img/re.gif" alt="re">
				<%} %>
				<!-- 조회수가 10이 넘는 경우 : hit 이미지 출력 -->
				<%if(fd.getFhit()>10){ %>
					<img src = "../img/hot.gif">
				<%} %>
				<a href='fboardContent.jsp?fnum=<%=fd.getFnum() %>&pageNum<%=pageNum %>'>
					<%=fd.getFsubject() %>
				</a>
				<!-- 파일이 첨부된 경우 : 파일 이미지 클릭 -->
				<%if(fd.getFfilename()!=null){ %>
					<img src = "../img/fileup.jpg">
				<%} %>
			</td>
			<td>
				<%=fd.getCemail()!= null ? fd.getCemail() : "-"  %>
			</td>
			<td>
				<%=fd.getFip()%>
			</td>
			<td>
				<%=fd.getFrdate() %>
			</td>
			<td>
				<%=fd.getFhit() %>
			</td>
		</tr>
			<%} %>
		<%} %>
	</table>
	<div class="paging">
		<%
			int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
			int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE + 1;
			int endPage = startPage + BLOCKSIZE - 1;
			if(endPage > pageCnt){
				endPage = pageCnt;
			}
			if(startPage>BLOCKSIZE){
				out.print("[<a href='fboardList.jsp?pageNum="+(startPage-1)+"'>이전</a>]");
			}
			for(int i=startPage; i<=endPage; i++){
				if(i==currentPage){
					out.print("[<b>"+i+"</b>]");
				}else{
					out.print("[<a href='fboardList.jsp?pageNum="+i+"'>"+i+"</a>]");
				}
			}
			if(endPage<pageCnt){
				out.print("[<a href='fboardList.jsp?pageNum="+(startPage-1)+"'>다음</a>]");
			}
		%>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>