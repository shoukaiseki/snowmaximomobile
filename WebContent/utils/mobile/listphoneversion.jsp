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
	
	
	<script type="text/javascript" src="<%=basePath%>js/iscroll/iscroll.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquerymobile/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquerymobile/jquery.mobile-1.4.5.js"></script>
	<!--
	<script type="text/javascript" src="<%=basePath%>js/jquerymobile/jquery.ba-throttle-debounce.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquerymobile/jquery.stickyheader.js"></script>
-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jquerymobile/jquery.mobile-1.4.5.css">  

	
	<script type="text/javascript">
var myScroll,
	pullDownEl, pullDownOffset,
	pullUpEl, pullUpOffset,
	generatedCount = 0;
/**
	* 下拉刷新 （自定义实现此方法）
	* myScroll.refresh();		// 数据加载完成后，调用界面更新方法
	*/
function pullDownAction () {
	setTimeout(function () {
		console.log("下拉刷新...");
		fenye_rows=20;
		fenye_page=1;
		$('#dataTbody').empty();
		loaddata();
		myScroll.refresh();		//数据加载完成后，调用界面更新方法   Remember to refresh when contents are loaded (ie: on ajax completion)
	}, 1000);
}
/**
	* 滚动翻页 （自定义实现此方法）
	* myScroll.refresh();		// 数据加载完成后，调用界面更新方法
	*/
function pullUpAction () {
	setTimeout(function () {	// <-- Simulate network congestion, remove setTimeout from production!
		console.log("上拉加载...");
		fenye_page++;
		loaddata();
		myScroll.refresh();		// 数据加载完成后，调用界面更新方法 Remember to refresh when contents are loaded (ie: on ajax completion)
	}, 1000);	// <-- Simulate network congestion, remove setTimeout from production!
}
/**
	* 初始化iScroll控件
	*/
$(function(){
	pullDownEl = document.getElementById('pullDown');
	pullUpEl = document.getElementById('pullUp');
	pullDownOffset = pullDownEl.offsetHeight;
	pullUpOffset = pullUpEl.offsetHeight;
	
	var id='list';
	var yLen=80;
	
	var hei=document.getElementById(id).maxScrollY;
	
	myScroll = new iScroll(id, {
		useTransition: false,
		topOffset: pullDownOffset,
		onRefresh: function () {
			if (pullDownEl.className.match('loading')) {
				pullDownEl.className = '';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
			} else if (pullUpEl.className.match('loading')) {
				pullUpEl.className = '';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
			}
		},
		onScrollMove: function () {
			if (this.y >= yLen && !pullDownEl.className.match('flip')) {
				pullDownEl.className = 'flip';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '松手开始更新...';
				this.minScrollY = 0;
			} else if (this.y < yLen && pullDownEl.className.match('flip')) {
				pullDownEl.className = '';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
				this.minScrollY = -pullDownOffset;
			}
			else if (this.y < (this.maxScrollY - yLen) && !pullUpEl.className.match('flip')) {
				pullUpEl.className = 'flip';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '松手开始更新...';
				this.maxScrollY = this.maxScrollY;
			} else if (this.y > (this.maxScrollY + yLen) && pullUpEl.className.match('flip')) {
				pullUpEl.className = '';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
				this.maxScrollY = pullUpOffset;
			}
			
		},
		onScrollEnd: function () {
			if (pullDownEl.className.match('flip')) {
				pullDownEl.className = 'loading';
				pullDownEl.querySelector('.pullDownLabel').innerHTML = '加载中...';				
				pullDownAction();	// Execute custom function (ajax call?)
			}
				else if (pullUpEl.className.match('flip')) {
				pullUpEl.className = 'loading';
				pullUpEl.querySelector('.pullUpLabel').innerHTML = '加载中...';				
				pullUpAction();	// Execute custom function (ajax call?)
			}
			
		}
	});
	
	setTimeout(function () { document.getElementById(id).style.left = '0'; }, 800);
});
</script>
	<style type="text/css" media="all">
/*需要修改的jquery mobile样式  */
.ui-table-columntoggle-btn {display:none;}
#list{
	position:absolute;
	top:5px;
	bottom:1px;
	width:100%;
}
/**
	*
	* 下拉样式 Pull down styles
	*
	*/
