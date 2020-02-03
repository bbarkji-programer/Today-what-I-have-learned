package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HelloWorld", urlPatterns = { "/HW" })
public class Ex01_HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex01_HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }


    // get 방식으로 요청했을 때 하고싶은 것.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // 스트림 생성
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("h1{ color:green;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>안녕하세요. 첫 servlet 예제입니다.</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close(); // 스트림은 닫아주는 게 안전.
	}


	// post 방식으로 요청했을 때 하고싶은 것.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost를 먼저 호춣했는데 여기서 doGet을 또 호출하네?");
		doGet(request, response);
	}

}
