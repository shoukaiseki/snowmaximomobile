package com.app.jfinal.service.workorder.db;

import java.util.Map;

import com.app.jfinal.service.wotodo.model.WorkToDo;
import com.google.common.collect.Maps;
import com.app.jfinal.service.workorder.model.Workorder;
import com.app.jfinal.service.wotodo.db.NormalWorktodoService;
import org.shoukaiseki.jfinal.kernel.utils.StringUtils;

public class WorkorderHandlerImpl implements NormalWorktodoService {
	
	WorkorderDB workDB=new WorkorderDB();
			

	@Override
	public Object getTask(WorkToDo workToDo) {
		// TODO Auto-generated method stub
		Map<String, String> paras=Maps.newHashMap();
		paras.put("workorderid",StringUtils.numberFormat(workToDo.getOwnerid()));
		Workorder obj = workDB.findwotrackbywoid(paras);
		return obj;
	}

}
