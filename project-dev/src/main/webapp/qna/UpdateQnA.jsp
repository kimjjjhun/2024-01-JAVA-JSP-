<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/UpdateContent.css">
<script type="text/javascript" src="script/Qna.js"></script>
<title>Insert title here</title>
</head>
<body>
   <header>
      <jsp:include page="../Header.jsp"></jsp:include>
   </header>
   <section>
      <h1>Q&A 수정</h1>
      <div id="wrap" align="center">
         <form method="post" name="frm" action="OttServlet">
            <input type="hidden" name="command" value="update_qna">
            <input type="hidden" name="qnaNum" value="${qna.qnaNum}">
            <input type="hidden" name="page" value="${page.page}">            
            <table>

               <tr>
                  <th>문의 제목</th>
                  <td><input type="text" name="qnaTitle"
                     value="${qna.qnaTitle}" size="70"></td>
               </tr>
               <tr>
                  <th>아이디</th>
                  <td><input type="text" name="userId" value="${qna.userId}"></td>
               </tr>
               <tr>
                  <th>카테고리</th>
                  <td><input type="text" name="qnaCategory" value="${qna.qnaCategory}"
                     size="70"></td>
               </tr>
               <tr>
                  <th>내용</th>
                  <td colspan="3"><input type="text" name="qnaContent"
                     value="${qna.qnaContent}" size="70"></td>
               </tr>
            </table>
            <div class="list">
               <input type="submit" value="등록" onclick="return updateCheck('${qna.qnaNum}')">
               <input type="reset" value="다시 작성"> 
               <input type="button" value="목록" onclick="location.href='OttServlet?command=qna_detail&qnaNum=${qna.qnaNum}&page=${page.page}'">
            </div>
         </form>
      </div>
   </section>
   <footer>
      <jsp:include page="../Footer.jsp"></jsp:include>
   </footer>
</body>
</html>