package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.ex.dao.MemberDao;

public class LoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		MemberDao dao = MemberDao.getInstance();
		int result = dao.login(mId, mPw);
		if(result==MemberDao.SUCCESS) { // 로그인 성공
			HttpSession session = request.getSession(); // 세션에 로그인한 아이디의 dto를 넣어두기 위해 세션을 연다.
			session.setAttribute("member", dao.getMemberDto(mId));
		}else { // 로그인 실패
			request.setAttribute("errorMsg", "아이디와 비밀번호를 확인하세요.");
		}

	}

}
