package com.tj.ex03insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOracle2 {
	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe"; 
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력하고자 하는 부서번호는?");
		int deptno=scanner.nextInt();				
		String selectSQL="SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"scott","tiger");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(selectSQL);
			if(!rs.next()) { 
				// rs.next()가 false면 = 데이터가 한 줄도 없으면 ->  if문 실행(부서이름,위치 insert)
				// wmr, SELECT * FROM DEPT WHERE DEPTNO="+deptno 를 실행했더니.(DEPT에서 DEPTNO를 조회해보니) 데이터가 없으면
				// 즉, 중복된 값이 없으면, 아래 실행
				System.out.println("입력할 부서 이름은?");
				String dname = scanner.next();
				System.out.println("입력할 부서 이름은?");
				String loc = scanner.next();
				String insertSQL = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(insertSQL); // 부서입력. insert -> stmt.excuteUpdate (*select -> stmt.excuteQuery();
				System.out.println(result>0? "부서입력 성공":"부서입력실패");
				
			}else { // 중복된 부서 번호를 입력한 경우
				System.out.println("중복된 부서 번호가 존재합니다. 다른 부서 번호를 적어주세요.");
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
