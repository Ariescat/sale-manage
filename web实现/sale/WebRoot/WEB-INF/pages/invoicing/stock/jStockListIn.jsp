<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%>
<html>
<head>
</head>
<body>
<form name="icform" method="post">
<div>
	<ul class="nav nav-pills">
	  <li><a href="#" onclick="formSubmit('stockAction_tocreate_fromIn','_self')"><img alt="add" src="${ctx }/img/add.png"></a></li>
	  <li><a href="#" onclick="formSubmit('stockAction_toupdate','_self')"><img alt="modify" src="${ctx }/img/modify.png"></a></li>
	  <li><a href="#" onclick="formSubmit('stockAction_delete','_self')"><img alt="delete" src="${ctx }/img/delete.png"></a></li>
	</ul>
</div>

<div>
	<h4>入库信息:</h4>
	<div style="text-align:center; height: 40px">${links }</div> 
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th>
	      	<input type="checkbox" name="selid" onclick="checkAll('id',this)">
	      </th>
	      <th>序号</th>
	      <th>入库单号</th>
	      <th>商品名称</th>
	      <th>入库数量</th>
	      <th>所属分类</th>
	      <th>所属仓库</th>
	      <th>经手人</th>
	    </tr>
	  </thead>
	 
	  <tbody>
	   	<c:forEach items="${results}" var="o" varStatus="status">
	    <tr>
	      <td style="width: 60px"><input type="checkbox" name="id" value="${o.id}"/></td>
	      <td>${status.index+1}</td>
	      <td>${o.id}</td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td>${o.handler.name}</td>
	    </tr>
	    <c:forEach items="${o.stockGoods }" var="sg" varStatus="status_sg">
	    <tr style="color: #007fff;">
	      <td style="width: 60px"><input type="hidden" value="${o.id}"/></td>
	      <td></td>
	      <td>${status_sg.index+1}</td>
	      <td>${sg.goodName }</td>
	      <td>${sg.amount }</td>
	      <td>${sg.good.category.name }</td>
	      <td>${sg.good.warehouse.name }</td>
	      <td></td>
	    </tr>
	    </c:forEach>
	    </c:forEach>
	  </tbody>
	</table>
</div>
</form>
</body>
</html>