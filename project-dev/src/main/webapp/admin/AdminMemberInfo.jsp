<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/MemberInfo.css">
<script type="text/javascript" src="script/AdminMember.js"></script>
<title>Insert title here</title>
<script>

</script>
</head>
<body>
<header>
	<jsp:include page="../Header.jsp"></jsp:include>
</header>
<section>
<h1>회원 목록</h1>
	<table>
		<tr>
			<th>아이디</th>
			<th>권한</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${memberList}" var="member">
			<tr>
				<td>${member.userId}</td>
				<td>${member.admin}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.phone}</td>
				<td>${member.address}</td>	
				<td><input type="button" value="회원 삭제" onclick="userConfirm('${member.userId}')">
				</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
				<div id="page" >
					<c:if test="${page.prev}">
						<a href="OttServlet?command=admin_member_info&page=${page.startPage-1}&limit=${page.limit}">이전</a>
					</c:if>
					 <c:forEach begin="${page.startPage}" end="${page.endPage}" var="nowPage">
					 	<c:if test="${page.page == nowPage}">
					 		<a href="OttServlet?command=admin_member_info&page=${nowPage}&limit=${page.limit}" style="color:yellowgreen;">${nowPage}</a>					 		
					 	</c:if>
					 	<c:if test="${page.page != nowPage}">
					 		<a href="OttServlet?command=admin_member_info&page=${nowPage}&limit=${page.limit}">${nowPage}</a>
					 	</c:if>
					 </c:forEach>
					 	<c:if test="${page.next}">
					 		<a href="OttServlet?command=admin_member_info&page=${page.endPage +1}&limit=${page.limit}">다음</a>
					 	</c:if>
      				</div>
      </td>
			</tr>
		</table>
		<div class="home" style="text-align:center">
			<input type="button" value="홈으로" name="home" onclick="location.href='OttServlet?command=admin_menu'">
		</div>
	</section>
	<footer>
		<jsp:include page="../Footer.jsp"></jsp:include>
	</footer>
</body>
</html>