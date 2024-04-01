<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #242424;
    }
    h2 {
        color: white;
        text-align: center;
        }
    h1{color:white;
       margin-left:40px;
        }
    }
    table {
        width: 100%;
        margin-bottom: 30px;
    }
    th, td {
        padding: 8px;
        text-align: center;
    }
    th {
        background-color: #333;
        color: #fff;
    }
    .record:hover {
        background-color: #f2f2f2;
    }
    .list1 {
        margin: 0 auto;
        max-width: 800px;
        border: 1px solid #ddd;
        background-color: #BDBDBD;
        margin-left:30px;
    }
    
     .list {
        margin: 0 auto;
        max-width: 800px;
        border: 1px solid #ddd;
        background-color: #BDBDBD;
    }
    
    a:link, a:visited {
    color: inherit; /* 링크의 색상을 부모 요소의 색상으로 상속 */
    text-decoration: none; /* 링크에 밑줄 제거 */
}

a:hover, a:active {
    color: inherit; /* 링크의 색상을 부모 요소의 색상으로 상속 */
    text-decoration: none; /* 링크에 밑줄 제거 */
}
#btn1, #btn2, #btn3{
    width: 150px;
    height: 45px;
    background-color: #fff;
    border-radius:10px;
    color: black;
       border: none;
    font-weight: bold;
    font-size: 17px;
    margin-left: 30px;

}
#btn1{
    position: absolute;
    top: 175px; /* 원하는 위치의 상단 여백 */
    left: 340px; /* 원하는 위치의 왼쪽 여백 */
}

#btn2{
    position: absolute;
    top: 235px; /* 원하는 위치의 상단 여백 */
    left: 340px; /* 원하는 위치의 왼쪽 여백 */
}

#btn3{
    position: absolute;
    top: 295px; /* 원하는 위치의 상단 여백 */
    left: 340px; /* 원하는 위치의 왼쪽 여백 */

}
    
    #btn1:hover,#btn2:hover,#btn3:hover {
    cursor: pointer;
    background-color: #A6A6A6;
}
#poster img {
   margin-right: 20px;
   margin-bottom: 20px;
   display: inline-block;
   width: 250px;
   height: 450px;
   border-radius: 5%;
   transition: all 0.2s linear;
   cursor: pointer;
}

#poster img:hover {
   transform: scale(1.1);
}
    
</style>
</head>
<body>
<header>
    <jsp:include page="../Header.jsp"></jsp:include>
</header>
<form action="OttServlet" method="post">
    <br><br><br><br><br><br><br><br><br><br><br><br>
    <h1>${member.name }님 환영합니다.</h1>
    <input type="button" id="btn1"  value="개인 정보 수정" onclick ='location.href="OttServlet?command=changeUser_InformationForm"'><br><br>
    <input type="button" id="btn2" value="회원 탈퇴" onclick='location.href="OttServlet?command=delete_User"'><br><br>
    <input type="button" id="btn3" value="로그아웃" onclick='location.href="OttServlet?command=logout_User"'><br>
      <h2>내가 찜한 컨텐츠</h2>
           <div id="poster">
            <c:forEach var="contentWish" items="${contentWish}">
       
               <img src="${contentWish.poster}" onclick="location.href='OttServlet?command=admin_content_detail&page=${page.page}&contentNum=${contentWish.contentNum}'">
              
            </c:forEach>
  </div>
    <div id="wrap" align="center">
        <h2>내가 찜한 게시글</h2>
        <table class="list">
            <tr>
                <th>게시글 번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
            <c:forEach var="bulletinWish" items="${bulletinWish}">
                <tr class="record">
                    <td><a href="OttServlet?command=bulletin_content_View&bulletinNum=${bulletinWish.bulletinNum}">${bulletinWish.bulletinNum}</a></td>
                    <td><a href="OttServlet?command=bulletin_content_View&bulletinNum=${bulletinWish.bulletinNum}">
                            ${bulletinWish.bulletinTitle}</a></td>
                    <td>${bulletinWish.name}</td>
                    <td><fmt:formatDate value="${bulletinWish.bulletinDate}" /></td>
                    <td>${bulletinWish.readCount}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div id="wrap" align="center">
        <h2>내가 쓴 게시글</h2>
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
                    <td><fmt:formatDate value="${bulletin.bulletinDate}" /></td>
                    <td>${bulletin.readCount}</td>
                </tr> 
            </c:forEach>
        </table>
    </div>
</form>
   <footer>
      <jsp:include page="../Footer.jsp"></jsp:include>
   </footer>
</body>
</html>