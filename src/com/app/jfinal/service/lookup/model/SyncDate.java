package com.app.jfinal.service.lookup.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;


/** SyncDate
 * 记录个功能同步时间
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月5日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class SyncDate extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;

	private String objectname;

	private Date lastsyncdate;

	private String tagname;

	private String methodname;

	private String classname;

	// 类似ROWSTAMP，记录最新更新的最大ROWSTAMP值，服务器如果有数据更新，则比这个值要大
	private Long rowstamp = Long.valueOf(0);
	
	private int tiaoshu=0;

	public String getObjectname() {
		return objectname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	public Date getLastsyncdate() {
		return lastsyncdate;
	}

	public void setLastsyncdate(Date lastsyncdate) {
		this.lastsyncdate = lastsyncdate;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the classname
	 */
	public String getClassname() {
		return classname;
	}

	/**
	 * @param classname
	 *            the classname to set
	 */
	public void setClassname(String classname) {
		this.classname = classname;
	}

	/**
	 * @return the tagname
	 */
	public String getTagname() {
		return tagname;
	}

	/**
	 * @param tagname
	 *            the tagname to set
	 */
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	/**
	 * @return the methodname
	 */
	public String getMethodname() {
		return methodname;
	}

	/**
	 * @param methodname
	 *            the methodname to set
	 */
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}

	public Long getRowstamp() {
		return rowstamp;
	}

	public void setRowstamp(Long rowstamp) {
		this.rowstamp = rowstamp;
	}
	
	public static SyncDate recordToObject(Record re) {
		// TODO Auto-generated method stub
		if(re==null)return null;
		SyncDate obj=new SyncDate();
		obj.setObjectname(re.getStr("OBJECTNAME"));
		obj.setRowstamp(re.getBigDecimal("ROWSTAMP").longValue());
		obj.setTiaoshu(re.getBigDecimal("TIAOSHU").intValue());
		
		return obj;
	}

	public int getTiaoshu() {
		return tiaoshu;
	}

	public void setTiaoshu(int tiaoshu) {
		this.tiaoshu = tiaoshu;
	}
	

}
