<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/18.0.0/classic/ckeditor.js"></script>	
<script type="text/javascript">
	$(function(){
		ClassicEditor
		.create( document.querySelector('#editor1'),{  // textarea의 id
			language: 'ko',        
			ckfinder: {
		        uploadUrl: 'ckeditor/upload5' // 내가 지정한 업로드 url (post로 요청감)
		    },
			image: {
            	resizeUnit: 'px'
        	}
		} )
		.catch( error => {
		    console.error( error );
		} );
	});
</script>
<style>
.ck-content .image.image_resized {
    display: block;
    box-sizing: border-box;
}

.ck-content .image.image_resized img {
    width: 100%;
}

.ck-content .image.image_resized > figcaption {
    display: block;
}
</style>
</head>
<body>
	<form action="ckeditor5UploadOk" method="post">
		<textarea name="editor1" id="editor1"></textarea>
		<br />
		<input type="submit" value="저장!!!">
	</form>
</body>
</html>