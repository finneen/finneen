<%--
  Created by IntelliJ IDEA.
  User: Finneen
  Date: 2015/1/19
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <%@include file="/WEB-INF/jsp/commons/taglibs.jspf" %>
    <%@include file="/WEB-INF/jsp/commons/import-css.jspf" %>
</head>
<body>
<div class="page-content">
  <div class="page-header">
    <h1>
      Treeview
      <small>
        <i class="icon-double-angle-right"></i>
        with selectable items(single &amp; multiple) and custom icons
      </small>
    </h1>
  </div><!-- /.page-header -->

  <div class="row">
    <div class="col-xs-12">
      <!-- PAGE CONTENT BEGINS -->

      <div class="row">
        <div class="col-sm-6">
          <div class="widget-box">
            <div class="widget-header header-color-blue2">
              <h4 class="lighter smaller">Choose Categories</h4>
            </div>

            <div class="widget-body">
              <div class="widget-main padding-8">
                <div id="tree1" class="tree"></div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-sm-6">
          <div class="widget-box">
            <div class="widget-header header-color-green2">
              <h4 class="lighter smaller">Browse Files</h4>
            </div>

            <div class="widget-body">
              <div class="widget-main padding-8">
                <div id="tree2" class="tree"></div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <script type="text/javascript">
        var $assets = "assets";//this will be used in fuelux.tree-sampledata.js
      </script>

      <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
  </div><!-- /.row -->
</div>

  <%@include file="/WEB-INF/jsp/commons/import-js.jspf" %>

  <script src="${ctx}/resources/assets/js/fuelux/fuelux.tree.min.js"></script>
  <script src="${ctx}/resources/js/tree.js"></script>
</body>
</html>
