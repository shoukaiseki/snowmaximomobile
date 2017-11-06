package com.app.jfinal.service.test;

import java.util.HashMap;

import com.google.common.collect.Maps;

public class NullValue {
	
	public static void main(String[] args) {
		HashMap<Object, Object> map = Maps.newHashMap();
		map.put("a", null);
		map.put("b", "Null");
		
		for (Object string : map.keySet()) {
			System.out.println("key="+string+",value="+map.get(string));
		}
	}

}
