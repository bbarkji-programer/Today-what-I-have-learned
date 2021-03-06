package com.tj.ex02selectWhere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDname2 {
	public static void main(String[] args) {
		// 1. 사용자로부터 부서이름 받아,
		// 2-1. 해당 부서 이름이 있을 경우, 부서정보출력, 해당 부서 사원 (사번,이름,부서위치,입사일)
		// 2-2. 해당 부서 이름이 없을 경우 없다고 출력
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe"; 
		Scanner sc = new Scanner(System.in);
		System.out.println("검색을 원하는 부서명은?");
		String dname = sc.nextLine();
		String sql1 = "SELECT * FROM DEPT WHERE DNAME='"+dname.toUpperCase()+"'";
		String sql2 = "SELECT EMPNO, ENAME, LOC, HIREDATE FROM EMP E,DEPT D WHERE E.DEPTNO=D.DEPTNO AND DNAME='"+dname.toUpperCase()+"'";	
	    //sql2=String.format("SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND DNAME='%s'",dname.toUpperCase()); <- 이렇게 해도 됨.
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"scott","tiger");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql1);
			if(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname2 = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println("[부서정보] 부서번호 : "+deptno+" 부서이름 : "+dname2+" 부서위치 : "+loc);
				rs.close();
				rs=stmt.executeQuery(sql2);
				if(rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						Date hiredate = rs.getDate("hiredate");
						String loc1 = rs.getString("loc");
						System.out.println("[사원정보] 사번 : "+empno+" 이름 : "+ename+" 입사일 : "+hiredate+" 부서위치 : "+loc1);						
					}while(rs.next());
				}else {
					System.out.println(dname+"부서에 사원이 없습니다.");
				}
			}else {
				System.out.println(dname+"(이)란 이름의 부서는 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) { }
		}
	}
}


