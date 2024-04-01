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

public class SelectMyBulletinContentViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BulletinVO vo = new BulletinVO();
		
		
		int bulletinNum =Integer.parseInt(request.getParameter("bulletinNum"));
		
		BulletinDAO bDao = BulletinDAO.getInstance();
		
		vo =bDao.selectOneBulletinByNum(bulletinNum);
		
		bDao.updateReadCount(bulletinNum);
		
		request.setAttribute("bulletinNum", vo.getBulletinNum());
		
	    request.setAttribute("bulletin", vo);
	    
	    CommentDAO cDao = CommentDAO.getInstance();
	    
	    List<CommentVO>list = new ArrayList<CommentVO>();
	    
	    list = cDao.getAllComments(bulletinNum);
	    
	    request.setAttribute("comment", list);
		
	    request.getRequestDispatcher("project/SelectBulletinView.jsp").forward(request, response);
	}

}
