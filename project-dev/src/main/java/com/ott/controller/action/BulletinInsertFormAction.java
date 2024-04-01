package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.ContentDAO;
import com.ott.dto.ContentVO;

public class BulletinInsertFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		
		ContentVO vo = ContentDAO.getInstance().getOneContent(contentNum);
		
		System.out.println(contentNum);
		System.out.println(vo);
		request.setAttribute("content", vo);
		request.setAttribute("contentNum", contentNum);
		request.getRequestDispatcher("bulletin/BulletinWrite.jsp").forward(request, response);
		
		
		
	}

}
