<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/ContentDetail.css">
<title>Insert title here</title>
</head>
<body>
<header>
   <jsp:include page="../Header.jsp"></jsp:include>
</header>
<section>
   <div id="detail" align="center">
   <input type="hidden" name="page" value="${page.page}">
   <input type="hidden" name="contentNum" value="${content.contentNum}">
   
      <div id="contentname"><h1>컨텐츠 상세페이지</h1></div>
      <div id="info">
      <c:if test="${content.contentNum != contentWish.contentNum}">
   <div class="heart"><input type="button" id="heartbtn" value="♥" style="color:#d5d5d5;" onclick="location.href='OttServlet?command=insert_content_wish&contentNum=${content.contentNum}&userId=${member.userId}'"></div>
   </c:if>
   <c:if test="${content.contentNum eq contentWish.contentNum}">
   <div class="heart"><input type="button" id="heartbtn" value="♥" style="color:red; " onclick="location.href='OttServlet?command=delete_content_wish&contentNum=${content.contentNum}&userId=${member.userId}'"></div>
   </c:if>
      <table class="table">
         <tr>
            <td><c:choose>
                  <c:when test="${empty content.poster}">
                     <img id="poster" src="images/noimage.gif">
                  </c:when>
                  <c:otherwise>
                     <img id="poster" src="${content.poster}">
                  </c:otherwise>
               </c:choose></td>
            <td>
               <table id="table">
                  <tr>
                     <th>컨텐츠 제목</th>
                     <td>${content.contentName}</td>
                  </tr>
                  <tr>
                  <th>감독</th>
                     <td>${content.director}</td>
                  </tr>
                  <tr>
                     <th>장르</th>
                     <td>${content.genre}</td>
                  </tr>
                  <tr>
                     <th>배우</th>
                     <td>${content.actor}</td>
                  </tr>
                  <tr>
                     <th>개봉연도</th>
                     <td colspan="3">${content.year}</td>
                  </tr>
                  <tr>
                     <th>내용</th>
                     <td colspan="3">${content.story}</td>
                  </tr>
               </table>
            </td>
         </tr>
      </table>
      <c:if test="${member.admin == 1}">
      <div class="contentlist"><a id="list" href="OttServlet?command=admin_content_info&page=${page.page}">컨텐츠 리스트</a></div>
      <div class="contentlist"><a id="list" href="OttServlet?command=admin_update_content_form&contentNum=${content.contentNum}&page=${page.page}">컨텐츠 수정</a></div> 
      </c:if>
      <c:if test="${member.admin == 0}">
      <div class="contentlist"><a id="list" href="OttServlet?command=content_list&page=${page.page}">컨텐츠 리스트</a></div>
      </c:if>
   </div>
   </div>
   <div id="bulletin">
      <c:if test="${member.admin == 0}">
      <jsp:include page="../bulletin/BulletinList.jsp"></jsp:include>
      </c:if>
   </div>
</section>
<footer>
   <jsp:include page="../Footer.jsp"></jsp:include>
</footer>
</body>
</html>