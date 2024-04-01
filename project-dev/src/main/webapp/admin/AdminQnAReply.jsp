<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/InsertContent.css?after">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section>
<form action="OttServlet?command=admin_qna_reply">
	<div id="info" align="center">
            <hr>
         <table>
            <tr>
               <th>문의 답변 드립니다.</th>
            </tr> 
            <tr>
               <td><textarea cols="70" rows="15" name="replyContent"></textarea></td>
            </tr>
            <tr>
            	<td colspan="2">
            	</td>
            </tr>
         </table>
         <br>
         <br> <input type="submit" value="등록"> 
         <input type="reset" value="다시 작성">
		   </div>
      </form>
   </section>
</body>
</html>