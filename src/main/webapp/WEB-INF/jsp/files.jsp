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
    <title>Files</title>
</head>
<body>
    <h2>Uploaded files</h2>
    <c:if test="${folder!=null}">
        <h3>Folder: ${folder}</h3>
    </c:if>


    <table>
        <c:forEach items="${files}" var="file">
            <tr>
                <td> - </td>
                <c:if test="${file.directory}">
                    <td><a href="files?folder=${file.name}">${file.name}</a></td>
                </c:if>
                <c:if test="${!file.directory}">
                    <td>${file.name}</td>
                </c:if>

                <td>${file.type}</td>
                <td>${file.date}</td>
                <td>${file.size}</td>
            </tr>
        </c:forEach>
    </table>
    <br />
    <p><a href="fileUpload">Upload New file</a></p>

</body>
</html>
