<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/Member.js"></script>
</head>
<body>
	<h2>로그인</h2>
	<form action="OttServlet" method="post" name="frm">
		<input type ="hidden" name = command value="login_Check" />
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" ></td>
			</tr>
			<tr>
				<td>암 호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td  colspan="2" align="center">
				<input type="submit" value="로그인"onclick="return loginCheck()">&nbsp;&nbsp; 
				<input type="reset" value="취소"> &nbsp;&nbsp; 
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
		</table>
	</form>
</body>
</html>