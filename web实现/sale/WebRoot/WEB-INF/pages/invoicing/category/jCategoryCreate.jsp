<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%>
<html>
<head>
<script type="text/javascript">
    function getSelectValue(obj) {  
       	var sValue = obj.options[obj.options.selectedIndex].value; //这是取值  
       	var sText = obj.options[obj.options.selectedIndex].innerHTML; //这是取文本内容  
    	document.getElementById("selectValue").value = sValue;
    	//alert("sText:" + sText  + "，他的值为：" + sValue); 
    }  
</script>
</head>
<body>
<form action="icform" class="form-horizontal" role="form" method="post">
<div>
	<ul class="nav nav-pills">
	  <li><a href="#" onclick="formSubmit('warehouseAction_list','_self')"><img alt="add" src="${ctx }/img/back.png"></a></li>
	  <li><a href="#" onclick="formSubmit('categoryAction_insert','_self')"><img alt="modify" src="${ctx }/img/save.png"></a></li>
	</ul>
</div>

<div style="margin: 10px">
<div class="col-md-4" style="margin-top: 30px">

	<div class="form-group">
		<label for="firstname" class="col-md-3 control-label">分类名</label>
		<div class="col-md-9">
			<input type="text" class="form-control" id="firstname" 
				   name="name" placeholder="请输入分类名">
		</div>
	</div>
</div>
</div>
</form>
</body>
</html>