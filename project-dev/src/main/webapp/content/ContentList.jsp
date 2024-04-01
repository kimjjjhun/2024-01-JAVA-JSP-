<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/ContentList.css">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
   <header>
      <jsp:include page="../Header.jsp"></jsp:include>
   </header>
   <section>
      <div id="poster">
         <c:forEach items="${contentList}" var="content">
            <input type="hidden" name="page" value="${page.page}">
            <c:if test="${not empty content.contentNum}">
               <input type="image" src="${content.poster}"
                  onclick="location.href='OttServlet?command=admin_content_detail&page=${page.page}&contentNum=${content.contentNum}'">
            </c:if>
         </c:forEach>
      </div>
      <table>
         <tr>
            <td>
               <div id="page">
                  <c:if test="${page.prev}">
                     <a
                        href="OttServlet?command=content_list&page=${page.startPage-1}&limit=${page.limit}">이전</a>
                  </c:if>
                  <c:forEach begin="${page.startPage}" end="${page.endPage}"
                     var="nowPage">
                     <c:if test="${page.page == nowPage}">
                        <a
                           href="OttServlet?command=content_list&page=${nowPage}&limit=${page.limit}"
                           style="color: red;">${nowPage}</a>
                     </c:if>
                     <c:if test="${page.page != nowPage}">
                        <a
                           href="OttServlet?command=content_list&page=${nowPage}&limit=${page.limit}" style="color:white;">${nowPage}</a>
                     </c:if>
                  </c:forEach>
                  <c:if test="${page.next}">
                     <a
                        href="OttServlet?command=content_list&page=${page.endPage +1}&limit=${page.limit}">다음</a>
                  </c:if>
               </div>
            </td>
         </tr>
      </table>
   </section>
   <footer>
   <jsp:include page="../Footer.jsp"></jsp:include>
</footer>
</body>
</html>