<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script>
	$(function(){
		$('#btn').click(function(){
			$(this).parent("form").submit();
			window.opener.document.location.reload();
		})
	})
</script>
</head>
<body>
	<h1>댓글 수정</h1>
	<form action="OttServlet" method="post" name="frm" id="frm">
		<input type="hidden" name="command" value="comment_Update"> 
		<input type="hidden" name="commentNum" value="${comment.commentNum }">
		<textarea rows="7" cols="70" name="commentContent">${comment.commentContent } </textarea>
		<br>
		<br> <input type="button" value="수정 완료" id="btn">
		<input type="button" value="취소" onclick="window.close()">
	</form>
</body>
</html>