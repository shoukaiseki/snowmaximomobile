package com.app.jfinal.service.workflow.model;

import java.util.Date;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;

public class Wftransaction extends BaseModel{

	//交易标识,主键
	private Long transid;
	
	/**
	 * 审核人
	 */
	private String person_displayname;
	
	/**
	 * 节点名称
	 */
	private String wfnode_title;
	
	//人员
	private String personid;
	
	//交易日期
	private Date transdate;
	

	//备忘录
	private String memo;
	
	
	

	
	//操作
	private Integer actionid;

	//执行的操作
	private String actionperformed;

	//任务分配
	private Long assignid;

	//节点标识
	private Integer nodeid;

	//节点类型
	private String nodetype;

	//所有者标识
	private Long ownerid;

	//所有者表
	private String ownertable;


	//过程
	private String processname;

	//过程修订
	private Integer processrev;


	//交易类型
	private String transtype;

	//工作流标识
	private Long wfid;

	//任务类型
	private String wftasktype;

	public Long getTransid() {
		return transid;
	}

	public void setTransid(Long transid) {
		this.transid = transid;
	}

	public String getPerson_displayname() {
		return person_displayname;
	}

	public void setPerson_displayname(String person_displayname) {
		this.person_displayname = person_displayname;
	}

	public String getWfnode_title() {
		return wfnode_title;
	}

	public void setWfnode_title(String wfnode_title) {
		this.wfnode_title = wfnode_title;
	}

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public Date getTransdate() {
		return transdate;
	}

	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getActionid() {
		return actionid;
	}

	public void setActionid(Integer actionid) {
		this.actionid = actionid;
	}

	public String getActionperformed() {
		return actionperformed;
	}

	public void setActionperformed(String actionperformed) {
		this.actionperformed = actionperformed;
	}

	public Long getAssignid() {
		return assignid;
	}

	public void setAssignid(Long assignid) {
		this.assignid = assignid;
	}

	public Integer getNodeid() {
		return nodeid;
	}

	public void setNodeid(Integer nodeid) {
		this.nodeid = nodeid;
	}

	public String getNodetype() {
		return nodetype;
	}

	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
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

	public String getTranstype() {
		return transtype;
	}

	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

	public Long getWfid() {
		return wfid;
	}

	public void setWfid(Long wfid) {
		this.wfid = wfid;
	}

	public String getWftasktype() {
		return wftasktype;
	}

	public void setWftasktype(String wftasktype) {
		this.wftasktype = wftasktype;
	}



	@Override
	public Long showMaxUniqueIDValue() {
		// TODO Auto-generated method stub
		return getTransid();
	}
	
	@Override
	public String showMaxUniqueIDName() {
		// TODO Auto-generated method stub
		return "TRANSID";
	}

}
