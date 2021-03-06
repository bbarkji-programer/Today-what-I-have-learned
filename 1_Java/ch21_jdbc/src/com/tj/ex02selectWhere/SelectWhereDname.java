package com.tj.ex02selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDname {
	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe"; 
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 부서 이름은?");
		String dname = sc.nextLine(); // 부서이름에 스페이스 가능 sc.nextLine
        String sql="SELECT * FROM DEPT WHERE DNAME='"+dname+"'"; // VARCHAR 필드는 ' ' single quotation mark를 살려줘야한다. '' 안살리면, select*from dept where dname=dname 을 하는 꼴이라 invalid identifier 오류남.
		//sql=String.format("SELECT*FROM DEPT WHERE DNAME='%s'",dname);
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"scott","tiger");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println("입력하신 부서번호 : "+deptno);
				System.out.println("입력하신 부서이름 : "+dname);
				System.out.println("입력하신 부서위치 : "+loc);
			}else {
				System.out.println("유효하지 않은 부서이름입니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"드라이버오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"SQL오류");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) { }
		}
	}
}
