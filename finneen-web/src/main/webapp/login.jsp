<%--
  Created by IntelliJ IDEA.
  User: yaofeng
  Date: 2014/12/10
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>login</title>
</head>
<body>
    <div class="error">${error}</div>
    <form action="" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit" value="登录">
    </form>
</body>
</html>
