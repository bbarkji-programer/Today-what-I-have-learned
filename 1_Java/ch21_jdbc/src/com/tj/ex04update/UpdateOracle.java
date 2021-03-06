package com.tj.ex04update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateOracle {
	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe"; 
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 부서 번호는?");
		int deptno = sc.nextInt();
		String selectSQL="SELECT COUNT(*) C FROM DEPT WHERE DEPTNO="+deptno; // 입력한 부서번호가 있는지 count (있으면 1, 없으면0)
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			rs.next(); // 실행 값 한 줄을 무조건 가져와야 하니까 if 문 안에 넣을 필요 없음 (실행값이 0이냐 1이냐를 보는 것)
			int cnt = rs.getInt("C"); // rs 첫 번 째 열의 값을 가져와라(필드명이 count(*)로 특수문자가 있는데, 특수문자를 getInt(count(*)) 이런식으로 쓰진 않음. 그래서 열 순서로.. 또는 ALIAS
			if(cnt==1) { // 부서번호가 존재하는 경우
				System.out.print("수정하고자 하는 부서이름은?");
				String dname = sc.next();
				System.out.println("수정하고자 하는 부서위치는?");
				String loc = sc.next();
				String updateSQL =String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d", dname, loc, deptno);
				int result = stmt.executeUpdate(updateSQL);
				System.out.println(result>0? deptno+"번 부서 수정 성공" : "수정 실패");
			}else { // 부서번호가 없음(cnt==0)
				System.out.println("존재하지 않은 부서번호입니다. 수정이 불가능합니다.");
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) { }
		}
		
	}
}
