<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../../top.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户登陆</title>
<script type="text/javascript">
    if(self.location!=top.location){
         top.location=self.location;
    }
</script>
</head>

<body>
<form action="login" class="form-horizontal" role="form" method="post">
	<div class="col-md-4 col-md-offset-4">
		<div class="col-md-9 col-md-offset-3">
			<h1 class="text-primary">&nbsp;销售管理系统</h1>
		</div>
		<div class="col-md-10 col-md-offset-3" style="margin-bottom: 20px">
			<h4>———— 用户登陆 ————</h4>
		</div>
		
		<div class="form-group">
			<label for="firstname" class="col-md-4 control-label">登录名：</label>
			<div class="col-md-8">
				<input type="text" class="form-control" name="name"
					placeholder="请输入名字">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-md-4 control-label">密&nbsp;&nbsp;&nbsp;码：</label>
			<div class="col-md-8">
				<input type="password" class="form-control" name="password"
					placeholder="请输入密码">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-10 col-md-offset-4">
				<div class="checkbox">
					<label><input type="checkbox"> 请记住我</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-3 col-md-offset-4 ">
				<button class="btn btn-default">注册</button>
			</div>
			<div class="col-md-3">
				<button type="submit" class="btn btn-default">登录</button>
			</div>
		</div>
	</div>
</form>
</body>
</html>