<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<style>
/* CSS 스타일 */
section{
padding:150px;
}
body {
    font-family: Arial, sans-serif;
    background-color: #242424;
}

#wrap {
    width: 80%;
    margin: 0 auto;
    padding: 20px;
    background-color: #BDBDBD;
    border-radius: 10px;
    
}

h1 {
    color: #333;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
    
}

th, td {
    padding: 10px;
    border-bottom: 1px solid #ddd;
    text-align: left;
}

input[type="text"], textarea {
    width: 100%;
    padding: 8px;
    border: 1px solid #black;
    border-radius: 5px;
    box-sizing: border-box;
    margin-bottom: 10px;
    
}

input[type="submit"], input[type="reset"], input[type="button"] {
    padding: 10px 20px;
    width:130px;
    height:40px;
    background-color: #fff;
    color: black;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin-right: 10px;
    font-weight:bold;
}

input[type="submit"]:hover, input[type="reset"]:hover, input[type="button"]:hover {
        background-color: #A6A6A6;
}

.input-error {
    border-color: red;
}
#text1{
background-color: #BDBDBD;
font-weight:bold;
}
</style>
</head>
<header>
      <jsp:include page="../Header.jsp"></jsp:include>
</header>

<body>
<section>
    <div id="wrap" align="center">
      <h1>게시글 등록</h1>
      <form name="frm" method="post" action="OttServlet">
         <input type="hidden" name="command" value="bulletin_write">
          <input type="hidden" name="contentNum" value="${contentNum}">
         <table>
            <tr>
               <th>작성자</th>
               <td><input type="text" id="text1"name="name" value="${member.name }" readonly style="border:none;"></td>
            </tr>
            <tr>
               <th>아이디</th>
               <td><input class="id-input" id="text1" type="text" name="userId" value="${member.userId}" readonly style="border:none;"></td>
            </tr>
            <tr>
               <th>제목</th>
               <td><input type="text" size="70" name="bulletinTitle"> * 필수</td>
            </tr>
            <tr>
               <th>내용</th>
               <td><textarea cols="70" rows="15" name="bulletinContent"></textarea></td>
            </tr>
         </table>
         <br>
         <br> 
            <input type="submit" value="등록" onclick="if(!confirm('등록하시겠습니까?')){return false;}"> 
            <input type="reset" value="다시 작성"> 
            <input type="button" value="목록" onclick="location.href='OttServlet?command=admin_content_detail&contentNum=${contentNum}'">
      </form>
   </div>
   </section>
   <footer>
   <jsp:include page="../Footer.jsp"></jsp:include>
</footer>
</body>

</html>
