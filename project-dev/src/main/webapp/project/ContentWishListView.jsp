<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <h1>내가 찜한 작품</h1>
      <table class="list" border =1>
         <tr>
            <th><pre>작품 번호</pre></th>
            <th><pre>제목</pre></th>
            <th><pre>작성자</pre></th>
            <th><pre>작성일</pre></th>
            <th>조회수</th>
         </tr>
         <c:forEach var="contentWish" items="${contentWish}">
            <tr class="record">
               <td>${contentWish.contentNum}</td>
               <td> ${contentWish.contentName}</td>
               <td>${contentWish.genre}</td>
               <td>${contentWish.year}</td>
               <td>${contentWish.story}</td>
               <td><img src="${contentWish.poster}" width ="400" height="500"></td>
               <td>
            </tr>
         </c:forEach>
         
      </table>
</body>
</html>