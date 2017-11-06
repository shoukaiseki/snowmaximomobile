package com.app.jfinal.service.workorder.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

@SnowTable(maxObjecxtName="FAILUREREPORT",maxSequenceName="FAILUREREPORTSEQ")
public class Failurereport extends BaseModel{

	//资产
	private String assetnum;

	//故障代码
	private String failurecode;

	//FAILUREREPORTID
	private Long failurereportid;

	//行
	private Long linenum;

	//组织
	private String orgid;

	//地点
	private String siteid;

	//凭单类别
	private String ticketclass;

	//凭单
	private String ticketid;

	//类型
	private String type;

	//工单
	private String wonum;

	public String getAssetnum() {
		return assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
	}

	public String getFailurecode() {
		return failurecode;
	}

	public void setFailurecode(String failurecode) {
		this.failurecode = failurecode;
	}

	public Long getFailurereportid() {
		return failurereportid;
	}

	public void setFailurereportid(Long failurereportid) {
		this.failurereportid = failurereportid;
	}

	public Long getLinenum() {
		return linenum;
	}

	public void setLinenum(Long linenum) {
		this.linenum = linenum;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getTicketclass() {
		return ticketclass;
	}

	public void setTicketclass(String ticketclass) {
		this.ticketclass = ticketclass;
	}

	public String getTicketid() {
		return ticketid;
	}

	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWonum() {
		return wonum;
	}

	public void setWonum(String wonum) {
		this.wonum = wonum;
	}




}
