package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.dao.CommentDAO;
import com.ott.dto.MemberVO;

public class CommentInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String commentContent =request.getParameter("commentContent");
		int bulletinNum = Integer.parseInt(request.getParameter("bulletinNum"));
		System.out.println("여기까진되냐?");
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		System.out.println("이게안뽑혀?>" + contentNum);
		MemberVO vo =(MemberVO)session.getAttribute("member");
		System.out.println("여기는?");
		String userId = vo.getUserId();
		System.out.println("진짜여기는?");
		System.out.println("댓글내용"+commentContent);
		System.out.println("게시글번호"+bulletinNum);
		System.out.println("유저아이디"+userId);
		
		
		
		CommentDAO.getInstance().insertComment(bulletinNum, commentContent, userId);
		
		response.sendRedirect("OttServlet?command=bulletin_view&bulletinNum="+ bulletinNum+"&contentNum="+contentNum);
	
		

	}

}
