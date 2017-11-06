package org.shoukaiseki.jfinal.kernel.utils;

import java.util.Map;

import com.google.common.base.Optional;
import org.shoukaiseki.jfinal.kernel.login.model.User;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;

/** org.shoukaiseki.jfinal.kernel.utils.BaseModelUtils
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月14日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class BaseModelUtils {
	Map<String,Object> map;
	
	public BaseModelUtils(Map<String,Object> map) {
		// TODO Auto-generated constructor stub
		Optional.fromNullable(map);
		this.map=map;
	}
	
	/**
	 * {@linkplain BaseModelUtils#setDefval(String, Object, User)}
	 */
	public BaseModelUtils setDefval(String attname,Object value) throws SnowException{
		return setDefval(attname, value,null);
	}
	
	
	/**全名为 setDefaultValueIfNull<br>
	 * 现在取短名为方便
	 * @param attname
	 * @param value
	 * @param user		可以为空
	 * @return 自身
	 * @throws SnowException
	 */
	public BaseModelUtils setDefval(String attname,Object value,User user) throws SnowException{
		if(DBUtils.isNull(map.get(attname))){
			Optional.fromNullable(value);
			Object val=value;
			if(val instanceof String){
				val=formatSnowValue(val.toString(),user);
			}
			map.put(attname, val);
			if(DBUtils.isNull(map.get(attname))){
				throw new SnowException(10001, "BaseModelUtils.setDefval 未知的value类型"+value);
			}
			
			
		};
		return this;
	}
	
	
	
	/** 默认值解析器,与maximo的定义的无关
	 * @param defval
	 * @param user
	 * @return
	 */
	public static Object  formatSnowValue(String defval,User user){
		Object val=null;
		
		switch (defval) {
		case "&SITEID&":
			Optional.fromNullable(user);
			val = user.getDefsite();
			break;
		case "&ORGID&":
			Optional.fromNullable(user);
			val=DBUtils.getOrgid(user.getDefsite());
			break;
		case "&SYSDATE&":
			val=DBUtils.getDate();
			break;
		case "&PERSONID&":
			val=user.getPersonid();
			break;

		default:
			val=defval;
			break;
		}
		return val;
	}
	
}
