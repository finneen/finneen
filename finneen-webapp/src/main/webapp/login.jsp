<%--
  Created by IntelliJ IDEA.
  User: yaofeng
  Date: 2014/12/10
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/commons/taglibs.jspf" %>
<es:contentHeader title="cloudWeb"/>

<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="icon-leaf green"></i>
                            <span class="white">云平台登录</span>
                        </h1>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee green"></i>
                                        请输入登录信息
                                    </h4>

                                    <div class="space-6"></div>

                                    <form id="login-form" method="post" action="/login">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" name="username"
                                                                   placeholder="用户名"/>
															<i class="icon-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" name="password"
                                                                   placeholder="密码"/>
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <div class="space"></div>

                                            <div class="clearfix">
                                                <label class="inline">
                                                    <input type="checkbox" class="ace" name="rememberMe"/>
                                                    <span class="lbl"> 记住我</span>
                                                </label>

                                                <button type="submit"
                                                        class="width-35 pull-right btn btn-sm btn-primary">
                                                    <i class="icon-key"></i>
                                                    登录
                                                </button>
                                            </div>

                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>

                                    <div class="social-or-login center">
                                        <span class="bigger-110">提示</span>
                                    </div>

                                    <div class="social-login center">
                                        如果忘记密码，请联系管理员
                                    </div>
                                </div>
                                <!-- /widget-main -->

                            </div>
                            <!-- /widget-body -->
                        </div>
                        <!-- /login-box -->

                    </div>
                    <!-- /position-relative -->
                </div>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
</div>
<!-- /.main-container -->

<es:contentFooter/>