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

import oracle.net.aso.d;

public class BoardDao {
	
	public static final int SUCCESS = 1; // 성공
	public static final int FAIL = 0; // 실패

	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() { 

	}
	// connection 객체 가져오는 메소드
	private Connection getConnection() throws SQLException {
		Connection conn = null; // 리턴타입 변수
		
		Context context;
		try {
			context = new InitialContext();
			DataSource datasource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g"); // object 형으로 리턴되기 때문에 datasource 형으로 형변환
			conn = datasource.getConnection(); // conn 객체는 datasource로부터
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		
		return conn; // 변수 리턴
	}	
	//[사용할 메소드 생성]
	// 글 개수 가져오기 : getBoardTotalCnt()
	public int getBoardTotalCnt() {
		int totCnt = 0; // 글이 아무것도 없는 경우(최악의조건)로 초기화
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM BOARD";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next(); // 일단 값을 받아와서 
			totCnt = rs.getInt(1); // 첫번째 열 값(int num)을가져와라
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return totCnt;
	}
	// 글 목록 출력 : listBoard()	
	public ArrayList<BoardDto> listBoard() {// 글이 몇 개 있는지 모르니 ArrayList로 가져오며, 변수 하나 하나의 타입은 BoardDto
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>(); // dtos 변수 선언
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;  // db연결 변수 선언
		String sql = "SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP"; 
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // db 연결 완료.
			while(rs.next()) { // db에서 아래 값들을 가져오기
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int hit = rs.getInt("hit");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_level = rs.getInt("re_level");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate"); // 값을 한 줄로 다 가져와서
				dtos.add(new BoardDto(num, writer, subject, content, email, hit, pw, ref, re_step, re_level, ip, rdate));// add한다.
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return dtos;
	}
	// starRow 부터 endRow 까지 list
	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {// 글이 몇 개 있는지 모르니 ArrayList로 가져오며, 변수 하나 하나의 타입은 BoardDto
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>(); // dtos 변수 선언
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;  // db연결 변수 선언
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A) WHERE RN BETWEEN ? AND ?"; 
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,startRow );
			pstmt.setInt(2,endRow );
			rs = pstmt.executeQuery(); // db 연결 완료.
			while(rs.next()) { // db에서 아래 값들을 가져오기
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int hit = rs.getInt("hit");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_level = rs.getInt("re_level");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate"); // 값을 한 줄로 다 가져와서
				dtos.add(new BoardDto(num, writer, subject, content, email, hit, pw, ref, re_step, re_level, ip, rdate));// add한다.
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
		return dtos;
	}	
	// 원글 쓰기 : insertBoard(dto)
	public int insertBoard(BoardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP)" + 
				"    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), ?, ?, ?, ?, ?, (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, ?)"; // re_step=0, re_level=0 (원글이니께)		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getIp());
			result = pstmt.executeUpdate(); // sql문을 쏘고, 나온 결과값 = result에 넣기
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return result;
	}
	// 글 번호로 글 dto 가져오기 : getBoardOneLine(int num)
	public BoardDto getBoardOneLine(int num) {
		BoardDto dto = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;  // db연결 변수 선언
		String sql = "SELECT * FROM BOARD WHERE NUM="+num; 
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // db 연결 완료.
			while(rs.next()) { // db에서 아래 값들을 가져오기
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int hit = rs.getInt("hit");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_level = rs.getInt("re_level");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate"); // 값을 한 줄로 다 가져와서
				dto = new BoardDto(num, writer, subject, content, email, hit, pw, ref, re_step, re_level, ip, rdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		
		return dto;
	}
	// 글 번호로 글 dto 가져오기 : getBoardOneLine(String num) --> String으로 가져오기
	public BoardDto getBoardOneLine(String num) {
		BoardDto dto = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;  // db연결 변수 선언
		String sql = "SELECT * FROM BOARD WHERE NUM="+num; 
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // db 연결 완료.
			while(rs.next()) { // db에서 아래 값들을 가져오기
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int hit = rs.getInt("hit");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_level = rs.getInt("re_level");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate"); // 값을 한 줄로 다 가져와서
				dto = new BoardDto(Integer.parseInt(num), writer, subject, content, email, hit, pw, ref, re_step, re_level, ip, rdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		
		return dto;
	}
	// hit 수 하나 올리기 : hitUp(int num) 
	public void hitUp(int num) { // return 값이 필요 없으니까 void
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET HIT = HIT+1 WHERE NUM=?"; 		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
	}
	// hit 수 하나 올리기 : hitUp(String num)  -> String으로 가져오면, Integer.parseInt 안해도 된다.
	public void hitUp(String num) {
		hitUp(Integer.parseInt(num));
	}
	// 글 수정 : updateBoard(dto)
	public int updateBoard(BoardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET WRITER = ?, SUBJECT = ?, CONTENT = ?, EMAIL = ?, PW=?, IP = ? WHERE NUM=?"; 		
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
			result = pstmt.executeUpdate(); // sql문을 쏘고, 나온 결과값 = result에 넣기
			System.out.println(result==SUCCESS? "글수정성공" : "글수정실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}				
		return result;
	}
	// 글 삭제 : deleteBoard(num,pw)
	public int deleteBoard(int num,String pw) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOARD WHERE NUM=? AND PW=?"; 		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);
			result = pstmt.executeUpdate(); // sql문을 쏘고, 나온 결과값 = result에 넣기
			System.out.println(result==SUCCESS? num+"번 글 삭제 성공" : num+"번 글 삭제 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}				
		return result;	
	}
	// step(a) : UPDATE BOARD SET RE_STEP = RE_STEP+1 WHERE REF=300 AND RE_STEP>0
	private void preReplyStepA(int ref, int re_step) { // 아래 답변글 저장에서 호출하기 위한 용도라 private으로 생성
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET RE_STEP = RE_STEP+1 WHERE REF=? AND RE_STEP>?"; 		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_step);
			pstmt.executeUpdate(); // sql문을 쏘고, 나온 결과값 = result에 넣기
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}	
	}	
	// 답변 글 저장
	public int reply(BoardDto dto) {
		// dto 호출 값 : NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP 
		// 원글 : ref, re_step, re_level
		// 사용자로부터 입력받을 답변 글 내용 : write, subject, content, email, pw
		// 시스템으로부터 가져옴 : ip
		int result = FAIL;
		preReplyStepA(dto.getRef(), dto.getRe_step()); // step(a) 먼저 하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP)" + 
				"    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setInt(6, dto.getRef());
			pstmt.setInt(7, dto.getRe_step()+1);
			pstmt.setInt(8, dto.getRe_level()+1);
			pstmt.setString(9, dto.getIp());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "답변성공" : "답변실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"답변실패"+dto.toString());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());			
			}
		}
		return result;
	}
}


