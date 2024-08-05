<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-31
  Time: 오전 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>EL 실습</h1>
    사용자 아이디: ${userid}<br>
    사용자 비밀번호: ${passwd}<br>

    ${login.name}/${login.passwd}
</body>
</html>
