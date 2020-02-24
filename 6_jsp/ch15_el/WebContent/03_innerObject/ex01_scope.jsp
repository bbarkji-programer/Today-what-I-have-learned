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
	<form action="ex02_scope.jsp">
		<p>
			이름 
			<input type="text" name="name">
		</p>
		<p>
			ID
			<input type="text" name="id">
		</p>
		<p>
			PW 
			<input type="password" name="pw">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<%
		pageContext.setAttribute("pageName", "pageValue");
		request.setAttribute("requestName", "requestValue"); // **
		session.setAttribute("sessionName", "sessionValue"); // **
		application.setAttribute("applicationName", "applicationValue");
		// forward 할 객체(dispatcher)
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex02_scope.jsp?name=hong&id=aaa&pw=111");
		// forward
		dispatcher.forward(request, response);
	%>	
<%-- 	<jsp:forward page="ex02_scope.jsp">
		<jsp:param name="name" value="hong"/>
		<jsp:param name="id" value="aaa"/>
		<jsp:param name="pw" value="111"/>
	</jsp:forward> --%>
	<h3>
		페이지 내 attribute : <%=pageContext.getAttribute("pageName") %>
	</h3>
	<h3>
		request 내 attribute : <%=request.getAttribute("requestName") %>
	</h3>
	<h3>
		세션 내 attribute : <%=session.getAttribute("sessionName") %>
	</h3>
	<h3>
		application 내 attribute : <%=application.getAttribute("applicationName") %>
	</h3>
	<hr>
	<h3>
		페이지 내 attribute : ${pageScope.pageName }
	</h3>
	<h3>
		request 내 attribute : ${requestScope.requestName }
	</h3>
	<h3>
		session 내 attribute: ${sessionScope.sessionName }
	</h3>
	<h3>
		application 내 attribute : ${applicationScope.applicationName }
	</h3>
	<hr>
	<h3>
		페이지 내 attribute : ${pageName }
	</h3>
	<h3>
		request 내 attribute : ${requestName }
	</h3>
	<h3>
		session 내 attribute: ${sessionName }
	</h3>
	<h3>
		application 내 attribute : ${applicationName }
	</h3>
</body>
</html>