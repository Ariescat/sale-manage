<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%>
<html>
<head>
<script>
	 var count;
     function isOnlyChecked(){
    	 var checkBoxArray = document.getElementsByName('goodId');
			count=0;
			for(var index=0; index<checkBoxArray.length; index++) {
				if (checkBoxArray[index].checked) {
					count++;
				}	
			}
		//jquery
		//var count = $("[input name='id']:checked").size();
		if(count==1)
			return true;
		else
			return false;
     }
     function deleteById(){
     	 isOnlyChecked();
    	 if(count > 0){
    	 	 alert("确认删除？");
    		 formSubmit('stockOutAction_deleteStockGood_fromUpdate','_self');
    	 }else{
    		 alert("请先选择一项并且只能选择一项，再进行操作！");
    	 }
     }
     //实现更新
     function toUpdate(){
    	 if(isOnlyChecked()){
    		 formSubmit('stockOutAction_toupdate','_self')
    	 }else{
    		 alert("请先选择一项并且只能选择一项，再进行操作！");
    	 }
     }
</script>
</head>
<body>
<form action="invoicing/saleAction_addOneGood" class="form-horizontal" role="form" method="post">
<div>
	<ul class="nav nav-pills">
	  <li><a href="#" onclick="formSubmit('stockOutAction_list','_self')"><img alt="add" src="${ctx }/img/back.png"></a></li>
	  <li><a href="#" onclick="formSubmit('stockOutAction_addOneGood','_self')"><img alt="add" src="${ctx }/img/add.png"></a></li>
	  <li><a href="#" onclick="javascript:deleteById()"><img alt="add" src="${ctx }/img/delete.png"></a></li>
	</ul>
</div>

<!-- 隐藏域 -->
<input type="hidden" name="id" value="${id }">

<div style="margin: 10px">

<div>
	<div class="col-md-5"><h5>该销售单下的货物:</h5></div>
	<div style="text-align:center; height: 40px;">${links }</div>
	<div style="margin-left: 10px">
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th>
	      	<input type="checkbox" name="selid" onclick="checkAll('goodId',this)">
	      </th>
	      <th>序号</th>
	      <th>商品名</th>
	      <th>商品数量</th>
	    </tr>
	  </thead>
	 
	  <tbody>
	   	<c:forEach items="${results }" var="o" varStatus="status">
	    <tr>
	      <td style="width: 60px"><input type="checkbox" name="goodId" value="${o.id}"/></td>
	      <td>${status.index+1}</td>
	      <td>${o.goodName}</td>
	      <td>${o.amount}</td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	</div>
</div>

</div>
</form>
</body>
</html>