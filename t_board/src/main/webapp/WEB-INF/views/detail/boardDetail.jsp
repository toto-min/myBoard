<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<link rel="stylesheet" href="${path}/resources/css/detail.css">
</head>
<body>
	<form action="${path}/updateForm" method="post" enctype="multipart/form-data">
    <table>
        <tbody>
            <tr id="mainTop">
                <th class="num">${boardDetail.articleNum}</th>
                <th class="title"> ${boardDetail.title }
                	<input type="hidden" value="${boardDetail.title}" name="title">
                </th>
                <th class="writer">${boardDetail.writer }</th>
                <th class="hit">${boardDetail.hit }</th>
                <th class="writeDate">${boardDetail.writeDate }</th>
            </tr>
	            <tr id="contentDetail">
	                <td class="detail" colspan="5">
                        <input type="hidden" value="${boardDetail.contents}" name="contents">
                        ${boardDetail.contents}	
                        <c:if test="${not empty boardDetail.imagefileName}">
                        <img src="${path}/preview?artNum=${boardDetail.articleNum}&file=${boardDetail.imagefileName}">
                        </c:if>
                    </td>
	            </tr>
        </tbody>
    </table>
   
	<a href="${path}/delete?articleNum=${boardDetail.articleNum}&imgfile=${boardDetail.imagefileName}" id="delete">삭제</a>
	<button type="submit" id="updatepage">수정</button>
    <a href="${path}/board" id="home">처음으로</a>
    <input type="hidden" value="${boardDetail.articleNum}" name="articleNum">
 </form>
</body>
</html>