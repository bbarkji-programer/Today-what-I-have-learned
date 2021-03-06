package com.tj.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		Scanner sc = new Scanner(System.in);
		String fn = "";
		ArrayList<StudentDTO> students = new ArrayList<StudentDTO>(); // 데이터베이스에 있는 걸 arraylist에 넣어서 출력.
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt =null;
		ResultSet rs = null;
		String sName,mName,nameNo;
		int score,rank;
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		do {
			System.out.print("1:학생입력(이름,학과명,점수), 2:학과 별 출력(학과명), 3:다 출력, 그 외:종료");			
			fn = sc.next();
			switch(fn) {
			case "1" : //학생입력(이름,학과명,점수)
				String sql="INSERT INTO STUDENT (sNO,sNAME,mNO,SCORE) VALUES" + 
						"    (TO_CHAR(SYSDATE,'YYYY')" +
						"    ||(SELECT mNO FROM MAJOR WHERE mNAME=?)" +
						"	 ||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL,'000'))," + 
						"    ?,(SELECT mNO FROM MAJOR WHERE mNAME=?),?)";
				System.out.print("입력할 학생 이름?");
				sName = sc.next();
				System.out.print("학과명?");
				mName = sc.next();
				System.out.print("점수?");
				score = sc.nextInt();
				try {
					conn = DriverManager.getConnection(url,"scott","tiger");	
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mName);
					pstmt.setString(2, sName);
					pstmt.setString(3, mName);
					pstmt.setInt(4, score);
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? sName+"입력성공":"입력실패");					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();						
					} catch (Exception e2) {}					
				}
				break;
			case "2" : //학과별 출력(학과명 입력받아 학생 출력)
				sql="SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE" + 
						"    FROM (SELECT*FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND mNAME=?" + 
						"    ORDER BY SCORE DESC)"; // 위에서 변수 선언 했으니까 따로 선언할 필요없이 그냥 씀
				System.out.print("출력할 학과 이름?");
				mName = sc.next(); //위에서 변수 선언 했으니까 따로 선언할 필요 없이 그냥 씀
				try {
					conn = DriverManager.getConnection(url,"scott","tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,mName);
					rs = pstmt.executeQuery(); // select문이니까 select한 결과값을 rs(resultSet으로 받을 예정. 일단 물음. query
					students.clear(); // ArrayList<StudentDTO>에 있는 값(students)을 지움 size=0
					while(rs.next()) { // rs.next() 이걸 해야 resultSet 값을 받아오는 것.
						rank = rs.getInt("rank");
						nameNo = rs.getString("name_no"); // select문의 alias 
						mName = rs.getString("mName"); // 위에 이미 선언한 객체는 그냥 바로 갖다 써도 됨.
						score = rs.getInt("score");	
						students.add(new StudentDTO(rank,nameNo,mName,score)); // rs.netx() 해서 변수에 받고, arrayList에 add. toString 메소드는 여기서 열고															
					}
					if(!students.isEmpty()) { // 데이터가 있는 경우. if(students.size()!=0 이렇게 해도 됨.
						System.out.println("등수\t이름(nameNo)\t학과\t점수");
						System.out.println("---------------------------------------");
						for(StudentDTO s : students) { // for 확장구문. s는 임시변수.
							System.out.println(s); //toString 뿌리는 건 여기서
						}
					}else { // 데이터가 없는 경우
						System.out.println("해당 학과 학생이 없습니다.");
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();						
					} catch (Exception e2) {}					
				}
				break;
			case "3" : //다 출력(제적 당하지 않은 학생 다)
				sql="SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE" + 
						"    FROM (SELECT*FROM STUDENT S, MAJOR M WHERE S.mNO=M.mNO AND sEXPEL=0 ORDER BY SCORE DESC)";
				try {
					conn = DriverManager.getConnection(url,"scott","tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					students.clear();
					while(rs.next()) {
						rank = rs.getInt("rank");
						nameNo = rs.getString("name_no");
						mName = rs.getString("mName");
						score = rs.getInt("score");
						students.add(new StudentDTO(rank,nameNo,mName,score));
					}
					if(students.size()!=0) {
						System.out.println("등수\t이름(nameNo)\t학과\t점수");
						System.out.println("---------------------------------------");
						for(StudentDTO s : students) {
							System.out.println(s);
						}
					}else {
						System.out.println("학생이 없습니다.");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();						
					} catch (Exception e2) {}					
				}			
				break;
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
		System.out.println("안녕~");

	}
}
