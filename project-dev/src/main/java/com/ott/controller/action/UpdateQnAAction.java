package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.QnaDAO;
import com.ott.dto.QnAVO;

public class UpdateQnAAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		QnAVO vo = new QnAVO();
		
		vo.setQnaNum(Integer.parseInt(request.getParameter("qnaNum")));
		vo.setUserId(request.getParameter("userId"));
		vo.setQnaTitle(request.getParameter("qnaTitle"));
		vo.setQnaPwd(request.getParameter("qnaPwd"));
		vo.setQnaCategory(request.getParameter("qnaCategory"));
		vo.setQnaContent(request.getParameter("qnaContent"));
		
		int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
		
		
		QnaDAO.getInstance().updateQna(vo);

		response.sendRedirect("OttServlet?command=qna_detail&qnaNum=" + qnaNum);
	}

}