#pullDown, #pullUp {
	background:#fff;
	height:40px;
	line-height:40px;
	padding:5px 10px;
	border-bottom:1px solid #ccc;
	font-weight:bold;
	font-size:14px;
	color:#888;
}
#pullDown .pullDownIcon, #pullUp .pullUpIcon  {
	display:block; float:left;
	width:40px; height:40px;
	background:url(pull-icon@2x.png) 0 0 no-repeat;
	-webkit-background-size:40px 80px; background-size:40px 80px;
	-webkit-transition-property:-webkit-transform;
	-webkit-transition-duration:250ms;	
}
#pullDown .pullDownIcon {
	-webkit-transform:rotate(0deg) translateZ(0);
}
#pullUp .pullUpIcon  {
	-webkit-transform:rotate(-180deg) translateZ(0);
}
#pullDown.flip .pullDownIcon {
	-webkit-transform:rotate(-180deg) translateZ(0);
}
#pullUp.flip .pullUpIcon {
	-webkit-transform:rotate(0deg) translateZ(0);
}
#pullDown.loading .pullDownIcon, #pullUp.loading .pullUpIcon {
	background-position:0 100%;
	-webkit-transform:rotate(0deg) translateZ(0);
	-webkit-transition-duration:0ms;
	-webkit-animation-name:loading;
	-webkit-animation-duration:2s;
	-webkit-animation-iteration-count:infinite;
	-webkit-animation-timing-function:linear;
}
@-webkit-keyframes loading {
	from { -webkit-transform:rotate(0deg) translateZ(0); }
	to { -webkit-transform:rotate(360deg) translateZ(0); }
}
</style>
</head>
<body>
	<div id="listPage" data-role="page" data-theme="a" >
		<div class="myPage-header" data-role="header" data-position="fixed">
			<!-- <a class="A-BACK ui-link ui-btn ui-btn-a ui-icon-arrow-l ui-btn-icon-notext ui-btn-inline ui-shadow ui-corner-all" role="button" data-role="button" data-iconpos="notext" data-theme="a" data-inline="true" data-icon="arrow-l">返回</a> -->
			<!-- <h1 class="title" style="padding:1px">下拉刷新（上拉加载）</h1> -->
			<!-- <a class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-icon-gear ui-btn-icon-left ui-btn-a ui-btn-icon-notext" href="#ssjcPanel" style="margin-right:6px; margin-top:3px" data-transition="slideup">Actions...</a> -->
		</div>
		<div id="list" class="ui-content" role="main" style="padding:0px;">
			<div id="shishi" name="shishi"  class="listDiv"  style="overflow-x:auto;width:100%;">
				<div id="pullDown">
					<span class="pullDownIcon"></span>
					<span class="pullDownLabel">下拉刷新...</span>
				</div>
				<table data-role="table" id="list-table"  border="1" align="center"   data-filter="true" data-input="#filterTable-input" class="ui-responsive movie-list table-stroke responsive" data-mode="columntoggle" >
					<thead id="dataThead">
						<tr>
							<th data-snowfield="snow_rn" width="20px">序号</th>
							<th data-snowfield="loginid" width="20px">登陆人</th>
							<th data-snowfield="brand" width="50px">系统定制商</th>
							<th data-snowfield="version" width="50px">版本号</th>
							<th data-snowfield="model">系统名称</th>
							<th data-snowfield="totalspace" data-snowfieldtype="bytesize" width="70px">空间总容量</th>
							<th data-snowfield="availablespace" data-snowfieldtype="bytesize" width="70px">剩余空间容量</th>
							<th data-snowfield="totalmemory" data-snowfieldtype="bytesize" width="70px">内存总容量</th>
							<th data-snowfield="availmemory" data-snowfieldtype="bytesize" width="70px">内存可用容量</th>
							<th data-snowfield="createdate" data-snowfieldtype="datetime"  width="230px">创建时间</th>
							<th data-snowfield="imei" width="100px">设备唯一编码</th>
							<th data-snowfield="isandroid" width="10px">是否android系统</th>
							<th data-snowfield="remark" width="100px">备注</th>
						</tr>
					</thead>
					<tbody id="dataTbody">
						
					</tbody>
				</table>
				<div id="pullUp">
					<span class="pullUpIcon"></span>
					<span class="pullUpLabel">上拉加载更多...</span>
				</div>
			</div>
		</div>
		<!-- /content -->
	</div>
	<!-- /listPage -->
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
function loaddata () {
	Logger.log("loaddata---fenye_page="+fenye_page+",fenye_rows="+fenye_rows);
	$.ajax({
				method : 'GET',
				url : '<%=basePath%>utils/getphoneversiondata',
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
						var row = $("<tr></tr>"); 
						$('#list-table').find('th').each(function (thindex, thitem) { //遍历Table list-table 的th  
								var key=  $(thitem).data("snowfield") ;
								var value=jsondata.rows[i][key];
								//Logger.log(key+':'+jsondata.rows[i][key]);
								var td = $("<td></td>"); 
								if(value == undefined||typeof(value) == "undefined"||value==null){
									
								}else{
									var snowfieldtype=$(thitem).data("snowfieldtype");
									if("bytesize"==snowfieldtype){
										value=bytesToSize(value);
									}else if("datetime"==snowfieldtype){
										var newDate = new Date();
										newDate.setTime(value);
										value=newDate.format('yyyy-MM-dd h:m:s');
									}
									td.append(value);
								}
								row.append(td);
						});
						$("#list-table").append(row);
					}	
				},
				error : function() {
					
				}
			});
}

		$(function(){
			loaddata();
		});
	</script>
</html>

