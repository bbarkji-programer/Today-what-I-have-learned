package com.tj.ex05delete;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOracle {
	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe"; 
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 부서번호는?");
		int deptno = sc.nextInt();
		String deleteSQL = String.format("DELETE FROM DEPT WHERE DEPTNO=%d",deptno);
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(deleteSQL);
			System.out.println(result>0? deptno+"번 부서 삭제 성공" : "삭제 실패");			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) { }		
		}		
	}
}
