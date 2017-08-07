<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload page</title>
</head>
<style>
  div.item img{
    width:100%
   }
  div#carousel-example-generic{
    width:80%;
    margin:0 auto;
  }
</style>
<script type="text/javascript" src = "js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src = "js/bootstrap.min.js"></script>
<body class="text-muted" style="text-align: center; ">
	<!-- 标题与副标题  -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="page-header">
		  <h1>英雄联盟LOL<small>英雄资料</small></h1>
		</div>
	</nav> 
	<!-- 轮播 -->
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="1000">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
	  </ol>
	  <div class="carousel-inner" role="listbox">
	    <div class="item active">
	      <img src="image/飞机.jpg" >
	      <div class="carousel-caption">
	                         飞机
	      </div>
	    </div>
	    <div class="item">
	            <img src="image/狐狸.jpg" >
	      <div class="carousel-caption">
	                          狐狸
	      </div>
	    </div>
	    <div class="item">
	            <img src="image/琴女.jpg" >
	      <div class="carousel-caption">
	                          琴女
	      </div>
	    </div>	 
	    <div class="item">
	            <img src="image/亚索.jpg" >
	      <div class="carousel-caption">
	                          亚索
	      </div>
	    </div>
	    
	    <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>		 
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>		 
		  </a>	 
	  </div>	 
	</div><br><br>
	
	<!--基本折叠-->
	<span>
		<button class="btn btn-block" style="width:20%;display:inline-block" type="button" data-toggle="collapse" href="#dota" aria-expanded="false" aria-controls="collapseExample">
		  Dota
		</button>
		<button class="btn btn-block" style="width:20%;margin-top:0px;display:inline-block" type="button" data-toggle="collapse" data-target="#lol" aria-expanded="false" aria-controls="collapseExample">
		  LOL
		</button><br><br>
	</span>
	<div class="collapse" id="dota">
	  	<div class="well">
			《DotA》（Defense of the Ancients），可以译作守护古树、守护遗迹、远古遗迹守卫， 是由暴雪公司出品即时战略游戏《魔兽争霸3》的一款多人即时对战、自定义地图，可支持10个人同时连线游戏，是暴雪公司官方认可的魔兽争霸的RPG地图。
	  	</div>
	</div> 
	<div class="collapse" id="lol">
	   <div class="well">
			《英雄联盟》（简称lol）是由美国Riot Games开发，中国大陆地区由腾讯游戏运营的网络游戏。
	  </div>
	</div>
	
	<!--面板折叠-->	 
	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
	  <div class="panel panel-default" >
	    <div class="panel-heading" role="tab" id="headingOne">
	      <h4 class="panel-title">
	        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
	          DOTA
	        </a>
	      </h4>
	    </div>
	    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
	      <div class="panel-body">
	       《DotA》（Defense of the Ancients），可以译作守护古树、守护遗迹、远古遗迹守卫， 是由暴雪公司出品即时战略游戏《魔兽争霸3》的一款多人即时对战、自定义地图，可支持10个人同时连线游戏，是暴雪公司官方认可的魔兽争霸的RPG地图。
	      </div>
	    </div>
	  </div>
	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="headingTwo">
	      <h4 class="panel-title">
	        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
	          LOL
	        </a>
	      </h4>
	    </div>
	    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
	      <div class="panel-body">
	《英雄联盟》（简称lol）是由美国Riot Games开发，中国大陆地区由腾讯游戏运营的网络游戏。
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 按钮、超大屏幕、鼠标悬停 -->
	<div class="jumbotron">
		<form action="uploadPhoto" method="post" enctype="multipart/form-data">
	 		 英雄名称: <input type="text" class="form-control" name="heroName" /> <br><br>
	 		 英雄血量: <input type="text" class="form-control" name="heroHp" /><br> <br>
	 		 英雄伤害: <input type="text" class="form-control" name="heroDamage" /><br><br> 
	    	 英雄头像: <br><br><input type="file" name="filepath" style="margin-left:600px"/><br><br>
	  		<input class="btn btn-primary" type="submit" value="上传">
		</form>
		<br><br>
		<button type="button" class="btn btn-block" onclick="window.location.href='showhero.jsp'" data-toggle="tooltip" data-placement="top" title="跳转至英雄详情页面">查询所有英雄</button>
	</div>
	
	<!-- 弹出框 -->
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
	 提问
	</button>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog">
	        <div class="modal-content">
	          <div class="modal-header">
	            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	            <h4 class="modal-title">提问</h4>
	          </div>
	          <div class="modal-body">
	            <p>问题描述</p>
	            <textarea class="form-control"></textarea>
	          </div>
	          <div class="modal-footer">
	            <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
	            <button class="btn btn-primary" type="button">提交</button>
	          </div>
	        </div>
	      </div>
	</div>
	<br><br> 
</body>
</html>
<jsp:include page="footer.jsp" />