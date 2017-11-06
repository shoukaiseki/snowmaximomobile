package com.app.jfinal.service.workorder.model;

import java.util.Map;

import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowField;

public class Relatedrecord extends BaseModel{
	
	//类
	@SnowField(isPersistent=false)
	private String sourceclass;
	//组织
	private String orgid;
	//记录键
	private String recordkey;
	//类
	private String relatedrecclass;
	//关联的记录键
	private String relatedreckey;
	//RELATEDRECORDID
	private Long relatedrecordid;
	//相关记录的组织
	private String relatedrecorgid;
	//相关记录的地点
	private String relatedrecsiteid;
	//关系
	private String relatetype;
	//地点
	private String siteid;
	public String getSourceclass() {
		return sourceclass;
	}
	public void setSourceclass(String sourceclass) {
		this.sourceclass = sourceclass;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getRecordkey() {
		return recordkey;
	}
	public void setRecordkey(String recordkey) {
		this.recordkey = recordkey;
	}
	public String getRelatedrecclass() {
		return relatedrecclass;
	}
	public void setRelatedrecclass(String relatedrecclass) {
		this.relatedrecclass = relatedrecclass;
	}
	public String getRelatedreckey() {
		return relatedreckey;
	}
	public void setRelatedreckey(String relatedreckey) {
		this.relatedreckey = relatedreckey;
	}
	public Long getRelatedrecordid() {
		return relatedrecordid;
	}
	public void setRelatedrecordid(Long relatedrecordid) {
		this.relatedrecordid = relatedrecordid;
	}
	public String getRelatedrecorgid() {
		return relatedrecorgid;
	}
	public void setRelatedrecorgid(String relatedrecorgid) {
		this.relatedrecorgid = relatedrecorgid;
	}
	public String getRelatedrecsiteid() {
		return relatedrecsiteid;
	}
	public void setRelatedrecsiteid(String relatedrecsiteid) {
		this.relatedrecsiteid = relatedrecsiteid;
	}
	public String getRelatetype() {
		return relatetype;
	}
	public void setRelatetype(String relatetype) {
		this.relatetype = relatetype;
	}
	public String getSiteid() {
		return siteid;
	}
	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}
	
	@Override
	public void recordToAfter(Record re) {
		// TODO Auto-generated method stub
		setSourceclass(re.getStr("CLASSS"));
	}
	
	@Override
	public void toInsertMapAfter(Map map) {
		// TODO Auto-generated method stub
		map.put("CLASS", getSourceclass());
	}
}
