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
<div id="all">
<jsp:include page="../main/header.jsp"/>
	<div id="signin_wrap">
		<div class="title">
			SIGN IN
		</div>
		<form action="main.jsp" method="post">
		<div class="signin">
			<table>
				<tr>
					<td><label for="cid"></label>
						<input type="text" name="cid" id="cid" required="required" placeholder="ID">
					</td>
				</tr>
				<tr>
					<td><label for="cpw"></label>
						<input type="password" name="cpw" id="cpw" required="required" placeholder="PASSWORD">
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="Find your ID" onclick="location.href='findId.jsp'">
						<span>or</span>
						<input type="button" value="Password" onclick="location.href='findPw.jsp'">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Sign in" class="signinBtn">
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="Register" class="signinBtn" onclick="location.href='register.jsp'">
					</td>
				</tr>
			</table>
		</div>
		</form>
	</div>
<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>