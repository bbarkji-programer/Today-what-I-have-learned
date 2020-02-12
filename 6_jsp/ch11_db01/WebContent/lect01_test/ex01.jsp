<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
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
</head>
<body>
<%! 
	// oracle 연결 변수 선언
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	// Mysql 연결 변수 선언
	String driverMysql = "com.mysql.jdbc.Driver";
	String urlMysql = "jdbc:mysql://127.0.0.1:3306/kimdb";
	String uidMysql = "root";
	String upwMysql = "mysql";
	// connection 객체 선언
	Connection conn;
	Statement stmt;
	ResultSet rs;
	String sql;
%>
<%
	sql = "SELECT*FROM EMP";

	try{
		 // 1단계: 드라이버 로드
		Class.forName(driver);
		// 2단계: DB연결 객체
		conn = DriverManager.getConnection(url, uid, upw); 
		// 3단계: SQL전송객체
		stmt = conn.createStatement(); 
		// 4단계 : sql 전송 -> 5단계: sql 결과 받기
		rs = stmt.executeQuery(sql); 
		// 6단계: 결과 받아 로직 수행
		while(rs.next()){ 
			int empno = rs.getInt(1); // 1번째 필드
			String ename = rs.getString("ename"); // ename 필드
			String job = rs.getString("job");
			int mgr = rs.getInt("mgr");
			Date hiredate = rs.getDate("hiredate");
			Timestamp hire = rs.getTimestamp("hiredate");
			int sal = rs.getInt("sal");
			int comm = rs.getInt("comm");
			int deptno = rs.getInt("deptno");
			// 출력
			out.println("<p>사번: "+empno+" ,이름; "+ename+" ,업무: "+job+" ,상사번호: "+mgr+" ,입사일: "+hiredate+
								" ,입사일: "+hire+" ,급여: "+sal+" ,상여: "+comm+" ,부서번호: "+deptno+"</p>");
		}
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{ // 7단계: 연결 해제
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch(Exception e){		
			System.out.println(e.getMessage()); // db pc가 다른 경우 꼭 close
		}
	}
%>
</body>
</html>