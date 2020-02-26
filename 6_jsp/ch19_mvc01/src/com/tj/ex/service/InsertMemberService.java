package com.tj.ex.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.MemberDao;
import com.tj.ex.dto.MemberDto;

public class InsertMemberService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tempBirth = request.getParameter("tempBirth");
		Date birth = null;
		if(tempBirth!=null) {
			birth = Date.valueOf(tempBirth);
		}
		String address = request.getParameter("address");
		MemberDto member = new MemberDto(id, pw, name, email, birth, null, address);
		MemberDao mDao = MemberDao.getInstance();
		request.setAttribute("insertMember", mDao.insertMember(member));
	}

}
