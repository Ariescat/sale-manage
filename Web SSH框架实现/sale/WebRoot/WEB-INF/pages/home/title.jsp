<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../top.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>title</title>
<script type="text/javascript">
function changeStyle(id) {
	var lis = document.getElementsByTagName("li");
	for(var i=0;i<lis.length;i++){
		lis[i].className = "";
	}
   	var obj = document.getElementById(id);
	obj.className = "active";
}
/* 第一个参数为要该改变样式的id， 第二个参数为模块名*/
function toModule(id, moduleName){
	changeStyle(id);
	top.leftFrame.location.href = 'homeAction_toLeft.action?moduleName=' + moduleName;
	top.mainFrame.location.href = 'homeAction_toMain.action?moduleName=' + moduleName;
}
</script>
</head>
<body>
<div style="padding-left: 20px">
	<ul class="nav nav-tabs">
		<li id="li1" class="active" onclick="toModule('li1', 'home')"><a href="#">首页</a></li>
		<li id="li2" onclick="toModule('li2', 'goods')"><a href="#">基础数据</a></li>
		<li id="li3" onclick="toModule('li3', 'invoicing')"><a href="#">进销存管理</a></li>
		<li id="li4" onclick="toModule('li4', 'user')"><a href="#">用户管理</a></li>
	</ul>
</div>
</body>
</html>