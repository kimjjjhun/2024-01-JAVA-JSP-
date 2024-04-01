package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class PosterActionTest extends HttpServlet implements Action{
	private static final long serialVersionUID = 1L;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		ServletContext context = getServletContext();
		
		String path = context.getRealPath("upload");
		
		System.out.println("realPath : " + path);
		
		String encType = "utf-8";
		
	   int sizeLimit = 20*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(request, path,sizeLimit, encType, new DefaultFileRenamePolicy());
		
	}

}
