<%@page import="com.ott.dto.CommentVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ott.dao.CommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.centerd {
	position: fixed;
	left: 50%;
}

.comment {
	width: 500px;
	height: 50px;
}
</style>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/Ott.css">
<script type="text/javascript" src="script/bulletin.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th>게시글 번호</th>
				<td>${bulletin.bulletinNum}</td>
				<th>작성자</th>
				<td>${bulletin.name}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${bulletin.bulletinDate}" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${bulletin.bulletinTitle }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${bulletin.bulletinContent }</pre></td>
			</tr>
		</table>
		<br>
		<br> <input type="button" value="게시글 리스트"
			onclick="location.href='OttServlet?command=admin_content_detail&contentNum=${bulletin.contentNum}'">
		<c:if test="${member.userId eq bulletin.userId}">
			<input type="button" value="게시글 수정"
				onclick="location.href='OttServlet?command=bulletin_update_form&bulletinNum=${bulletin.bulletinNum}'">
			<input type="button" value="게시글 삭제"
				onclick="return check1(${bulletinNum})">
		</c:if>
	</div>
	<br>
	<br>

	<div align="center">
		<form action="OttServlet" method="post" name="check">
			<input type="hidden" name="command" value="comment_Insert"> 
			<input type="hidden" name="bulletinNum" value="${bulletinNum }"> 
			<input type="text" name="commentContent" placeholder="댓글을 입력하세요" class="comment">
			<input type="submit" value="댓글 달기" onclick="return com_check()">
		</form>
	</div>
	<br><br>	
	<div align="center">
		<table>
			<c:forEach var="comment" items="${comment}">
				<tr>
					<td>${comment.userId }</td>
				</tr>
				<tr>
					<td>${comment.commentContent}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>