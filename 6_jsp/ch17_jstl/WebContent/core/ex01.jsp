<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- core lib 쓰겠다. -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- fmt lib 쓰겠다. -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <!-- fuction lib 쓰겠다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<h2>
		core 라이블러리
	</h2>
	<c:forEach begin="1" end="10" step="2">
		<p>
			안녕하세요?
		</p>
	</c:forEach>
	<hr>
	<h2>
		fmt(formatting) 라이브러리
	</h2>
	<fmt:formatNumber value="3.241592" pattern="#.000">
	</fmt:formatNumber> <!-- 액션태그는 무적권 닫는 태그 있어야 된당. 또는 끝에 />-->
	<hr>
	<h2>
		그 외 라이브러리(function 라이브러리)
	</h2>
	${fn:toUpperCase(param.id) }
	<!-- fn 라이브러리는 EL과 함께 사용할 수 있다.  -->
</body>
</html>