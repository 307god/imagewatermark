<%--
  Created by IntelliJ IDEA.
  User: sunnylinner
  Date: 2016/9/25
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html:charset=UTF-8">
    <title>上传图片</title>
  </head>
  <body>
  <h4>上传图片</h4>
  <hr/>
  <form name="form1"
        action="${pageContext.request.contextPath}/watermark.action"
        method="post"
        enctype="multipart/form-data">
    <input type="file" name="image"/>
    <input type="file" name="image"/>
    <input type="file" name="image"/>
    <input type="file" name="image"/>
    <input type="file" name="image"/>
    <input type="submit" value="上传图片"/>
  </form>
  <hr/>
  </body>
</html>
