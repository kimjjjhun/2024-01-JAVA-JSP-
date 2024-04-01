package com.ott.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.QnAReplyDAO;
import com.ott.dao.QnaDAO;
import com.ott.dto.PagingVO;
import com.ott.dto.QnAReplyVO;
import com.ott.dto.QnAVO;

public class QnAListFormAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      int page = 1;
      int limit = 10;
      
      if(request.getParameter("page")!= null) {
         page = Integer.parseInt(request.getParameter("page"));
      }
      if(request.getParameter("limit")!= null) {
         limit = Integer.parseInt(request.getParameter("limit"));
      }
      
      List<QnAVO> list = QnaDAO.getInstance().getAllList(page, limit);
      
      int count = QnaDAO.getInstance().getQnaList();
      PagingVO vo = new PagingVO(page,limit,count);
      
      List<QnAReplyVO> rList = QnAReplyDAO.getInstance().getAllQnAReply();
      
      System.out.println(rList);
      
      request.setAttribute("qnaReply", rList);
      request.setAttribute("page", vo);
      request.setAttribute("qnaList", list);
      request.getRequestDispatcher("qna/QnAList.jsp").forward(request, response);
      
   }

}