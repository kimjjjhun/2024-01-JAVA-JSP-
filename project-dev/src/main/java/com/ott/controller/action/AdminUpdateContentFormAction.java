package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.ContentDAO;
import com.ott.dto.ContentVO;
import com.ott.dto.PagingVO;

public class AdminUpdateContentFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page")!= null) {
			page = Integer.parseInt(request.getParameter("page"));			
		}
		if(request.getParameter("limit")!=null) {
			limit = Integer.parseInt(request.getParameter("limit"));			
		}
		
		
		ContentVO vo =  ContentDAO.getInstance().getOneContent(contentNum);
		
		int count = ContentDAO.getInstance().getContentList();
		PagingVO pVo = new PagingVO(page, limit, count);
		
		request.setAttribute("page", pVo);
		request.setAttribute("content", vo);
		request.getRequestDispatcher("admin/AdminUpdateContent.jsp").forward(request, response);
		
		
	}

}
