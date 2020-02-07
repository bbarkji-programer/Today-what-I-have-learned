<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<%
	if(session.getAttribute("name")!=null){
		response.sendRedirect("welcome.jsp");
	}
	String msg = request.getParameter("msg");
	if(msg!=null){
%>
<script>
	alert('<%=msg%>');
</script>
<%		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../lect03_join/header.jsp"/>
	<form action="loginOK.jsp" method="post">
		<table>
			<caption>로그인</caption>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" autofocus="autofocus" required="required" 
							value="<%
								String sessionId = (String)session.getAttribute("id");
								if(sessionId!=null){
									out.print(sessionId);
								}
							%>">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" autofocus="autofocus" required="required"></td>
			</tr>
			<tr>
				<td> </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
</body>
</html>