<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/UpdateContent.css">
<script type="text/javascript" src="script/AdminContent.js"></script>
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../Header.jsp"></jsp:include>
</header>
<section>
		<h1>컨텐츠 수정</h1>
	<div id="info" align="center">
		<form enctype="multipart/form-data" method="post" name="frm"
			action="OttServlet">
			<input type="hidden" name="command" value="admin_update_content">
			<input type="hidden" name="contentNum" value="${content.contentNum}">
			<input type="hidden" name="nomakeImg" value="${content.poster}">
			<input type="hidden" name="page" value="${page}">
			<table>
				<tr>
					<td><c:choose>
							<c:when test="${empty content.poster}">
								<img src="images/noimage.gif" width=150px height=300px>
							</c:when>
							<c:otherwise>
								<img src="${content.poster}" width=150px height=300px>
							</c:otherwise>
						</c:choose></td>
					<td>
						<table>
							<tr>
								<th>컨텐츠 제목</th>
								<td><input type="text" name="contentName"
									value="${content.contentName}" size="70"></td>
							</tr>
							<tr>
								<th>감독</th>
								<td><input type="text" name="director"
									value="${content.director}" size="70"></td>
							</tr>
							<tr>
								<th>장르</th>
								<td><input type="text" name="genre"
									value="${content.genre}" size="70"></td>
							</tr>
							<tr>
								<th>배우</th>
								<td><input type="text" name="actor"
									value="${content.actor}" size="70"></td>
							</tr>
							<tr>
								<th>개봉연도</th>
								<td colspan="3"><input type="text" name="year"
									value="${content.year}" size="70"></td>
							</tr>
							<tr>
								<th>내용</th>
								<td colspan="3"><textarea
										 name="story">${content.story}</textarea></td>
							</tr>
							<tr>
								<th>사진</th>
									<td colspan="3">
										<input type="file" name="poster" size="70">
									</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div class="link">
			<input type="submit" value="등록" onclick="return updateCheck('${content.contentNum}')"> 
						<input type="reset" value="다시 작성"> 
						<input type="button" value="목록" onclick="location.href='OttServlet?command=admin_content_detail&contentNum=${content.contentNum}&page=${page.page}'">
		</div>
		</form>
	</div>
	</section>
	<footer>
	<jsp:include page="../Footer.jsp"></jsp:include>
</footer>
</body>
</html>