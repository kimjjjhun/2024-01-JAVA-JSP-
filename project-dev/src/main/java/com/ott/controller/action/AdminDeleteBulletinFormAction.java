package com.ott.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.BulletinDAO;
import com.ott.dto.BulletinVO;
import com.ott.dto.PagingVO;

public class AdminDeleteBulletinFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page")!= null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("limit")!=null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		List<BulletinVO> list = BulletinDAO.getInstance().getAllBulletin(page,limit);
		
		int count = BulletinDAO.getInstance().getListCount();
		PagingVO vo = new PagingVO(page, limit, count);
		
		request.setAttribute("Bpage", vo);
		request.setAttribute("bulletinList", list);
		
		request.getRequestDispatcher("admin/AdminDeleteBulletin.jsp").forward(request, response);
		
	}

}
