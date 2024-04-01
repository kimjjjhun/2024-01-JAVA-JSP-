<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/Ott.css">
<title>Insert title here</title>
<script>
function checkDeleteQna(qnaNum){
    if(confirm("삭제하시겠습니까?")){
       alert("삭제되었습니다")
        location.href="OttServlet?command=delete_qna&qnaNum="+qnaNum;
    }else{
       alert("취소되었습니다")
    }
}
</script>
<style>
body{
background-color:#242424;
}
</style>
</head>
<body>
   <header>
      <jsp:include page="../Header.jsp"></jsp:include>
   </header>
   <section>
      <div id="wrap" align="center">
         <input type="hidden" name="page" value="${page.page}"> <input
            type="hidden" name="qnaNum" value="${qna.qnaNum}">
         <h1>문의 내용</h1>
         <div id="info">
            <table>
               <tr>
                  <th>문의 제목</th>
                  <td>${qna.qnaTitle}</td>
               </tr>
               <tr>
                  <th>아이디</th>
                  <td>${qna.userId}</td>
               </tr>
               <tr>
                  <th>카테고리</th>
                  <td>${qna.qnaCategory}</td>
               </tr>
               <tr>
                  <th>등록 일자</th>
                  <td>${qna.qnaRegiDate}</td>
               </tr>
               <tr>
                  <th>내용</th>
                  <td colspan="3">${qna.qnaContent}</td>
               </tr>
               <tr>
                  <td colspan="2">
                  <div id="ownuser">
                  <c:if test="${member.userId == qna.userId}">
                        <a
                           href="OttServlet?command=update_qna_form&qnaNum=${qna.qnaNum}&page=${page.page}" class="list">수정하기</a>
                        <input type="button" class="list" value="삭제하기" onclick="checkDeleteQna(${qna.qnaNum})">
                     </c:if>
                     </div>
                     </td>
               </tr>
            </table>
            <div id="reply">
                  <table>
               <c:if test="${not empty reply.replyNum}">
                     <input type="hidden" name="qnaNum" value="${qna.qnaNum}">
                     <tr>
                        <th>문의 답변</th>
                     </tr>
                     <tr>
                        <td>${reply.replyRegiDate}</td>
                     </tr>
                     <tr>
                        <td>${reply.replyContent}</td>
                     </tr>
               </c:if>
               <c:if test="${member.admin == 1 && empty reply.replyContent}">
                  <form action="OttServlet?command=admin_qna_reply" method="post">
                     <input type="hidden" name="qnaNum" value="${qna.qnaNum}">
                     <table>
                        <tr>
                           <th>문의 답변</th>
                        </tr>
                        <tr>
                           <td><textarea cols="135" rows="15" name="replyContent" >${reply.replyContent}</textarea></td>
                        </tr>
                     </table>
                     <br> <br> <input type="submit" value="등록"> <input
                        type="reset" value="다시 작성">
                  </form>
               </c:if>
               </table>
               </div>
            <input type="button" id="btn" value="목록"
               onclick="location.href='OttServlet?command=qna_list&page=${page.page}'">
         </div>
      </div>
   </section>
   <footer>
      <jsp:include page="../Footer.jsp"></jsp:include>
   </footer>
</body>
</html>