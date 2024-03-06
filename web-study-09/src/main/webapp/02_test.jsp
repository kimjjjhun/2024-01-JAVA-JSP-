<%@page import="java.sql.Connection"%>
<%@page import="com.saeyan.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%
	MemberDAO memdao = MemberDAO.getInstance();
	
	Connection con = memdao.getConnection();
	
	out.println("DB연결 성공 : " + con);
%>