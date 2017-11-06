<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String sendurl=com.jfinal.kit.PropKit.get("snow.testclient.sendurl", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@ page contentType="text/html;charset=UTF-8" buffer="128kb" autoFlush="true" import="java.util.*" %><%
	//response.setHeader("Access-Control-Allow-Origin", "*");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "no-cache");

	java.util.Calendar cal=java.util.Calendar.getInstance();
	Date date=new Date();
	cal.setTime(date);
	cal.add(java.util.Calendar.DAY_OF_YEAR, -1);
	String startDate=new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	String endDate=new SimpleDateFormat("yyyy-MM-dd").format(date);

	String sql=null;
	String SelectTemplateSession=new Date().getTime()+"";
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
	
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/snow_icon.css">
	<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/shoukaiseki/logger-1.0.js"></script>
	
	<style type="text/css">
	
	</style>
	
	<script type="text/javascript">
		var jiekouname=null;
	</script>
	
</head>
<body  class="easyui-layout" >

	<div class="easyui-layout" style="width:100%;height:100%;">
			<!--
				<ul class="easyui-tree" data-options="url:'/dunanjfinal/testclient/tree_data1.json',method:'get',animate:true,dnd:true"></ul>
			-->
			<div data-options="region:'west',split:true" title="接口" style="width:180px;">
				<ul id="tree" class="easyui-tree" data-options="url:'/dunanjfinal/test/getnavigationtest',method:'get',animate:true,dnd:true"></ul>
			</div>
			<div class="easyui-layout" data-options="region:'center',split:true,title:'参数'" style="">
				<div  data-options="fit:true,border:false,plain:true" style="width:100%;height:100%">
					
						<table id="paras" class="easyui-datagrid"
								data-options="rownumbers:true,toolbar:toolbar,url:'',method:'get',singleSelect:true,fit:true,fitColumns:true
								,footer:'#ft'">
							<thead>
								<tr>
									<th data-options="field:'name'"  width="50%">参数</th>
									<th data-options="field:'value',editor:'text'" width="50%" >值</th>
								</tr>
							</thead>
						</table>
				</div>
			</div>
			<div data-options="region:'east',split:true" title="说明" style="width:50%;">
				<div style="padding:10px">
					<textarea id="setumei"  style='width:99%;height:99%'>使用说明</textarea>
				</div>
			</div>
			
			<div id="ft" style="padding:5px;height:auto">
				<div style="margin-bottom:5px">
					<a  class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:delete_prpo()">删除属性</a>
					<a  class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:add_page_prpo()">添加分页属性</a>
					<a  class="easyui-linkbutton" iconCls="snow-prev" plain="true" onclick="javascript:prev_page_prpo()">上一页</a>
					<a  class="easyui-linkbutton" iconCls="snow-next" plain="true" onclick="javascript:next_page_prpo()">下一页</a>
				</div>
			</div>
			
			<div data-options="region:'south',split:true,title:'调用返回数据',iconCls:'icon-ok',tools:[{
		iconCls:'icon-redo',
		handler:function(){$('#jsonerror_dialog').dialog('open');$('#jsonerror_dialog').window('center'); }
    },{
		iconCls:'icon-print',
		handler:function(){$('#datas_dialog').dialog('open');$('#datas_dialog').window('center'); }
    }]" style="height:60%">
				<input id="msgtext" class="easyui-textbox" data-options="multiline:true"   labelPosition="top" multiline="true" value="返回信息." style="width:100%;height:100%" >
					 
			</div> 
		</div>
	</div>
	<div id="jsonerror_dialog" class="easyui-dialog" title="错误信息" style="width:600px;height:400px;"
    data-options="iconCls:'icon-no',closed:true,resizable:true,modal:true,buttons: [{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){ 
$('#jsonerror_dialog').dialog('close');}}]">
		<textarea id="errorexception" style='width:99%;height:99%'>
		</textarea>
	</div>
	
	
	<div id="datas_dialog" class="easyui-dialog" title="数据" style="width:600px;height:400px;"
    data-options="iconCls:'icon-print',closed:true,resizable:true,modal:false,maximizable:true,buttons: [{
					text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){ 
					$('#datas_dialog').dialog('close');}}]">
				<div  data-options="fit:true,border:false,plain:true" style="width:100%;height:100%">
					
						<table id="datas" class="easyui-datagrid"
								data-options="width:'100%',height:'100%',rownumbers:true,url:'',method:'get',singleSelect:true,fit:true,fitColumns:true">
						</table>
				</div>
	</div>
	
