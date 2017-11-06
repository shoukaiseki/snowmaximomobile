package org.shoukaiseki.jfinal.kernel.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;

import java.util.HashMap;

public class ClassUtils {
	
	/** 获取所有字段,包括父类的字段
	 * @param cls
	 * @param fs
	 * @return
	 */
	public static List<Field> getFieldsAndSuper(Class<?> cls){
		List<Field> fields = new ArrayList<Field>();
		Class clsSup=cls;
		for (int i = 0; clsSup!=null; clsSup=clsSup.getSuperclass()) {
			fields.addAll(Arrays.asList(clsSup.getDeclaredFields()));
			fields.addAll(Arrays.asList(clsSup.getFields()));
		}
		
        return fields;
    }
	
	/**
	 *  获取所有字段,包括父类的字段
	 * @param cls 要查询的类名称
	 * @param endsuperclass 查询到该父类结束(包含该父类属性)
	 * @return
	 */
	public static List<Field> getFieldsAndToSuperStop(Class<?> cls,Class<?> endsuperclass){
		List<Field> fields = new ArrayList<Field>();
		Class clsSup=cls;
		for (int i = 0; clsSup!=null; clsSup=clsSup.getSuperclass()) {
			fields.addAll(Arrays.asList(clsSup.getDeclaredFields()));
			fields.addAll(Arrays.asList(clsSup.getFields()));
			if(clsSup.getName().equals(endsuperclass.getName())){
				break;
			}
		}
		
        return fields;
    }
	
	
	
	/**使用序列化进行深拷贝
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj){

		T clonedObj = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			clonedObj = (T) ois.readObject();
			ois.close();

		}catch (Exception e){
			e.printStackTrace();
		}

		return clonedObj;
	}
	
	public static HashMap<String,Object> cloneMap(Map<String,Object> map){
		HashMap<String,Object> remap=null;
		HashMap<String,Object> tempmap=null;
		if(map instanceof HashMap){
			tempmap=(HashMap<String, Object>)map;
			remap= (HashMap<String, Object>) tempmap.clone();
		}
		
		return remap;
	}

}
