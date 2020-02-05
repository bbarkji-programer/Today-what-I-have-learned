package com.tj.lect01;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener // annotation은  class 이름과 붙여서 써야함
public class Ex06_Listener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 웹 프로젝트가 메모리에 구동되는 시점에 실행 
		System.out.println("★ch04 context가 시작될 때");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 웹 프로젝트가 메모리에서 해제되는 시점에 실행
		System.out.println("★ch04 context가 종료될 때");
	}
}
