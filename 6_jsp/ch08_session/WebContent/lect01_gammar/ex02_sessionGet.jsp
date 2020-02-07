<%@page import="java.util.Enumeration"%>
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
	// 특정한 세션값 가져오기(로그인 시 사용)
	out.println("<h3>특정한 세션값 가져오기</h3>");
	String sessionName = (String)session.getAttribute("sessionName");
	Integer myNum = (Integer)session.getAttribute("myNum");
	out.print("sessionName : "+sessionName+"<br>");
	out.print("mynum : "+myNum+"<br>");
	out.print("id : "+session.getAttribute("id")+"<br>");
	
	// 모든 세션 리스트 출력
	out.println("<h3>모든 세션 속성들 list</h3>");
	Enumeration<String> sAttNames = session.getAttributeNames(); // 세션 속성 이름들 
	int cnt=0;
	while(sAttNames.hasMoreElements()){
		String sname = sAttNames.nextElement(); // 세션(속성)이름
		String svalue = session.getAttribute(sname).toString(); // 세션(속성) 값
		out.println(sname+"(세션 이름) : "+svalue+"(세션값)<br>");
		cnt++;
	}
	if(cnt==0){
		out.println("세션 속성이 없습니다.<br>");
	}
	
	// 특정한 세션(의 attribute)을 삭제하기(로그아웃 시 사용)
	session.removeAttribute("myNum");
	
	// 모든 세션 리스트 출력
	out.println("<h3>myNum 세션  삭제 후의 모든 세션 속성들 list</h3>");
	sAttNames = session.getAttributeNames(); // 세션 속성 이름들 
	cnt=0;
	while(sAttNames.hasMoreElements()){
		String sname = sAttNames.nextElement(); // 세션(속성)이름
		String svalue = session.getAttribute(sname).toString(); // 세션(속성) 값
		out.println(sname+"(세션 이름) : "+svalue+"(세션값)<br>");
		cnt++;
	}
	if(cnt==0){
		out.println("세션 속성이 없습니다.<br>");
	}
	
	// 모든 섹션(의 attribute) 삭제하기
	session.invalidate();// setAttribute 한 모든 세션 값 다 삭제	
	
	// 세션의 유효성 보기
		out.println("<h3>모든 세션 속성 삭제 후 유효한 세션은?</h3>");
		if(request.isRequestedSessionIdValid()){ // 유효한 세션 속성 요청
			out.println("session valid<br>");
		}else{
			out.print("session invalid<br>");
		}
%>
	<h2>세션 ID : <%=session.getId() %></h2>
	<h2>세션의 유효시간 : <%=session.getMaxInactiveInterval() %></h2>
</body>
</html>