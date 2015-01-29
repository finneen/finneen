<%--
  Created by IntelliJ IDEA.
  User: Finneen
  Date: 2015/1/29
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<html>
<head>
    <title>SiteMesh example: <sitemesh:title /></title>
    <%@include file="/jsp/commons/taglibs.jspf" %>
    <%@include file="/jsp/commons/import-css.jspf" %>

    <sitemesh:head />
</head>
<body>
    <c:set var="ctx" value="${pageContext.servletContext.contextPath }" />
    <%@include file="/jsp/commons/import-js.jspf" %>
    <sitemesh:body/>
</body>
</html>
