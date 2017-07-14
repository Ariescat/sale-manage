<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%>
<html>
<head>
<!-- <script type="text/javascript">
    function getSelectValue(obj) {  
       	var sValue = obj.options[obj.options.selectedIndex].value; //这是取值  
       	var sText = obj.options[obj.options.selectedIndex].innerHTML; //这是取文本内容  
    	document.getElementById("selectValue").value = sValue;
    	//alert("sText:" + sText  + "，他的值为：" + sValue); 
    }  
</script> -->
</head>
<body>
<form action="user/userAction_update" class="form-horizontal" role="form" method="post">
<div>
	<ul class="nav nav-pills">
	  <li><a href="#" onclick="formSubmit('userAction_list','_self')"><img alt="add" src="${ctx }/img/back.png"></a></li>
	  <li><a href="#" onclick="formSubmit('userAction_update','_self')"><img alt="modify" src="${ctx }/img/save.png"></a></li>
	</ul>
</div>

<!-- 隐藏域 userid -->
<input type="hidden" name="id" value="${id }">

<div style="margin: 10px">
<div class="col-md-4" style="margin-top: 30px">
	<div class="form-group">
		<label for="firstname" class="col-md-2 control-label">昵称</label>
		<div class="col-md-10">
			<input type="text" class="form-control" id="firstname" 
				   name="name" placeholder="请输入昵称" value="${name }">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-md-2 control-label">密码</label>
		<div class="col-md-10">
			<input type="password" class="form-control" id="lastname" 
				   name="password" placeholder="请输入密码" value="${password }">
		</div>
	</div>
	<div class="form-group">
		<input type="hidden" id="selectValue" name="identity" value="${identity }">
		<label class="col-md-2 control-label">身份</label>
		<div class="col-md-10">
			<s:select cssClass="form-control" name="role.id" list="#roles" headerKey="" headerValue="--请选择--" listKey="id" listValue="name"></s:select>
			<!-- 身份标识:0代表普通用户，1代表管理员 -->
			<!-- <select id="identity" class="form-control" onchange="getSelectValue(this);"> 
				<option value="0">—— 请选择 ——</option> 
				<option value="1">普通用户</option> 
				<option value="2">销售人员</option> 
				<option value="3">库存人员</option> 
				<option value="4">超级管理员</option> 
			</select> --> 
		</div>
	</div>
</div>
</div>
</form>
</body>
</html>