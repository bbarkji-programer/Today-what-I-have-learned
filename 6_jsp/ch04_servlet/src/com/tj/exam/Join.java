package com.tj.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hidden = request.getParameter("hiddenParam");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String star ="";
		for(int i=1; i<pw.length(); i++) {
			star += "*";
		}
		String birth = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby"); // {1,2,3,4,5}
		String gender = request.getParameter("gender"); // w or m
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");// {1,2,3}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='/ch04_servlet/css/join.css' rel='stylesheet'>");
		out.println("<body>");
		out.println("<div id='join_title'>회원가입정보</div><hr>");
		out.println("<p>hiddenParam : "+hidden+"</p>");
		out.println("<p>이름 : "+name+"</p>");
		out.println("<p>아이디 : "+id+"</p>");
		out.println("<p>비밀번호: "+star+"</p>");
		out.println("<p>생년월일: "+birth+"</p>");
		out.println("<p>취미 : ");
		for(int i=0; i<hobby.length; i++) {
			if(i!=hobby.length-1) {
				out.print(hobby[i]+", ");			
			}else {
				out.print(hobby[i]);
			}
		}
		out.println("</p><p>성별 : "+gender+"</p>");
		out.println("<p>이메일 : "+email+"</p>");
		out.println("<p>메일수신동의 : ");
		if(mailSend!=null) {
			for(int i=0; i<mailSend.length; i++) {
				if(i!=mailSend.length-1) {
					out.print(mailSend[i]+", ");					
				}else {
					out.print(mailSend[i]);
				}
			}
		}else {
			out.print("모두 거부");
		}
		out.println("</p></body>");
		out.println("</head>");
		out.println("</html>");
		
		
	}
}
