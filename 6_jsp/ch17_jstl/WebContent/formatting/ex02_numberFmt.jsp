<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link href="../css/style.css" rel="stylesheet"> -->
</head>
<body>
	<c:set var="num" value="1234567.879"/>
	<p>
		첫 번째 수는 세 자리마다  , <br>
		두 번째 수는 소수점 두 자리까지(소수점 한 자리까지만 있는 경우 한 자리만)<br>
		세 번째 수는 소수점 두 자리까지(반드시, 소수점 한 자리까지만 있는 경우 뒤에 0)
	</p>
	<p>
		num : ${num }
	</p>
	<p>
		첫 번째 : <fmt:formatNumber value="${num }" groupingUsed="true"/>
	</p>
	<p>
		두 번째 : <fmt:formatNumber value="${num }" pattern="#,###.####"/> <!-- #은 없으면 출력 안하고, 있으면 출력한다. -->
	</p>
	<p>
		세 번째 : <fmt:formatNumber value="${num }" pattern="0,000.0000"/> 
	</p>
</body>
</html>