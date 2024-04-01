package com.ott.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.ContentDAO;
import com.ott.dto.ContentVO;
import com.ott.dto.PagingVO;

public class ContentListFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page =1;
		int limit = 35;
		
		if(request.getParameter("page")!= null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("limit")!= null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		List<ContentVO> list = ContentDAO.getInstance().getAllContentList(page, limit);
		
		int count = ContentDAO.getInstance().getContentList();
		
		PagingVO vo = new PagingVO(page, limit, count);
		
		request.setAttribute("page", vo);
		request.setAttribute("contentList", list);
		request.getRequestDispatcher("content/ContentList.jsp").forward(request, response);
		
	}

}
