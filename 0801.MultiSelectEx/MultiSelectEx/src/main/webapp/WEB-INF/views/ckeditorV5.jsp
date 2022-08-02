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
		ClassicEditor.create( document.querySelector( '#editor1' ) )
		.then( editor => {
            console.log( editor );
        } )
        .catch( error => {
                console.error( error );
        } );
	});
</script>
</head>
<body>
 <textarea id="editor1">이것은 연습용 내용입니다.</textarea>
</body>
</html>