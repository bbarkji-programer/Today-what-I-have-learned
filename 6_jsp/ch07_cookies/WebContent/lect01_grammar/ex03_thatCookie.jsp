<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 회원 정보 수정할 때 사용한다. -->
<h2>특정 쿠키(쿠키이름 : cookieName)인 쿠키의 값 확인</h2>
<%
	Cookie[] cookies = request.getCookies();
	int idx=0;
	if(cookies!=null){
		for(idx=0; idx<cookies.length; idx++){
			String name = cookies[idx].getName();
			if(name.equals("cookieName")){
				String value = cookies[idx].getValue();
				out.print("<h3>찾고자 하는 쿠키 이름 : "+name+"</h3>");
				out.print("<h3>찾고자 하는 쿠키 값 : "+value+"</h3>");
				break;
			}
		}
		if(idx==cookies.length){
			out.println("찾는 쿠키가 없습니다.");
		}
	}else{
		out.print("구운 쿠키가 없습니다.");
	}
%>
<hr>
	<a href="ex01_cookieConstruct.jsp">쿠키생성</a> <br>
	<a href="ex02_cookiesList.jsp">쿠키값들 리스트 확인</a> <br>
	<a href="ex03_thatCookie.jsp">특정 쿠키값(이름이 cookieName)찾기</a> <br>
	<a href="ex04_cookieDel.jsp">쿠키 삭제</a>
</body>
</html>