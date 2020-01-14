package com.tj.ex06preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementSelect {
	public static void main(String[] args) {
		
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	String sql = "SELECT * FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME=?)";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Scanner sc = new Scanner(System.in);
	System.out.print("원하는 부서 이름은?");
	String dname = sc.next();
	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,"scott","tiger");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dname);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			int deptno = rs.getInt("deptno");
			System.out.println(empno+"\t"+ename+"\t"+deptno);
		}
		System.out.println("DONE");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	} finally {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) { }				
	}
	
	
	}
}
