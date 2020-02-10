<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"  %> <!-- 이 페이지는 에러가 났다고 알려줌 -> exception 내부 객체 사용을 위해 -->
<% response.setStatus(200); /* 브라우저 별로 에러가 발생할 경우 아예 화면이 안보이는 경우가 있으니 화면은 보이게 조정함.*/
	/* 200 : 정상 상태
	   404 : 해당 문서를 찾을 수 없는 경우
	   407 : 인증을 받지 못한 경우(ex: 구글로 로그인...)
	   500 : 문법 오류나 예외 상황이 발생한 경우	   
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	console.log('예외 메시지 : '+'<%=exception.getMessage()%>');
	console.log('예외  타입 : '+'<%=exception.getClass().getName()%>');
</script>
<body>
	<h1>공사중입니다.</h1>
	<%
		System.out.println("예외메시지 : "+exception.getMessage());
		System.out.println("예외타입 : "+exception.getClass().getName());
	%>
</body>
</html>