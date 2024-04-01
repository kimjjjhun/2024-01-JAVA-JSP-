package com.ott.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.ott.controller.action.Action;
import com.ott.controller.action.ActionFactory;
import com.ott.dao.ContentDAO;
import com.ott.dto.ContentVO;

@WebServlet("/OttServlet")
public class OttServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		if(action != null) {
			action.execute(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentType = request.getContentType();
		
		if(contentType != null && contentType.startsWith("multipart/form-data")) {
			ServletContext context = request.getSession().getServletContext();
			String path = context.getRealPath("images");
			String encType = "utf-8";
			int sizeLimit = 20*1024*1024;
			
			MultipartRequest multi = new MultipartRequest(
					request,path,sizeLimit,encType,new DefaultFileRenamePolicy()
			);
			
			String command = multi.getParameter("command");
			
			ContentVO vo = new ContentVO();
			
			vo.setContentName(multi.getParameter("contentName"));
			vo.setGenre(multi.getParameter("genre"));
			vo.setActor(multi.getParameter("actor"));
			vo.setYear(Integer.parseInt(multi.getParameter("year")));
			vo.setStory(multi.getParameter("story"));
			vo.setPoster("images/"+multi.getOriginalFileName("poster"));
			vo.setDirector(multi.getParameter("director"));

			
			if(command.equals("admin_insert_content")) {
				ContentDAO.getInstance().insertContent(vo);
				response.sendRedirect("OttServlet?command=admin_content_info");				
			}else if(command.equals("admin_update_content")) {
				vo.setContentNum(Integer.parseInt(multi.getParameter("contentNum")));
				
				if(multi.getOriginalFileName("poster")==null) {
					vo.setPoster("images/" + multi.getOriginalFileName("nomakeImg"));
				}else {
					vo.setPoster("images/"+multi.getOriginalFileName("poster"));					
				}
				
				ContentDAO.getInstance().updateContent(vo);
				response.sendRedirect("OttServlet?command=admin_content_info");								
			}
			
			
			return;
		}
		else {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			doGet(request, response);
		}
		
	}

}
