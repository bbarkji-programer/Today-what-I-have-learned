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
<!-- 같은 이름의 쿠키를 유효시간이 0 이 되도록 만들고, response에 탑재 -->
<% // 특정 쿠키(쿠키이름 : cookieName) 삭제
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie c : cookies){
			String name = c.getName();
			if(name.equals("cookieName")){
				Cookie cookie = new Cookie("cookieName","zz");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				out.print("<h3>쿠키 삭제 성공</h3>");
				break;
			}
		}
	}	

%>
	<hr>
	<a href="ex01_cookieConstruct.jsp">쿠키생성</a> <br>
	<a href="ex02_cookiesList.jsp">쿠키값들 리스트 확인</a> <br>
	<a href="ex03_thatCookie.jsp">특정 쿠키값(이름이 cookieName)찾기</a> <br>
	<a href="ex04_cookieDel.jsp">쿠키 삭제</a>
</body>
</html>