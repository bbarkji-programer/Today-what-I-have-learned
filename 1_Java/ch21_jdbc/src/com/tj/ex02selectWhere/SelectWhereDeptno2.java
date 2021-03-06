package com.tj.ex02selectWhere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDeptno2 {
	// 1. 사용자에게 부서 번호를 물어보고,
	// 2-1. 해당 부서 번호가 있으면, 해당 부서 이름, 해당 부서 위치 출력 후 해당 부서 사원을 출력
	// 2-2. 없는 부서 번호면, '없는 부서 번호'라고 출력.
	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe"; 
		Scanner sc = new Scanner(System.in);
		System.out.print("출력을 원하는 부서변호는?");
		int deptno = sc.nextInt();
		
		String query1="SELECT*FROM DEPT WHERE DEPTNO="+deptno;
		String query2="SELECT*FROM EMP WHERE DEPTNO="+deptno;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query1);
			if(rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println("부서명 : "+dname+"\t 부서위치 : "+loc);
				rs.close(); // 기존에 가져온 rs 닫기
				rs = stmt.executeQuery(query2); // 다시 받기
				if(rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						Date hiredate = rs.getDate("hiredate");
						System.out.println(empno+"\t"+ename+"\t"+hiredate);
					}while(rs.next());
				}else {
					System.out.println(deptno+"번 부서에 사원은 없습니다.");
				}
						
			}else {
				System.out.println(deptno+"번은 유효하지 않은 부서 번호 입니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
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
