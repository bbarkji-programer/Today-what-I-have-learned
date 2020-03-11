package com.jyp.shopping.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jyp.shopping.dao.ProductDao;
import com.jyp.shopping.dto.ProductDto;

public class ProductContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// pId 받아오기 (선택한 상품 정보)
		int pId = Integer.parseInt(request.getParameter("pId"));
		// pId로 상품 정보 불러오기
		ProductDao dao = ProductDao.getInstance();
		ProductDto dto = dao.productContent(pId); 
		request.setAttribute("dto", dto);
	}
}
