package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex02")
public class Ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex02() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // 스트림 객체 생성
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>1부터 "+num+"까지 누적 합은 "+sum);
		out.print("</body>");
		out.print("</html>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
