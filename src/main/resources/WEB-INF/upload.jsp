<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/s"

      method="post" enctype="multipart/form-data">

    <p>上传用户：<input type="text" name="username"></p>

    <p>上传文件：<input type="file" name="file"></p>

    <p><input type="submit"></p>

</form>


</body>

</html>