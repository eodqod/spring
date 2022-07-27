<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Spring Security Example</title>
</head>
<body>
	<div style="height: 100px; padding:5px; border: 1px solid gray;">
	<c:if test="${not empty error or not empty logout}">
		<div style="width: 98%; padding:5px; border: 1px solid gray;">
			<c:if test="${not empty error}">없는 아이디 또는 비번이 틀립니다.</c:if>
			<c:if test="${not empty logout}">성공적으로 로그아웃 했습니다. </c:if>
		</div>
	</c:if>
	<form  action="/login" method="post">
		<div>
			<label> User Name : <input type="text" name="username" />
			</label>
		</div>
		<div>
			<label> Password: <input type="password" name="password" />
			</label>
		</div>
		<div>
			<input type="submit" value="로그인" />
		</div>
	</form>
	</div>
</body>
</html>