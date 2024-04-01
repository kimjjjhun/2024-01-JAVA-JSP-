package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.BulletinDAO;
import com.ott.dto.BulletinVO;

public class BulletinInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		
		BulletinVO bVo = new BulletinVO();
		
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		
		bVo.setName(request.getParameter("name"));
		bVo.setUserId(request.getParameter("userId"));
		bVo.setBulletinTitle(request.getParameter("bulletinTitle"));
		bVo.setBulletinContent(request.getParameter("bulletinContent"));
		bVo.setContentNum(Integer.parseInt(request.getParameter("contentNum")));
		BulletinDAO.getInstance().insertBulletin(bVo);
		
		System.out.println("bVo : " + bVo);
		
		
		response.sendRedirect("OttServlet?command=admin_content_detail&contentNum="+contentNum);
	}

}
