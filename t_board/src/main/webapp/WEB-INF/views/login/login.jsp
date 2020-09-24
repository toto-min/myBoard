<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
<link rel="stylesheet" href="${path}/resources/css/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <c:choose>
   <c:when test="${result =='loginFailed'}">
     <script>
    	 window.onload=function(){
         alert("아이디나 비밀번호가 틀립니다.다시 로그인 하세요!");
       }
     </script>
   </c:when>
</c:choose>
</head>
<body>
    <form action="${path}/login" method="POST" name="loginForm">
        <div id="login">
            <h2>로그인</h2>
            <div id="loginid">
                <ul>
                    <li>아이디 :</li>
                    <li>
                        <input type="text" name="id">
                    </li>
                </ul>
            </div>
            <div id="loginpw">
                <ul>
                    <li>비밀번호 : </li>
                    <li>
                        <input type="password" name="pw" id="">
                    </li>
                </ul>
            </div>
        </div>
        	<input type="submit" value="로그인" id="loginbtn">
    </form>
</body>
</html>