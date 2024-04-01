package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.dao.MemberDAO;

public class LoginCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String url = "project/Login.jsp";
		HttpSession session = request.getSession();
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		int result = mDao.userCheck(userId, pwd);
		
		
		//1: 로그인 성공 0: 비밀번호 불일치 -1: 아이디 불일치
		if(result == 1) {
			url = "project/MyPage.jsp";
			session.setAttribute("userid", userId);
		}
		else if(result == 0) {
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}else if(result == -1) {
			request.setAttribute("message", "아이디가 틀렸습니다.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
