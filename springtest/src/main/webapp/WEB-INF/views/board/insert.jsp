<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>

<link href="<c:url value='/resources/css/summernote-bs4.min.css'></c:url>" rel="stylesheet">
<script src="<c:url value='/resources/js/summernote-bs4.min.js'></c:url>"></script>
 	<meta charset="UTF-8">
 	<title>게시글등록</title>
 </head>
 <body>
 	<h1>게시글 등록</h1>
 	<form action="<c:url value='/board/insert'></c:url>" method="post" id="insert"enctype="multipart/form-data">
 	<div class="form-group">
 		<label>타입:</label>
 		<select name="bo_bt_num" class="form-control">
 			<option value="0" style="color:white">게시판을 선택해라 뿅</option>
	 		<c:forEach items="${typeList}" var="i">
		 		<option value="${i.bt_num}">${i.bt_name}</option>
	 		</c:forEach>
 		</select>
 	</div>
 	
 	<div class="form-group">
 		<label>제목:</label>
 		<input type="text" name="bo_title" class="form-control">
 	</div>
 	<div class="form-group">
 		<label>내용:</label>
 		<textarea name="bo_content" class="form-control"></textarea>
 	</div>
 	
 	<div class="form-group">
 		<label>첨부파일:</label>
 		<input type="file" name="files" class="form-control">
 		<input type="file" name="files" class="form-control">
 		<input type="file" name="files" class="form-control">
 	</div>
 	<button class="btn btn-outline-success col-12 mb-2">게시글 등록</button>
 
 
 
 	</form>
 	<a class="btn btn-outline-primary" href="<c:url value='/board/list'></c:url>">목록</a>
 </body>
 <script>

 $('[name=bo_content]').summernote({
 	placeholder: '내용을 입력하세요.',
 	tabsize: 2,
 	height: 400
 });
 
	 
	 $('#insert').submit(function(){
		
		 let type = $("[name=bo_bt_num]").val();
		 if(type ==0){
			 alert('게시판을 선택하세요')
		 }
		 let title =$("[name=bo_title]").val();
		 if(title.trim().length==0){
			 alert('제목을 입력해주세요.')
			 return false;
		 }
		 if(content.trim().length==0){
			 alert('내용을 입력해주세요.')
			 return false;
		 }
 });
 </script>
 </html>