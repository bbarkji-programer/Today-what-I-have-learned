<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
<%! String id=null, name=null; // 쿠키가 있는 경우, 쿠키 값을 저장하기 위한 용도 %>
<%
	Cookie[] cs = request.getCookies();
	if(cs!=null){
		for(int i=0; i<cs.length; i++){
			if(cs[i].getName().equals("id")){
				id = cs[i].getValue();
			}else if(cs[i].getName().equals("name")){
				name = cs[i].getValue();
			}
		} // 로그인 했다면 - id(aaa), name(홍길동) / 로그인 안했다면 - id(null), name(null)
	}
	if(id==null){ // 로그인 전 화면
%>	
	<h1>손님(guest)님 반값습니다. 로그인 하세요.</h1>	
	<p>
		<button onclick="location.href='login.html'">로그인</button>
		<button onclick="location.href='cookiesList.jsp'">쿠키 확인</button>
	</p>
<%	}else{ // 로그인 이후 화면 %>
	<h1><%=name %>(<%=id %>)님 반갑습니다. &#128129;</h1>
	<p>
		<button onclick="location.href='logout.jsp'">로그아웃</button>
		<button onclick="location.href='cookiesList.jsp'">쿠키 확인</button>
	</p>	
<%	}
%>
</body>
</html>