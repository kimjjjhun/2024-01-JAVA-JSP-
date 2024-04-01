<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/ContentInfo.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
   <jsp:include page="../Header.jsp"></jsp:include>
</header>
<section>
   <h1>QnA 목록</h1>
      <table style="text-align:center;" align="center">
         <tr>
            <th>답변 여부</th>
            <th>QnA 번호</th>
            <th>QnA 제목</th>
            <th>아이디</th>
            <th>등록 일자</th>
            <th>QnA 종류</th>
         </tr>
         <c:forEach items="${qnaList}" var="qna" >
            <tr>
               <td>
                  <c:set var="frag" value="false"></c:set>
                  <c:set var="doubleFrag" value="false"></c:set>
                  <c:forEach items="${qnaReply}" var="reply">
                     <c:choose>
                        <c:when test="${reply.qnaNum == qna.qnaNum}">
                              <p>답변완료</p>
                              <c:set var="frag" value="true"></c:set>
                        </c:when>
                        <c:otherwise>
                           <c:set var="doubleFrag" value="false"></c:set>
                        </c:otherwise>
                     </c:choose>
                  </c:forEach>
                     <c:if test="${frag == doubleFrag}">
                        <p style="color:red">미답변문의</p>
                        <c:set var="tripleFrag" value="false"></c:set>
                     </c:if>
               </td>
               <td>${qna.qnaNum}</td>
               <td><a href="OttServlet?command=qna_detail&qnaNum=${qna.qnaNum}&page=${page.page}">${qna.qnaTitle}</a></td>
               <td>${qna.userId}</td>
               <td><fmt:formatDate value="${qna.qnaRegiDate}" pattern="yyyy-MM-dd hh:mm" /></td>
               <td>${qna.qnaCategory}</td>
            </tr>
         </c:forEach>
         <tr>
            <td colspan="6">
            <div id="page" >
               <c:if test="${page.prev}">
                  <a href="OttServlet?command=qna_list&page=${page.startPage-1}&limit=${page.limit}">이전</a>
               </c:if>
                <c:forEach begin="${page.startPage}" end="${page.endPage}" var="nowPage">
                   <c:if test="${page.page == nowPage}">
                      <a href="OttServlet?command=qna_list&page=${nowPage}&limit=${page.limit}" style="color:yellowgreen;">${nowPage}</a>                      
                   </c:if>
                   <c:if test="${page.page != nowPage}">
                      <a href="OttServlet?command=qna_list&page=${nowPage}&limit=${page.limit}">${nowPage}</a>
                   </c:if>
                </c:forEach>
                   <c:if test="${page.next}">
                      <a href="OttServlet?command=qna_list&page=${page.endPage +1}&limit=${page.limit}">다음</a>
                   </c:if>
                  </div>
      </td>
         </tr>
      </table>
      
      <div class="login" style="text-aling:center">
                 <button class="btn-hover color-2" name="home" onclick="location.href='OttServlet?command=insert_qna_form'">문의하기</button>
            </div>
      
      <div class="login" style="text-aling:center">
                 <button class="btn-hover color-2" name="home" onclick="location.href='index.jsp'">홈으로</button>
            </div>
      
   </section>
<footer>
   <jsp:include page="../Footer.jsp"></jsp:include>
</footer>


</body>
</html>