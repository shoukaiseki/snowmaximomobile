package com.app.jfinal.service.wotodo.db;

import java.util.HashMap;
import java.util.Map;

import com.app.jfinal.service.workorder.db.WorkorderHandlerImpl;
import com.app.jfinal.service.wotodo.model.WorkToDo;


/** WorkTodoHandler
 * worktodo 处理类
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月14日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class WorkTodoHandler {
	
	@SuppressWarnings("serial")
	Map<String,NormalWorktodoService> classMap = new HashMap<String,NormalWorktodoService>(){
		{
			put("WOTRACK",new WorkorderHandlerImpl());
		}
	};
	
	/**
	 * 处理待办任务的方法，返回object类型
	 * @param workToDo
	 * @return
	 */
	public  WorkToDo handWorkTodo(WorkToDo workToDo){
		String appName = workToDo.getApp(); 
		NormalWorktodoService handler =classMap.get(appName) ; 
		//处理对象
		if(handler!=null){
			Object task = handler.getTask(workToDo) ; 
			workToDo.setTask(task); 
		}
		return workToDo ; 
	}
	
	/**
	 * 数据上传成功后
	 * 更新服务器状态
	 */
	public void uploadResult(WorkToDo workTodo){
		String appName=workTodo.getApp();
		NormalWorktodoService handler=classMap.get(appName) ; 
		if(handler!=null){
//			handler.
		}
		
	}
}
