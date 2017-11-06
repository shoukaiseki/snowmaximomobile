<%@ page language="java" import="java.util.*,java.net.URL,java.io.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	String contentType = request.getContentType();		
	System.out.println("contentType="+contentType);

	String strMessage="";
	StringBuffer buffer = new StringBuffer();
	BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
	while ((strMessage = reader.readLine()) != null) {
		buffer.append(strMessage);
	}
	System.out.println("buffer="+buffer.toString());

	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>snow</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta property="qc:admins" content="4746776325477164510063757" >
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    snow <br>
    JVM版本= <%=System.getProperty("java.version", "not specified")%><br>
    JVM缺省路径=<%=System.getProperty("java.home", "not specified")%>
    <br />
    <%=buffer.toString()%>
  </body>
</html>
