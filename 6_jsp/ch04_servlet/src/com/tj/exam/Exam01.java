package com.tj.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam01")
public class Exam01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Exam01() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일 hh시 mm분");
		String dateStr = sdf.format(date);
		response.setContentType("text/html;charset=utf-8"); //브라우저 출력 값이 한글일 경우
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href=\"css/ex01.css\" rel=\"stylesheet\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>현재는 "+dateStr+"입니다.</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //파라미터값이 한글일 경우
		doGet(request,response);
	}

}
