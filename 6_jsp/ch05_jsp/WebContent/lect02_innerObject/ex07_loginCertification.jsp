<%@ page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 	boolean isValid = false;
	String msg="";
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// ★ 이건 아이디, 패스워드 따로 체크 버전이지만, 실제로는 같이 체크되도록 해야 해킹에 덜 취약함...
	if(id!=null && id.equals("aaa")){ // 아이디를 잘 입력하고
		if(pw!=null && pw.equals("111")){ // 비밀번호도 잘 입력하면
			isValid = true; // true -> if문 나가서 출력~
		}else{ // 비밀전호를 잘못 입력한 경우
			msg = "비밀번호를 확인하세요."; // alert 하는 경우는 인코딩 필요 음슴.
			// msg = URLEncoder.encode("비밀번호를 확인하세요~", "utf-8"); // 한글을 보내려면 URLEncoder 필요
		}
	}else{ // 아이디를 잘못 입력한 경우
		msg = "아이디를 확인하세요."; 
		// msg = URLEncoder.encode("아이디를 확인하세요~", "utf-8");
	}
	if(!isValid){
	%>
	<!-- msg를 alert로 띄우는 경우 -->
	<script>
		alert('<%=msg%>');
		location.href = 'loginFrm.jsp?msg='+'<%=msg%>'; // alert 하는 경우 redirect 할 필요 음슴.
	</script>
	<%
	}
	%>
	<%-- <%
		response.sendRedirect("loginFrm.jsp?msg="+msg); // msg를 가지고 넘어가야 함.
	}%> --%>
		<h2>ID : <%=id %></h2>
		<h2>PW : <%=pw %></h2>
		<h2>로그인 성공. 반갑습니다.</h2>
	

</body>
</html>