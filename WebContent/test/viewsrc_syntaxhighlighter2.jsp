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
	<script type="text/javascript" src="<%=basePath%>js/syntaxhighlighter2/scripts/shCore.js?ver=2.1.364"></script>
	<script type="text/javascript" src="<%=basePath%>js/syntaxhighlighter2/scripts/shBrushJava.js?ver=2.1.364"></script>

	
	
<script type='text/javascript'>
	var url="<%=basePath%>";
	(function(){
		var corecss = document.createElement('link');
		var themecss = document.createElement('link');
		var corecssurl = url+"js/syntaxhighlighter2/styles/shCore.css?ver=2.1.364";
		if ( corecss.setAttribute ) {
				corecss.setAttribute( "rel", "stylesheet" );
				corecss.setAttribute( "type", "text/css" );
				corecss.setAttribute( "href", corecssurl );
		} else {
				corecss.rel = "stylesheet";
				corecss.href = corecssurl;
		}
		document.getElementsByTagName("head")[0].insertBefore( corecss, document.getElementById("syntaxhighlighteranchor") );
		var themecssurl = url+"js/syntaxhighlighter2/styles/shThemeEmacs.css?ver=2.1.364";
		if ( themecss.setAttribute ) {
				themecss.setAttribute( "rel", "stylesheet" );
				themecss.setAttribute( "type", "text/css" );
				themecss.setAttribute( "href", themecssurl );
		} else {
				themecss.rel = "stylesheet";
				themecss.href = themecssurl;
		}
		//document.getElementById("syntaxhighlighteranchor").appendChild(themecss);
		document.getElementsByTagName("head")[0].insertBefore( themecss, document.getElementById("syntaxhighlighteranchor") );
	})();
	SyntaxHighlighter.config.clipboardSwf = url+'js/syntaxhighlighter2/scripts/clipboard.swf';
	SyntaxHighlighter.config.strings.expandSource = 'show source';
	SyntaxHighlighter.config.strings.viewSource = '查看源代码';
	SyntaxHighlighter.config.strings.copyToClipboard = '复制到剪贴板';
	SyntaxHighlighter.config.strings.copyToClipboardConfirmation = '代码现在在你的剪贴板';
	SyntaxHighlighter.config.strings.print = '打印';
	SyntaxHighlighter.config.strings.help = '帮助';
	SyntaxHighlighter.config.strings.alert = 'SyntaxHighlighter\n\n';
	SyntaxHighlighter.config.strings.noBrush = '无法找到Brush：';
	SyntaxHighlighter.config.strings.brushNotHtmlScript = 'Brush不能设置 html-script选项';
	SyntaxHighlighter.defaults['pad-line-numbers'] = true;
	SyntaxHighlighter.all();
</script>
	
</head>
	${src}
	<br />
	${path}
	<br />
	
	
		

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
<pre class="brush: java;">
<script>
	${java}

</script>
</pre>

</html>

