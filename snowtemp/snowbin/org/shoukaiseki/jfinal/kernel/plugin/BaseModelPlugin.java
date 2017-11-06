/**
 *@Copyright:Copyright (c) 2015
 *@Company:SHUTO
 */
package org.shoukaiseki.jfinal.kernel.plugin;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jfinal.config.Routes;
import com.jfinal.plugin.IPlugin;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.utils.FileUtils;

/**
 * @Title: 扫描AbstractController的所走子类，得到定义静态参数TAG，绑定Controller和controllerKey
 * @Description: 利用类反射的原理，找到Controller的类，然后加载相应的上下文<code>TAG</code>，这样做到自动装载和配置
 * @Author:pilllar
 * @Since:2015年6月13日
 * @Version:1.1.0
 */
public class BaseModelPlugin implements IPlugin {

	protected final static Logger log = Logger.getLogger(BaseModelPlugin.class);
	private BaseModel newInstance;


	public BaseModelPlugin() {
	}

	public boolean start() {
		Class<?> cl = BaseModel.class;
		List<Class<BaseModel>> cls;
		cls = getAllAssignedClass(cl);
		log.info("getAllAssignedClass=" + cls.size());
		for (Class<BaseModel> ss : cls) {
			   try {
				BaseModel bm = ss.newInstance();
				bm.init();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * 获取Controller所有子类或接口实现类
	 * 
	 * @param intf
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static List<Class<BaseModel>> getAllAssignedClass(
			Class<?> cls) {
		List<Class<BaseModel>> classes = new ArrayList<Class<BaseModel>>();
		for (Class<?> c : FileUtils.loadControllerFile()) {
			if (cls.isAssignableFrom(c) && !cls.equals(c)) {
				classes.add((Class<BaseModel>) c);
				log.debug("Controller ="+c.getName());
			}
		}
		return classes;
	}

	public boolean stop() {
		return true;
	}

	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException {
		Class<?> cl = BaseModel.class;
		List<Class<BaseModel>> cls;
		Map<String, Class<?>> map = new HashMap<String, Class<?>>();
		try {
			cls = getAllAssignedClass(cl);
			for (Class<BaseModel> ss : cls) {
				for (Field ff : ss.getFields()) {
					System.out.println(ff.getName() + "|" + ff.get(ss));
					if ("TAG".endsWith(ff.getName())) {
						map.put("/" + ff.get(ss.getClass()), ss);
						break;
					}
				}
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(map);
	}

}
