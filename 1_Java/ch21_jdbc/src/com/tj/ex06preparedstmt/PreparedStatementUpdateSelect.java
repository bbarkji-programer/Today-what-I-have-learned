package com.tj.ex06preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementUpdateSelect {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// 사용자에게 부서 번호를 입력받아 부서 번호가 존재하면 수정작업(부서 이름, 부서 위치를 입력 받아서 수정)
		// 						  부서 번호가 존재하지 않으면 없다고 출력
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String updateSQL = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 부서 번호는?");
		int deptno = sc.nextInt();
				                                           
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setInt(1,deptno);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt==1) {
				System.out.println("수정할 부서 이름은?");
				String dname = sc.next();
				System.out.println("수정할 부서 위치는?");
				String loc = sc.next();
				rs.close(); // ★기존에 연 객체 먼저 닫고 
				pstmt.close(); // ★기존에 연 객체 먼저 닫고 
				pstmt = conn.prepareStatement(updateSQL); // 객체 새로 만든다.
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result>0? "수정성공" : "수정실패");
			
			}else {
				System.out.println("부서번호가 존재하지 않습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
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
