<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/datagrid.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>

<script type="text/javascript" src = "js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src = "js/bootstrap.min.js"></script>

<body style="text-align:center;">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="page-header">
		  <h1>用户登录</h1>
		</div>
	</nav> 
	<div class="jumbotron" style="margin-top:120px">
		<form action="login" method="post" >
	 		 用户名: <input type="text" style="width:250px;margin:0 auto;" class="form-control" name="name" /> <br><br>
	 		 密码: <input type="password" style="width:250px;margin:0 auto;" class="form-control" name="password" /><br> <br>
	  		<input class="btn btn-primary" style="width:250px;margin:0 auto;" type="submit" value="登录">
		</form>
		<br><br>
	</div>
</body>

</html>