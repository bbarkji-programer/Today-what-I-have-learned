package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.BoardDao;

public class BListService implements Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// list.do -> list.do?pageNum=1
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = (startRow + PAGESIZE) - 1;
		
		BoardDao bDao = new BoardDao();
		request.setAttribute("list", bDao.list(startRow, endRow)); // 글 목록
		int totCnt = bDao.getBoardTotCnt(); // 전체개수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); // 전체 페이지 수
		int startPage = ((currentPage - 1)/BLOCKSIZE)*BLOCKSIZE+1;
		int endPage = (startPage+BLOCKSIZE)-1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCnt", pageCnt);
	}

}
