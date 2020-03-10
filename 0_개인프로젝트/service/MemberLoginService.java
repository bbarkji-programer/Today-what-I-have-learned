package com.jyp.shopping.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jyp.shopping.dao.MemberDao;
import com.jyp.shopping.dto.MemberDto;

public class MemberLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		MemberDao dao = MemberDao.getInstance();		
		int result = dao.loginMember(mId, mPw);
		
		if(result==MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			MemberDto dto = dao.getMemberDto(mId);
			session.setAttribute("memberDto", dto);			
		}else {
			request.setAttribute("errorMsg", "아이디와 비밀번호를 확인하세요.");
		}
	}

}
