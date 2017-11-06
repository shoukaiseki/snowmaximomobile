package com.app.jfinal.service.mobileapp.model;

import java.util.Date;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowField;

public class Phoneversion extends BaseModel{
	
	//系统定制商
	private String brand;
	
	// 登陆人
	private String loginid;
	
	//剩余空间容量
	private Long availablespace;
	
	//内存可用容量
	private Long availmemory;
	
	//创建时间
	private Date createdate;
	
	//设备唯一编码
	private String imei;
	
	//是否android系统
	private Long isandroid;
	
	//系统名称(Redmi 3)
	private String model;
	
	//主键
	private Long phoneversionid;
	
	//内存总容量
	private Long totalmemory;
	
	//空间总容量
	private Long totalspace;
	
	//版本号
	private String version;
	
	
	//备注
	private String remark;
	
	

	public Long getAvailablespace() {
		return availablespace;
	}

	public void setAvailablespace(Long availablespace) {
		this.availablespace = availablespace;
	}

	public Long getAvailmemory() {
		return availmemory;
	}

	public void setAvailmemory(Long availmemory) {
		this.availmemory = availmemory;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Long getIsandroid() {
		return isandroid;
	}

	public void setIsandroid(Long isandroid) {
		this.isandroid = isandroid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getPhoneversionid() {
		return phoneversionid;
	}

	public void setPhoneversionid(Long phoneversionid) {
		this.phoneversionid = phoneversionid;
	}

	public Long getTotalmemory() {
		return totalmemory;
	}

	public void setTotalmemory(Long totalmemory) {
		this.totalmemory = totalmemory;
	}

	public Long getTotalspace() {
		return totalspace;
	}

	public void setTotalspace(Long totalspace) {
		this.totalspace = totalspace;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}


}
