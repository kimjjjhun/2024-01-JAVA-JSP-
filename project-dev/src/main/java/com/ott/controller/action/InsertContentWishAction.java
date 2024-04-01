package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.ContentWishListDAO;
import com.ott.dto.ContentWishListVO;

public class InsertContentWishAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		String userId = request.getParameter("userId");
		
		ContentWishListDAO.getInstace().insertContentWish(contentNum, userId);
		
		
		
		response.sendRedirect("OttServlet?command=admin_content_detail&contentNum="+contentNum);
	}

}
