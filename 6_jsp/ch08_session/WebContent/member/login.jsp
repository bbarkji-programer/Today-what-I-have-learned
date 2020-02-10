<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/login.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
	<div id="loginForm_wrap">
		<div id="login_title">
			로그인
		</div>
		<form action="loginPro.jsp" method="post">
		<table>
			<tr>
				<td colspan="2"> </td>
			</tr>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="id" id="id" autofocus="autofocus" required="required"
						value="<%
								String sessionId = (String)session.getAttribute("sessionId");
								if(sessionId!=null){
									out.print(sessionId);
								}
						%>">
				</td>
			</tr>
			<tr>
				<th>
					비밀번호
				</th>
				<td>
					<input type="password" name="pw" id="pw" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2"> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" class="loginBtn_style" value="로그인">
				</td>
			</tr>
			<tr>
				<td> </td>
			</tr>
			<tr>
				<td colspan="2">
				<% 
				if(session.getAttribute("name")!=null){
					response.sendRedirect("main.jsp");
				}
					String msg = request.getParameter("msg");			
					if(msg!=null){%>
					<p id="login_findIdPw" onclick="alert('id=aaa / pw=111')">아이디/비밀번호를 잊으셨나요?</p>	
				<%} %>
				</td>
			</tr>
		</table>
		</form>
		<p id="login_join">아직 회원이 아니신가요? <a href="join.jsp">회원가입</a></p>
	</div>
<%@include file="footer.jsp" %>
</body>
</html>