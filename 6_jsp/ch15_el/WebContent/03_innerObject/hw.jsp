<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<style>
p{
	text-align:center;
}
</style>
</head>
<body>
	<form action="">
		<p>
			<input type="number" name="su1" value="<%=(int)(Math.random()*9)+1 %>">
			*
			<input type="number" name="su2" value="<%=(int)(Math.random()*9)+1 %>">
			=
			<input type="number" name="result">
		</p>
		<p>
			<input type="submit" value="확인">
		</p>
	</form>
		<p>
		${empty param.su1 ? "" : param.su1 } 
		*
		${empty param.su2 ? "" : param.su2 }
		= 는
		${param.result != param.su1*param.su2 ? "false" : param.result }
		${param.result != param.su1*param.su2 ? "" : "는 true 정답"}
		</p>
		<hr>
		<p>
			${param.su1 }*${param.su2 } = ${param.result }
			${param.su1*param.su2 eq param.result }
			${not empty param.result? (param.su1*param.su2 eq param.result? "정답" : "오답") : "" }
		</p>
</body>
</html>