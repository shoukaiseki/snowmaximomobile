package com.app.jfinal.service.lookup.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

@SnowTable(maxObjecxtName = "FAILURECODE")
public class Failurecode extends BaseModel{

	// 故障代码
	private String failurecode;

	// 组织
	private String orgid;

	// 类型
	private String type;

	// 描述
	private String description;

	private String parent;
	
	private Long failurelist;
	
	private Long failurecodeid;

	private Long rowstamp;

	public String getFailurecode() {
		return failurecode;
	}

	public void setFailurecode(String failurecode) {
		this.failurecode = failurecode;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Long getFailurelist() {
		return failurelist;
	}

	public void setFailurelist(Long failurelist) {
		this.failurelist = failurelist;
	}

	public Long getFailurecodeid() {
		return failurecodeid;
	}

	public void setFailurecodeid(Long failurecodeid) {
		this.failurecodeid = failurecodeid;
	}

	public Long getRowstamp() {
		return rowstamp;
	}

	public void setRowstamp(Long rowstamp) {
		this.rowstamp = rowstamp;
	}
	
	

}
