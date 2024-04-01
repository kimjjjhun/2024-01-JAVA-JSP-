<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/AdminMenu.css">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../Header.jsp"></jsp:include>
</header>
	<section>
		<div id="link">
			<input type="button" value="회원관리" onclick="location.href='OttServlet?command=admin_member_info'"> 
			<input type="button" value="컨텐츠 관리" onclick="location.href='OttServlet?command=admin_content_info'"> 
			<input type="button" value="게시글 삭제" onclick="location.href='OttServlet?command=admin_delete_bulletin_form'">
			<input type="button" name="qna" value="Q&A" onclick="location.href='OttServlet?command=qna_list'">
		</div>
	</section>
	<footer>
		<jsp:include page="../Footer.jsp"></jsp:include>
	</footer>
</body>
</html>