<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/InsertContent.css?after">
<script type="text/javascript" src="script/Content.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../Header.jsp"></jsp:include>
</header>
<section>
	<div id="info" align="center">
      <h1>문의 등록</h1>
      <form method="post" name="frm" action="OttServlet">
         <input type="hidden" name="command" value="insert_qna">
         <table>
            <tr>
               <th>문의 제목</th>
               <td><input type="text" size="70" name="qnaTitle"></td>
            </tr> <tr>
               <th>아이디</th>
               <td><input type="text" size="70" name="userId" value="${member.userId}"></td>
            </tr> 
            <tr>
            <th>카테고리</th>
               <td><input type="text" size="70" name="qnaCategory"></td>
            </tr>
     		 <tr>
               <th>내용</th>
               <td><input type="text" size="70" name="qnaContent"></td>
            </tr>
     		 <tr>
               <th>비밀번호</th>
               <td><input type="password" size="70" name="qnaPwd"></td>
            </tr>
         </table>
         <br>
         <br> 
            <button type="submit" class="btn-hover color-2" onclick="return check()">등록</button>
            <button type="reset" class="btn-hover color-2">다시 작성</button>
            <button class="btn-hover color-2" onclick="location.href='OttServlet?command=qna_list'">목록</button>
      </form>
   </div>
   </section>
   <footer>
	<jsp:include page="../Footer.jsp"></jsp:include>
</footer>
</body>
</html>