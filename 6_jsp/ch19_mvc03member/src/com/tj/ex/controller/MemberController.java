package com.tj.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.JoinService;
import com.tj.ex.service.LoginService;
import com.tj.ex.service.LogoutService;
import com.tj.ex.service.Service;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		
		if(command.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		}else if(command.equals("/login.do")) {
			// service.execute(request, response) - LoginService.java - mId, dPw로 로그인 여부에 따라 세션
			service = new LoginService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/joinView.do")) {
			viewPage = "member/join.jsp";
		}else if(command.equals("/join.do")) {
			// service.execute(request, response) - JoinService.java - mId 중복체크 후 회원가입
			service = new JoinService();
			service.execute(request, response);
			viewPage = "member/login.jsp";
		}else if(command.equals("/modifyView.do")) {
			// 구냥 세션에 있는 걸로 뿌리고 db는 갈 필요 없당.
			viewPage = "member/modify.jsp";
		}else if(command.equals("/modify.do")) {
			// service.execute(request, response) - ModifyService.java - db에 수정, 세션도 수정
			viewPage = "member/main.jsp";
		}else if(command.equals("/list.do")) {
			// service.execute(request, response) - ListService.java - startRow, endRow 목록 가져오기
			viewPage = "member/list.jsp";
		}else if(command.equals("/logout.do")) {
			// service.execute(request, response) - LogoutService.java - 세션 데이터 지우기(db 연동은 안한다.)
			service = new LogoutService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
