package com.app.jfinal.service.wotodo.db;

import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;

public class WorkTodoDB {
	public static final Logger logger = Logger.getLogger(WorkTodoDB.class);

	/** 查询待办任务条数
	 * @param hashMap
	 * @return
	 */
	public int getWorkTodoUnsignCount(HashMap<String, String> hashMap) {
		String sql = SqlReadConfig.getSql("wotodo.listcountbypersonid",hashMap);
		Record record = Db.findFirst(sql);
		BigDecimal date = record.get("VALUE");
		return date.intValue();
	}
	
	/**
	 * 查询指定 personid 的待办任务
	 * @param user
	public  void queryWorkTodoUnsignByPersonid(HashMap<String, String> hashMap) {
		// TODO Auto-generated method stub
		String sql = SqlReadConfig.getSql("wotodo.queryworktodounsignbypersonid",hashMap);
		List<Record> list = Db.find(sql);
		WorkToDo obj=null;
		for (Record record : list) {
			 obj=WorkToDo.recordTo(record,WorkToDo.class);
		}

	}
	**/
}


