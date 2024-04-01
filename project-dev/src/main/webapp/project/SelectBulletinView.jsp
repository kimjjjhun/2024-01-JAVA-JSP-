<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ott.dao.CommentDAO" %>
<%@page import="com.ott.dto.CommentVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 모바일 환경 대응 -->
<title>게시글 상세보기</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #242424;
    }
    #wrap {
        text-align: center;
        margin-top: 20px;
        border-radius:10px;
    }
    h1 {
        color: #fff;
    }
    tr{border-radius:5px;
    }
    table {
        width: 80%;
        margin: 20px auto; /* 가운데 정렬 */
        border-collapse: collapse;
        border-radius:5px;
    }
    th, td {
        padding: 10px;
        border: 1px solid #ddd;
        color:#black;
    }
    th {
        background-color: #BDBDBD;
        color: #black;
    }
    td{background-color: #fff;
    font-size:15px;
    }
    .comment {
        width: 400px;
        height: 30px;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin-bottom: 10px;
    }
    input[type="submit"] {
        padding: 8px 20px;
        border: none;
        border-radius: 5px;
        background-color: #fff;
        color: #black;
        cursor: pointer;
        font-weight:bold;
        height:40px;
    }
    input[type="submit"]:hover {
 background-color: #A6A6A6;
    }
    .centerd {
        position: fixed;
        left: 50%;
        transform: translateX(-50%);
    }
    .comment-container {
        width: 80%;
        margin: 20px auto;
    }
    .comment-item {
        background-color: #f9f9f9;
        border-radius: 5px;
        padding: 10px;
        margin-bottom: 10px;
    }
    .comment-info {
        font-size: 14px;
        color: #666;
        margin-bottom: 5px;
    }
    .comment-content {
        font-size: 16px;
        color: #333;
        margin-bottom: 10px;
    }
    .comment-btns {
        margin-top: 5px;
    }
    .comment-btns input[type="button"] {
        padding: 5px 10px;
        margin-right: 5px;
        border: none;
        border-radius: 3px;
        background-color: #ccc;
        color: #fff;
        cursor: pointer;
    }
    .comment-btns input[type="button"]:hover {
        background-color: #999;
    }
    
.bulletinComment td {
  width: 100px;
  height: 100px;
}
#btn{
        padding: 8px 20px;
        border: none;
        border-radius: 5px;
        background-color: #fff;
        color: #black;
        font-weight:bold;
        cursor: pointer;
}
#btn:hover{
 background-color: #A6A6A6;
}

.heart {
   background-color: none;
   
}

#heartbtn {
    position: absolute;
    top: 388px; /* 원하는 위치의 상단 여백 */
    left: 1165px; /* 원하는 위치의 왼쪽 여백 */
   font-size: 30px;
   width: 40px;
   height: 40px;
   background-color: none;
}
</style>
</head>
<body>
<div id="wrap">
    <h1>게시글 상세보기</h1>
    <table>
        <tr>
            <th>게시글 번호</th>
            <td>${bulletin.bulletinNum}</td>
            <th>작성자</th>
            <td>${bulletin.name}</td>
        </tr>
        <tr>
            <th>작성일</th>
            <td><fmt:formatDate value="${bulletin.bulletinDate}" /></td>
            <th>조회수</th>
            <td>${bulletin.readCount }</td>
        </tr>
        <tr>
            <th>제목</th>
            <td colspan="3">${bulletin.bulletinTitle }</td>
        </tr>
        <tr class ="bulletinComment">
            <th>내용</th>
            <td colspan="3"><pre>${bulletin.bulletinContent }</pre></td>
        </tr>
    </table>



    <c:if test="${member.userId eq bulletin.userId}">
        <br><br>
        <input type="button" id="btn" value="게시글 수정" onclick="location.href='OttServlet?command=Bulletin_Update_Form&bulletinNum=${bulletin.bulletinNum}&contentNum=${contentNum } '">
        <input type="button" id="btn" value="게시글 삭제" onclick="return check1(${bulletinNum}, ${contentNum })">
    </c:if>
    <input type="button" id="btn" value="뒤로 돌아가기" onclick="location.href='OttServlet?command=admin_content_detail&contentNum=${bulletin.contentNum}'">
   <c:if test="${bulletin.bulletinNum != bulletinWish.bulletinNum}">
   <div class="heart"><input type="button" id="heartbtn" value="♥" style="color:#d5d5d5;" onclick="location.href='OttServlet?command=insert_bulletin_wish&bulletinNum=${bulletin.bulletinNum}&userId=${member.userId}&contentNum=${contentNum }'"></div>
   </c:if>
   <c:if test="${bulletin.bulletinNum eq bulletinWish.bulletinNum}">
   <div class="heart"><input type="button" id="heartbtn" value="♥" style="color:red; " onclick="location.href='OttServlet?command=delete_bulletin_wish&bulletinNum=${bulletin.bulletinNum}&userId=${member.userId}&contentNum=${contentNum }'"></div>
   </c:if>
</div>



<div class="comment-container">
    <form action="OttServlet" method="post">
    <input type="hidden" name="contentNum" value="${contentNum }">
        <input type="hidden" name="command" value="comment_Insert">
        <input type="hidden" name="bulletinNum" value="${bulletin.bulletinNum }">
        <input type="text" name="commentContent" placeholder="댓글을 입력하세요" class="comment">
        <input type="submit" value="댓글 달기">
    </form>

    <c:forEach var="comment" items="${comment}">
        <div class="comment-item">
            <div class="comment-info">작성자 명 :${comment.userId} 작성 날짜: <fmt:formatDate value="${comment.commentDate }"/></div>
            <div class="comment-content">${comment.commentContent }</div>
            <div class="comment-btns">
                <c:if test="${member.userId eq comment.userId}">
                    <input type="button" value="삭제" onclick="return checkComment(${comment.commentNum},${bulletinNum })">
                    <input type="button" value="수정" onclick="open_wid('OttServlet?command=comment_Update_Form&commentNum=${comment.commentNum}', 'update')">
                </c:if>
            </div>
        </div>
    </c:forEach>
</div>

<script>
function open_wid(url, name){
    window.open(url, name, "width=550, height=290");
};

function checkComment(commentNum, bulletinNum){
    if(confirm("삭제하시겠습니까?")){
        location.href="OttServlet?command=comment_Delete&commentNum="+ commentNum + "&bulletinNum=" + bulletinNum;  
    }
}

function check1(bulletinNum, contentNum) {
	console.log('asdsaed')
	if(confirm("삭제하시겠습니까?")) {
		location.href="OttServlet?command=bulletin_delete&bulletinNum="+bulletinNum+"&contentNum=" +contentNum;
	}
}

</script>

</body>
</html>