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
	String num = request.getParameter("num");
%>

<table>
	<caption>
		<%=num %>번 글 삭제
	</caption>
	<tr>
		<td>
			<fieldset>
				<legend>
					삭제하기 위한 암호 입력
				</legend>
				<form action="deletePro.jsp" method="post">
					<input type="hidden" name="num" value="<%=num %>"> <!-- num도 넘겨줘야 하니까 -->
					<p>
						암호
						<input type="password" name="pw" required="required" autofocus="autofocus" class="btn">
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
</body>
</html>