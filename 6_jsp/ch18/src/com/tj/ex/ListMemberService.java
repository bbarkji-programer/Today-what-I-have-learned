package com.tj.ex;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.member.MemberDao;

public class ListMemberService implements Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao mdao = MemberDao.getInstance();
		request.setAttribute("members", mdao.listMember());
		
	}

}
