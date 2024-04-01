package com.ott.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.dao.BulletinDAO;
import com.ott.dao.ContentDAO;
import com.ott.dao.ContentWishListDAO;
import com.ott.dto.BulletinVO;
import com.ott.dto.ContentVO;
import com.ott.dto.ContentWishListVO;
import com.ott.dto.MemberVO;
import com.ott.dto.PagingVO;

public class AdminContentDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO)session.getAttribute("member");
		System.out.println("테스트에오");
		int contentNum = Integer.parseInt(request.getParameter("contentNum"));
		
		
		System.out.println("contentNum>" + contentNum);
		int page = 1;
		int limit = 10;
		System.out.println("어딘데1;");
		ContentVO cVo =  ContentDAO.getInstance().getOneContent(contentNum);
		ContentWishListVO wVo = ContentWishListDAO.getInstace().getContentNums(contentNum,vo.getUserId());
		
		System.out.println("테스트WVO>>" + wVo);
		System.out.println("어딘데2;");
		// 페이지 번호를 클릭 하는 경우
		if(request.getParameter("page") != null && 
				request.getParameter("limit") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		System.out.println("어딘데3;");
		// 1. DAO 생성
		BulletinDAO bDao = BulletinDAO.getInstance();
		// 2. pageVO생성
		List<BulletinVO> list = bDao.getAllBulletin(page, limit);
		int listCount = bDao.getListCount(contentNum); // 전체 게시글 수
		PagingVO pagingVO = new PagingVO(page, limit, listCount);
		request.setAttribute("contentWish", wVo);
		request.setAttribute("page", pagingVO);
		request.setAttribute("bulletinList", list);
		request.setAttribute("content", cVo);
		System.out.println("어딘데;");
		request.getRequestDispatcher("admin/AdminContentDetail.jsp").forward(request, response);
	}

}
