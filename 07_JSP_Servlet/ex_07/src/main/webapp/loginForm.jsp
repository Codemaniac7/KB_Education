
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Title</h1>
<form action="login" method="get">
    <fieldset>
        <legend>로그인 폼</legend>
        <ul>
            <li>
                <label for="userid">아이디</label>
                <input type="text" name="userid" id="userid">
            </li>
            <li>
                <label for="passwd">비밀번호</label>
                <input type="password" name="passwd" id="passwd">
            </li>
            <li><input type="submit" value="전송"></li>
        </ul>
    </fieldset>
</form>
</body>
</html>
