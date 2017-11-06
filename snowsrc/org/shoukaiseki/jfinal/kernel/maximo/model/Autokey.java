package org.shoukaiseki.jfinal.kernel.maximo.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;

public class Autokey extends BaseModel{

	//前缀
	private String prefix;
	//自动键标识
	private Long autokeyid; 
	//起始数
	private Long seed;
	//语言代码
	private String langcode;
	//集
	private String setid;
	//自动编号名称
	private String autokeyname;
	//组织
	private String orgid;
	//地点
	private String siteid;
	
	private Long rowstamp;
	
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public Long getAutokeyid() {
		return autokeyid;
	}
	public void setAutokeyid(Long autokeyid) {
		this.autokeyid = autokeyid;
	}
	public Long getSeed() {
		return seed;
	}
	public void setSeed(Long seed) {
		this.seed = seed;
	}
	public String getLangcode() {
		return langcode;
	}
	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}
	public String getSetid() {
		return setid;
	}
	public void setSetid(String setid) {
		this.setid = setid;
	}
	public String getAutokeyname() {
		return autokeyname;
	}
	public void setAutokeyname(String autokeyname) {
		this.autokeyname = autokeyname;
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


}
