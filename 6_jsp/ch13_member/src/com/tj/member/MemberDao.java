package com.tj.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	// static final 변수 - 외부에서 따로 객체 생성 필요 없이 사용하기 위함. (대문자로)
	public static final int SUCCESS = 1; // 회원가입, 정보 수정 성공
	public static final int FAIL = 0; // 회원가입, 정보 수정 실패
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공
	public static final int LOGIN_FAIL_ID = -1; // 로그인 실패_id오류
	public static final int LOGIN_FAIL_PW = 0; // 로그인 실패_pw오류
	public static final int MEMBER_NONEXIST = 1; // 없는 id(사용가능한 id)
	public static final int MEMBER_EXIST = 0; // 있는 id(중복id)
	// 싱글톤 
	private static MemberDao instance = new MemberDao(); // 실행하자마자 memberDao 라는 변수가 생기고, instance가 그 주소를 가르킴. 
	public static MemberDao getInstance() {
		return instance; // 외부에서 getInstance 하면, instance(memberDao주소) 리턴
	}
	private MemberDao() {}
	// conn 객체 가져오는 함수
	private Connection getConnection() throws SQLException { // 밑에서 예외 처리
		Connection conn = null;
		try {
			Context ctx = new InitialContext(); // ctx 생성
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g"); // ds = ctx에서 찾아오기
			conn = ds.getConnection(); // conn에 연결
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 사용할 메소드 생성
	// 1. 회원 가입 시 아이디 유무 확인(중복체크) (매개변수 : id)
	public int confirmId(String id) {
		int result = MEMBER_EXIST; // 최악의 경우로 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		String sql = "SELECT * FROM MEMBER WHERE ID=?";		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 해당 아이디가 (이미) 있음(사용불가)
				result = MEMBER_EXIST;
			}else { // 해당 아이디는 없음(사용 가능)
				result = MEMBER_NONEXIST;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
	
	// 2. 회원 가입 시 INSERT (매개변수 : dto)
	public int insertMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (ID,PW,NAME,EMAIL,BIRTH,RDATE,ADDRESS) VALUES (?,?,?,?,?,SYSDATE,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setDate(5, dto.getBirth());
			pstmt.setString(6, dto.getAddress());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "회원가입 성공" : "회원가입 실패"+dto.toString());
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패"+dto.toString());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return result;
	}
	
	// 3. 로그인 할 때 (매개변수 : id/pw)
	public int loginChk(String id, String pw) {
		int result = LOGIN_FAIL_ID;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 유효한 id를 입력한 경우 
				String dbPw = rs.getString("pw"); // db의 pw 가져옴
				if(dbPw.equals(pw)) { // 비밀 번호를 제대로 입력
					result = LOGIN_SUCCESS;
				}else { // 틀린 비밀번호 입력
					result = LOGIN_FAIL_PW;
				}
			}else { // 유효하지 않은 id를 입력한 경우
				result = LOGIN_FAIL_ID;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return result;
	}
	
	// 4. ID로 DTO 가져오기 (매개변수 : id)
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) { // id가 있으면,
				dto = new MemberDto();
				dto.setId(id);
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setBirth(rs.getDate("birth"));
				dto.setRdate(rs.getTimestamp("rdate"));
				dto.setAddress(rs.getString("address"));	
			}else { // id 없으면
				// 아무 짓도 안함. 초기화 시킨 null 값이 그대로 return
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return dto;
	}
	
	// 5. 회원 정보 수정(UPDATE) (매개변수 : dto)
	public int updateMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET PW=?,NAME=?,EMAIL=?,BIRTH=?,ADDRESS=? WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setDate(4, dto.getBirth());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getId());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "회원정보 수정성공" : "회원정보 수정실패"+dto.toString());
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원정보 수정실패"+dto.toString());
		}finally {
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
