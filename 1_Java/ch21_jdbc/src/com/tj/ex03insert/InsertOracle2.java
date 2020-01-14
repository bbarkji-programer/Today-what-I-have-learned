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
		System.out.print("�Է��ϰ��� �ϴ� �μ���ȣ��?");
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
				// rs.next()�� false�� = �����Ͱ� �� �ٵ� ������ ->  if�� ����(�μ��̸�,��ġ insert)
				// wmr, SELECT * FROM DEPT WHERE DEPTNO="+deptno �� �����ߴ���.(DEPT���� DEPTNO�� ��ȸ�غ���) �����Ͱ� ������
				// ��, �ߺ��� ���� ������, �Ʒ� ����
				System.out.println("�Է��� �μ� �̸���?");
				String dname = scanner.next();
				System.out.println("�Է��� �μ� �̸���?");
				String loc = scanner.next();
				String insertSQL = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(insertSQL); // �μ��Է�. insert -> stmt.excuteUpdate (*select -> stmt.excuteQuery();
				System.out.println(result>0? "�μ��Է� ����":"�μ��Է½���");
				
			}else { // �ߺ��� �μ� ��ȣ�� �Է��� ���
				System.out.println("�ߺ��� �μ� ��ȣ�� �����մϴ�. �ٸ� �μ� ��ȣ�� �����ּ���.");
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
