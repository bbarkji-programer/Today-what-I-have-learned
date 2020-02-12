<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<%
	if(request.getParameter("result")!=null){%>
		<script>
			alert('아이디와 비밀번호를 확인하세요.');
		</script>		
	<%}%>
</head>
<body>
	<form action="../LoginOk" method="post">
		<table>
			<caption>
				로그인
			</caption>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="id" size="20" autofocus="autofocus" required="required"
						value="<%
							String id = (String)session.getAttribute("id");
							if(id!=null){
								out.print(id);
							}
						%>">
				</td>
			</tr>
			<tr>
				<th>
					비밀번호
				</th>
				<td>
					<input type="password" name="pw" size="20" required="required">
				</td>
			</tr>
			<tr>
				<td colspan='2'>
					<input type="submit" value="로그인">
					<input type="reset" value="취소">
					<input type="button" value="회원가입" onclick="location.href='join.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>