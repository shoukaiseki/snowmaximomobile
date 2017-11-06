<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@ page contentType="text/html;charset=UTF-8" buffer="128kb" autoFlush="true" import="java.util.*" %><%
	//response.setHeader("Access-Control-Allow-Origin", "*");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "no-cache");

	response.setHeader("Access-Control-Allow-Origin", "*");
	%>

  <head>
    <base href="<%=basePath%>">
    
    <title>testclient</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="<%=basePath%>js/shoukaiseki/logger-1.0.js"></script>
	
	<link rel='stylesheet' type='text/css' href='<%=basePath%>js/highlight/styles/default.css'>
	<link rel='stylesheet' type='text/css' href='<%=basePath%>js/highlight/styles/monokai.css'>
	<script type="text/javascript" src="<%=basePath%>js/highlight/highlight.pack.js"></script>
	
	<script src="<%=basePath%>js/jquery-3.2.1.min.js"></script>

	
	
</head>
<!--
	${src}
	<br />
	${path}
	<br />
	-->
	
	
		

<!--font-size:1em;字体大小-->
<!--body style="background: white; font-family: Helvetica;font-size:1em;"-->
<!--<body style="background: #121212; font-family: #D0D0D0 ">-->
<body style="color:#d0d0d0;background: #121212; font-family: Helvetica ">

	<!--<script>-->
		<!--<h1>Hello SyntaxHighlighter </h1>-->
		<!--</script>-->
	<!--<h1>Hello SyntaxHighlighter-->
&nbsp; &nbsp;&nbsp;&nbsp;
<!--<font size="+1" color="BlueViolet">		開発:</font>-->
<font size="+2" color="#FF0000">蒋カイセキのホーム </font>
<font size="+2" color="#FF0000"><a href="http://sksweb.duapp.com/">http://sksweb.duapp.com/</a></font>
</h1>
<div style="color:#5fd7ff; background-color:#1C1C1C;" id="doc_file_fileName">&nbsp; &nbsp;&nbsp;&nbsp;</div>
<font>  </font>
<!--<font size="+1" color="#FF0000">双击代码区域为全选代码,之后可以Ctrl+C进行复制,进行一次全选之后如果想再次双击全选需点击非代码区域后,源码恢复高亮显示后才可再次使用</font>-->
<hr>

<script language='JavaScript'>
	//parent.frames['fairu'].document.getElementById('doc_file_fileName').innerHTML='&nbsp; &nbsp;&nbsp;&nbsp;統計總行:';
</script>
<!--pre class="brush: java; auto-links: false;gutter: bool;toolbar:bool;width:500"-->

<table width="100%"  align="left">

	<tr>
		<td colspan="3">
				<input id="copy_modelsrcmodelsnowtable" type="button" value="复制代码"/>
		</td>
	</tr>
	<tr>
		<td colspan="3">

			<pre id="modelsrcmodelsnowtable">
				<code class="java">
					${modelsnowtable}
				</code>
			</pre>
		</td>
	</tr>
	<tr>
		<td>
			<input id="copy_modelsrc" type="button" value="复制代码"/>
		</td>
		<td>
			<input id="copy_androidsrc" type="button" value="复制代码"/>
		</td>
		<td>
			<input id="copy_iossrc" type="button" value="复制代码"/>
		</td>
	</tr>
	<tr valign="top">
		<td width="30%">
			<pre id="modelsrc">
				<code class="java">
					${modelsrc}
				</code>
			</pre>
		</td>
		<td width="33%">
			<pre id="androidsrc">
				<code class="java">
				${androidsrc}
				</code>
			</pre>
		</td>
		<td width="34%">
			<pre id="iossrc">
				<code class="java">
				${iossrc}
				</code>
			</pre>
		</td>
	</tr>
</table>

<script type="text/javascript">
 hljs.initHighlightingOnLoad();
 // url 转向网页的地址  
 // name 网页名称，可为空  
 function openwindow(url,name,src)  
 {  
	 iWidth="750px";
	 iHeight="400px";
	 //window.screen.height获得屏幕的高，window.screen.width获得屏幕的宽  
	 var iTop = (window.screen.height-30-iHeight)/2; //获得窗口的垂直位置;  
	 var iLeft = (window.screen.width-10-iWidth)/2; //获得窗口的水平位置;  
	 myWindow=window.open(url,name,'height='+iHeight+',,innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');  
	 myWindow.document.write("<textarea style='width:99%;height:99%'>");
	 myWindow.document.write(src);
	 myWindow.document.write("</textarea>");

	 myWindow.focus();
 }  



 $(document).ready(function(){
	 $('#copy_iossrc').click(function() {
		 var src=$('#iossrc').text();
		 //Logger.log(src);
		 openwindow('','src',src);
	 });
	 $('#copy_androidsrc').click(function() {
		 var src=$('#androidsrc').text();
		 //Logger.log(src);
		 openwindow('','src',src);
	 });
	 $('#copy_modelsrc').click(function() {

		 var src=$('#modelsrc').text();
		 //Logger.log(src);
		 openwindow('','src',src);
	 });
	 $('#copy_modelsrcmodelsnowtable').click(function() {

		 var src=$('#modelsrcmodelsnowtable').text();
		 //Logger.log(src);
		 openwindow('','src',src);
	 });

	 Logger.log("click");
 });	

</script>


</html>

