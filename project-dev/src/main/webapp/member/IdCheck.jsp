<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/Member.js"></script>
</head>
<body>

<!-- ID 중복체크 폼 -->

	<h2>아이디 중복 체크</h2>
	<form action="OttServlet" method="get" name="frm">
	<input type="hidden" name="command" value="idCheck">
		아이디<input type="text" name="userId" value=${userId}>
			<input type="submit" value="중복 체크">
			
			<br>
			<c:if test="${result == 1 }">
				<script type="text/javascript">
					opener.document.frm.userId.value="";
					</script>
					${userId}는 <font color="red"><b>사용</b></font> 불가능 ID입니다.				
			</c:if>
			<c:if test="${result == -1 }">
					${userId}는 <font color="red"><b>사용 가능</b></font>한 ID입니다.
				<input type="button" value="사용" class="cancel" onclick="idok()">				
			</c:if>
	</form>

</body>
</html>