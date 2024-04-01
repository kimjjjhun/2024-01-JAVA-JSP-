package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.QnaDAO;
import com.ott.dto.PagingVO;
import com.ott.dto.QnAVO;

public class UpdateQnAFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
		int limit = 10;
		
		int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
		
		QnAVO vo = QnaDAO.getInstance().getOneQna(qnaNum);
		
		int count = QnaDAO.getInstance().getQnaList();
		
		PagingVO pVo = new PagingVO(page, limit, count);
		
		request.setAttribute("page", pVo);
		request.setAttribute("qna", vo);
		request.getRequestDispatcher("qna/UpdateQnA.jsp").forward(request, response);
		
		
		
		
	}

}
