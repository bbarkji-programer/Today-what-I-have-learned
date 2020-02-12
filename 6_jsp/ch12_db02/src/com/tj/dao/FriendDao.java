package com.tj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dto.FriendDto;

public class FriendDao {

	private DataSource dataSource;	
	private static FriendDao instance = new FriendDao();	
	public static FriendDao getInstance() {
		return instance;
	}
	
	private FriendDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<FriendDto> selectAll(){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND";
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				dtos.add(new FriendDto(no,name,phone));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) rs.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return dtos;
	}
	public int insertFriend(FriendDto dto) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO FRIEND VALUES (FRIEND_SEQ.NEXTVAL, ?, ?)";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			result = pstmt.executeUpdate();
			System.out.println(result>0? dto.toString()+"친구등록 성공" : dto.toString()+"회원가입 실패" );
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(dto.toString()+"회원가입실패");
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				
			}
		}
		
		return result;
	}
	public ArrayList<FriendDto> selectNamePhone(String name, String phone){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND WHERE NAME LIKE '%'||?||'%' AND PHONE LIKE '%'||?||'%'";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FriendDto dto = new FriendDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				
			}
		}				
		return dtos;
	}
}

