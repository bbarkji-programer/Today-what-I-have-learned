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

		public static final int SUCCESS = 1;
		public static final int FAIL = 0;
		
		
		private static BoardDao instance = new BoardDao();
		private BoardDao() {} // 자기 자신에서 한 번 생성
		public static BoardDao getInstance() { // 외부에서는 getInstance로 호출(새로 생성X)
			return instance; // 외부에서 호출하면 instance 주소 값만 리턴
		}
		// connection 객체 가져오는 메소드
		private Connection getConnection() throws SQLException {
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
		// 글 개수 가져오기 : getBoardTotalCnt()
		public int getBoardTotalCnt() {
			int totCnt = 0;
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT COUNT(*) FROM BOARD";
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				rs.next(); // 한 줄을 가져온다.
				totCnt = rs.getInt(1);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}			
			return totCnt;
		}
		// 글 목록 출력 : listBoard(int startRow, int endRow)
		public ArrayList<BoardDto> listBoard(int startRow, int endRow){
			ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC) A)" + 
					"    WHERE RN BETWEEN ? AND ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				while(rs.next()) {
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
					Timestamp rdate = rs.getTimestamp("rdate");
					dtos.add(new BoardDto(num, writer, subject, content, email, hit, pw, ref, re_step, re_level, ip, rdate));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}			
			return dtos;
		}
		// 원글 쓰기 : insertBoard(BoardDto dto)
		public int insertBoard(BoardDto dto) {
			int result = FAIL;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP)\r\n" + 
					"    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), ?, ?, ?, ?, ?, (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, ?)";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getSubject());
				pstmt.setString(3, dto.getContent());
				pstmt.setString(4, dto.getEmail());
				pstmt.setString(5, dto.getPw());
				pstmt.setString(6, dto.getIp());
				result = pstmt.executeUpdate();
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
		// 답글 쓰기 stepA : replyStepA(int ref, int re_step)
		private void replyStepA(int ref, int re_step) { // 여기서만 쓰고(private), return할 필요 없으니 void
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE BOARD SET RE_STEP = RE_STEP+1 WHERE REF=? AND RE_STEP>?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate(); // 결과 값을 굳이 받을 필요가 없어 받지 않을 뿐...
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
		// 답글 쓰기 : reply(BoardDto dto)
		public int reply(BoardDto dto) {
			int result = FAIL;
			replyStepA(dto.getRef(), dto.getRe_step());
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql="INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP)" + 
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
				pstmt.setInt(7, dto.getRe_step()+1); // 답글이니까
				pstmt.setInt(8, dto.getRe_level()+1); // 답글이니까	
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "답변성공" : "답변실패");
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"답변실패"+dto.toString());
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
		// 글 번호로 dto 가져오기 : BoardDto getBoardOneLine(int num)
		public BoardDto getBoardOneLine(int num) { // BoardDto 타입의 결과(변수,객체)를 return 하는 메소드
			BoardDto dto = null;
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql="SELECT * FROM BOARD WHERE NUM="+num;
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) { // 일단 BoardDto 호출에 필요한 아래 값을 다 받아온다.
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
					Timestamp rdate = rs.getTimestamp("rdate");
					dto = new BoardDto(num, writer, subject, content, email, hit, pw, ref, re_step, re_level, ip, rdate);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			return dto;
		}
		// 글 번호로 dto 가져오기 : getBoardOneLine(String num)
		public BoardDto getBoardOneLine(String num) {
			BoardDto dto = null;
			getBoardOneLine(Integer.parseInt(num));
			return dto;
		}
		// 글 번호로 hit 수 하나 올리기 : hitUp(int num)
		public void hitUp(int num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE BOARD SET HIT = HIT+1 WHERE NUM=?";
		}
		// 글 번호로 hit 수 하나 올리기 : hitUp(String num)
		// 글 수정 : updateBoard(dto)
		// 글 삭제 : deleteBoard(int num, String pw)
		
}
