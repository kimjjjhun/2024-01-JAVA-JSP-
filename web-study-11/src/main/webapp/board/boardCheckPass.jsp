<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>비밀번호 확인</h1>
		<form action="BoardServlet" name="frm" method="get">
			<input type="hidden" name="command" value="board_check_pass">
			<input type="hidden" name="num" value="${param.num}">
			<table style="width: 80%">
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" size="20"></td>
				</tr>
			</table>
			<br> <input type="submit" value=" 확 인 " > <br> 
			<br>${message}
		</form>
	</div>
</body>
</html>