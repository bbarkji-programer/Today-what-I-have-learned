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
<%! String id, pw; %>
<%
	// request.setCharacterEncoding("utf-8");
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	// 입력 받은 id, pw가 DB에 있는지 확인 절차
	if(id!=null && id.equals("aaa") && pw!=null && pw.equals("111")){
		// 로그인 처리
		Cookie cookieID = new Cookie("id",id);
		cookieID.setMaxAge(-1); // 유효시간은 브라우저 창을 닫을 때 까지
		response.addCookie(cookieID);
		Cookie cookieName = new Cookie("name", "홍길동"); // DB에서 가져온 이름을 쿠키값으로
		cookieName.setMaxAge(-1);
		response.addCookie(cookieName);
		response.sendRedirect("welcome.jsp");
	}else{
%>		
<script>
	alert("아이디와 비밀번호를 확인하세요.");
	location.href="login.html";
</script>
<% }	
%>

</body>
</html>