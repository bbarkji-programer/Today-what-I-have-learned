package com.tj.lect01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex02")
public class Ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getParameterValues -> 같은 이름의 파라미터를 복수로 전달 받았을 때(select, checkBox) 
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		String nation = request.getParameter("nation");
		
		response.setContentType("text/html; charset=UTF-8"); // 화면(브라우저)에 한글(또는 외국어)을 뿌릴거면 무조건 해줘야 함.
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>h2{color:red;}</style>");
		out.println("</head>");
		out.println("<body>");
			// menu에 null 값이 올 수 도 있으니까, 
			if(menu != null) {
				out.println("<h2>선택한 메뉴는");
				for(String m : menu) {
					out.println(m+" ");
				}
				out.println("입니다.</h2>");
			}else {
				out.println("<h2>선택한 메뉴가 없습니다.</h2>");
			}
			// rest에 null 값이 올 수 도 있으니까, 
			if(rest != null) {
				out.println("<h2>선택한 식당(지역)은"+Arrays.toString(rest)+"입니다.</h2>");				
			}else {
				out.println("<h2>선택한 식당(지역)이 없습니다.</h2>");
			}
			out.println("<h2>선택한 국적은 "+nation+"입니다.</h2>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // parameter값(=name값)에 한글을 전달 할 경우에만 해주면 됨.
		doGet(request, response);
	}

}