</body>

<script type="text/javascript">

function delete_prpo(){
	var row = $('#paras').datagrid('getSelected');
	if (row) {
			 var rowIndex = $('#paras').datagrid('getRowIndex', row);
			 $('#paras').datagrid('deleteRow', rowIndex);  
	 }
}
function add_page_prpo(){
	$('#paras').datagrid('appendRow',
		{
			name: 'ms_rows',
			value: '10'
		}
	);
	$('#paras').datagrid('appendRow',
		{
			name: 'ms_page',
			value: '1'
		}
	);
}

function prev_page_prpo(){
		var rows = $("#paras").datagrid("getRows");
		$.each(rows,function(index,obj){
			if(obj.name=='ms_page'){
				obj.value=parseInt(obj.value)-1;
				if(obj.value==0){
					obj.value=1
				}
				$('#paras').datagrid('getChanges',' updated');
				$('#paras').datagrid('loadData',{total:0,rows});
				Logger.log(obj);
			}
		})		
}
function next_page_prpo(){
		var rows = $("#paras").datagrid("getRows");
		$.each(rows,function(index,obj){
			if(obj.name=='ms_page'){
				obj.value=parseInt(obj.value)+1;
				$('#paras').datagrid('getChanges',' updated');
				$('#paras').datagrid('loadData',{total:0,rows});
				Logger.log(obj);
			}
		})		
}
	$(function(){
		//tree API 资料 http://www.jeasyui.com/documentation/tree.php
		$('#tree').tree({
			onDblClick: function(node){
				$('#paras').datagrid('loadData',{total:0,rows:[]});
				jiekouname=node;
				Logger.log(node);
				if(node.parameter!= undefined){
					//jquery 操作数组
					$.each(node.parameter,function(index,para){
						$('#paras').datagrid('appendRow',{
								name: para.name,
								value: para.value
							});
						Logger.log(para);
					})
				}
				var str=node.id+"<br>"+node.description;
				str=str.replace(/<br\/>/g, "\n").replace(/<\/br>/g, "\n").replace(/<br>/g, "\n");
				$("#setumei").html(str);
			}
		});

	
		Logger.log("asas啊啊");
		$.messager.progress({
						title:'请等待',
						msg:'正在加载数据...'
					});
					//'<%=basePath%>/testclient/datagrid_data1.json'
		$.ajax({
				method : 'GET',
				url : '<%=basePath%>/testclient/datagrid_data1.json',
				async : false,
				dataType : 'json',
				beforeSend : function(xhr) {
					//xhr.setRequestHeader('Authorization', 'Bearer ');
					//
					$.messager.progress({
						title:'请等待',
						msg:'正在加载数据............'
					});
				},
				success : function(jsondata) {
						Logger.log("jsondata="+jsondata);
						$('#paras').datagrid('appendRow',{
							name: 'new name',
							value: 30
						});
					for ( var machine in jsondata) {
						
					}
					 setTimeout(function(){$.messager.progress('close');},1000)
				},
				error : function() {
					setTimeout(function(){
					$.messager.progress('close');
					$.messager.alert('提示',"数据加载失败...",'error');
					},1000)
					
				}
			});

		
		
		
	}); 
		var toolbar = [{
            text:'发送测试',
            iconCls:'icon-tip',
            handler:function(){
				if(jiekouname==null){
					$.messager.alert('提示',"请先选择接口名称",'error');
				}
				
				$.messager.progress({
					title:'请等待',
					msg:'正在加载数据............'
				});
				Logger.log("发送测试按钮按下..");
				setTimeout(function(){

					var rows = $("#paras").datagrid("getRows");
					Logger.log("ajax接口名称=")
					Logger.log(jiekouname)
					$.each(rows,function(index,obj){
						Logger.log(obj);
						Logger.log(obj.name);
					})
					Logger.log(JSON.stringify(rows))
					$.ajax({
						method : 'GET',
						url : '<%=basePath%>test/testsend',
						async : false,
						dataType : 'json',
						data:{
							parameters:JSON.stringify(rows),
							asus:"华硕电脑",
							jiekouurl:"<%=sendurl%>"+jiekouname.id,
							jiekouurlid:jiekouname.id
						},
						beforeSend : function(xhr) {
							//xhr.setRequestHeader('Authorization', 'Bearer ');
							//
						},
						success : function(jsondata) {
							Logger.log("jsondata=");
							Logger.log(jsondata);
							//JSON.stringify(jsondata)
							var jsonstr = JSON.stringify(jsondata)
							$("#msgtext").textbox("setValue",jsonstr);
							Logger.log(jsondata.errorexception);
							try
							{
								//在此运行代码
								var datascolumns=[{
									field:'snow_rn',
									title:'snow_rn',
									width:'100',
									align:'right',
									sortable:true
								}];
								if(jsondata.columnNames != null || typeof(jsondata.columnNames) != 'undefined'){
									$.each(jsondata.columnNames,function(index,obj){
										datascolumns.push({
											field:obj.toLowerCase(),
											title:obj.toLowerCase(),
											width:'100',
											align:'right',
											sortable:true
										})
									});
									Logger.log(datascolumns);
									//Logger.log(JSON.stringify(datascolumns));

									$("#datas").datagrid({
										remoteSort: false,
										columns: [datascolumns]
									});
									var tbdatas=[];
									Logger.log(jsondata.data);
									for(var key in jsondata.data){
										//Logger.log("key:" + key + ",value:"+JSON.stringify(jsondata.data[key]));   
										//tbdatas.push(jsondata.data[key]);
										Logger.log("value:"+JSON.stringify(jsondata.data[key]));
										tbdatas.push(jsondata.data[key]);
									}
									$('#datas').datagrid('loadData',{total:0,rows:tbdatas});
									if(jsondata.snow_count>=0){
										$('#datas_dialog').panel("setTitle","数据:总共"+jsondata.snow_count);
									}

								}
							}
							catch(err)
							{
								Logger.log(err);//在此处理错误
							}

							//jsondata.errorexception;
							if(typeof(jsondata.errorexception)=="undefined"){ 
								$("#errorexception").val(jsondata);
							}else{
								$("#errorexception").val(jsondata.errorexception);
							}

							setTimeout(function(){$.messager.progress('close');},1000)
						},
						error : function() {
							setTimeout(function(){
								$.messager.progress('close');
								$.messager.alert('提示',"数据加载失败...",'error');
							},1000)

						}
					});
				},500);
			}
        },{text:'查看测试代码',
            iconCls:'icon-redo',
            handler:function(){
				if(jiekouname==null){
					$.messager.alert('提示',"请先选择接口名称",'error');
				}
				
				Logger.log("ajax接口名称=")
				Logger.log(jiekouname)
				window.open('<%=basePath%>test/viewsource?jiekouurl='+jiekouname.id)

			}
		},{text:'开发工具主页',
            iconCls:'icon-help',
            handler:function(){
				Logger.log("ajax接口名称=")
				Logger.log(jiekouname)
				window.open('<%=basePath%>utils/index.jsp')

			}
		}
		];
	/**
	,{
            text:'删除',
            iconCls:'icon-cut',
            handler:function(){
			}
        },'-',{
            text:'修改',
            iconCls:'icon-edit',
            handler:function(){
			}
        },'-',{
            text:'生成随机数据',
            iconCls:'icon-tip',
            handler:function(){
			}
        }
	**/
	/**
		 **/
		 		$.extend($.fn.datagrid.methods, {
			editCell: function(jq,param){
				return jq.each(function(){
					var opts = $(this).datagrid('options');
					var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor1 = col.editor;
						if (fields[i] != param.field){
							col.editor = null;
						}
					}
					$(this).datagrid('beginEdit', param.index);
                    var ed = $(this).datagrid('getEditor', param);
                    if (ed){
                        if ($(ed.target).hasClass('textbox-f')){
                            $(ed.target).textbox('textbox').focus();
                        } else {
                            $(ed.target).focus();
                        }
                    }
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor = col.editor1;
					}
				});
			},
            enableCellEditing: function(jq){
                return jq.each(function(){
                    var dg = $(this);
                    var opts = dg.datagrid('options');
                    opts.oldOnClickCell = opts.onClickCell;
                    opts.onClickCell = function(index, field){
                        if (opts.editIndex != undefined){
                            if (dg.datagrid('validateRow', opts.editIndex)){
                                dg.datagrid('endEdit', opts.editIndex);
                                opts.editIndex = undefined;
                            } else {
                                return;
                            }
                        }
                        dg.datagrid('selectRow', index).datagrid('editCell', {
                            index: index,
                            field: field
                        });
                        opts.editIndex = index;
                        opts.oldOnClickCell.call(this, index, field);
                    }
                });
            }
		});

	$(function(){
			$('#paras').datagrid().datagrid('enableCellEditing');
		})

	</script>
</html>
