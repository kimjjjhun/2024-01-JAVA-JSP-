<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/Header.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript">
    function checkLogin() {
        <c:choose>
            <c:when test="${empty member.userId}">
                // 사용자가 로그인되어 있지 않은 경우
                window.location.href = 'OttServlet?command=member_login_form';
            </c:when>
        </c:choose>
    }
</script>

<title>Insert title here</title>
</head>
<body>
   <div id="goMain">
      <a href="index.jsp"> <img alt="로고" src="images/logo.png">
      </a>
   </div>
   <div id="menu">
      <ul class="menu">
         <li class="mainlist"><a id="menulist" href="OttServlet?command=content_list" onclick="checkLogin()">컨텐츠</a>
            <ul class="submenu">
               <li>액션</li>
               <li>호러</li>
               <li>로맨스</li>
               <li>범죄</li>
            </ul></li>
         <li class="mainlist"><a id="menulist" href="OttServlet?command=qna_list" onclick="checkLogin()">Q&A</a></li>
      </ul>
   </div>
   <div id="profile">
      <c:choose>
         <c:when test="${!empty member.userId}">
            <c:if test="${member.admin == 1}">
               <input type="image" class="myPage" src="images/adminlogin.png"
                  onclick="location.href='OttServlet?command=admin_menu'">
               <div class="logout">
                   <button class="btn-hover color-2" onclick="location.href='OttServlet?command=logout_User'">로그아웃</button>
               </div>
            </c:if>
            <c:if test="${member.admin == 0 }">
               <input type="image" class="myPage" src="images/userlogin.png"
                  onclick="location.href='OttServlet?command=my_page'">
               <div class="btn">
                  <button class="btn-hover color-2" onclick="location.href='OttServlet?command=logout_User'">로그아웃</button>
               </div>
            </c:if>
         </c:when>
         <c:when test="${empty member.userId}">
         <input type="image" class="myPage" src="images/user.png" onclick="location.href='OttServlet?command=member_login_form'">
            <div class="login">
                 <button class="btn-hover color-2" onclick="location.href='OttServlet?command=member_login_form'">로그인</button>
            </div>
         </c:when>
      </c:choose>
   </div>
</body>
</html>
