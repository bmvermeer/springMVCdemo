<html>
<head>
    <title>Spring MVC File Upload</title>
</head>
<body>

<h2>Submitted File</h2>
<table>
    <tr>
        <td>OriginalFileName :</td>
        <td>${file.originalFilename}</td>
    </tr>
    <tr>
        <td>Type :</td>
        <td>${file.contentType}</td>
    </tr>
</table>
<br />
<p><a href="files">All Files</a> | <a href="fileUpload">Upload New file</a></p>

</body>
</html>