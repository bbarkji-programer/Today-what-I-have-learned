package com.tj.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import com.tj.dto.MemberDto;

// 회원 리스트(select*from member)
// 회원가입
public class MemberDao2 {

	private DataSource dataSource;
	private static MemberDao2 instance; // MemberDao 객체를 가르키는 변수
	
	// 외부에서 MemberDao 객체 생성 시, 
	// MemberDao dao = new MemberDao() 해야하는데 생성자가 private이라 new를 못한다. 하려면,
	// MemberDao dao = MemberDao.getInstance(); 이렇게 해야한다.
	public static MemberDao2 getInstance() {
		if(instance==null) {
			instance = new MemberDao2();
		}
		return instance;
	}
	
	private MemberDao2() { // 딱 한 번만 한다. 
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<MemberDto> selectAll(){ // 회원 리스트
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		// 2~7단계 
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER";
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				dtos.add(new MemberDto(id,pw,name,phone1,phone2,phone3,gender));
			
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}	
		return dtos;
	}
	public int insertMember(MemberDto dto) {
		int result = 0;
		//2~7단계
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?)";
		try {
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.getPhone1());
		pstmt.setString(5, dto.getPhone2());
		pstmt.setString(6, dto.getPhone3());
		pstmt.setString(7, dto.getGender());
		result = pstmt.executeUpdate();
		System.out.println(result>0? dto.toString()+"회원가입성공" : dto.toString()+"회원가입실패");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(dto.toString()+"회원가입실패");
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				
			}finally {
				
			}
		}
		return result;
	}
}
