<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-08-19
  Time: 오전 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>/security/admin page</h1>

<h2>
    username: <sec:authentication property="principal.username"></sec:authentication>
</h2>

<h2>
    email: <sec:authentication property="principal.member.email"></sec:authentication>
</h2>

<h2>
    mbti: <sec:authentication property="principal.member.mbti"></sec:authentication>
</h2>


<form action="/security/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="로그아웃"/>
</form>
</body>
</html>
