<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="10_testLogin.jsp" method="post">

	<label for="userid">아이디 : </label>
	<input type="text" name="id" id="userid"><br>
	<label for="userpwd">암 &nbsp; 호 : </label>
	<input type="password" name="pwd" id="userpwd"><br>
	<input type="submit" value="로그인">
</form>

<form action="10_sginUp.jsp" method="post" >
	<input type="submit" value="회원가입">
</form>
<form action="10_sginUp.jsp" method="post" >
	<input type="submit" value="id/pw 찾기">
</form>


</body>
</html>