package com.tj.ex01selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe"; 
		String query = "SELECT*FROM EMP";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver); // 1단계.driver load
			conn = DriverManager.getConnection(url,"scott","tiger"); // 2단계. DB연결
			stmt = conn.createStatement(); // 3단계.SQL문을 전송할 객체
			rs = stmt.executeQuery(query); // 4단계.SQL문 전송, 5.SQL문 결과 받기(rs)
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
			System.out.println("----------------------------------------------------------------------------------");
			if(rs.next()) { // 6단계.결과를 받아 원하는 로직 수행 
				do {
					int EMPNO = rs.getInt("EMPNO");
					String ENAME = rs.getString("ENAME");
					String JOB = rs.getString("JOB");
					int MGR = rs.getInt("MGR");
					Date HIREDATE = rs.getDate("HIREDATE");
					int SAL = rs.getInt("SAL");
					int COMM = rs.getInt("COMM");
					int DEPTNO = rs.getInt("DEPTNO");
					if(JOB!=null && JOB.length()>=7) {
						System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n",
											EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO);
					}else {
						System.out.printf("%d\t %s\t %s\t\t %d\t %TF\t %d\t %d\t %d\n",
								EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO); //rs값 뿌리기			
					}
				}while(rs.next());
			}else {
				System.out.println("데이터가 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 7단계.연결해제
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) { }
		}
	}
}
