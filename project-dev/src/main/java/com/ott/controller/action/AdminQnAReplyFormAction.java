package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.QnAReplyDAO;
import com.ott.dto.QnAReplyVO;

public class AdminQnAReplyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
		
		QnAReplyVO vo = QnAReplyDAO.getInstance().getOneQnAReply(qnaNum);
		
		request.setAttribute("reply", vo);
		request.setAttribute("qnaNum", qnaNum);
		request.getRequestDispatcher("qna/AdminQnAReply.jsp").forward(request, response);
		
	}

}
