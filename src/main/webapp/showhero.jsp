<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/datagrid.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Hero</title>
</head>

<script type="text/javascript" src = "js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src = "js/bootstrap.min.js"></script>

<body style="text-align:center;">
<table id="table" ></table>
</body>
<script>
$(function(){
	$("#table").datagrid({
	   	fitColumns: true,
	   	border: true,
		striped: true,//交替颜色
		url: "showHero?action=query",
		type: "POST",
		pageSize: 10,
		columns: [[
			{ field: 'ck', checkbox: true },
			{
			 title:'英雄名',
			 field:'name',
			 width:120,
			 align: 'center' 
			},
			{
			 title:'血量', 
			 field:'hp',
			 width:120,
			 align: 'center'
			},
			{
			 title:'伤害', 
			 field:'damage',
			 width:120,
			 align: 'center' 
			},
			{
			 title:'头像', 
			 field:'imgsrc',
			 width:120,
			 align: 'center' ,
			 formatter:function(value,row,index){
				 return '<img height="50" width="100" class="img-rounded" src="/image/'+row.imgsrc+'" />';
			 }
			}		
		]]
	});
})
</script>
</html>