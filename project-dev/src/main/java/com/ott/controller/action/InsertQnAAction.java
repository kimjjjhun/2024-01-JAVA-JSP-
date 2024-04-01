package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.dao.QnaDAO;
import com.ott.dto.QnAVO;

public class InsertQnAAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		QnAVO vo = new QnAVO();
		
		vo.setQnaTitle(request.getParameter("qnaTitle"));
		vo.setUserId(request.getParameter("userId"));
		vo.setQnaCategory(request.getParameter("qnaCategory"));
		vo.setQnaContent(request.getParameter("qnaContent"));
		vo.setQnaPwd(request.getParameter("qnaPwd"));
		
		QnaDAO.getInstance().insertQnA(vo);
		
		response.sendRedirect("OttServlet?command=qna_list");
	}

}
