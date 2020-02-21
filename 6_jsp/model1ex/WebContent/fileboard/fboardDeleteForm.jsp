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
	String fnum = request.getParameter("fnum");
%>
<table>
	<caption>
		<%=fnum %>번 글 삭제
	</caption>
	<tr>
		<td>
			<fieldset>
				<legend>
					삭제하기 위한 암호 입력
				</legend>
				<form action="fboardDeletePro.jsp" method="post">
					<input type="hidden" name="pageNum" value="<%=pageNum %>">
					<input type="hidden" name="num" value="<%=fnum %>"> <!-- num도 넘겨줘야 하니까 -->
					<p>
						암호
						<input type="password" name="fpw" required="required" autofocus="autofocus" class="btn">
					</p>
					<p>
						<input type="submit" value="삭제" class="btn">
						<input type="button" value="삭제취소" onclick="history.go(-1)" class="btn">
					</p>
				</form>
			</fieldset>
		</td>
	</tr>
</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>