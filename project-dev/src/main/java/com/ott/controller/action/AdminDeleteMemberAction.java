package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.MemberDAO;
import com.ott.dto.MemberVO;

public class AdminDeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		
		MemberDAO.getInstance().deleteMember(userId);
		
		response.sendRedirect("OttServlet?command=admin_member_info");
		
	}

}
