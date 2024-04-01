package com.ott.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.ContentDAO;
import com.ott.dto.ContentVO;
import com.ott.dto.PagingVO;

public class AdminContentInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page")!= null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("limit")!= null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		List<ContentVO> list = ContentDAO.getInstance().getAllContentList(page,limit);		
		
		int listCount = ContentDAO.getInstance().getContentList();
		PagingVO vo = new PagingVO(page, limit, listCount);
		
		request.setAttribute("page", vo);
		request.setAttribute("contentList", list);
		request.getRequestDispatcher("admin/AdminContentInfo.jsp").forward(request, response);
		
	}

}
