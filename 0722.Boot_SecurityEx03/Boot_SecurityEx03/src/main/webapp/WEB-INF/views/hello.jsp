<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <title>회원 전용 페이지!!!</title>
    </head>
    <body>
    	<h1>회원 전용 페이지!!!</h1>
        <h1>반갑습니다. ${userName}님!!!</h1>
        <form action="logout" method="post">
            <input type="submit" value="로그아웃"/>
   	        <input type="button" onclick="location.href='/'" value="홈으로"/>
        </form>
    </body>
</html>