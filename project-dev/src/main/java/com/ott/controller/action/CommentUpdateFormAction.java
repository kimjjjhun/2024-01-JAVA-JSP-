package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.CommentDAO;
import com.ott.dto.CommentVO;

public class CommentUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 int commentNum =Integer.parseInt(request.getParameter("commentNum"));
		 
		 CommentDAO cDao =CommentDAO.getInstance();
		 
		 CommentVO vo = cDao.getOneComments(commentNum);
		 System.out.println("testVo>>" + vo);
		 request.setAttribute("comment", vo);
		 
		 request.getRequestDispatcher("project/CommentUpdateForm.jsp").forward(request, response);
		 
	}

}
