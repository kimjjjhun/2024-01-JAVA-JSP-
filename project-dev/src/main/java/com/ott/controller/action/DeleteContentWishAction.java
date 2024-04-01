package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.ContentWishListDAO;

public class DeleteContentWishAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		String userId = request.getParameter("userId");
		
		System.out.println(userId);
		ContentWishListDAO.getInstace().deleteContentWish(contentNum, userId);
		
		response.sendRedirect("OttServlet?command=admin_content_detail&contentNum="+contentNum);
		
	}

}
