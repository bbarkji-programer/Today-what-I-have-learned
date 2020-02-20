<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/customer.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div id="loginForm_wrap">
<form action="loginPro.jsp" method="post">
		<table>
			<caption id=login_title>
				로그인
			</caption>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="cid" id="cid" autofocus="autofocus" required="required" 
						value="<% 
							String sessionId = (String)session.getAttribute("cid");
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
					<input type="password" name="cpw" id="cpw" required="required" 
						value="<% 
							String pw = (String)session.getAttribute("cpw");
							out.print(pw!=null? pw:"");
						%>">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" class="loginBtn_style">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<%
					if(session.getAttribute("cname")!=null){
						response.sendRedirect("../main/main.jsp");
					}
					String msg = request.getParameter("msg");
					if(msg!=null){%>
					<p id="login_findIdPw" onclick="alert('아이디 : aaa / 패스워드 : 111')"> 아이디/비밀번호를 잊으셨나요?</p>
				<%} %>
				</td>
			</tr>
		</table>
	</form>
	<p id="login_join">아직 회원이 아니신가요?<a href="join.jsp"> 회원가입</a></p>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>