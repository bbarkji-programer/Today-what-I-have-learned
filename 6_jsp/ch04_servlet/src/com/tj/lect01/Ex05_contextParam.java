package com.tj.lect01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex05_contextParam
 */
@WebServlet("/Ex05_contextParam")
public class Ex05_contextParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextId = getServletContext().getInitParameter("contextId"); // web.xml 에서 <context-param>
		String contextPw = getServletContext().getInitParameter("contextPw"); 
		String id = getServletContext().getInitParameter("id"); // web.xml 에서 <init-param>으로 넣은 건 다른 java에서는 값을 못가져옴(그래서 여기서 null)
		System.out.println("contextId = "+contextId);
		System.out.println("contextPw = "+contextPw);
		System.out.println("id = "+id); 
	}
}
