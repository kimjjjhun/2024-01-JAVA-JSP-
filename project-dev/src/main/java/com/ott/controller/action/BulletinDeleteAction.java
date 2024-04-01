package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.BulletinDAO;

public class BulletinDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("bulletinNum"));
		
	 	int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		
		BulletinDAO.getInstance().deleteBulletin(num);
		
		response.sendRedirect("OttServlet?command=admin_content_detail&contentNum="+ contentNum);
	}

}
