<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 조회</title>
<link rel="stylesheet" href="${path}/resources/css/main.css">
</head>
<body>

    <h3>글 목록</h3>
    <table>
        <tbody>
            <tr id="mainTop">
                <th class="num">글번호</th>
                <th class="title">제목</th>
                <th class="writer">글쓴이</th>
                <th class="hit">조회수</th>
                <th class="writeDate">작성일</th>
            </tr>
	        <c:forEach var="boardlist" items="${boardNum}">
	            <tr id="content">
	                <td class="num">${boardlist.articleNum}</td>
	                <td class="title">
                        <a href="${path}/board/detail?articleNum=${boardlist.articleNum}">
                        ${boardlist.title }
                        </a>
                    </td>
	                <td class="writer">${boardlist.writer}</td>
	                <td class="hit">${boardlist.hit }</td>
	                <td class="writeDate">${boardlist.writeDate }</td>
	            </tr>
	        </c:forEach>
        </tbody>
    </table>

	<c:choose>
	<c:when test="${isLogon == false || empty isLogon}">
    	<a href="${path}/board" id="insert" onClick="alert('로그인 해주세요');">글쓰기</a>
    </c:when>
    <c:otherwise>
    	<a href="${path}/insertForm" id="insert">글쓰기</a>
    </c:otherwise>
    </c:choose>
    <c:choose>
    <c:when test="${isLogon==true}">
    	<a href="${path}/logout" id="logout">로그아웃</a>
    </c:when>
    <c:otherwise>
    	<a href="${path}/loginForm" id="login">로그인</a>
    </c:otherwise>
    </c:choose>
    <a href="${path}/joinForm" id="join">회원가입</a>

</body>
</html> 