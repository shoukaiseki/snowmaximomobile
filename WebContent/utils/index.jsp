<%@ page language="java" import="java.util.*,java.net.URL" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>开发工具主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta property="qc:admins" content="4746776325477164510063757" >
	
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
	<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/shoukaiseki/logger-1.0.js"></script>
	
  </head>
  
  <body  class="easyui-layout" >

	<div style="margin:20px 0 20px 0;"></div>
	<a href="<%=basePath%>utils/viewsnowfieldprop" target="_blank" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:180px">查看字段信息</a>
	
	
	<div style="margin:20px 0 20px 0;"></div>
	<a href="<%=basePath%>utils/mobile/listphoneversion.jsp" target="_blank" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:180px">查看登录日志</a>
	<div style="margin:20px 0 40px 0;"></div>
	<p>根据表名生成 Model 类(包括android绑定sqlite字段)</p>
	<div style="margin-bottom:40px" >
		<input id="tablename" class="easyui-textbox" data-options="buttonText:'查看代码',prompt:'需要查找的对象名',
		onClickButton:function(){
					var v = $('#tablename').textbox('getValue');
					window.open('<%=basePath%>utils/viewmodelsrc?tablename='+v)
				}
		" style="width:250px;height:32px;"
		value='DA_WORKPD' >
	</div>
	
		<p>查看应用xml</p>
	<div style="margin-bottom:40px" >
		<input id="appname" class="easyui-textbox" data-options="buttonText:'查看代码',prompt:'需要查找的对象名',
		onClickButton:function(){
					var v = $('#appname').textbox('getValue');
					window.open('<%=basePath%>utils/viewmaxappxml?appname='+v)
				}
		" style="width:250px;height:32px;"
		value='WOTRACK' >
	</div>
	
	<div style="margin:20px 0 40px 0;"></div>
    JVM版本= <%=System.getProperty("java.version", "not specified")%><br>
    JVM缺省路径=<%=System.getProperty("java.home", "not specified")%>
	<br>
	java.version=<%=System.getProperty("java.version")%>
	<br>
	java.class.version=<%=System.getProperty("java.class.version")%>
	<br>
	Java 虚拟机中的内存总量=<%=Runtime.getRuntime().totalMemory()/1024/1024%>MB
	<br>
	Java 虚拟机试图使用的最大内存量=<%=Runtime.getRuntime().maxMemory()/1024/1024%>MB
	<br>
	Java 虚拟机中的空闲内存量=<%=Runtime.getRuntime().freeMemory()/1024/1024%>MB
	<br />
  </body>
</html>
