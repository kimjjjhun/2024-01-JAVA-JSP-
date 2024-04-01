<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="css/test.css">
<title>Insert title here</title>
</head>
<body>
   <header>
      <jsp:include page="Header.jsp"></jsp:include>
   </header>
   <section>
   <div id="recommand">
      <video  width="100%;" style="height: 1100px; overflow:hidden; position:absolute;" autoplay
         muted loop>
         <source src="images/파묘 1차 예고편.mp4" type="video/mp4">
      </video>
      <div class="button">
      <h1>나와선 안될 것들이 나왔다</h1>
      <p>오컬트 장르 최초 천만 관객 돌파</p>
      <p>검은 사제들, 사바하를 이은 장재현 감독의 오컬트 최종판</p>
         <p>
            <b><input type="button" value="상세보기"
               onclick="location.href='OttServlet?command=admin_content_detail&contentNum=1&page=4'"></b>
         </p>
      </div>
      </div>
      <section>
         <div id="contentlist">
            <h1>최신 추천작</h1>
            <div id="poster">
               <input type="image" src="images/듄 파트 2.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=18&page=4'">
               <input type="image" src="images/웡카.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=51&page=3'">
               <input type="image" src="images/파묘.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=1&page=4'">
               <input type="image" src="images/더문.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=16&page=4'">
               <input type="image" src="images/밀수.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=88&page=2'">
               <input type="image" src="images/노량_죽음의 바다.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=108&page=2'">
               <input type="image" src="images/길복순.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=93&page=2'">
            </div>
         </div>
         <div id="contentlist">
            <h1>강렬한 액션이 땡길 때</h1>
            <div id="poster">
               <input type="image" src="images/헌트.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=49&page=3'">
               <input type="image" src="images/데드풀.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=145&page=1'">
               <input type="image" src="images/모가디슈.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=23&page=4'">
               <input type="image" src="images/강철비.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=90&page=2'">
               <input type="image" src="images/밀정.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=104&page=2'">
               <input type="image" src="images/베를린.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=100&page=2'">
               <input type="image" src="images/암살.jpg"
                  onclick="location.href='OttServlet?command=admin_content_detail&contentNum=103&page=2'">
            </div>
         </div>
      </section>
   </section>
   <footer>
      <jsp:include page="Footer.jsp"></jsp:include>
   </footer>
</body>
</html>

