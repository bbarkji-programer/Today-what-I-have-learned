package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.Date;
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

import com.tj.ex.dto.MemberDto;

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
	//1. 회원 리스트
	public ArrayList<MemberDto>listMember() {
		ArrayList<MemberDto> members = new ArrayList<MemberDto>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM MEMBER";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");
				Timestamp rdate = rs.getTimestamp("rdate");
				String address = rs.getString("address");
				members.add(new MemberDto(id, pw, name, email, birth, rdate, address));
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
		return members;
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
	
}
