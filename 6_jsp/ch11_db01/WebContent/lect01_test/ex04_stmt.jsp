<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String job = request.getParameter("job");
	// stmt 객체는 완성된 sql문인 경우만 객체 생성이 가능하다.
	String sql = "SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB='"+job+"'";

	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, upw);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		out.println("<table>");
		out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>부서번호</th></tr>");
		if(rs.next()){
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			int deptno = rs.getInt("deptno");
			do{
				out.println("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+job+"</td><td>"+deptno+"</td></tr>");				
			}while(rs.next());
		}else{
			out.println("<tr><td colspan='4'>해당 직책("+job+")의 사원은 없습니다.</td></tr>");
		}
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}
%>
</body>
</html>