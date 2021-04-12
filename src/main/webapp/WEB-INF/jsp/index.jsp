<%--
  Created by IntelliJ IDEA.
  User: brianvermeer
  Date: 01/04/2021
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Spring MVC Demo APP</h1>
<form action="/springmvc/intro" method="post">
    <label for="user">What is your username:</label><br>
    <input type="text" id="user" name="user" value="John"><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
