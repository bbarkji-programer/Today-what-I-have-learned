package com.tj.ex06preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String sql = "INSERT INTO DEPT VALUES (?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 부서번호?");
		int deptno = sc.nextInt();
		System.out.print("부서 이름은?");
		String dname = sc.next();
		System.out.println("부서 위치는?");
		String loc = sc.next();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql); // 아직 sql문을 쏜 건 아님. sql문 전송할 객체만 생성한 것.
			pstmt.setInt(1, deptno); // sql문의 첫 번째 ? 처리 
			pstmt.setString(2, dname);
			pstmt.setString(3, loc); // 이렇게만 하면 타입에 따라 알아서 '' 처리 등을 해서 sql문에 넣음
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println(deptno+"번 부서 입력 성공");
			}else {
				System.out.println("입력 실패");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) { }				
		}
		
		
	}
}
