package com.app.jfinal.service.wotodo.model;

import java.util.Date;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;

/** WorkToDo
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月14日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class WorkToDo extends BaseModel{
	
	public static final String KEY_STATUS = "活动";
	
	private String ownertable;
	
	// maximo中任务唯一id
	private Long wfassignmentid;
	
	//唯一id
	private Long assignid ; 

	// 关联id
	private Long ownerid;

	// 状态
	private String status;

	// 任务名称
	private String description;

	// 所属功能
	private String app;

	// 任务归属人
	private String assigncode;

	// 表名称
	private String processname;
	
	//关联的业务对象
	private Object task  ;
	
	//任务开始时间
	private Date startdate;
	
	//应用名称
	private String apptitle;
	
	//是否已下载到app
	private Boolean issyncapp = false;
	
	private String personname;
	
	/**
	 * 如果客户机与服务器该字段一致则该条数据不需要再同步
	 */
	private Long rowstamp;
	
	

	public String getOwnertable() {
		return ownertable;
	}

	public void setOwnertable(String ownertable) {
		this.ownertable = ownertable;
	}

	/**
	 * @return the rowstamp
	 */
	public Long getRowstamp() {
		return rowstamp;
	}

	/**
	 * @param rowstamp the rowstamp to set
	 */
	public void setRowstamp(Long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public Object getTask() {
		return task;
	}

	public void setTask(Object task) {
		this.task = task;
	}


	public Long getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}

	/**
	 * @return the assigncode
	 */
	public String getAssigncode() {
		return assigncode;
	}

	/**
	 * @param assigncode the assigncode to set
	 */
	public void setAssigncode(String assigncode) {
		this.assigncode = assigncode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the assignid
	 */
	public Long getAssignid() {
		return assignid;
	}

	/**
	 * @param assignid the assignid to set
	 */
	public void setAssignid(Long assignid) {
		this.assignid = assignid;
	}

	/**
	 * @return the app
	 */
	public String getApp() {
		return app;
	}

	/**
	 * @param app the app to set
	 */
	public void setApp(String app) {
		this.app = app;
	}

	/**
	 * @return the processname
	 */
	public String getProcessname() {
		return processname;
	}

	/**
	 * @param processname the processname to set
	 */
	public void setProcessname(String processname) {
		this.processname = processname;
	}

	/**
	 * @return the apptitle
	 */
	public String getApptitle() {
		return apptitle;
	}

	/**
	 * @param apptitle the apptitle to set
	 */
	public void setApptitle(String apptitle) {
		this.apptitle = apptitle;
	}

	/**
	 * @return the startdate
	 */
	public Date getStartdate() {
		return startdate;
	}

	/**
	 * @param startdate the startdate to set
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	/**
	 * @return the issyncapp
	 */
	public Boolean getIssyncapp() {
		return issyncapp;
	}

	/**
	 * @param issyncapp the issyncapp to set
	 */
	public void setIssyncapp(Boolean issyncapp) {
		this.issyncapp = issyncapp;
	}

	/**
	 * @return the personname
	 */
	public String getPersonname() {
		return personname;
	}

	/**
	 * @param personname the personname to set
	 */
	public void setPersonname(String personname) {
		this.personname = personname;
	}

	/**
	 * @return the wfassignmentid
	 */
	public Long getWfassignmentid() {
		return wfassignmentid;
	}

	/**
	 * @param wfassignmentid the wfassignmentid to set
	 */
	public void setWfassignmentid(Long wfassignmentid) {
		this.wfassignmentid = wfassignmentid;
	}

		
}
