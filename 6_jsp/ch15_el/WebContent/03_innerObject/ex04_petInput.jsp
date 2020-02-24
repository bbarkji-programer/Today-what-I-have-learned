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
	<form action="ex04_petResult.jsp">
		ID
		<input type="text" name="id">
		<br>
		키우는 애완동물을 선택하세요.
		<br>
		<input type="checkbox" name="pets" value="짱구"> 짱구
		<input type="checkbox" name="pets" value="고영희"> 고영희
		<input type="checkbox" name="pets" value="봉자"> 봉자 
		<input type="checkbox" name="pets" value="애자"> 애자
		<br>
		<input type="submit" value="확인">
	</form>
</body>
</html>