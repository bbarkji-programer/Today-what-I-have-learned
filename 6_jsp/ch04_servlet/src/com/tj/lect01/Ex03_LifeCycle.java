package com.tj.lect01;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex03_LifeCycle")
public class Ex03_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@PostConstruct
	private void postConstruct() {
		System.out.println("Ex03_LifeCycle 객체 생성 되자마자 바로 실행 - 1");
	}
	
    public void init(ServletConfig config) throws ServletException {
    	// 객체가 만들어질 때 최초에 한 번 수행
    	System.out.println("Ex01_LifeCycle 서블릿 객체가 생성될 때 수행 - 2");
    }
    
    //public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// client의 요청이 들어올 때 수행. -> service가 있으면 doGet, doPost를 수행하지 않는다. 
    //	response.getWriter().append("<h1>service() 수행</h1>");
    //}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// client의 요청이 get 방식으로 들어올 때 수행
		response.getWriter().append("<h1>doGet() 수행</h1>");
		System.out.println("doGet() 실행");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// client의 요청이 post 방식으로 들어올 때 수행
		doGet(request, response);
	}

	public void destroy() {
		// 객체가 메모리에서 해제(끝낼 때)
		System.out.println("Ex03_LifeCycle 서블릿 종료- 1");
	}
	@PreDestroy
	private void preDestroy() { // 매개 변수에 뭘 넣으면서 소멸할 때 쓰면 됨..
		System.out.println("Ex03_LifeCycle형 객체 소멸되기 바로 전에 수행 -2");
	}
}
