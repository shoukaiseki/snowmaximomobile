package com.app.jfinal.service.workorder.model;


/**
 * 系统分类表
 * @author zhangfei
 *
 */
public class Classstructure {
	
	private String classstructureid ; //分类id
	
	private String description ; //描述
	
	private String classqc; // 全称]
	
	private String classificationid ;//分类内码
	
	private String parent; //父级

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getClassstructureid() {
		return classstructureid;
	}

	public String getClassificationid() {
		return classificationid;
	}

	public void setClassificationid(String classificationid) {
		this.classificationid = classificationid;
	}

	public void setClassstructureid(String classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClassqc() {
		return classqc;
	}

	public void setClassqc(String classqc) {
		this.classqc = classqc;
	}
	
	

}
