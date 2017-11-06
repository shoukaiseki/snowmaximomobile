package com.app.jfinal.service.checkversion.model;

public class Version{
	//最新版本下载地址
	private String url;
	//是否强制更新
	private Boolean forced;
	//是否需要更新
	private Boolean updated;
	//系统类别:android/ios
	private String systemtype;
	//版本号
	private String version;
	
	private Integer version1;
	private Integer version2;
	private Integer version3;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getForced() {
		return forced;
	}
	public void setForced(Boolean forced) {
		this.forced = forced;
	}
	public Boolean getUpdated() {
		return updated;
	}
	public void setUpdated(Boolean updated) {
		this.updated = updated;
	}
	public String getSystemtype() {
		return systemtype;
	}
	public void setSystemtype(String systemtype) {
		this.systemtype = systemtype;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Integer getVersion1() {
		return version1;
	}
	public void setVersion1(Integer version1) {
		this.version1 = version1;
	}
	public Integer getVersion2() {
		return version2;
	}
	public void setVersion2(Integer version2) {
		this.version2 = version2;
	}
	public Integer getVersion3() {
		return version3;
	}
	public void setVersion3(Integer version3) {
		this.version3 = version3;
	}

}
