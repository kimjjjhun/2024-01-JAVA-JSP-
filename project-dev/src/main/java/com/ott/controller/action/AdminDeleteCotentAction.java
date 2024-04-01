package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.ContentDAO;

public class AdminDeleteCotentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		
		ContentDAO.getInstance().deleteContent(contentNum);
		
		response.sendRedirect("OttServlet?command=admin_content_info");
	}

}
