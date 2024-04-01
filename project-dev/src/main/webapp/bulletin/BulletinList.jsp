<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/Ott.css">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="6" style="border: white; text-align: right">
			<input type="button" id="btn" value="게시글 등록" onclick="location.href='OttServlet?command=bulletin_write_form&contentNum=${content.contentNum}'"></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>아이디</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<c:forEach var="bulletin" items="${bulletinList}">
				<c:if test="${content.contentNum == bulletin.contentNum}">
					<tr class="record">
						<td>${bulletin.bulletinNum }</td>
						<td><a href="OttServlet?command=bulletin_view&bulletinNum=${bulletin.bulletinNum}&contentNum=${bulletin.contentNum}">
								${bulletin.bulletinTitle } </a></td>
						<td>${bulletin.name}</td>
						<td>${bulletin.userId }</td>
						<td><fmt:formatDate value="${bulletin.bulletinDate }"
								pattern="yyyy-MM-dd" /></td>
						<td>${bulletin.readCount}</td>
					</tr>
				</c:if>
			</c:forEach>
			<tr>
				<td colspan="6" style="text-align: center">
					<div id="page">
							<c:if test="${page.prev}">
								<a
									href="OttServlet?command=admin_content_list&page=${page.startPage-1}&limit=${page.limit}">이전</a>
							</c:if>
							<c:forEach begin="${page.startPage}" end="${page.endPage}"
								var="nowPage">
								<c:if test="${page.page == nowPage}">
									<a
										href="OttServlet?command=admin_content_list&page=${nowPage}&limit=${page.limit}"
										style="color: yellowgreen;">${nowPage}</a>
								</c:if>
								<c:if test="${page.page != nowPage}">
									<a
										href="OttServlet?command=admin_content_list&page=${nowPage}&limit=${page.limit}">${nowPage}</a>
								</c:if>
							</c:forEach>
							<c:if test="${page.next}">
								<a
									href="OttServlet?command=admin_content_list&page=${page.endPage +1}&limit=${page.limit}">다음</a>
							</c:if>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>