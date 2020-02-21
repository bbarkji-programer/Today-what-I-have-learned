package com.tj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.dto.BoardDto;

public class BoardDao {
	// static final ����. �ܺο��� ���� ��ü ���� ���� ����ϱ� ����.
	public static final int SUCCESS = 1;
	public static final int FAIL = 0; 
	
	// ���߿� BoardDao�� �� �� �ֵ��� �޼ҵ� ����
	// (��, ���� �����̹Ƿ� �̱������� ������ getInstance �� ������ �Ѵ�.
	private static BoardDao instance = new BoardDao(); // instance�� static ���� ����, �ʱ�ȭ �� �ٷ� �Ҵ�(=���� Ŭ���� �ε� �� �����Ǿ� ��������). instance�� BoardDao() �ּ� ����Ŵ
	private BoardDao() { } // private���� ����� ������(�� �ϳ��� �ν��Ͻ� ������ ����)
	public static BoardDao getInstance() { // ���߿� �̰� ����
		return instance; // �̱����� instance(BoardDao �ּ�)�� ����
	}
	
	//connection ��ü ��������
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		Context context;
		try {
			context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = datasource.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}				
		return conn;
	}
	// ����� �޼ҵ� ����
	// ���� �� ����
	public int totCnt() {
		int totCnt = 0; // �־���? �������� �ʱ�ȭ(=���� �ϳ��� ���� ���)
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM REVIEW_BOARD";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next(); // ���� �޾ƿͼ� 
			totCnt = rs.getInt(1); // ù ��° �� ��(num)�� �����Ͷ�
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
		return totCnt;
	}
	// �� ���(�ֽ��� ����)
	public ArrayList<BoardDto> list(){ // ���� �� ���� �ִ��� �𸣴� arraylist�� �����´�.
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM REVIEW_BOARD ORDER BY ROW_GROUP DESC";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String email = rs.getString("email");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				String pw = rs.getString("pw");
				String ip = rs.getString("ip");
				Timestamp write_date = rs.getTimestamp("write_date");
				int row_group = rs.getInt("row_group");
				int row_step = rs.getInt("row_step");
				int row_level = rs.getInt("row_level");
				dtos.add(new BoardDto(num, writer, email, subject, content, hit, pw, ip, write_date, row_group, row_step, row_level));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return dtos;
	}
	// �� ����
	public int insert(BoardDto dto) {
		int result = FAIL; 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO REVIEW_BOARD (NUM, WRITER, EMAIL, SUBJECT, CONTENT, HIT, PW, IP, WRITE_DATE, ROW_GROUP, ROW_STEP, ROW_LEVEL)" +
			    "VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM REVIEW_BOARD), ?, ?, ?, ?, 0, ?, ?, SYSDATE,(SELECT NVL(MAX(NUM),0)+1 FROM REVIEW_BOARD),0,0)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getWriter());
			pstmt.setString(2,dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5,dto.getPw());
			pstmt.setString(6, dto.getIp());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				
			}
		}
		return result;
	}
	// �� ��ȣ�� �� DTO ��������(int num)
	public BoardDto getOneLine (int num) {
		BoardDto dto = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM REVIEW_BOARD WHERE NUM="+num;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String writer = rs.getString("writer");
				String email = rs.getString("email");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				String pw = rs.getString("pw");
				String ip = rs.getString("ip");
				Timestamp write_date = rs.getTimestamp("write_date");
				int row_group = rs.getInt("row_group");
				int row_step = rs.getInt("row_step");
				int row_level = rs.getInt("row_level");
			}
		} catch (SQLException e) {	
			System.out.println(e.getMessage());
		}		
		return dto;
		
	}
	// �� ��ȣ�� �� ��������(String num)
	public BoardDto getOneLine (String num) {
		BoardDto dto = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM REVIEW_BOARD WHERE NUM="+num;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String writer = rs.getString("writer");
				String email = rs.getString("email");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				String pw = rs.getString("pw");
				String ip = rs.getString("ip");
				Timestamp write_date = rs.getTimestamp("write_date");
				int row_group = rs.getInt("row_group");
				int row_step = rs.getInt("row_step");
				int row_level = rs.getInt("row_level");
			}
		} catch (SQLException e) {	
			System.out.println(e.getMessage());
		}		
		return dto;
	}
	// Ư�� �� ��ȣ ��ȸ �� �ø���(int num)
	public void hitUp(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE REVIEW_BOARD SET HIT = HIT+1 WHERE NUM=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				
			}
		}		
	}
	// Ư�� �� ��ȣ ��ȸ �� �ø���(String num)
	public void hitUp(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE REVIEW_BOARD SET HIT = HIT+1 WHERE NUM=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				
			}
		}		
	}
	// �� �����ϱ�
	public int update(BoardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE REVIEW_BOARD SET WRITER = ?, SUBJECT=?, CONTENT=?, EMAIL=?, PW=?, IP=? WHERE NUM=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getIp());
			pstmt.setInt(7, dto.getNum());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "�� ���� ����" : "�� ���� ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return result;
	}	
	// Ư�� �� ����
	public int delete(int num, String pw) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM REVIEW_BOARD WHERE NUM=? AND PW=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			pstmt.setString(2,pw);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? num+"�� �� ��������" : num+"�� �� ��������");			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return result;
	}
}
