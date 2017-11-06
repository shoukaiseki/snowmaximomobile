package org.shoukaiseki.jfinal.kernel.http;

import java.util.HashMap;

/** org.shoukaiseki.jfinal.kernel.http.ErrorCode
 * 错误编码含义
 * @author 蒋カイセキ    Japan-Tokyo  2017年3月31日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class ErrorCode {
	
	public static HashMap<Integer,String> codemap;
	public static int NONE = 0;
	public static int DEFAERROR = 1;
	
	static{
		codemap=new HashMap<Integer, String>();
		codemap.put(NONE, "");
		codemap.put(1, "默认错误编码,请联系管理员");
		codemap.put(2, "getWebClient() 获取的值为空");
		codemap.put(3, "maximo正在维护中,请稍后再试");
		codemap.put(4, "版本号不能为空");
		codemap.put(5, "服务器获取最新版本信息失败");
		
		codemap.put(1000, "更新 AUTOKEY 失败,可能另外一个程序是否正在更新 AUTOKEY 表");
		
		
		
		codemap.put(3000, "必填字段为空");
		codemap.put(3001, "更新验证失败,{0}.{1}={2}的记录不存在/已删除");
		codemap.put(3002, "更新验证失败,记录已被更新,{0}.{1}={2}当前待更新记录.ROWSTAMP={3},最新ROWSTAMP={4}");
		codemap.put(3003, "验证保存权限时出错");
		codemap.put(3004, "记录没有保存权限:{0}");
		
		codemap.put(10000, "未知的错误,请联系管理员");
		
		codemap.put(10001, "未知的错误,请联系管理员");
		codemap.put(10002, "请联系管理员:SnowDb初始化Connection失败");
		codemap.put(10003, "严重的错误,请联系管理员");
		
		codemap.put(20000, "jsonmodeldata 为空");
		codemap.put(20001, "解码之后为空值");
		codemap.put(20002, "ms_id 不能为空");
		
		
		codemap.put(20100, "附件的 {0} 不能为空");
		codemap.put(20101, "保存附件时出现错误:{0}");

		//数据库操作错误
		codemap.put(30000, "snowDB.update.设置值出错.索引位:{0},字段名:{1}");
		codemap.put(30001, "snowDB.update.设置值出错.索引位:{0},字段值:{1}");

		codemap.put(90000, "maximo接口出现错误");

	}
	
	

	
}
