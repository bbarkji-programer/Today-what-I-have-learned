package com.tj.model1ex.dao;

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

import com.tj.model1ex.dto.BookDto;

public class BookDao {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 1;
	
	private static BookDao instance = new BookDao(); // 자기 클래스 타입(BookDao의 변수 instance
	
	private BookDao() { // 싱글톤(외부에서 new 연산자 사용하지 못하게 private)
		
	} 
	public static BookDao getInstance() { // 리턴타입이 BookDao 인 getInstance() 메소드로 외부에서 쓴다.
		return instance;
	}
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
	// 책 등록
	public int insertBook(BookDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOOK (BOOK_ID, BOOK_TITLE, BOOK_PRICE, BOOK_IMAGE1, BOOK_IMAGE2, BOOK_CONTENT, BOOK_DISCOUNT)" + 
				"    VALUES (BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBook_title());
			pstmt.setInt(2, dto.getBook_price());
			pstmt.setString(3, dto.getBook_image1());
			pstmt.setString(4, dto.getBook_image2());
			pstmt.setString(5, dto.getBook_content());
			pstmt.setInt(6, dto.getBook_discount());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "책 등록 성공" : "책 등록 실패");
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
	// 책 전체 목록(신착 도서 순)
	public ArrayList<BookDto> bookList(){ // 몇 개가 들어올지 모르니 Arraylist, 하나하나 타입은 bookDto. booklist는 메소드 이름
		ArrayList<BookDto> books = new ArrayList<BookDto>(); 
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM BOOK ORDER BY BOOK_RDATE DESC";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int book_id = rs.getInt("book_id");
				String book_title = rs.getString("book_title");
				int book_price = rs.getInt("book_price");
				String book_image1 = rs.getString("book_image1");
				String book_image2 = rs.getString("book_image2");
				String book_content = rs.getString("book_content");
				int book_discount = rs.getInt("book_discount");
				Date book_rdate = rs.getDate("book_rdate");
				books.add(new BookDto(book_id, book_title, book_price, book_image1, book_image2, book_content, book_discount, book_rdate));
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
		
		return books;
	}
	// 책 목록(Top-N) : 페이징(start row 부터 end row 까지)
	public ArrayList<BookDto> bookList(int startRow, int endRow){
		ArrayList<BookDto> books = new ArrayList<BookDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BOOK_RDATE DESC)A) " + 
				"    WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int book_id = rs.getInt("book_id");
				String book_title = rs.getString("book_title");
				int book_price = rs.getInt("book_price");
				String book_image1 = rs.getString("book_image1");
				String book_image2 = rs.getString("book_image2");
				String book_content = rs.getString("book_content");
				int book_discount = rs.getInt("book_discount");
				Date book_rdate = rs.getDate("book_rdate");
				books.add(new BookDto(book_id, book_title, book_price, book_image1, book_image2, book_content, book_discount, book_rdate));
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
		return books;		
	}
	// 등록된 책 개수
	public int getBookCnt() {
		int bookCnt = 0;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) bookCnt FROM BOOK";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				bookCnt = rs.getInt("bookCnt");			
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
		return bookCnt;
	}
	// book_id로 책 가져오기(책 상세보기)
	public BookDto getBook(int book_id) {
		BookDto book = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK WHERE BOOK_ID=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String book_title = rs.getString("book_title");
				int book_price = rs.getInt("book_price");
				String book_image1 = rs.getString("book_image1");
				String book_image2 = rs.getString("book_image2");
				String book_content = rs.getString("book_content");
				int book_discount = rs.getInt("book_discount");
				Date book_rdate = rs.getDate("book_rdate");
				book = new BookDto(book_id, book_title, book_price, book_image1, book_image2, book_content, book_discount, book_rdate);
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
		return book;
	}
}
