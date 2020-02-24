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
	<%-- <%session.setAttribute("customer","ok"); %> --%>
	<h2>
		표현식 태그 이용
	</h2>
	<p>
		산술연산 : 10+1 = <%=10+1 %>
	</p>
	<p>
		산술연산 : 10/0.0 = <%=10/0.0 %>
	</p>
	<p>
		관계연산 : 1 > 2 = <%=1>2 %>
	</p>
	<p>
		관계연산 : 1 == 2 = <%=1==2 %>
	</p>
	<p>
		관계 연산 : 1!=2 = <%=1!=2 %>
	</p>
	<p>
		조건연산 : <%=(1>2) ? "1은 2보다 큽니다." : "1은 2보다 크지 않습니다."+"만" %>
	</p>
	<p>
		논리연산 : (1>2) || (1<2) = <%=(1>2) || (1<2) %>
	</p>
	<p>
		로그인여부 : <%=session.getAttribute("customer")==null? "로그인 전" : "로그인 후" %>
	</p>
	<p>
		로그인여부 : <%=session.getAttribute("customer")!=null? "로그인 후" : "로그인 전" %>
	</p>
	<p>
		pageNum파라미터 여부 : <%=request.getParameter("pageNum")==null? "pageNum 안옴" : "pageNum 옴" %>
	</p>
	<p>
		 su 파라미터 값 : <%=request.getParameter("su") %>
	</p>
	<h2>
		EL 표기법 이용(표현식 안에 쓸 수 있는 연산자는 다 사용 가능)
	</h2>
	<p>
		산술연산 : 10+1 = ${10+1 }
	</p>
	<p>
		산술연산 : 10/0.0 = ${10/0.0 }
	</p>
	<p>
		관계연산 : 1 > 2 = ${1>2 }
	</p>
	<p>
		관계연산 : 1 == 2 = ${1 eq 2 }
	</p>
	<p>
		관계연산 : 1!=2 = ${1!=2 }
	</p>
	<p>
		조건연산 : ${(1>2) ? "1은 2보다 큽니다.": "1은 2보다 크지 않습니다." } <!-- 삼항 연산자 안에서 계싼 안됨 -->
	</p>
	<p>
		논리연산 : (1>2) || (1<2) = ${(1>2) || (1<2) }
	</p>	
	<p>
		로그인 여부 : ${empty customer ? "로그인 전" : "로그인 후" }
	</p>
	<p>
		로그인 여부 : ${not empty customer ? "로그인 후" : "로그인 전" }
	</p>
	<p>
		파라미터 여부 : ${empty param.pageNum ? "pageNum 안옴" : "pageNum 옴" }
	</p>
	<p>
		su 파라미터 값 : ${param.su.toUpperCase() } <!-- 해당 파라미터 값이 없어도 예외 발생 안한다. -->
	</p>
</body>
</html>