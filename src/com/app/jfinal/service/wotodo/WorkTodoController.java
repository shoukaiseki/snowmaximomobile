package com.app.jfinal.service.wotodo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.app.jfinal.service.wotodo.db.WorkTodoDB;
import com.app.jfinal.service.wotodo.db.WorkTodoHandler;
import com.app.jfinal.service.wotodo.model.WorkToDo;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.app.jfinal.service.lookup.model.SyncDate;
import org.shoukaiseki.jfinal.kernel.AbstractController;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;

public class WorkTodoController extends AbstractController{
	
	public static final String TAG = "worktodo";
	private WorkTodoDB workTodoDB = new WorkTodoDB();
	
	/**
	 * 查询待办任务条数
	 */
	public void queryworktodounsigncount(){
		initJsonModel();
		logger.debug("jm="+JSONObject.toJSONString(jm));
		int count = workTodoDB.getWorkTodoUnsignCount(jm.getParameters());
		SyncDate sd=new SyncDate();
		sd.setTiaoshu(count);
		jsonModel.addDatas(sd);
		jsonModel.setStatus(JsonModel.SUCCESS);
		render(jsonModel);
		
	}

	/**
	 * 查询指定 personid 的待办任务
	 */
	public void queryworktodounsignbypersonid(){
		initJsonModel();
		logger.debug("jm="+JSONObject.toJSONString(jm));
		
		String sql = SqlReadConfig.getSql("wotodo.queryworktodounsignbypersonid",jm.getParameters());
		
		List<Record> list = Db.find(sql);
		WorkToDo obj=null;
		WorkTodoHandler workTodoHandler = new WorkTodoHandler();
		int rownum=0;
		for (Record record : list) {
			rownum++;
			 obj= WorkToDo.Companion.recordTo(record,WorkToDo.class);
			 if(obj.getOwnerid()!=null){
				 workTodoHandler.handWorkTodo(obj);
			 }
			 jsonModel.addDatas( obj);
		}
		
		jsonModel.setStatus(JsonModel.SUCCESS);
		render(jsonModel);
		
	}
	
}
