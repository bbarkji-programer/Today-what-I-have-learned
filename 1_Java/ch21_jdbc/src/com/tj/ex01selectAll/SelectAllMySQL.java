package com.tj.ex01selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		String query = "SELECT*FROM PERSONAL"; // ctrl+shift+x
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver); // driver
			conn = DriverManager.getConnection(url,"root","mysql"); // DB연결
			stmt = conn.createStatement(); // SQL전송 
			rs = stmt.executeQuery(query); // SQL전송/결과받기
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
			System.out.println("-----------------------------------------------------------------------------");
			
			while(rs.next()) { // 원하는 로직 수행
				int pno = rs.getInt("pno");
				String pname = rs.getString("pname");
				String job = rs.getString("job");
				int manager = rs.getInt("manager");
				Date startdate = rs.getDate("startdate");
				int pay = rs.getInt("pay");
				int bonus = rs.getInt("bonus");
				int dno = rs.getInt("dno");
				if(job!=null && job.length()>=8) {
				System.out.println(pno+"\t"+pname+"\t"+job+"\t"+manager+"\t"+startdate+"\t"+pay+"\t"+bonus+"\t"+dno);
			}else {
				System.out.println(pno+"\t"+pname+"\t"+job+"\t\t"+manager+"\t"+startdate+"\t"+pay+"\t"+bonus+"\t"+dno);
			}
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
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}

