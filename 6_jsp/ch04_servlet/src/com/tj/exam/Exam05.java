package com.tj.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Exam05")
public class Exam05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] colorSet = {"red","orange","yellow","green","blue","navy","violet"};
		int backColor = Integer.parseInt(request.getParameter("color")); // 0
		int fontColor = (backColor==0)? 6 : backColor-1; // 6
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
						
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<style>");
		out.println("*{ background-color:"+colorSet[backColor]+"}"); // colorSet[0] = red
		out.println("h2{ color:"+colorSet[fontColor]+"}"); // colorSet[6] = violet
		out.println("</style>");
		out.println("<body>");
		out.println("<h2>배경색은 "+colorSet[backColor]+"색 입니다.</h2>"); // colorSet[0] = red
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
