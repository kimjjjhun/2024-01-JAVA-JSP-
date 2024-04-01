package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.BulletinWishListDAO;

public class DeleteBulletinWishAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bulletinNum = Integer.parseInt(request.getParameter("bulletinNum"));
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));

		String userId = request.getParameter("userId");
		
		BulletinWishListDAO.getInstace().deleteBulletinWish(bulletinNum, userId);
		
		response.sendRedirect("OttServlet?command=bulletin_view&bulletinNum="+ bulletinNum + "&contentNum=" + contentNum);

	}

}
