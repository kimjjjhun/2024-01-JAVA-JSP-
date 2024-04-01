package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.BulletinDAO;
import com.ott.dto.BulletinVO;

public class BulletinUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "bulletin/BulletinUpdate.jsp";
		System.out.println("테스트잉");
		String num = request.getParameter("bulletinNum");
				System.out.println(num);
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		System.out.println("dd"+contentNum);
		BulletinVO bVo = BulletinDAO.getInstance().
				selectOneBulletinByNum(Integer.parseInt(num));
		
		request.setAttribute("bulletin", bVo);
		request.setAttribute("contentNum", contentNum);
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
