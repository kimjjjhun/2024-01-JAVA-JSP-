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
import com.ott.dao.ContentWishListDAO;
import com.ott.dto.BulletinVO;
import com.ott.dto.ContentVO;
import com.ott.dto.MemberVO;

public class MemberMyPageFormAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
      HttpSession session = request.getSession();
      
      MemberVO vo = (MemberVO)session.getAttribute("member");
      
      String userId = vo.getUserId(); //아이디 값 가져왔어
      
      System.out.println("test>" + userId);
      ContentWishListDAO cWDao=ContentWishListDAO.getInstace(); 
      
      List<Integer>list = new ArrayList<Integer>();
      
      list = cWDao.getContentNums(userId); //아이디 값을 통해 찜한 콘텐츠번호 가져와서
      
      System.out.println("ContentNumlist>>" + list);
      
      List<ContentVO>Clist = new ArrayList<ContentVO>();
      
      Clist = cWDao.getContentWishList(list); // 가져온 콘텐츠 번호를 통해 찜한 콘텐츠 내용을 가져와서
      
      System.out.println("Clist>>" + Clist);
      
   BulletinWishListDAO bwDao= BulletinWishListDAO.getInstace();
      
      List<Integer>BulletinNumlist = new ArrayList<Integer>(); 
      
      BulletinNumlist = bwDao.getWishBulletinNums(userId); //아이디를 통해 자기가 찜한 게시글번호 가져오고
      
      System.out.println("list>>>" + BulletinNumlist);
      
      List<BulletinVO>voList = new ArrayList<BulletinVO>();
      voList = bwDao.getBulletinWishList(BulletinNumlist); //게시글 번호를 통해 게시글 값들 뽑아오고
      
      System.out.println("voList>>" + voList);
      
      List<BulletinVO>Mylist = new ArrayList<BulletinVO>();
      
      Mylist = BulletinDAO.getInstance().selectUserAllBulletin(userId);
      
      request.setAttribute("bulletin", Mylist);
      
      request.setAttribute("bulletinWish", voList); //게시글 정보 셋해주고
      
      
      request.setAttribute("contentWish", Clist); //콘텐츠 정보들 셋해주고
      
      request.setAttribute("userId", userId); 
      
      request.getRequestDispatcher("project/MyPage.jsp").forward(request, response);

   }

}