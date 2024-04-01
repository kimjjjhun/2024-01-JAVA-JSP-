package com.ott.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.dao.ContentWishListDAO;
import com.ott.dto.ContentVO;

public class ContentWishListFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("왜 안찍혀 ;");
		
		HttpSession session = request.getSession();
		
		String userid =(String)session.getAttribute("userid");
		
		System.out.println("콘텐트위시리스트 아이디 >>" +userid);
		
		ContentWishListDAO cWDao=ContentWishListDAO.getInstace();
		
		
		List<Integer>list = new ArrayList<Integer>();
		
		list = cWDao.getContentNums(userid);
		
		System.out.println("ContentNumlist>>" + list);
		
		List<ContentVO>Clist = new ArrayList<ContentVO>();
		
		Clist = cWDao.getContentWishList(list);
		
		System.out.println("Clist>>" + Clist);
		
		request.setAttribute("contentWish", Clist);
		
		
		request.getRequestDispatcher("project/ContentWishListView.jsp").forward(request, response);

	}

}
