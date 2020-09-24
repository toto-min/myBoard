<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<link rel="stylesheet" href="${path}/resources/css/join.css">
</head>
<body>
 
    <form action="${path}/join" method="post" name="joinForm">

        <h2>회원가입</h2>

        <div id="id">
            <ul>
                <li>아이디</li>
                <li>
                    <input type="text" name="id">
                </li>
            </ul>
        </div>
        <div id="pw">
            <ul>
                <li>비밀번호</li>
                <li>
                    <input type="password" name="pw" id="pw">
                </li>
            </ul>
        </div>
        <div id="pwchk">
            <ul>
                <li>비밀번호 확인</li>
                <li>
                    <input type="password" name="pwChek" id="pwchk" >
                </li>
            </ul>
        </div>
        <div id="name">
            <ul>
                <li>이름</li>
                <li>
                	<input type="text" name="name">
                </li>
            </ul>
        </div>

        <input type="submit" value="회원 가입하기" id="joinbtn">
    </form>
</body>
</html>