package com.tj.ex;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDao {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}		
		return conn;
	}
	
	public ArrayList<EmpDto> getListEmp(int startRow, int endRow){
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>(); // 최악의 경우 = 사이즈 0짜리
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT*FROM (SELECT ROWNUM RN, A.* FROM (SELECT*FROM EMP) A) WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				emps.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return emps;
	}
	// 전체 글 수 가져오기
	public int getEmpTotCnt() {
		int totCnt = 0;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="SELECT COUNT(*) TOTCNT FROM EMP";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				totCnt = rs.getInt("totCnt");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				
			}
			
		}
		return totCnt;
	}
	
	// 검색해서 찾기
	public ArrayList<EmpDto> getListEmp(String sth1, String sth2){
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>(); // 최악의 경우 = 사이즈 0짜리
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT*FROM EMP WHERE ENAME LIKE '%'||?||'%' AND JOB LIKE '%'||?||'%'";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sth1);
			pstmt.setString(2, sth2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				emps.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return emps;
	}
	// 페이징 용
	
}
