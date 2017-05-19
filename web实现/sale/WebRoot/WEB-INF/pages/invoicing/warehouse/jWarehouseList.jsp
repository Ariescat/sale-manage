<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%>
<html>
<head>
</head>
<body>
<form name="icform" method="post">
<div>
	<ul class="nav nav-pills">
	  <li><a href="#" onclick="formSubmit('warehouseAction_tocreate','_self')"><img alt="add" src="${ctx }/img/add.png"></a></li>
	  <li><a href="#" onclick="formSubmit('warehouseAction_toupdate','_self')"><img alt="modify" src="${ctx }/img/modify.png"></a></li>
	  <li><a href="#" onclick="formSubmit('warehouseAction_delete','_self')"><img alt="delete" src="${ctx }/img/delete.png"></a></li>
	</ul>
</div>

<div>
	<h4>仓库信息:</h4>
	<div style="text-align:center; height: 40px">${links }</div> 
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th>
	      	<input type="checkbox" name="selid" onclick="checkAll('id',this)">
	      </th>
	      <th>序号</th>
	      <th>名称</th>
	    </tr>
	  </thead>
	 
	  <tbody>
	   	<c:forEach items="${results}" var="o" varStatus="status">
	    <tr>
	      <td style="width: 60px"><input type="checkbox" name="id" value="${o.id}"/></td>
	      <td>${status.index+1}</td>
	      <td>${o.name}</td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
</div>
</form>
</body>
</html>