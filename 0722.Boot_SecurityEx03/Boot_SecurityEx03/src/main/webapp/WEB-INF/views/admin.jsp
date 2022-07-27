<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <title>Hello World!</title>
    </head>
    <body>
        <h1>관리자 전용 페이지!!!</h1>
        <h1>반갑습니다. ${userName}님!!!</h1>
        <form action="logout" method="post">
            <input type="submit" value="로그아웃"/>
	        <input type="button" onclick="location.href='/'" value="홈으로"/>
        </form>
    </body>
</html>