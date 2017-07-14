<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../base.jsp"%>
<html>
<head>
<script type="text/javascript">
function changeStyle(id) {
	var lis = document.getElementsByTagName("li");
	for(var i=0;i<lis.length;i++){
		lis[i].className = "";
	}
   	var obj = document.getElementById(id);
	obj.className = "active";
}
</script>
</head>
<body>
<div style="padding: 10px">
	<ul class="nav nav-pills nav-stacked">
		<li id="li1" class="active" onclick="changeStyle('li1')" ><a href="invoicing/saleAction_list" target="mainFrame">销售单</a></li>
		<li id="li2" onclick="changeStyle('li2')"><a href="invoicing/stockInAction_list" target="mainFrame">入库单</a></li>
		<li id="li3" onclick="changeStyle('li3')"><a href="invoicing/stockOutAction_list" target="mainFrame">出库单</a></li>
		<li id="li4" onclick="changeStyle('li4')"><a href="invoicing/warehouseAction_list" target="mainFrame">仓库管理</a></li>
		<li id="li5" onclick="changeStyle('li5')"><a href="invoicing/categoryAction_list" target="mainFrame">商品分类管理</a></li>
	</ul>
</div>
</body>
</html>