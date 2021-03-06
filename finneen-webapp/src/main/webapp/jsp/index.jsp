<%--
  Created by IntelliJ IDEA.
  User: Finneen
  Date: 2015/1/19
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/commons/taglibs.jspf" %>
<html>
<head>
    <title>index</title>
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
                <%--<div id="tree1" class="tree"></div>--%>
                <ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
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
      <%--<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>--%>
      <script type="text/javascript">
        var $assets = "assets";//this will be used in fuelux.tree-sampledata.js
      </script>

      <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
  </div><!-- /.row -->

</div>

  <script src="${ctx}/resources/js/tree.js"></script>
</body>
</html>
