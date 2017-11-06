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
    
    <title>登录日志</title>
	<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta charset="UTF-8"> 
	
	<script type="text/javascript" src="<%=basePath%>js/shoukaiseki/logger-1.0.js"></script>
	
	
	
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/metro/easyui.css">  
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/mobile.css">  
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">  
    <script type="text/javascript" src="<%=basePath%>js/easyui/jquery.min.js"></script>  
    <script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script> 
    <script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.mobile.js"></script> 

	
	<script type="text/javascript">

</script>
	<style type="text/css" media="all">

</style>
</head>
<body>
	 <table id="list-table" data-options="
	 header:'#hh',
	 singleSelect:true,
	 border:false,
	 fit:true,
	 fitColumns:false,
	 scrollbarSize:0,
	 nowrap:false">  

					<thead id="dataThead" data-asus="linuxasus">
						<tr>
							<th data-options="align:'center',field:'snow_rn',width:30"  >序号</th>
							<th data-options="align:'center',field:'loginid',width:80" >登陆人</th>
							<th data-options="align:'center',field:'brand',width:50" >系统定制商</th>
							<th data-options="align:'center',field:'version',width:50">版本号</th>
							<th data-options="align:'center',field:'model',width:80">系统名称</th>
							<th data-options="align:'center',field:'totalspace',width:70,formatter:function(value,row,index){return bytesToSize(value);}" >空间总容量</th>
							<th data-options="align:'center',field:'availablespace',width:70,formatter:function(value,row,index){return bytesToSize(value);}">剩余空间容量</th>
							<th data-options="align:'center',field:'totalmemory',width:70,formatter:function(value,row,index){return bytesToSize(value);}" >内存总容量</th>
							<th data-options="align:'center',field:'availmemory',width:70,formatter:function(value,row,index){return bytesToSize(value);}">内存可用容量</th>
							<th data-options="align:'center',field:'createdate',width:130,formatter:function(value,row,index){
								var newDate = new Date();
								newDate.setTime(value);
								return newDate.format('yyyy-MM-dd h:m:s');
								}" >创建时间</th>
							<th data-options="align:'center',field:'imei',width:130" >设备唯一编码</th>
							<th data-options="align:'center',field:'isandroid',width:30"  >安卓</th>
							<th data-options="align:'center',field:'remark',width:300,formatter:function(value,row,index){return value;}">备注</th>
						</tr>
					</thead>
				</table>
				<div id="hh">
					<div class="m-toolbar">
						<div class="m-title">登录日志</div>
					</div>
				</div>
</body>
<script>

function bytesToSize(bytes) {  
　　if (bytes === 0) return '0 B';
　　var k = 1024;
　　sizes = ['B','KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
　　i = Math.floor(Math.log(bytes) / Math.log(k))　　
　　//return (bytes / Math.pow(k, i)) + ' ' + sizes[i];
　　return (bytes / Math.pow(k, i)).toPrecision(3) + ' ' + sizes[i];
　　//toPrecision(3) 后面保留两位小数，如1.00GB  
} 
Date.prototype.format = function(format) {
       var date = {
              "M+": this.getMonth() + 1,
              "d+": this.getDate(),
              "h+": this.getHours(),
              "m+": this.getMinutes(),
              "s+": this.getSeconds(),
              "q+": Math.floor((this.getMonth() + 3) / 3),
              "S+": this.getMilliseconds()
       };
       if (/(y+)/i.test(format)) {
              format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
       }
       for (var k in date) {
              if (new RegExp("(" + k + ")").test(format)) {
                     format = format.replace(RegExp.$1, RegExp.$1.length == 1
                            ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
              }
       }
       return format;
}

var fenye_page=1;
var fenye_rows=20;
var baseurl='<%=basePath%>utils/getphoneversiondata';
function loaddata () {
	Logger.log("loaddata---fenye_page="+fenye_page+",fenye_rows="+fenye_rows);
	$.messager.progress({
			title:'请等待',
			msg:'正在加载数据............'
	});
	$.ajax({
				method : 'GET',
				url : baseurl,
				async : false,
				dataType : 'json',
				data:{
					page:fenye_page,
					rows:fenye_rows,
					asus:"华硕电脑"
				},
				beforeSend : function(xhr) {
					
				},
				success : function(jsonstr) {
					var jsondata=jsonstr;//eval("("+jsonstr+")")
					Logger.log(jsondata);
					Logger.log("jsondata="+jsondata.columns);
					Logger.log("jsondata.rows="+jsondata.rows);
					for(var i=0,l=jsondata.rows.length;i<l;i++){
						/**
						Logger.log("jsondata.rows.i=");
						Logger.log(jsondata.rows[i]);
						Logger.log("count="+$("#list-table").datagrid("getRows"));
						**/
					
						//$("#list-table").datagrid("appendRow", jsondata.rows[i]);
						$('#list-table').datagrid('appendRow',jsondata.rows[i]);
						
					}
					$.messager.progress('close');
				},
				error : function() {
					setTimeout(function(){
						$.messager.progress('close');
						$.messager.alert('提示',"数据加载失败...",'error');
						},1000)
				}
			});
}
//滚动条到达最顶部时会触发两次top=0的,故第二次才执行到达顶部方法
var topcishu=0;
		$(function(){
			
			$('#list-table').datagrid({
				data: []
			});
			loaddata();
			try{      
					  Logger.log("datagrid-body");
					  Logger.log($(".datagrid-body"));
                $(".datagrid-body").scroll(function(){   
					  Logger.log("datagrid-body2");
                      //Logger.log($(this)[0]); 
                      var sheight = $(this)[0].scrollHeight;    
                      var top=$(this)[0].scrollTop;    
                      var height=$(this).height();
                      //Logger.log('sheight='+sheight+",top="+top+",height="+height); 
                      if((top+height)+20==sheight){      
							fenye_page++;
							loaddata();         
                            Logger.log('滚动条到达底部');  
                        }else if(top==0){
							topcishu++;
							if(topcishu==1){
								/**
								fenye_rows=20;
								fenye_page=1;
								$('#list-table').datagrid('loadData', { total: 0, rows: [] }); 
								loaddata(); 
								**/			
								Logger.log('滚动条到达顶部');					
							}  
                        }else {    
                            //Logger.log('滚动条没有到达底部');    
							topcishu=0;
                        }    
                });    
            }    
            catch(e){    
                Logger.log(e);       
            } 
		});
	</script>
</html>

