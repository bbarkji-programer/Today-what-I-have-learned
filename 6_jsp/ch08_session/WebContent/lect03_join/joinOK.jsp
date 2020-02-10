<%@page import="java.io.PrintWriter"%>
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
<%
	String msg =""; // 추후 보낼 msg 초기화
	String agree = request.getParameter("agree"); // 동의 y 거부  n
	if(agree.equals("y")){ // y - 세션에 값 받아서 저장, 일부 세션 날림
		// 세션에 값 저장
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		String name = (String)session.getAttribute("name");
		// 파일에 저장
		String file = "D:/mega_IT/source/6_jsp/ch08_session/WebContent/WEB-INF/"+id+".txt";
		PrintWriter writer = null; 
		try{
			writer = new PrintWriter(file); //  폴더가 없는 경우 에러 발생 가능성 있음. try catch 해줘야 함.
			writer.println("오늘은 DB insert 대신 파일에 쓸게여");
			writer.println("아이디 : "+id);
			writer.println("비밀번호: "+pw);
			writer.println("이름 : "+name);
			msg = "success";
		// 일부 세션 날리기
			session.removeAttribute("pw");
			session.removeAttribute("name");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(writer!=null) writer.close();
		}
	}else if(agree.equals("n")){ // n - 세션 전체 날림
		session.invalidate();
		msg ="fail";
	}else{ // 이상한 경우
		response.sendRedirect("join.jsp");
	}
	response.sendRedirect("result.jsp?msg="+msg); // result.jsp로 보내면서 msg 파라미터 값을 가지고 감. 이때 동의했으면 msg=success, 거부했으면 msg=fail
%>
<jsp:include page="footer.jsp"/>
</body>
</html>