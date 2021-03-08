<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>File Upload Example</title>
</head>

<body>

<h2>Enter The File to Upload</h2>

<form action="/springmvc/uploadFile" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Select a file to upload</td>
                <td><input type="file" name="file" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
</form>
<br />
<p><a href="files">All Files</a></p>




</body>

</html>