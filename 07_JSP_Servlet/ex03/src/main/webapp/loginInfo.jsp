<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오전 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>로그인 입력 파라미터 출력</h1>
    <%
        String userid =request.getParameter("userid");
        String Password =request.getParameter("Password");
        String strAge = request.getParameter("age");
        int age = strAge != null ? Integer.parseInt(strAge) : -1;
    %>
    아이디값: <%= userid %>
    비밀번호: <%= Password%>
    나이: <%= age%>
</body>
</html>
