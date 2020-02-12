<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
<%! String name, pw, phone1, phone2, phone3, gender;%> <!-- 선언부에 적으면 알아서 null로 초기 -->
<% 
	if(session.getAttribute("validmember")==null){
		response.sendRedirect("login.jsp");
	}
	if(request.getParameter("result")!=null){
%>	
<script>
	alert('현재 비밀번호가 맞지 않아 수정이 불가능합니다.');
</script>	
	<%}
	// 화면에 수정할 정보를 가져오기
	String id = (String)session.getAttribute("id");
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid = "scott";
	String upw = "tiger";	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "SELECT*FROM MEMBER WHERE ID=?";
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, upw);
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1,id);
		rs = pstmt.executeQuery();
		
		rs.next();
		
		name = rs.getString("name");
		pw = rs.getString("pw");
		phone1 = rs.getString("phone1");
		phone2 = rs.getString("phone2");
		phone3 = rs.getString("phone3");
		gender = rs.getString("gender");
		
	}catch(Exception e){
		System.out.println("e.getMessage()");
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
%>
<form action="../ModifyOk" method="post">
	<input type="hidden" name="dbPw" value="<%=pw %>"> <!-- 현재pw(oldPw)와 비교용 -->
		<table>
			<caption>회원 정보 수정</caption>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="id" value="<%=id%>" readonly="readonly" size="20">
				</td>
			</tr>
			<tr>
				<th>
					현재 비밀번호
				</th>
				<td>
					<input type="password" name="oldPw" required="required" size="20">
				</td>
			</tr>
			<tr>
				<th>
					새로운 비밀번호
				</th>
				<td>
					<input type="password" name="newPw" size="20">
				</td>
			</tr>	
			<tr>
				<th>
					이름
				</th>
				<td>
					<input type="text" name="name" value="<%=name %>" required="required" size="20">
				</td>
			</tr>
			<tr>
				<th>
					전화번호
				</th>
				<td>
					<select name="phone1">
					<%
						if("02".equals(phone1)){%>
							<option></option>
							<option selected="selected">02</option>
							<option>010</option>
						<%}else if("010".equals(phone1)){%>
							<option></option>
							<option>02</option>
							<option selected="selected">010</option>
						<%}else{%>
							<option></option>
							<option>02</option>
							<option>010</option>
						<%}%>
					</select>
					<span>-</span>
					<input type="text" name="phone2" value="<%=phone2!=null? phone2:"" %>" size="4">
					<span>-</span>
					<input type="text" name="phone3" value="<%=phone3!=null? phone3:"" %>" size="4">
				</td>
			</tr>
			<tr>
				<th>
					성별
				</th>
				<td>
				<%
					if("f".equals(gender)){%>
						<input type="radio" name="gender" value="f" checked="checked">여
						<input type="radio" name="gender" value="m">남	
					<%}else if("m".equals(gender)){%>
						<input type="radio" name="gender" value="f" >여
						<input type="radio" name="gender" value="m" checked="checked">남	
					<%}else{%>
						<input type="radio" name="gender" value="f" >여
						<input type="radio" name="gender" value="m" >남	
					<%}%>
				
								
				</td>
			</tr>	
			<tr>
				<td colspan='2'>
					<input type="submit" value="수정">
					<input type="reset" value="취소">
					<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>