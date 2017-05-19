<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../base.jsp"%>
<html>
<head>
</head>
<body>
<form action="icform" class="form-horizontal"  method="post">
<div>
	<ul class="nav nav-pills">
	  <li><a href="#" onclick="formSubmit('goodAction_list','_self')"><img alt="add" src="${ctx }/img/back.png"></a></li>
	  <li><a href="#" onclick="formSubmit('goodAction_insert','_self')"><img alt="modify" src="${ctx }/img/save.png"></a></li>
	</ul>
</div>

<!-- 隐藏于：商品id -->
<input type="hidden" name="id" value="${id }">

<div style="margin: 10px">
<div class="col-md-6">
  <div class="form-group">
    <label class="col-md-2 control-label">商品名称</label>
    <div class="col-md-10">
      <input type="text" class="form-control" name="name" placeholder="请输入商品名称" value="${name }">
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">商品价格</label>
    <div class="col-md-10">
      <input type="text" class="form-control" name="price" placeholder="请输入商品价格" value="${price }">
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">所属分类</label>
    <div class="col-md-10">
      <s:select cssClass="form-control" name="category.id" list="#categorys" headerKey="" headerValue="--请选择--" listKey="id" listValue="name"></s:select>
      <!-- <input type="text" class="form-control" id="lastname" placeholder="请输入所属分类"> -->
    </div>
  </div>
</div>

<div class="col-md-6">
  <div class="form-group">
    <label class="col-md-2 control-label">商品产地</label>
    <div class="col-md-10">
      <input type="text" class="form-control" name="origin" placeholder="请输入商品产地" value="${origin }">
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">商品库存</label>
    <div class="col-md-10">
      <input type="text" class="form-control" name="stock" placeholder="请输入商品库存" value="${stock }">
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">所属仓库</label>
    <div class="col-md-10">
      <s:select cssClass="form-control" name="warehouse.id" list="#warehouses" headerKey="" headerValue="--请选择--" listKey="id" listValue="name"></s:select>
      <!-- <input type="text" class="form-control" id="lastname" placeholder="请输入所属仓库"> -->
    </div>
  </div>
</div>
</div>
</form>
</body>
</html>