<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/commons/taglibs.jspf"%>
<es:contentHeader title="cloudWeb"/>
<form id="springrain_sco_ajax_form"  method="POST"></form>
<%@include file="WEB-INF/jsp/commons/nav.jspf"%>
<div class="main-container" id="main-container">
	<%@include file="WEB-INF/jsp/commons/sidebar.jspf"%>
	<div class="page-content"  id="ajax_target">
		<p>Content here. <a class="alert" href="javascript:myprompt('sdfsdfsd');">Alert!</a></p>
		<a data-trigger="modal" href="${ctx}/system/org/tree" data-title="选择部门" class="btn">Launch demo modal</a>
	</div>
</div>


<es:contentFooter/>