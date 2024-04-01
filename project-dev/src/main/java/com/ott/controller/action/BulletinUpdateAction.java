package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.BulletinDAO;
import com.ott.dto.BulletinVO;

public class BulletinUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println("테스트인걸요");
		int contentNum =Integer.parseInt(request.getParameter("contentNum"));
		int bulletinNum = Integer.parseInt(request.getParameter("bulletinNum"));
		System.out.println("콘텐트번홏테스트"+contentNum);
		
		BulletinVO bVo = new BulletinVO();
		
		bVo.setBulletinNum(bulletinNum);
		bVo.setBulletinTitle(request.getParameter("bulletinTitle"));
		bVo.setBulletinContent(request.getParameter("bulletinContent"));
		bVo.setContentNum(contentNum);
		
		System.out.println("bVo : " + bVo);
		
		BulletinDAO.getInstance().updateBulletin(bVo);
		
		response.sendRedirect("OttServlet?command=bulletin_view&contentNum="+ contentNum +"&bulletinNum=" + bulletinNum);
	}

}
