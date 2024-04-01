package com.ott.controller.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.MemberDAO;


public class MemberIdcheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userId = request.getParameter("userId");
		
		System.out.println("체크요>" + userId);
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.confirmID(userId);
		
		request.setAttribute("userId",userId);
		request.setAttribute("result",result);
		
		request.getRequestDispatcher("member/IdCheck.jsp").forward(request, response);
		
	}

}
