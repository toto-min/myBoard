<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8"); %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="${path}/resources/css/insert.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

    <form action="${path}/update" method="post" enctype="multipart/form-data">
        <table>
            <tbody>
                <tr>
                    <th>제목</th>
                    <td>
                    	
                        <input type="text" id="text" name="title" value="${boardDetail.title }">
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                        <textarea name="contents" id="">${boardDetail.contents}<c:if test="${not empty boardDetail.imagefileName}"><img src="${path}/preview?artNum=${boardDetail.articleNum}&file=${boardDetail.imagefileName}"></c:if></textarea>
                        <img id="preview" src="#"/>
                    </td>
                </tr>
            </tbody>
        </table>
        
        <a href="${path}/board" id="home">처음으로</a>
        <div class="fileupdate">
        <input type="file" id="imgup" name="imgfile" onChange="readURL(this);"/>
        <label for="imgup" id="fileup">파일선택</label>
        </div>
        <input type="submit" value="글쓰기" id="submit">
        <input type="hidden" value="${boardDetail.articleNum}" name="articleNum">
    </form>
    
    <script type="text/javascript">
    	
    	$('#imgup').onClick(function(){
    		if($('#preview').hide == true){
    			this.show();
    		}else{
    			this.hide();
    		}
    	});
    
    	function readURL(input){
    		if(input.files && input.files[0]){
    			var reader = new FileReader();
    			reader.onload = function(e){
    			$('#preview').attr('src', e.target.result).show();
    				
    			}
    			reader.readAsDataURL(input.files[0]);
    		}
    	}
    </script>
</body>
</html>