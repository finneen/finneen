<%--
  Created by IntelliJ IDEA.
  User: yaofeng
  Date: 2014/12/10
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


    <div id="login-page" class="container">
        <h1>登录</h1>
        <form id="login-form" method="post" class="well">
	        <input type="text" class="span2" name="username" placeholder="Email"><br>
	        <input type="password" class="span2" name="password" placeholder="Password"><br>
	        <label class="checkbox"> <input type="checkbox"  name="rememberMe"> 记住我 </label>
	        <button type="submit" class="btn btn-primary">登录</button>
	        <button type="submit" class="btn">忘记密码</button>
        </form>
    </div>
