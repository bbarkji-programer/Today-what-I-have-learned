<%@page import="com.tj.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
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
				제목
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
		<% /* paging 처리를 위한 startRow, endRow 계산 
			  list.jsp -> list.jsp?pageNum=1 */
			String pageNum = request.getParameter("pageNum"); // 사용자가 원하는(선택한) page 번호 받아오기
		    if(pageNum==null) pageNum = "1"; // 만약에 pageNum 따로 없으면, 1페이지로 셋팅
			int currentPage = Integer.parseInt(pageNum); // 계산을 위해 페이지 번호를 int 형 변환
			final int PAGESIZE = 10, BLOCKSIZE = 10; // 한 페이지에 나타낼 글 수와 페이지 수 상수화			
			int startRow = (currentPage - 1) * PAGESIZE + 1; // startRow = (페이지번호 - 1) * 페이지당 개수 + 1			
			int endRow = startRow + PAGESIZE - 1; // endRow = 시작번호(startRow) + 페이지 당 개수 -1
			BoardDao bDao = BoardDao.getInstance(); // boardDao 호출
			int totCnt = bDao.getBoardTotalCnt(); // 전체 글 개수
			if(totCnt==0){%>
				<tr>
					<td colspan='7'>
						등록된 글이 없습니다.
					</td>
				</tr>
			<%}else{
				ArrayList<BoardDto> dtos = bDao.listBoard(startRow, endRow); // startRow 부터 endRow 까지 
				for(BoardDto dto : dtos){ // for(타입 임시변수 : arraylist 변수)
			%>
				<!-- 글번호, 작성자, 제목, 메일, ip, 작성일, 조회수 -->
					<tr>
						<td>
							<%=dto.getNum() %>
						</td>					
						<td>
							<%=dto.getWriter() %>
						</td>
						<td class='left'>							
							<!-- 답변글일 경우 = 들여쓰기 처리 + re.gif 출력 -->
							<%if(dto.getRe_level()>0){ 
								int width = dto.getRe_level()*10;%>
								<img src='../img/level.gif' alt='' width='<%=width %>' height="10">
								<img src='../img/re.gif' alt='re'>
							<%}%>
							<% if(dto.getHit()>10){%>
								<img src='../img/hot.gif'>
							<%} %>
							<a href='content.jsp?num=<%=dto.getNum() %>&pageNum=<%=pageNum %>'>
								<%=dto.getSubject() %>
							</a>
						</td>
						<td>
							<%=dto.getEmail()!= null ? dto.getEmail() : "-"%>
						</td>
						<td>
							<%=dto.getIp() %>
						</td>
						<td>
							<%=dto.getRdate() %>
						</td>
						<td>
							<%=dto.getHit() %>
						</td>
					</tr>
				<%} %>
			<%} %>
	</table>
	<div class="paging">
		<%
			int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); // 전체 페이지 수 = (인트로형변환)올림((올림할 수 있게 더블형변환)전체 글 개수/페이지 당 출력개수)			
			int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE + 1; // startPage = ((현재페이지-1)/블록사이즈)*블록사이즈 + 1			
			int endPage = startPage + BLOCKSIZE - 1; // endPage = 시작페이지 + 블록사이즈 수 -1
			if(endPage > pageCnt){
				endPage = pageCnt;
			}
			if(startPage>BLOCKSIZE){
				out.print("[<a href='list.jsp?pageNum="+(startPage-1)+"'>이전</a>]");
			}
			for(int i=startPage; i<=endPage; i++){
				if(i==currentPage){
					out.print("[<b>"+i+"</b>]"); // 현재 페이지인 경우
				}else{
					out.print("[<a href='list.jsp?pageNum="+i+"'>"+i+"</a>]"); // 현재 페이지 아닌 경우
				}
			}
			if(endPage<pageCnt){
				out.print("[<a href='list.jsp?pageNum="+(endPage+1)+"'>다음</a>]");
			}
			%>
	</div>
</body>
</html>