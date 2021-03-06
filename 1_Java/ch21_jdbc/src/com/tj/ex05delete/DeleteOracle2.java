package com.tj.ex05delete;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOracle2 {
	public static void main(String[] args) {
		// 1. 삭제할 부서번호 입력받기
		// 2-1. 존재하는 부서번호일 경우 : 1) 진짜 삭제할지 물어보고, 2) Y 입력 시 -> 해당 부서번호 삭제, N 입력 시 -> 삭제안함. 프로그램 끝.
		// 2-2. 존재하지 안는 부서일 경우 : "존재하지 않는 부서번호 입니다." 출력
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe"; 
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 부서번호는?");
		int deptno = sc.nextInt();
		String selectSQL = "SELECT COUNT(*) FROM DEPT WHERE DEPTNO="+deptno;
		String deleteSQL = String.format("DELETE FROM DEPT WHERE DEPTNO=%d",deptno);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt = rs.getInt(1);
			if(cnt==1) {
				System.out.print(deptno+"번 부서를 진짜 삭제하시겠습니까?");
				String answer = sc.next();
				if(answer.equalsIgnoreCase("y")) {				
					int result = stmt.executeUpdate(deleteSQL);
					System.out.println(result>0? deptno+"번 부서 삭제 성공" : "삭제 실패");					
				}else if(answer.equalsIgnoreCase("n")) {
					System.out.print("프로그램을 종료합니다.");
				}else {
					System.out.println("유효하지 않은 입력값입니다.");
				}
			}else {
				System.out.println("존재하지 않는 부서번호입니다. 삭제가 불가능합니다.");
			}
						
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
