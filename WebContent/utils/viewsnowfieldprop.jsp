<%@ page language="java" import="java.util.*,java.text.*,org.shoukaiseki.jfinal.kernel.common.*,org.shoukaiseki.jfinal.kernel.model.*,com.wmc.dunanjfinal.service.common.model.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
		Map<String, HashMap<String, SnowFieldProp>> map = BaseModel.Companion.loadSnowfieldMap();
		Set<String> objecttreekey=new TreeSet<String>(map.keySet());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@ page contentType="text/html;charset=UTF-8" buffer="128kb" autoFlush="true" %>
<%@ page import="org.shoukaiseki.jfinal.kernel.maximo.model.Maxattributecfg" %>
<%
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
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
	<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/shoukaiseki/logger-1.0.js"></script>
	
	<style type="text/css">
		table
		{
		border-collapse: collapse;
		border-spacing: 0;
		margin-right: auto;
		margin-left: auto;
		width: 100%;
		}
		th, td
		{
		border: 1px solid #b5d6e6;
		font-size: 12px;
		font-weight: normal;
		text-align: center;
		vertical-align: middle;
		}
		th
		{
		background-color: Gray;font-size: 18px;
		}
		.paneltitlestyle .panel-title{
			
			height:30px;
			vertical-align:middle;
		}
	</style>
	<style> 
		.required{background:#FF9900;} 
		.defaultvalue{background:#00FF00;} 
	</style>
	
	
</head>
<body>
<table>
		<th>颜色</th>
		<th>说明</th>
		<th>颜色</th>
		<th>说明</th>
<tr>
	<td style="background:#006400" width="150px"></td>
	<td >Model 类包含的属性</td>
	<td style="background:#800080" width="150px"></td>
	<td >Model 类定义的主键</td>
</tr>

</table>


	<%
	for(String key:objecttreekey){
		HashMap<String,SnowFieldProp> ssmap =map.get(key);
	%>
	<!--
	maximizable:true, 最大化有问题,按钮隐藏
	-->
	<div id="p" class="easyui-panel" title=" <font size='6'><%=key%></font>" style="width:100%;padding:10px;"
				data-options="collapsible:true,headerCls:'paneltitlestyle',border:true,collapsed:true
				,tools:[{
    iconCls:'icon-redo',
    handler:function(){
		window.open('utils/viewclasssource?classkey=<%=key%>')
	}
    },{
    iconCls:'icon-tip',
    handler:function(){
		window.open('utils/viewdefaultvaluesource?classkey=<%=key%>')
		}
    }]"
				>
		<table>
		<th>序号</th>
		<th>字段名</th>
		<th>标题</th>
		<th>描述</th>
		<th>model必填</th>
		<th>max必填</th>
		<th>model默认值</th>
		<th>max默认值</th>
		<th>maxtype类型</th>
		<th>虚拟字段</th>
		<th>insert时忽略</th>
		<th>update时忽略</th>
	<tr>
		<td  colspan="12" style="background:#A9A9A9" align="center" valign="middle" >
		<!--
		-->
		 <font size="6"><a href="utils/viewclasssource?classkey=<%=key%>" target="view_window">查看对象代码</a></font>
		<font size="6"><%=key%> <a href="utils/viewdefaultvaluesource?classkey=<%=key%>" target="view_window">生成默认值代码</a></font>
		
		</td>
	</tr>
			<%
			int sn=0;
			Set<String> treekey=new TreeSet<String>(ssmap.keySet());
			for(Object sskey:treekey){
				sn++;
				SnowFieldProp sfp=ssmap.get(sskey);	
				boolean hasrequired=false;
				boolean hasdefval=false;
				String sfpRequired="<td></td>";
				if(sfp.isRequired()){
					sfpRequired="<td class='required'>true</td>";
					hasrequired=true;
				}
				String title="<td></td>";
				String description="<td></td>";
				String attname="<td >"+sskey+"</td>";
				String maxtype="<td></td>";
				String snowDefaultvalue="<td></td>";
				String required="<td></td>";
				String Defaultvalue="<td></td>";
				if(sfp.hasField()){
					attname="<td style='background:#006400'>"+sskey+"</td>";
				}
				if(sfp.isPrimary()){
					attname="<td style='background:#800080'>"+sskey+"</td>";
				}
				if(sfp.getSnowdefval()!=null){
					snowDefaultvalue="<td style='background:#00FF7F'>"+sfp.getSnowdefval()+"</td>";
					hasdefval=true;
				}
			%>
				<%
				if(sfp.hasMaxatt()){
					Maxattributecfg maxatt=sfp.outMaxatt();
					if(maxatt.getRequired()!=null&&maxatt.getRequired()){
						required="<td class='required'>true</td>";
						hasrequired=true;
					}else{
						required="<td style='background:#7FFFD4'>false</td>";
					}
					if(maxatt.getDefaultvalue()!=null){
						Defaultvalue="<td class='defaultvalue'>"+maxatt.getDefaultvalue()+"</td>";
						hasdefval=true;
					}
					title="<td width='121px'>"+maxatt.getTitle()+"</td>";
					description="<td width='240px'>"+maxatt.getRemarks()+"</td>";
					maxtype="<td>"+maxatt.getMaxtype()+"</td>";
				%>
		
				<%
				}else{
				%>
			
				<%
				}
				if(sfp.hasMaxatt()&&sfp.outMaxatt().getDefaultvalue()!=null){
				%>
				<%
				}else{
				%>
				<%
				}
				String persistent;
				if(!sfp.isPersistent()){
					persistent="<td style='background:#1E90FF'>true</td>";
				}else{
					persistent="<td></td>";
				}
				String insertignore;
				if(sfp.isInsertignore()){
					insertignore="<td style='background:#8A2BE2'>true</td>";
				}else{
					insertignore="<td></td>";
				}
				String updateignore;
				if(sfp.isUpdateignore()){
					updateignore="<td style='background:#FF00FF'>true</td>";
				}else{
					updateignore="<td></td>";
				}
					String trstype="";
					//必填字段且无默认值,也不是主键 显示红色
					if(hasrequired&&!hasdefval&&!sfp.isPrimary()){
						trstype="style='background:#FF0000'";
					}
				%>
				
			<tr <%=trstype%>>
				<td ><%=sn%></td>
				<%=attname%>
				<%=title%>
				<%=description%>
				<%=sfpRequired%>
				<%=required%>
				<%=snowDefaultvalue%>
				<%=Defaultvalue%>
				<%=maxtype%>
				<%=persistent%>
				<%=insertignore%>
				<%=updateignore%>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<%
	}
	%>
</body>
	
	
</html>

