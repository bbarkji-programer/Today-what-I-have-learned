<%@page import="com.tj.model1ex.dao.FileboardDao"%>
<%@page import="com.tj.model1ex.dto.FileboardDto"%>
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
	if(session.getAttribute("customer")==null){
		response.sendRedirect("../customer/login.jsp");
	}
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null) pageNum="1"; // 원글인 경우 
	int fnum = 0; // 글 번호를 0으로 초기화
	
	FileboardDto dto = new FileboardDto();
	if(request.getParameter("fnum")!=null){ // 답변글을 쓰려고 들어온 경우
		fnum = Integer.parseInt(request.getParameter("fnum"));
		FileboardDao dao = FileboardDao.getInstance();
		dto = dao.getDetail(fnum); // 원글에 대한 정보 (ref, ref_step, ref_level)
	}
	
%>
	<form action="fboardUpdatePro.jsp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="fnum" value="<%=fnum %>">
		<input type="hidden" name="dbfilename" value="<%=dto.getFfilename() %>">
		<table>
			<caption>
				<%=fnum%>번 글 수정
			</caption>
			<tr>
				<th>
					제목
				</th>
				<td>
					<input type="text" name="fsubject" required="required" autofocus="autofocus"
						value="<%=dto.getCname()%>">
				</td>
			</tr>
			<tr>
				<th>
					파일첨부
				</th>
				<td>
					기존 첨부 파일 : <%=dto.getFfilename()==null? "":dto.getFfilename() %> <input type="file" name="ffilename"> 
				</td>
			</tr>
			<tr>
				<th>
					본문
				</th>
				<td>
					<textarea rows="10" cols="5" name="fcontent"><%=dto.getFcontent() %></textarea>
				</td>
			</tr>
			<tr>
				<th>
					비밀번호
				</th>
				<td>
					<input type="password" name="fpw" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기" class="btn">
					<input type="button" value="수정취소" class="btn" onclick="history.back()">
					<input type="button" value="삭제" class="btn" onclick="location.href='deleteForm.jsp">
					<input type="button" value="목록" class="btn" 
						onclick="location.href='fboardList.jsp?pageNum=<%=pageNum %>'">
				</td>
			</tr>
		</table>
	</form>	
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>