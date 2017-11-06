package com.app.jfinal.service.workflow.model;

import java.util.Date;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;

public class Wfassignment  extends BaseModel{

	private String assigncode_displayname;

	//接受表达式
	private String acceptexpr;

	//应用程序
	private String app;

	//已分配任务的人员代码
	private String assigncode;

	//任务分配
	private Long assignid;

	//任务分配状态
	private String assignstatus;

	//扩展字段 1
	private String assign_01;

	//扩展字段 2
	private String assign_02;

	//扩展字段 3
	private String assign_03;

	//扩展字段 4
	private String assign_04;

	//扩展字段 5
	private String assign_05;

	//基于日历
	private Boolean calendarbased;

	//条件代码
	private String condition;

	//条件类
	private String conditionclass;

	//描述
	private String description;

	//到期日
	private Date duedate;

	//发送电子邮件
	private Boolean emailnotification;

	//升级角色
	private String escrole;

	//组号
	private Integer groupnum;

	//具有详细描述
	private Boolean hasld;

	//委派时保留原始任务分配
	private Boolean keeporigassgn;

	//语言代码
	private String langcode;

	//节点标识
	private Integer nodeid;

	//非接受消息
	private String nonacceptmsg;

	//最初的被指派人
	private String origperson;

	//所有者标识
	private Long ownerid;

	//所有者表
	private String ownertable;

	//优先级
	private Integer priority;

	//过程
	private String processname;

	//过程修订
	private Integer processrev;

	//分配者关联
	private String relationship;

	//角色标识
	private String roleid;

	//独立的组
	private Boolean separategroups;

	//开始日期
	private Date startdate;

	//通信模板
	private String templateid;

	//时限
	private Double timelimit;

	//WFASSIGNMENTID
	private Long wfassignmentid;

	//工作流标识
	private Long wfid;

	public String getAcceptexpr() {
		return acceptexpr;
	}

	public void setAcceptexpr(String acceptexpr) {
		this.acceptexpr = acceptexpr;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getAssigncode() {
		return assigncode;
	}

	public void setAssigncode(String assigncode) {
		this.assigncode = assigncode;
	}

	public Long getAssignid() {
		return assignid;
	}

	public void setAssignid(Long assignid) {
		this.assignid = assignid;
	}

	public String getAssignstatus() {
		return assignstatus;
	}

	public void setAssignstatus(String assignstatus) {
		this.assignstatus = assignstatus;
	}

	public String getAssign_01() {
		return assign_01;
	}

	public void setAssign_01(String assign_01) {
		this.assign_01 = assign_01;
	}

	public String getAssign_02() {
		return assign_02;
	}

	public void setAssign_02(String assign_02) {
		this.assign_02 = assign_02;
	}

	public String getAssign_03() {
		return assign_03;
	}

	public void setAssign_03(String assign_03) {
		this.assign_03 = assign_03;
	}

	public String getAssign_04() {
		return assign_04;
	}

	public void setAssign_04(String assign_04) {
		this.assign_04 = assign_04;
	}

	public String getAssign_05() {
		return assign_05;
	}

	public void setAssign_05(String assign_05) {
		this.assign_05 = assign_05;
	}

	public Boolean getCalendarbased() {
		return calendarbased;
	}

	public void setCalendarbased(Boolean calendarbased) {
		this.calendarbased = calendarbased;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getConditionclass() {
		return conditionclass;
	}

	public void setConditionclass(String conditionclass) {
		this.conditionclass = conditionclass;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public Boolean getEmailnotification() {
		return emailnotification;
	}

	public void setEmailnotification(Boolean emailnotification) {
		this.emailnotification = emailnotification;
	}

	public String getEscrole() {
		return escrole;
	}

	public void setEscrole(String escrole) {
		this.escrole = escrole;
	}

	public Integer getGroupnum() {
		return groupnum;
	}

	public void setGroupnum(Integer groupnum) {
		this.groupnum = groupnum;
	}

	public Boolean getHasld() {
		return hasld;
	}

	public void setHasld(Boolean hasld) {
		this.hasld = hasld;
	}

	public Boolean getKeeporigassgn() {
		return keeporigassgn;
	}

	public void setKeeporigassgn(Boolean keeporigassgn) {
		this.keeporigassgn = keeporigassgn;
	}

	public String getLangcode() {
		return langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public Integer getNodeid() {
		return nodeid;
	}

	public void setNodeid(Integer nodeid) {
		this.nodeid = nodeid;
	}

	public String getNonacceptmsg() {
		return nonacceptmsg;
	}

	public void setNonacceptmsg(String nonacceptmsg) {
		this.nonacceptmsg = nonacceptmsg;
	}

	public String getOrigperson() {
		return origperson;
	}

	public void setOrigperson(String origperson) {
		this.origperson = origperson;
	}

	public Long getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}

	public String getOwnertable() {
		return ownertable;
	}

	public void setOwnertable(String ownertable) {
		this.ownertable = ownertable;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getProcessname() {
		return processname;
	}

	public void setProcessname(String processname) {
		this.processname = processname;
	}

	public Integer getProcessrev() {
		return processrev;
	}

	public void setProcessrev(Integer processrev) {
		this.processrev = processrev;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public Boolean getSeparategroups() {
		return separategroups;
	}

	public void setSeparategroups(Boolean separategroups) {
		this.separategroups = separategroups;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public Double getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(Double timelimit) {
		this.timelimit = timelimit;
	}

	public Long getWfassignmentid() {
		return wfassignmentid;
	}

	public void setWfassignmentid(Long wfassignmentid) {
		this.wfassignmentid = wfassignmentid;
	}

	public Long getWfid() {
		return wfid;
	}

	public void setWfid(Long wfid) {
		this.wfid = wfid;
	}

	public String getAssigncode_displayname() {
		return assigncode_displayname;
	}

	public void setAssigncode_displayname(String assigncode_displayname) {
		this.assigncode_displayname = assigncode_displayname;
	}



	@Override
	public Long showMaxUniqueIDValue() {
		// TODO Auto-generated method stub
		return getWfassignmentid();
	}
	
	@Override
	public String showMaxUniqueIDName() {
		// TODO Auto-generated method stub
		return "WFASSIGNMENTID";
	}


}
