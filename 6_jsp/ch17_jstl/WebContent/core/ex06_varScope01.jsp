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
		물품정보
	</h2>
	<h3>
		코드 : ${code } <!-- ${requestScope.code} -->
	</h3>
	<h3>
		이름 : ${name }
	</h3>
	<h3>
		가격 : ${price } 원
	</h3>
</body>
</html>