<%--
  Created by IntelliJ IDEA.
  User: sunnylinner
  Date: 2016/9/25
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html:charset=UTF-8">
    <title>处理结果</title>
</head>
<body>
<table width="99%" align="center">
    <s:iterator value="picInfo">
    <tr>
        <td width="50%"><img
                src='${pageContext.request.contextPath}<s:property value="imageURL"/>' width="350" />
        </td>
        <td width="50%"></td>
        <td width="50%"><img
                src='${pageContext.request.contextPath}<s:property value="logoImageURL"/>' width="350" />
        </td>
        <td width="50%"></td>
    </tr>
    </s:iterator>
</table>
</body>
</html>
