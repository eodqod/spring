<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body>
	<h1>Hello World!!!</h1>
	<hr />
	접속자 : ${userName }
	<hr />
	<a href="hello">회원 전용페이지 가기</a> 눌러봐~~~~
	<br />
	<a href="admin">관리자 전용페이지 가기</a> 눌러봐~~~~
	<br />
	<c:if test="${empty userName }">
		<button onclick="location.href='login'">로그인</button>
	</c:if>
	<c:if test="${not empty userName }">
		<form action="logout" method="post">
			<input type="submit" value="로그아웃" />
		</form>
	</c:if>
</body>
</html>