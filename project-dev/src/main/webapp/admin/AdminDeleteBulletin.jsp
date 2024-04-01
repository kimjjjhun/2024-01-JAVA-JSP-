<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/DeleteBulletin.css">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../Header.jsp"></jsp:include>
</header>
<section>
<h1>게시글 삭제</h1>
	<table>
		<tr>
			<th>게시글 번호</th>
			<th>게시글 제목</th>
			<th>이름</th>
			<th>아이디</th>
			<th>개시일자</th>
		</tr>
		<c:forEach items="${bulletinList}" var="bulletin">
			<tr>
				<td>${bulletin.bulletinNum}</td>
				<td><a
					href="OttServlet?command=admin_bulletin_detail&bulletinNum=${bulletin.bulletinNum}">${bulletin.bulletinTitle}</a></td>
				<td>${bulletin.name}</td>
				<td>${bulletin.userId}</td>
				<td>${bulletin.bulletinDate}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
			<div id="page">
					<c:if test="${Bpage.prev}">
						<a href="OttServlet?command=admin_delete_bulletin_form&page${Bpage.startPage-1}&limit=${Bpage.limit}">이전</a>
					</c:if>
					<c:forEach begin="${Bpage.startPage}" end="${Bpage.endPage}" var="nowPage">
					<c:if test="${Bpage.page == nowPage}">
						<a href="OttServlet?command=admin_delete_bulletin_form&page=${nowPage}&limit=${Bpage.limit}" style="color:yellowgreen">${nowPage}</a>
					</c:if>
					<c:if test="${Bpage.page != nowPage}">
						<a href="OttServlet?command=admin_delete_bulletin_form&page=${nowPage}&limit=${Bpage.limit}" >${nowPage}</a>
					</c:if>
				</c:forEach>
					<c:if test="${Bpage.next}">
						<a href="OttServlet?command=admin_delete_bulletin_form&page${Bpage.endPage +1}&limit=${Bpage.limit}">이전</a>
					</c:if>
				</div>					
			</td>
		</tr>
	</table>
	<div class="home">
	<input type="button" value="홈으로" onclick="location.href='OttServlet?command=admin_menu'">
	</div>
	</section>
	<footer>
	<jsp:include page="../Footer.jsp"></jsp:include>
</footer>
</body>
</html>