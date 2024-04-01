<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>정보 수정</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 0;
    }
    h2 {
        text-align: center;
        margin-top: 30px;
        color: #333;
    }
    form {
        width: 600px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    table {
        width: 100%;
    }
    table td {
        padding: 10px;
    }
    input[type="text"],
    input[type="password"] {
        width: calc(100% - 20px);
        padding: 8px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }
    input[type="button"],
    input[type="submit"],
    input[type="reset"] {
        padding: 10px 20px;
        margin-top: 10px;
        border: none;
        border-radius: 3px;
        background-color: #368AFF;
        color: #fff;
        cursor: pointer;
    }
    input[type="button"]:hover,
    input[type="submit"]:hover,
    input[type="reset"]:hover {
        background-color: #1E67C5;
    }
    .message {
        text-align: center;
        color: #FF0000;
    }
</style>
</head>
<body>
    <h2>정보 수정</h2>
    <form action="OttServlet" method="post" name="frm">
        <input type="hidden" name="command" value="update_member">
        <table>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name" value="${member.name}" size="40" readonly></td>
            </tr>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="userId" id="userId" value="${member.userId}" size="40" readonly></td>
            </tr>
            <tr>
                <td>암 호 확인</td>
                <td><input type="password" name="pwd" size="20"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email" value="${member.email}" size="20"></td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td><input type="text" name="phone" value="${member.phone}" size="20"></td>
            </tr>
            <tr>
                <td>주소</td>
                <td>
                    <input type="text" id="sample6_address" name="address" value="${member.address}" size="50"><br>
                    <input type="text" name="detailAddress" id="sample6_detailAddress" placeholder="상세주소" size="25"><br>
                    <input type="button" onclick="sample6_execDaumPostcode()" value="주소 찾기">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="수정" onclick="return pwdCheck()">
                    <input type="reset" value="취소">
                </td>
            </tr>
            <tr>
                <td colspan="2" class="message">${message }</td>
            </tr>
        </table>
    </form>
    <script>
        function pwdCheck() {
            if (document.frm.pwd.value != ${member.pwd}) {
                alert("비밀번호가 일치하지 않습니다");
                return false;
            }
            if (document.frm.email.value == "") {
                alert("이메일을 작성해주세요.")
                return false;
            }
            if (document.frm.phone.value == "") {
                alert("전화번호를 입력해주세요.")
                return false;
            }
        }

        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    var addr = '';
                    var extraAddr = '';

                    if (data.userSelectedType === 'R') {
                        addr = data.roadAddress;
                    } else {
                        addr = data.jibunAddress;
                    }

                    if (data.userSelectedType === 'R') {
                        if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                            extraAddr += data.bname;
                        }
                        if (data.buildingName !== '' && data.apartment === 'Y') {
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                    } else {
                        document.getElementById("sample6_extraAddress").value = '';
                    }

                    document.getElementById("sample6_address").value = addr;
                    
                    document.getElementById("sample6_detailAddress").focus();
                }
            }).open();
        }
    </script>
</body>
</html>

                   