package org.shoukaiseki.jfinal.kernel.testkit;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.SnowDB;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;
import org.shoukaiseki.jfinal.kernel.utils.ClassUtils;

public class RandomModel {
	
	public static final Logger log = Logger.getLogger(RandomModel.class);
	
	private HashMap<String,RandomColumnSetting> rcsMap= Maps.newHashMap();

	private String tablename=null;
	
	public RandomModel() throws SnowException {
		this(null);
	}
	
	public RandomModel(String tablename) throws SnowException {
		// TODO Auto-generated constructor stub
		try {
			if(tablename!=null){
				this.tablename=tablename;
				init(DbKit.getConfig().getDataSource().getConnection());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SnowException(10002, e);
		}
	}
	
	public RandomModel( String tablename,Connection conn)  {
		// TODO Auto-generated constructor stub
			if(tablename!=null){
				this.tablename=tablename;
				init(conn);
			}
		
		
	}
	
	protected void init(Connection conn){
		SnowDB snowDb=new SnowDB(conn);
		List<Record> list = snowDb.find("select * from dba_tab_columns where owner=(select user from dual) and table_name=upper(:tablename)",tablename);
		for (Record record : list) {
			RandomColumnSetting rcs = BaseModel.Companion.recordTo(record, RandomColumnSetting.class);
			rcs.setMax_char_length(record.getBigDecimal("CHAR_LENGTH").intValue());
			rcsMap.put(rcs.getColumn_name().toLowerCase(), rcs);
		}
		
	}
	
	

	/**
	 * 随机生成一个对象
	 * 
	 * @param rec
	 * @param model
	 * @return 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @Description: 有异常不再抛出
	 */
	public  <T> T random(Class<T> clazz,Class<?> endclazz)  {
		log.info("random...");
		T model=null;
		try {
				model = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		log.info("model="+model);
		List<Field> fields = new ArrayList<Field>();
		
		fields=ClassUtils.getFieldsAndToSuperStop(clazz,endclazz);
		// //获取该类中可以调用的方法
		// ArrayList<String> al=new ArrayList<String>();
		// Method[] methods = model.getClass().getMethods();
		// for (Method method2 : methods) {
		// al.add(method2.getName());
		// }
		String name;
		String attr;
		Method method = null;
		String type;
		// 遍历所有属性
		StringBuffer sb = new StringBuffer();
		Map<String,String> map2 = Maps.newHashMap();
		for (Field fi : fields) {
			// 获取属性的名字
			name = fi.getName();
			
			if(map2.get(name) != null){
				continue;
			}
			map2.put(name, name);
			// 将属性的首字符大写，方便构造get，set方法
			attr = name.substring(0, 1).toUpperCase() + name.substring(1);
			
			// 获取属性的类型
			type = fi.getGenericType().toString();
//			log.info("type="+type+",name="+name);

			// //如果不存在该方法,则进行下次循环
			// //当然也可以通过 fi.getModifiers() 获取修饰符来判断是否为 FINAL 类型的进行过滤循环
			sb.append(name).append(":").append(type).append(" | ");
			// 判断修饰符,如果存在 final类型的则表示无对应的set方法,跳过此次循环
			if (Modifier.isFinal(fi.getModifiers())) {
				continue;
			}
			if (Modifier.isStatic(fi.getModifiers())) {
				continue;
			}

			// 按照变量类型获取相应set方法,为空时如果变量为boolean类型,会报错
			try {
				method = model.getClass().getMethod("set" + attr,
						fi.getType());
			} catch (SecurityException e) {
				log.error(" SecurityException : " + e.toString());
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				log.error(" NoSuchMethodException : " + e.toString());
				e.printStackTrace();
			}
			Object value=null;
			RandomColumnSetting rcs = rcsMap.get(name);
			int max_char_length=30;
			int min_char_length=1;
			if(rcs!=null&&rcs.isString()){
				max_char_length=rcs.getMax_char_length();
				min_char_length=rcs.getMin_char_length();
			}

			// 如果type是类类型，则前面包含"class "，后面跟类名
			try {
				if (type.equals("class java.lang.String")) {
					log.debug("rcs="+JSONObject.toJSONString(rcs));
					method.invoke(model, RandomData.randomChineseByte(min_char_length,max_char_length));
				} else if (type.equals("class java.lang.Integer")) {
					method.invoke(model, RandomData.randomInt());
				} else if (type.equals("class java.lang.Short")) {
					method.invoke(model, value);
				} else if (type.equals("class java.lang.Double")) {
						method.invoke(model, RandomData.randomDouble());
				}else if (type.equals("class java.math.BigDecimal")) {
						method.invoke(model, RandomData.randomDouble());
				}else if (type.equals("class java.lang.Long")) {
						method.invoke(model, RandomData.randomLong());
				} else if (type.equals("class java.lang.Boolean")) {
					method.invoke(model, RandomData.randomBoolean());
				} else if (type.equals("class java.util.Date")) {
					method.invoke(model, RandomData.randomDate());
				} else if (type.equals("boolean")) {
					method.invoke(model, RandomData.randomBoolean());
				} else {
					log.error("StringUtils.recordToObject 暂不支持转换的类型 : " + model.getClass().getName() + "|"
							+ name + "=" + "| type=" + type);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			//log.debug("recordToObject 设置值结束");
		}
		
		return model;
	}

	public HashMap<String, RandomColumnSetting> getRcsMap() {
		return rcsMap;
	}

	
	
}
