<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/Ott.css">
<title>Insert title here</title>
</head>
<body>
	<form method="post" name="search" action="OttServlet">
		<input type="hidden" name="command" value="serach_bulletin">
		<table>
			<tr>
				<td><select class="form-control" name="searchField">
						<option value="0">선택</option>
						<option value="bulletinTitle">제목</option>
						<option value="name">작성자</option>
				</select></td>
				<td><input type="text" placeholder="검색어 입력" name="searchText"
					maxlength="100"></td>
				<td><button type="submit">검색</button></td>
			</tr>

		</table>
	</form>

	<div id="wrap" align="center">
		<h1>내가 찜한 게시글</h1>
		<table class="list">
			<tr>
				<th>게시글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="bulletinWish" items="${bulletinWish}">
				<tr class="record">
					<td><a
						href="OttServlet?command=bulletin_content_View&bulletinNum=${bulletinWish.bulletinNum}">${bulletinWish.bulletinNum}</a></td>
					<td><a
						href="OttServlet?command=bulletin_content_View&bulletinNum=${bulletinWish.bulletinNum}">
							${bulletinWish.bulletinTitle}</a></td>
					<td>${bulletinWish.name}</td>
					<td>${bulletinWish.bulletinDate}</td>
					<td>${bulletinWish.readcount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
