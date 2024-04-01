package com.ott.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.BulletinDAO;
import com.ott.dao.CommentDAO;
import com.ott.dto.BulletinVO;
import com.ott.dto.CommentVO;

public class SelectBulletinContentViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		BulletinVO vo = new BulletinVO();
		
		
//		int bulletinNum = (int) request.getAttribute("bulletinNum");
		int bulletinNum =Integer.parseInt(request.getParameter("bulletinNum"));
		
		BulletinDAO bDao = BulletinDAO.getInstance();
		
		vo = bDao.selectOneBulletinByNum(bulletinNum);
		
		bDao.updateReadCount(bulletinNum);
		
		request.setAttribute("bulletinNum", vo.getBulletinNum());
		
	    request.setAttribute("bulletin", vo);
	    
	    System.out.println("jsp테스트 화면 테스트입니다.");
		CommentDAO cDao = CommentDAO.getInstance();
	   List<CommentVO>list = new ArrayList<CommentVO>();
	   
	   System.out.println("게시글번호출력테스트>>" + bulletinNum);
	   list = cDao.getAllComments(bulletinNum);
	   System.out.println("게시글번호출력테스트>>" + bulletinNum);
	   
	   request.setAttribute("comment", list);
	   System.out.println("jsp리스트 값>>" + list);
		
	    request.getRequestDispatcher("project/SelectBulletinView.jsp").forward(request, response);
		
//		String vo = new BulletinVO();
		
//		vo.setBulletinNum(0);
//		vo.setBulletinTitle(null);
//		vo.setName(null);
//		vo.setBulletinDate(null);
//		vo.setBulletinContent(null);
//		
//		
//		
		 
		 
		

	}

}
