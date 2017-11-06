package org.shoukaiseki.jfinal.kernel.sql.oracle;

import org.apache.log4j.Logger;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.logger.SnowLogger;
import org.shoukaiseki.jfinal.kernel.utils.TypeConversionUtils;

public class SqlPagingFormat {
	
	public static final Logger logger = SnowLogger.SQLLogger;
	
	
	/**
	 * @param sql
	 * @return 返回条数,如果为-2,则查询出错,sql有问题
	 */
	public static Long countFormat(String sql){
		StringBuffer sb=new StringBuffer("select count(*) value  from (");
		sb.append(sql);
		sb.append(") a1 ");
		logger.debug("sql="+sb.toString());
		Record record = Db.findFirst(sb.toString());
		if(record!=null){
			return TypeConversionUtils.longByObject(record.get("VALUE"));
		}
		
		return -2L;
	}
	
	
	/** 格式化成分页语句
	 * @param inrows
	 * @param inpage
	 * @param sql
	 * @param jsonModel 如果不为空,而且为第一页,则获取该sql所能获取的行数设置 jsonModel.datacount ,,如果为空,则不作处理
	 * @return
	 */
	public static String pagingFormat(Integer inrows,Integer inpage,String sql,JsonModel jsonModel){
		Integer rows=inrows;
		Integer page=inpage;
		if(inpage==null){
			page=1;
		}
		if(inrows==null){
			rows=10;
		}
		
		if(page==1&&jsonModel!=null){
			jsonModel.setSnow_count(countFormat(sql));
		}else{
			//-1为没有进行条数查询
			jsonModel.setSnow_count(-1L);
		}
		
		StringBuffer sb=new StringBuffer("select * from (select a1.*,rownum snow_rn from (");
		sb.append(sql);
		sb.append(") a1 where rownum <=");
		sb.append(page*rows).append(") where snow_rn>").append((page-1)*rows);
		logger.debug("sql="+sb.toString());
		return sb.toString();
	}

}
