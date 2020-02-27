package com.tj.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.*;

@WebServlet("*.do")
public class BController extends HttpServlet {
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
		
		if(command.contentEquals("/list.do")) { // 글 목록
			// service.execute()호출 - BListService.java
			service = new BListService();
			service.execute(request, response);
			viewPage = "board/list.jsp";
		}else if(command.contentEquals("/write_view.do")) { // 글 쓰기 페이지
			viewPage = "board/write_view.jsp";
		}else if(command.contentEquals("/write.do")) { // 글 저장
			// service.execute()호출 - BWriteService.java
			service = new BWriteService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.contentEquals("/content_view.do")) { // 상세보기 페이지
			// service.execute()호출 - BContentService.java -> dto를 가져오고 + 조회수 올림
			service = new BcontentService();
			service.execute(request, response);
			viewPage = "board/content_view.jsp";
		}else if(command.contentEquals("/modify_view.do")) { // 글 수정 페이지
			// service의 execute()호출 - BModifyViewService.java
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage = "board/modify_view.jsp";
		}else if(command.contentEquals("/modify.do")) { // 글 수정 저장
			// service의 execute()호출 - BModifyService.java
			service = new BModifyService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.contentEquals("/delete.do")){
			// service의 execute()호출 - BdeleteService.java
			service = new BdeleteService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.contentEquals("/reply_view.do")) { // 답글 쓰기 페이지
			// service의 execute()호출 - BReplyViewService.java
			service = new BReplyViewService();
			service.execute(request, response);
			viewPage = "board/reply_view.jsp";
		}else if(command.contentEquals("/reply.do")) {
			// service의 execute()호출 - BreplyService.java
			service = new BReplyService();
			service.execute(request, response);
			viewPage = "list.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
