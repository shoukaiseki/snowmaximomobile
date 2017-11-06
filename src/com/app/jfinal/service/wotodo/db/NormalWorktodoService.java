package com.app.jfinal.service.wotodo.db;

import com.app.jfinal.service.wotodo.model.WorkToDo;
import org.apache.log4j.Logger;

/** NormalWorktodoService
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月14日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public interface NormalWorktodoService {
	
	public static final Logger log = Logger.getLogger(NormalWorktodoService.class);
	
	/**
	 * 根据worktodo返回具体的业务对象
	 * @param workToDo
	 * @return
	 */
	public Object getTask(WorkToDo workToDo);
	
	/**
	 * 数据上传移动端返回服务器消息操作类
	 * @param workTodo
	 * @return
	 */
//	public boolean uploadRusult(WorkToDo workTodo);
	
}
