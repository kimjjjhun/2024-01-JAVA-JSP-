package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.dao.MemberDAO;
import com.ott.dto.MemberVO;

public class ChangeUserInformationFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		MemberVO vo =(MemberVO)session.getAttribute("member");
		
		
		String id = vo.getUserId();
		System.out.println("id>>" + id);
//		MemberVO mVo= MemberDAO.getInstance().getOneMember(id);
		
		System.out.println("vo>>" + vo);
		request.getRequestDispatcher("project/Information.jsp")
		.forward(request, response);

		
		

	}

}
