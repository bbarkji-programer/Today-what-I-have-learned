<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="com.tj.model1ex.dto.FileboardDto"%>
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
<%
	String pageNum = request.getParameter("pageNum");
	int fnum = Integer.parseInt(request.getParameter("fnum"));
	FileboardDao dao = FileboardDao.getInstance();
	dao.hitUp(fnum);
	FileboardDto dto = dao.getDetail(fnum);
%>
<table>
	<caption>
		글 상세보기
	</caption>
	<tr>
		<th>
			글 번호
		</th>
		<td>
			<%=fnum %>
		</td>
	</tr>
	<tr>
		<th>
			글 제목
		</th>
		<td>
			<%=dto.getFsubject() %>
		</td>
	</tr>
	<tr>
		<th>
			작성자
		</th>
		<td>
			<%=dto.getcId() %>
		</td>
	</tr>
		<tr>
		<th>
			첨부파일
		</th>
		<td>
			<%
			if(dto.getFfilename()==null){%>
				첨부파일 없음
			<%}else{%>
				<a href="../fileboardUpload/<%=dto.getFfilename() %> target='_blank'">
					<%=dto.getFfilename() %>
				</a>
			<%}%>
		</td>
	</tr>
	<tr>
		<th>
			본문
		</th>
		<td>
			<%=dto.getFcontent() %>
		</td>
	</tr>
	<tr>
		<th>
			작성일
		</th>
		<td>
			<%=dto.getFrdate() %>
		</td>
	</tr>
	<tr>
		<th>
			조회수
		</th>
		<td>
			<%=dto.getFhit() %>
		</td>
	</tr>
	<tr>
		<th>
			IP
		</th>
		<td>
			<%=dto.getFip()%>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<!-- 로그인 후 : 글 목록, 글 수정, 글 삭제, 답변 -->
		<%
		String cId = null;
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		if(customer!=null){
			cId = customer.getCid();
		}
		if(dto.getcId().equals(cId)){  %>
			<button onclick="location.href='fboardList.jsp?fnum=<%=fnum %>&pageNum<%=pageNum %>'">목록</button>
			<button onclick="location.href='fboardUpdateForm.jsp?fnum=<%=fnum %>&pageNum<%=pageNum %>'">글 수정</button>
			<button onclick="location.href='fboardDeleteForm.jsp?fnum=<%=fnum %>&pageNum<%=pageNum %>'">글 삭제</button>
			<button onclick="location.href='fboardWriteForm.jsp?fnum=<%=fnum %>&pageNum<%=pageNum %>'">답변</button>
		<%}else{ %>
		<!-- 로그인 전 : 글 목록, 글 삭제 -->
			<button onclick="location.href='fboardList.jsp?fnum=<%=fnum %>&pageNum<%=pageNum %>'">목록</button>
			<button onclick="location.href='fboardDeleteForm.jsp?fnum=<%=fnum %>&pageNum<%=pageNum %>'">글 삭제</button>
		<%} %>
		</td>
	</tr>
</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>