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
	// static final 변수. 외부에서 따로 객체 생성 없이 사용하기 위함.
	public static final int SUCCESS = 1;
	public static final int FAIL = 0; 
	
	// 나중에 BoardDao를 쓸 수 있도록 메소드 생성
	// (단, 공통 내용이므로 싱글톤으로 생성해 getInstance 로 쓰도록 한다.
	private static BoardDao instance = new BoardDao(); // instance를 static 으로 생성, 초기화 시 바로 할당(=최초 클래스 로드 시 생성되어 남아있음). instance는 BoardDao() 주소 가르킴
	private BoardDao() { } // private으로 선언된 생성자(단 하나의 인스턴스 생성을 보장)
	public static BoardDao getInstance() { // 나중에 이걸 쓰면
		return instance; // 싱글톤의 instance(BoardDao 주소)를 리턴
	}
	
	//connection 객체 가져오기
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
	// 사용할 메소드 생성
	// 현재 글 개수
	public int totCnt() {
		int totCnt = 0; // 최약의? 조건으로 초기화(=글이 하나도 없는 경우)
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM REVIEW_BOARD";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next(); // 값을 받아와서 
			totCnt = rs.getInt(1); // 첫 번째 열 값(num)을 가져와라
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
		return totCnt;
	}
	// 글 목록(최신이 위로)
	public ArrayList<BoardDto> list(){ // 글이 몇 개가 있는지 모르니 arraylist로 가져온다.
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
	// 글 쓰기
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
	// 글 번호로 글 DTO 가져오기(int num)
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
	// 글 번호로 글 가져오기(String num)
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
	// 특정 글 번호 조회 수 올리기(int num)
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
	// 특정 글 번호 조회 수 올리기(String num)
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
	// 글 수정하기
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
			System.out.println(result==SUCCESS ? "글 수정 성공" : "글 수정 실패");
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
	// 특정 글 삭제
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
			System.out.println(result==SUCCESS ? num+"번 글 삭제성공" : num+"번 글 삭제실패");			
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
