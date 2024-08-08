<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-08-06
  Time: 오전 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sample/exUploadPost" mehtod="post" enctype="multipart/form-data">
    <div><input type="file" name="files"></div>
    <div><input type="file" name="files"></div>
    <div><input type="file" name="files"></div>
    <div><input type="file" name="files"></div>
    <div><input type="file" name="files"></div>
    <div><input type="submit"></div>
</form>
</body>
</html>
