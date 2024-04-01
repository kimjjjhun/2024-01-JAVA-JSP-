package com.ott.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.dao.BulletinDAO;
import com.ott.dto.BulletinVO;

public class BulletinListViewFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("userid");
	
		System.out.println("userid!!>>" + userid);
		List<BulletinVO>list = new ArrayList<BulletinVO>();
		
		list = BulletinDAO.getInstance().selectUserAllBulletin(userid);
		
		request.setAttribute("bulletin", list);
		
		
		
		request.getRequestDispatcher("project/BulletinMyList.jsp").forward(request, response);
	}

}
