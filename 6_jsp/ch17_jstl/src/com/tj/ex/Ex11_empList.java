package com.tj.ex;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex11_empList")
public class Ex11_empList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		actionDo(request,response);
	}


	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpDao dao = new EmpDao();
		
		/*
		 * // 페이징 처리 해볼까? String pageNum = request.getParameter("pageNum");
		 * if(pageNum==null) pageNum = "1"; int currentPage = Integer.parseInt(pageNum);
		 * final int PAGESIZE = 3, BLOCKSIZE = 3; int startRow =
		 * (currentPage-1)*PAGESIZE+1; int endRow = startRow+PAGESIZE-1; int totCnt =
		 * dao.getEmpTotCnt();
		 */
		
	
		String sth1 = request.getParameter("sth1");
		String sth2 = request.getParameter("sth2");
		sth1 = sth1!=null? sth1.toUpperCase() : null ; // 바로 uppercase를 쓰면 null point Exception 발생할 수 있음.
		sth2 = sth2!=null? sth2.toUpperCase() : null ;
		
		
		
		ArrayList<EmpDto> emps = dao.getListEmp(sth1, sth2);		
		request.setAttribute("emps",emps);
		RequestDispatcher dispatcher = request.getRequestDispatcher("core/ex11_empList.jsp");
		dispatcher.forward(request, response);

	}	
}
