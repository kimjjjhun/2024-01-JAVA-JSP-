package com.ott.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.dao.BulletinDAO;
import com.ott.dao.BulletinWishListDAO;
import com.ott.dao.CommentDAO;
import com.ott.dao.ContentDAO;
import com.ott.dto.BulletinVO;
import com.ott.dto.BulletinWishListVO;
import com.ott.dto.CommentVO;
import com.ott.dto.ContentVO;
import com.ott.dto.MemberVO;

public class BulletinViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO)session.getAttribute("member");
		
		String userId = vo.getUserId();
		
		int num = Integer.parseInt(request.getParameter("bulletinNum"));
		
		System.out.println("bulletinNum>" + num);
		
		System.out.println("userid>>"+ userId);
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		System.out.println("테스트임 제발" + contentNum);
		
		
		BulletinWishListVO wVo= BulletinWishListDAO.getInstace().getBulletinNums(num, userId);
				
		System.out.println("찍어>"+wVo);
		BulletinVO bVo = BulletinDAO.getInstance().selectOneBulletinByNum(num);
		
		BulletinDAO.getInstance().updateReadCount(num);
		System.out.println("bVO>>" + bVo);
		request.setAttribute("bulletin", bVo);
		
		
		String url = "project/SelectBulletinView.jsp";
		int bulletinNum = bVo.getBulletinNum();
		
		
		
		CommentDAO cDao = CommentDAO.getInstance();
   	  	List<CommentVO> list = new ArrayList<CommentVO>();
   	  	//int bulletinNum = (int) request.getAttribute("bulletinNum");
   	  	list = cDao.getAllComments(num);
   	  	
//   	  	ContentVO cVo = ContentDAO.getInstance().getOneContent(contentNum);
   	  	
   	  	request.setAttribute("bulletinNum", bulletinNum);
   	  	request.setAttribute("contentNum", contentNum);
   	  	request.setAttribute("content", vo);
   	  	request.setAttribute("comment", list);
   	  	request.setAttribute("bulletinWish", wVo);
		
   	  	request.getRequestDispatcher(url).forward(request, response);
	}

}
