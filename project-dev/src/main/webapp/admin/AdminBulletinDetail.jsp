<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/BulletinDetail.css">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../Header.jsp"></jsp:include>
</header>
<section>
	<div id="info" align="center">
		<input type="hidden" name="contentNum" value="${bulletin.bulletinNum}">
		<h1>게시글 상세페이지</h1>
		<table>


			<tr>
				<th>게시글 제목</th>
				<td>${bulletin.bulletinTitle}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${bulletin.userId}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${bulletin.name}</td>
			</tr>
			<tr>
				<th>개시일자</th>
				<td colspan="3"><fmt:formatDate value="${bulletin.bulletinDate}" pattern="yyyy-MM-dd hh:mm"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${bulletin.bulletinContent}</pre></td>
			</tr>
		</table>


		<br>  
		<a href="OttServlet?command=admin_delete_bulletin&bulletinNum=${bulletin.bulletinNum}">삭제하기</a>
			<input type="button" value="게시글 리스트"
			onclick="location.href='OttServlet?command=admin_admin_content_detail&contentNum=${bulletin.contentNum}'">
	</div>
	</section>
	<footer>
	<jsp:include page="../Footer.jsp"></jsp:include>
</footer>
</body>
</html>