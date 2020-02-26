package com.tj.ex;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.member.MemberDao;
import com.tj.member.MemberDto;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		System.out.println("url = "+url);
		System.out.println("uri = "+uri);
		System.out.println("conPath = "+conPath);
		System.out.println("들어온 요청은 "+command);
		String viewPage = null;
		Service service = null;
		if(command.equals("/insert.do")) {
			System.out.println("insert command 호출함");
			//insert 로직
			request.setAttribute("result", "insert_command 호출함");
			viewPage = "01_front/ex02.jsp";
		}else if(command.equals("/select.do")) {
			System.out.println("select command 호출함");
			// select 로직
			request.setAttribute("result", "select_command 호출함");
			viewPage = "01_front/ex02.jsp";
		}else if(command.equals("/delete.do")) {
			System.out.println("delete command 호출함");
			//delete 로직
			request.setAttribute("result", "delete_command 호출함");
			viewPage = "01_front/ex02.jsp";
		}else if(command.equals("/update.do")) {
			System.out.println("update command 호출함");
			//delete 로직
			request.setAttribute("result", "update_command 호출함");
			viewPage = "01_front/ex02.jsp";
		}else if(command.equals("/listMember.do")) {		
			System.out.println("회원 목록 출력 호출함");
			// 로직수행
			service = new ListMemberService();
			service.execute(request, response);
			viewPage = "01_front/ex03_list.jsp";
		}else if(command.equals("/joinPro.do")) {
			System.out.println("회원가입 호출함");
			// 로직수행
			service = new JoinMemberService();
			service.execute(request, response);
			viewPage = "/01_front/ex04_joinResult.jsp";			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}	
}
