package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.QnaDAO;

public class DeleteQnAAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
      
      QnaDAO.getInstance().deleteQna(qnaNum);
      
      response.sendRedirect("OttServlet?command=qna_list&page=1");
      
   }

}