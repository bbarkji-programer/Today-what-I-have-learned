<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="4kb" autoFlush="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 버퍼의 크기 : <%=out.getBufferSize()%></h2>
	<h2> 남은 버퍼의 크기 : <%=out.getRemaining()%></h2>
	<h2>TEST</h2>
	<h2> 남은 버퍼의 크기 : <%=out.getRemaining()%></h2>
	<%
		for(int i=0; i<1000; i++){
			out.println("<h2>TEST "+i+" 남은 버퍼의 크기 : "+out.getRemaining()+"</h2>");
		}
	%>
	
</body>
</html>