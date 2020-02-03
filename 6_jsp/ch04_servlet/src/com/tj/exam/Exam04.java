package com.tj.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam04")
public class Exam04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Exam04() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] su = request.getParameterValues("su"); // {2,3,4,5,6,7,8,9}
		
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='/ch04_servlet/css/Exam04.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		for(String s : su) {
			out.println("<td>"+s+"단</td>");
		}
		out.println("</tr>");
		for(int i=1; i<10; i++) {
			out.println("<tr>");
			for(String s : su){
				out.println("<td>");
				out.println(s+"*"+i+"="+Integer.parseInt(s)*i);
				out.println("</td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
