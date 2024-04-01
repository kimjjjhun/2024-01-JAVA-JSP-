package com.ott.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.MemberDAO;
import com.ott.dto.MemberVO;
import com.ott.dto.PagingVO;

public class AdminMemberInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		List<MemberVO> list = MemberDAO.getInstance().getAllMemberList(page, limit);
		
		int count = MemberDAO.getInstance().getMemberList();		
		PagingVO vo = new PagingVO(page, limit, count);
		
		request.setAttribute("page", vo);
		request.setAttribute("memberList", list);
		request.getRequestDispatcher("admin/AdminMemberInfo.jsp").forward(request, response);
	}

}
