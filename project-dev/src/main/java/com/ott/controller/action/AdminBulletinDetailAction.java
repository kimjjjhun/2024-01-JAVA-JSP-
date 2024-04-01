package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.BulletinDAO;
import com.ott.dto.BulletinVO;

public class AdminBulletinDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bulletinNum = Integer.parseInt(request.getParameter("bulletinNum"));
		
		BulletinVO vo = BulletinDAO.getInstance().selectOneBulletinByNum(bulletinNum);
		
		request.setAttribute("bulletin", vo);
		request.getRequestDispatcher("admin/AdminBulletinDetail.jsp").forward(request, response);
	}

}
