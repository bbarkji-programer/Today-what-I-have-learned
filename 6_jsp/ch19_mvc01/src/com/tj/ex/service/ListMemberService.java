package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.MemberDao;

public class ListMemberService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao mDao = MemberDao.getInstance();
		request.setAttribute("listMember", mDao.listMember() );
	}

}
