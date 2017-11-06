package org.shoukaiseki.jfinal.kernel.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.Maps;

public class MapUtils {
	
	/** 将 map 中的 key 转换为小写
	 * @param map
	 */
	public static void keytoLowerCase(Map map) {
		// TODO Auto-generated method stub
		//所有 字段名  转小写
        Iterator<Map.Entry> it = map.entrySet().iterator();  
        HashMap tempmap = Maps.newHashMap();
        while(it.hasNext()){  
            Map.Entry entry=it.next();  
            Object keyobj=entry.getKey();  
            if(keyobj instanceof String){
            	String key=(String) keyobj;
            	if(!key.equals(key.toLowerCase())){  
            		tempmap.put(key.toLowerCase(), entry.getValue());
            		it.remove();
            	}  
            }
        }  		
        map.putAll(tempmap);

	}
	
	/** 将 map 中的 key 转换为大写
	 * @param map
	 */
	public static void keytoUpperCase(Map map) {
		// TODO Auto-generated method stub
		//所有 字段名  转小写
        Iterator<Map.Entry> it = map.entrySet().iterator();  
        HashMap tempmap = Maps.newHashMap();
        while(it.hasNext()){  
            Map.Entry entry=it.next();  
            Object keyobj=entry.getKey();  
            if(keyobj instanceof String){
            	String key=(String) keyobj;
            	if(!key.equals(key.toUpperCase())){  
            		tempmap.put(key.toUpperCase(), entry.getValue());
            		it.remove();
            	}  
            }
        }  		
        map.putAll(tempmap);

	}

}
