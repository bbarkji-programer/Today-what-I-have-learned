package com.tj.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam08")
public class Exam08 extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response); // get 방식 요청 들어오면, actionDo 실행
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // post 방식 요청 들어오면, parameter 값 인코딩 후
		actionDo(request, response); // actionDo 실행
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href=\"/ch04_servlet/css/Exam08.css\" rel=\"stylesheet\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><th colspan=\"2\">반갑습니다."+writer+"님</th></tr>");
		out.println("<tr><th>글제목</th><td>"+title+"</td></tr>");
		out.println("<tr><th>글내용</th><td><pre>"+content+"</pre></td></tr>");
		out.println("</table>");	
		out.println("</body>");
		out.println("</html>");
		
	}
}
