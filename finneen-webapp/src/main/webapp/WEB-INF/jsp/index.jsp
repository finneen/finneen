<%--
  Created by IntelliJ IDEA.
  User: Finneen
  Date: 2015/1/14
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/commons/taglibs.jspf"%>
<es:contentHeader title="cloudWeb"/>
<%@include file="/WEB-INF/jsp/commons/nav.jspf"%>
<div class="main-container" id="main-container">
  <%@include file="/WEB-INF/jsp/commons/sidebar.jspf"%>
  <div class="page-content"  id="ajax_target">
    <p>Content here. <a class="alert" href="javascript:myprompt('sdfsdfsd');">Alert!</a></p>
    <a data-trigger="modal" href="${ctx}/system/org/tree" data-title="选择部门" class="btn">Launch demo modal</a>
  </div>
</div>


<es:contentFooter/>
