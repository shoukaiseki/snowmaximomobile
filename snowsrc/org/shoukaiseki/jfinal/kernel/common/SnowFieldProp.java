package org.shoukaiseki.jfinal.kernel.common;

import com.google.common.base.Preconditions;
import org.shoukaiseki.jfinal.kernel.maximo.model.Maxattributecfg;

import java.lang.reflect.Field;

/** org.shoukaiseki.jfinal.kernel.common.SnowFieldProp
 * BaseModel 对象的字段属性存放,用于应用判断
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月12日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class SnowFieldProp {
	
	private String tablename;
	
	private String attname;
	
	private boolean persistent=true;
	
	private boolean primary=false;

	private boolean required=false;
	
	private boolean insertignore=false;
	
	private boolean updateignore=false; 
	
	private String format="";
	
	private Maxattributecfg maxatt;

	private Field field;
	
	private Object snowdefval;
	
	public SnowFieldProp(String objectname,String attname) {
		// TODO Auto-generated constructor stub
		this.attname=attname.toLowerCase();
		this.tablename=objectname.toLowerCase();
	}
	
	/**
	 * 是否存在 Field 对象
	 * @return
	 */
	public boolean hasField(){
		return field==null?false:true;
	}
	
	public Field outField() {
		return Preconditions.checkNotNull(field);
	}

	public void setField(Field field) {
		this.field = field;
	}

	/**
	 * 是否存在 maxattributecfg 对象
	 * @return
	 */
	public boolean hasMaxatt(){
		return maxatt==null?false:true;
	}

	public Maxattributecfg outMaxatt() {
		return Preconditions.checkNotNull(maxatt,"表:"+tablename+",字段:"+attname);
	}

	public void setMaxatt(Maxattributecfg maxatt) {
		this.maxatt = maxatt;
	}

	public boolean isPersistent() {
		return persistent;
	}

	public void setPersistent(boolean persistent) {
		this.persistent = persistent;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isInsertignore() {
		return insertignore;
	}

	public void setInsertignore(boolean insertignore) {
		this.insertignore = insertignore;
	}

	public boolean isUpdateignore() {
		return updateignore;
	}

	public void setUpdateignore(boolean updateignore) {
		this.updateignore = updateignore;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Object getSnowdefval() {
		return snowdefval;
	}

	public void setSnowdefval(Object snowdefval) {
		this.snowdefval = snowdefval;
	}

	
	
	
}
