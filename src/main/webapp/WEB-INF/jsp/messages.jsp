<%--
  Created by IntelliJ IDEA.
  User: brianvermeer
  Date: 05/03/2021
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Messages</title>
</head>
<body>
    <h2>Messages</h2>

    <form action="/springmvc/insert" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>New message</td>
            </tr>
            <tr>
                <td><textarea id="text" name="text" rows="4" cols="50"></textarea></td>
            </tr>
            <tr>
                <td><input type="submit" value="Post new message" /></td>
            </tr>
        </table>
    </form>

    <hr/>

    <form action="/springmvc/search" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Search</td>
                <td><input type="text" name="text" /></td>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
    <br/>

    <table>
        <tr>
            <td></td>
            <td><h3>Message</h3></td>
            <td><h3>|</h3></td>
            <td><h3>User</h3></td>
        </tr>
        <c:forEach items="${messages}" var="message">
            <tr>
                <td> - </td>
                <td>${message.text}</td>
                <td></td>
                <td>${message.userId}</td>
            </tr>
        </c:forEach>
    </table>
    <br />
    <p><a href="fileUpload">New Message</a></p>

</body>
</html>
