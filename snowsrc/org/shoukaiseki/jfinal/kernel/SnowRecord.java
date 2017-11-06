package org.shoukaiseki.jfinal.kernel;

import java.util.Map;

import com.google.common.collect.Maps;
import com.jfinal.plugin.activerecord.Record;

public class SnowRecord extends Record {
	
	private Map<String, Object> columns=null;
	
	
	@Override
	public Map<String, Object> getColumns() {
		// TODO Auto-generated method stub
		if(columns==null){
			columns=Maps.newHashMap();	
		}
		return columns;
	}
}
