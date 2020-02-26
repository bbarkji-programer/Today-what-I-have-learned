package com.tj.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.InsertMemberService;
import com.tj.ex.service.ListMemberService;
import com.tj.ex.service.Service;


@WebServlet("*.do")
public class MfrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request,response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // "/ch19_mvc01/list.do"
		String conPath = request.getContextPath(); // "/ch19_mvc01"
		String command = uri.substring(conPath.length()); // "/list.do"
		String viewPage = null;
		Service service = null;
		
		if(command.equals("/listMember.do")){ // 회원리스트
			// service의 execute 호출 (ListMemberService.java)
			service = new ListMemberService();
			service.execute(request, response);
			viewPage = "member/listMember.jsp";
		}else if(command.equals("/insertMemberView.do")) { // 이건 그냥 View. db연결없음. service 필요 없음.
			viewPage = "member/insertMember.jsp";
		}else if(command.contentEquals("/insertMember.do")) {
			// service의 execute 호출 (InsertMemberService.java)
			service = new InsertMemberService();
			service.execute(request, response);
			viewPage = "listMember.do"; // 여기로 가야 db 연결해 데이터를 받아서 리스트를 뿌릴 수 있다.
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
