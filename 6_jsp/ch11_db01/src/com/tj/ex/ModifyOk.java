package com.tj.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	private Connection conn;
	private PreparedStatement pstmt;
	private HttpSession session; // java에서 세션 만들기 위해
	
	private String dbPw, id, name, oldPw, newPw, phone1, phone2, phone3, gender; // param
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request,response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		dbPw = request.getParameter("dbPw");
		id = request.getParameter("id");
		oldPw = request.getParameter("oldPw");
		newPw = request.getParameter("newPw");
		name = request.getParameter("name");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		String sql ="UPDATE MEMBER SET NAME=?,PW=?,PHONE1=?, PHONE2=?, PHONE3=?, GENDER=?" + 
				"    WHERE ID=?";
		
		if(dbPw.equals(oldPw)) { // 회원정보 수정 진행
			if(newPw.equals("")) {
				newPw = oldPw;
			}			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, name);
				pstmt.setString(2,  newPw);
				pstmt.setString(3, phone1);
				pstmt.setString(4, phone2);
				pstmt.setString(5, phone3);
				pstmt.setString(6, gender);
				pstmt.setString(7, id);
				
				int result = pstmt.executeUpdate();
				
				if(result>0) { // 회원정보 수정 성공
					System.out.println("회원 정보 수정 성공");
					session = request.getSession(); // db에 수정한 내용을 session에도 set
					session.setAttribute("name", name);
					session.setAttribute("pw", newPw);
					session.setAttribute("phone1", phone1);
					session.setAttribute("phone2", phone2);
					session.setAttribute("phone3", phone3);
					session.setAttribute("gender", gender);
					session.setAttribute("validmember", "ok");
					response.sendRedirect("lect02_member/modifyResult.jsp?result=success");
				}else { // db에 회원정보 수정 실패
					response.sendRedirect("lect02_member/modifyResult.jsp?result=fail");
				}
				
			}catch(Exception e) {
				System.out.print(e.getMessage());
				response.sendRedirect("lect02_member/modifyResult.jsp?result=fail");
				// db에 회원정보 수정 실패
			}finally {
				if(pstmt!=null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}else {
			response.sendRedirect("lect02_member/modify.jsp?result=");
		}
	}
}
