<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#area").change(function(){
			var data = $("#area").val();
			$.ajax('area/' + data, {
				type:'GET',
				dataType:'json',
				error : function(){
					alert('실패!!!');
				},
				success:function(data){
					// 자식모두 삭제
					$("select#areaid option").remove();
					// 자식추가
					for(i in data){
						$("select#areaid").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
					}
					$("#areaid").change(); // 메서드 호출
				}
			});
		});
		$("#areaid").change(function(){
			var data = $("#areaid").val();
			$.ajax('area2/' + data, {
				type:'GET',
				dataType:'json',
				error : function(){
					alert('실패!!!');
				},
				success:function(data){
					// 자식모두 삭제
					$("select#areaid2 option").remove();
					// 자식추가
					if(data==null || data.length==0){
						$("select#areaid2").append("<option>자치구 선택</option>");
					}else{
						for(i in data){
							$("select#areaid2").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
						}
						$("#areaid2").change();
					}
				}
			});
		});
		$("#areaid2").change(function(){
			var data1 = $("#area option:selected").text();
			var data2 = $("#areaid option:selected").text();
			var data3 = $("#areaid2 option:selected").text();
			if(data3!='자치구 선택'){
				// alert(data1 + ' ' + data2 + ' ' + data3);
				
			}
		});
	});
</script>
</head>
<body>
	<select name="area" id="area">
		<c:forEach var="vo" items="${list1 }">
			<option value="${vo.id }">${vo.name }</option>
		</c:forEach>
	</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<select name="areaid" id="areaid">
		<c:forEach var="vo" items="${list2 }">
			<option value="${vo.id }">${vo.name }</option>
		</c:forEach>
	</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<select name="areaid2" id="areaid2">
		<c:forEach var="vo" items="${list3 }">
			<option value="${vo.id }">${vo.name }</option>
		</c:forEach>
	</select>
	<hr /><br />
	<div id="result"></div>
</body>
</html>
