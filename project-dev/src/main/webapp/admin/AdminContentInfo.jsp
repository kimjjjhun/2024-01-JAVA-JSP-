<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/ContentInfo.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../Header.jsp"></jsp:include>
</header>
<section>
	<h1>컨텐츠 목록</h1>
	<form name="frm">
	<div id="insert">
		<a href="OttServlet?command=admin_insert_content_form">컨텐츠 추가</a>
		</div>
		<table style="text-align:center;" align="center">
			<tr>
				<th>컨텐츠 번호</th>
				<th>컨텐츠 제목</th>
				<th>감독</th>
				<th>배우</th>
				<th>개봉연도</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${contentList}" var="content">
				<tr>
					<td>${content.contentNum}</td>
					<td><a
						href="OttServlet?command=admin_content_detail&contentNum=${content.contentNum}&page=${page.page}">${content.contentName}</a></td>
					<td>${content.director}</td>
					<td>${content.actor}</td>
					<td>${content.year}</td>
					<td><a
						href="OttServlet?command=admin_delete_content&contentNum=${content.contentNum}"
						onclick="return deleteCheck()">컨텐츠 삭제</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6">
				<div id="page" >
					<c:if test="${page.prev}">
						<a href="OttServlet?command=admin_content_info&page=${page.startPage-1}&limit=${page.limit}">이전</a>
					</c:if>
					 <c:forEach begin="${page.startPage}" end="${page.endPage}" var="nowPage">
					 	<c:if test="${page.page == nowPage}">
					 		<a href="OttServlet?command=admin_content_info&page=${nowPage}&limit=${page.limit}" style="color:yellowgreen;">${nowPage}</a>					 		
					 	</c:if>
					 	<c:if test="${page.page != nowPage}">
					 		<a href="OttServlet?command=admin_content_info&page=${nowPage}&limit=${page.limit}">${nowPage}</a>
					 	</c:if>
					 </c:forEach>
					 	<c:if test="${page.next}">
					 		<a href="OttServlet?command=admin_content_info&page=${page.endPage +1}&limit=${page.limit}">다음</a>
					 	</c:if>
      				</div>
      </td>
			</tr>
		</table>
		<div class="home" style="text-align:center">
			<input type="button" value="홈으로" name="home" onclick="location.href='OttServlet?command=admin_menu'">
		</div>
	</form>
	</section>
<footer>
	<jsp:include page="../Footer.jsp"></jsp:include>
</footer>


</body>
</html>