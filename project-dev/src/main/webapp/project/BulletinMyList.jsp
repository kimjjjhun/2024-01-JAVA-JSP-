<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/Ott.css">
<title>Insert title here</title>
</head>
<body>

<div id="wrap" align="center">
      <h1>나의 게시글 확인</h1>
      <table class="list">
         <tr>
            <th>게시글 번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
         </tr>
         <c:forEach var="bulletin" items="${bulletin}">
            <tr class="record">
               <td><a href="OttServlet?command=myBulletin_content_View&bulletinNum=${bulletin.bulletinNum}">${bulletin.bulletinNum}</a></td>
               <td><a href="OttServlet?command=myBulletin_content_View&bulletinNum=${bulletin.bulletinNum}"> ${bulletin.bulletinTitle}</a></td>
               <td>${bulletin.name}</td>
               <td>${bulletin.bulletinDate}</td>
               <td>${bulletin.readcount}</td>
            </tr>
         </c:forEach>
      </table>
   </div>
   </body>
</html>