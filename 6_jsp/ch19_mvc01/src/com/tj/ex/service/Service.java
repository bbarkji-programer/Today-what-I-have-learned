package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	public void execute(HttpServletRequest request, HttpServletResponse response); // 추상메소드 (서비스 단에서 오버라이드 될 메소드)
}
