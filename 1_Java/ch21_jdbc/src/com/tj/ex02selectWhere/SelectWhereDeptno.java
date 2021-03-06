package com.tj.ex02selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDeptno {
	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe"; 
		Scanner sc = new Scanner(System.in);
		System.out.print("출력을 원하는 부서변호는?");
		int deptno = sc.nextInt();
		String query="SELECT*FROM EMP WHERE DEPTNO="+deptno;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) { // 1행 이상 결과 출력
				// if 절 안에서 바로 while문을 쓰면, rs.next()를 두 번하게 되서 첫 번째 행은 무조건 안나오니까, do while 해야한다.
				do {
					// rs받아서 출력 (사번,이름,부서번호)
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					int deptnum = rs.getInt("deptno");
					System.out.println(empno+"\t"+ename+"\t"+deptnum);
				}while(rs.next());
				
			}else { // 결과가 0행
				System.out.println("해당 부서번호의 사원은 없습니다.");
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
