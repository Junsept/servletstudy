<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Image page</title>
</head>
<body>
<%
	String filename = request.getParameter("filename"); 

%>
<p id="filename"><%=filename%></p>
<script type="text/javascript">
	var obj = new Image();
	obj.src = "res/image/"+document.getElementById("filename").innerHTML;
	obj.onload=function(){
	    document.getElementById("mypic").innerHTML="<img src='"+this.src+"' />";
	}
</script>
<div id="mypic">onloading……</div>
</body>
</html>