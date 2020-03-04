package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.ex.dto.MemberDto;

public class MemberDao {

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	public static final int EXIST = 0; // 사용 불가능
	public static final int NONEXIST = 1; // 사용가능
	
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	private MemberDao() {
		
	}
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
	// 아이디 중복체크(mID)
	public int mIdChk(String mId) {
		int result = EXIST;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT*FROM MVC_MEMBER WHERE mID=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = EXIST;
			}else {
				result = NONEXIST;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}		
		return result;
	}
	// 회원가입(mID, mPW, mNAME / mEMAIL, mPHOTO, mBIRTH, mADDRESS)
	public int join(MemberDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_MEMBER(mID, mPW, mNAME, mEMAIL, mPHOTO, mBIRTH, mADDRESS)" + 
				"    VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmId());
			pstmt.setString(2, dto.getmPw());
			pstmt.setString(3, dto.getmName());
			pstmt.setString(4, dto.getmEmail());
			pstmt.setString(5, dto.getmPhoto());
			pstmt.setDate(6, dto.getmBirth());
			pstmt.setString(7, dto.getmAddress());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입 성공":"회원가입 실패");			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패"+dto.toString());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}						
		return result;
	}	
	// 로그인(mID, mPW)
	public int login(String mId, String mPw) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT*FROM MVC_MEMBER WHERE mID=? AND mPW=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = SUCCESS;
			}else {
				result = FAIL;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}								
		return result;
	}
	// 로그인 후 세션에 정보를 넣기 위해 mID로 member dto 가져오기
	public MemberDto getMemberDto(String mId) {
		MemberDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT*FROM MVC_MEMBER WHERE mID=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mPw = rs.getString("mPw");
				String mName = rs.getString("mName");
				String mEmail = rs.getString("mEmail");
				String mPhoto = rs.getString("mPhoto");
				Date mBirth = rs.getDate("mBirth");
				String mAddress = rs.getString("mAddress");
				Date mRdate = rs.getDate("mRdate");
				dto = new MemberDto(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress, mRdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}						
		return dto;
	}
	// 회원 정보 수정(mID)
	public int modify(MemberDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_MEMBER" + 
				"    SET mPW = ?," + 
				"        mNAME = ?," + 
				"        mEMAIL = ?," + 
				"        mPHOTO = ?," + 
				"        mBIRTH = ?," + 
				"        mADDRESS = ?" + 
				"        WHERE mID= ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmPw());
			pstmt.setString(2, dto.getmName());
			pstmt.setString(3, dto.getmEmail());
			pstmt.setString(4, dto.getmPhoto());
			pstmt.setDate(5, dto.getmBirth());
			pstmt.setString(6, dto.getmAddress());
			pstmt.setString(7, dto.getmId());
			result = pstmt.executeUpdate();	
			System.out.println(result==SUCCESS? "정보수정 성공" : "정보수정 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("정보수정 실패"+dto.toString());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}								
		return result;
	}
	// 회원 목록(startRow, endRow)
	public ArrayList<MemberDto> list(int startRow, int endRow){
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT*FROM(SELECT ROWNUM RN, A.* FROM (SELECT*FROM MVC_MEMBER ORDER BY mRDATE DESC)A) WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String mId = rs.getString("mId");
				String mPw = rs.getString("mPw");
				String mName = rs.getString("mName");
				String mEmail = rs.getString("mEmail");
				String mPhoto = rs.getString("mPhoto");
				Date mBirth = rs.getDate("mBirth");
				String mAddress = rs.getString("mAddress");
				Date mRdate = rs.getDate("mRdate");
				dtos.add(new MemberDto(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress, mRdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}								
		return dtos;
	}
	// 가입한 전체 회원 수
	public int totCnt() {
		int totCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) TOTCNT FROM MVC_MEMBER";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totCnt = rs.getInt("TOTCNT");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}			
		return totCnt;
	}
}
