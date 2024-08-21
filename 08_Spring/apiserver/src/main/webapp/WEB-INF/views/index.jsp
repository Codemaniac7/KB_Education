<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-08-01
  Time: 오후 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>환영합니다.</h1>

    <sec:authorize access="isAnonymous()">
        <a href="/security/login">로그인</a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username" />
            <form action="/security/logout" method="post">
                <input type="hidden" name="{_csrf.parameterName}" value="{_csrf.token}" />
                <input type="submit" value="로그아웃" />
            </form>
    </sec:authorize>
</body>
</html>
