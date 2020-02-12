<%@page import="java.sql.Timestamp"%>
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
<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // select문 쓸 때 필요
	String sql = "SELECT * FROM EMP01";
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, upw);
		pstmt = conn.prepareStatement(sql); // stmt = conn.createStatement();
		rs = pstmt.executeQuery();
		out.println("<table>");
		out.println("<tr><th>사번</th><th>이름</th><th>입사일</th><th>부서번호</th></tr>");
		if(rs.next()){ // sql 수행 결과가 1행 이상일 때 (사번, 이름, 입사일, 부서번호)
			do{
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int deptno = rs.getInt("deptno");
				out.println("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+hiredate+"</td><td>"+deptno+"</td></tr>");
			}while(rs.next());
		}else{ // sql 실행 결과가 0행
			out.println("<tr><td colspan='4'>사원이없습니다.</td></tr>");
		}
		out.println("</table>");
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch(Exception e){		
			System.out.println(e.getMessage()); // db pc가 다른 경우 꼭 close
		}
	}
%>
</body>
</html>