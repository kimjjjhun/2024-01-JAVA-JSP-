package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.QnAReplyDAO;
import com.ott.dao.QnaDAO;
import com.ott.dto.QnAReplyVO;
import com.ott.dto.QnAVO;

public class AdminQnAReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
		System.out.println(qnaNum);
		
		QnAReplyVO rVo = new QnAReplyVO();
		
		rVo.setReplyContent(request.getParameter("replyContent"));
		rVo.setQnaNum(qnaNum);
		System.out.println(rVo);
		
		QnAReplyDAO.getInstance().insertQnAReply(rVo);
		
		
		
		response.sendRedirect("OttServlet?command=qna_list");
	}

}
