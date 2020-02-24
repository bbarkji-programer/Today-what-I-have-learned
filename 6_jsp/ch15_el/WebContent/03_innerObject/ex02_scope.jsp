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
	<h2>
		회원정보
	</h2>
	<h3>
		이름
		${param.name }
	</h3>
	<h3>
		ID
		${param.id }
	</h3>
	<h3>
		PW
		${param.pw }
	</h3>
	<hr>
	<h3>
		페이지 내 attribute : ${pageName }
	</h3>
	<h3>
		request 내 attribute : ${requestName }
	</h3>
	<h3>
		session 내 attribute: ${sessionName }
	</h3>
	<h3>
		application 내 attribute : ${applicationName }
	</h3>	
</body>
</html>