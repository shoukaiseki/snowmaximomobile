package org.shoukaiseki.jfinal.kernel.utils;

import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Record;

public class RecordUtis {
	
	public static JSONObject toJsonObject(Record record){
		 JSONObject jsonObect = new JSONObject(); 
		
		if(record!=null){
			Map<String, Object> map = record.getColumns(); 
			for(Map.Entry<String, Object> entry: map.entrySet()){
				String key = entry.getKey().toLowerCase();
				jsonObect.put(key, entry.getValue()); 
			}
		}
		return jsonObect; 
	}
	
	public static JSONArray toJsonArray(List<Record> recordList){
		JSONArray jsonArray = new JSONArray();  
		for(int x=0;x<recordList.size();x++){
			jsonArray.add(toJsonObject(recordList.get(x))); 
		}
		return jsonArray; 
	}
}
