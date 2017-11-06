package org.shoukaiseki.jfinal.kernel.maximo.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;

public class Maxattributecfg extends BaseModel{
	//类
	private String
	classname;
	//搜索类型
	private String
	searchtype;
	//缺省值
	private String
	defaultvalue;
	//别名
	private String
	alias;
	//已变更
	private String
	changed;
	//标题
	private String
	title;
	//描述
	private String
	remarks;
	//文本方向
	private String
	textdirection;
	//MAXATTRIBUTECFGID
	private Long
	maxattributeid;
	//属性号
	private Integer
	attributeno;
	//长度
	private Integer
	length;
	//小数位数
	private Integer
	scale;
	//扩展
	private Integer
	extended;
	//主列
	private Integer
	primarykeycolseq;
	//类型
	private String
	maxtype;
	//实体
	private String
	entityname;
	//域
	private String
	domainid;
	//列
	private String
	columnname;
	//自动编号
	private String
	autokeyname;
	//对象
	private String
	objectname;
	//属性
	private String
	attributename;
	//复杂表达式类型
	private String
	complexexpression;
	//操作列名称
	private String
	handlecolumnname;
	//等同对象
	private String
	sameasobject;
	//等同属性
	private String
	sameasattribute;
	//正向
	private Boolean
	ispositive;
	//用户定义
	private Boolean
	userdefined;
	//详细描述所有者
	private Boolean
	isldowner;
	//电子签名已启用
	private Boolean
	esigenabled;
	//支持多语言
	private Boolean
	mlsupported;
	//使用多语言
	private Boolean
	mlinuse;
	//持久性
	private Boolean
	persistent;
	//启用审计
	private Boolean
	eauditenabled;
	//必须是
	private Boolean
	mustbe;
	//可本地化
	private Boolean
	localizable;
	//受限
	private Boolean
	restricted;
	//必需
	private Boolean
	required;
	//是否能自动编码
	private Boolean
	canautonum;
	
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getSearchtype() {
		return searchtype;
	}
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	public String getDefaultvalue() {
		return defaultvalue;
	}
	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getChanged() {
		return changed;
	}
	public void setChanged(String changed) {
		this.changed = changed;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getTextdirection() {
		return textdirection;
	}
	public void setTextdirection(String textdirection) {
		this.textdirection = textdirection;
	}
	public Long getMaxattributeid() {
		return maxattributeid;
	}
	public void setMaxattributeid(Long maxattributeid) {
		this.maxattributeid = maxattributeid;
	}
	public Integer getAttributeno() {
		return attributeno;
	}
	public void setAttributeno(Integer attributeno) {
		this.attributeno = attributeno;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getScale() {
		return scale;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	public Integer getExtended() {
		return extended;
	}
	public void setExtended(Integer extended) {
		this.extended = extended;
	}
	public Integer getPrimarykeycolseq() {
		return primarykeycolseq;
	}
	public void setPrimarykeycolseq(Integer primarykeycolseq) {
		this.primarykeycolseq = primarykeycolseq;
	}
	public String getMaxtype() {
		return maxtype;
	}
	public void setMaxtype(String maxtype) {
		this.maxtype = maxtype;
	}
	public String getEntityname() {
		return entityname;
	}
	public void setEntityname(String entityname) {
		this.entityname = entityname;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getColumnname() {
		return columnname;
	}
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}
	public String getAutokeyname() {
		return autokeyname;
	}
	public void setAutokeyname(String autokeyname) {
		this.autokeyname = autokeyname;
	}
	public String getObjectname() {
		return objectname;
	}
	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}
	public String getAttributename() {
		return attributename;
	}
	public void setAttributename(String attributename) {
		this.attributename = attributename;
	}
	public String getComplexexpression() {
		return complexexpression;
	}
	public void setComplexexpression(String complexexpression) {
		this.complexexpression = complexexpression;
	}
	public String getHandlecolumnname() {
		return handlecolumnname;
	}
	public void setHandlecolumnname(String handlecolumnname) {
		this.handlecolumnname = handlecolumnname;
	}
	public String getSameasobject() {
		return sameasobject;
	}
	public void setSameasobject(String sameasobject) {
		this.sameasobject = sameasobject;
	}
	public String getSameasattribute() {
		return sameasattribute;
	}
	public void setSameasattribute(String sameasattribute) {
		this.sameasattribute = sameasattribute;
	}
	public Boolean getIspositive() {
		return ispositive;
	}
	public void setIspositive(Boolean ispositive) {
		this.ispositive = ispositive;
	}
	public Boolean getUserdefined() {
		return userdefined;
	}
	public void setUserdefined(Boolean userdefined) {
		this.userdefined = userdefined;
	}
	public Boolean getIsldowner() {
		return isldowner;
	}
	public void setIsldowner(Boolean isldowner) {
		this.isldowner = isldowner;
	}
	public Boolean getEsigenabled() {
		return esigenabled;
	}
	public void setEsigenabled(Boolean esigenabled) {
		this.esigenabled = esigenabled;
	}
	public Boolean getMlsupported() {
		return mlsupported;
	}
	public void setMlsupported(Boolean mlsupported) {
		this.mlsupported = mlsupported;
	}
	public Boolean getMlinuse() {
		return mlinuse;
	}
	public void setMlinuse(Boolean mlinuse) {
		this.mlinuse = mlinuse;
	}
	public Boolean getPersistent() {
		return persistent;
	}
	public void setPersistent(Boolean persistent) {
		this.persistent = persistent;
	}
	public Boolean getEauditenabled() {
		return eauditenabled;
	}
	public void setEauditenabled(Boolean eauditenabled) {
		this.eauditenabled = eauditenabled;
	}
	public Boolean getMustbe() {
		return mustbe;
	}
	public void setMustbe(Boolean mustbe) {
		this.mustbe = mustbe;
	}
	public Boolean getLocalizable() {
		return localizable;
	}
	public void setLocalizable(Boolean localizable) {
		this.localizable = localizable;
	}
	public Boolean getRestricted() {
		return restricted;
	}
	public void setRestricted(Boolean restricted) {
		this.restricted = restricted;
	}
	public Boolean getRequired() {
		return required;
	}
	public void setRequired(Boolean required) {
		this.required = required;
	}
	public Boolean getCanautonum() {
		return canautonum;
	}
	public void setCanautonum(Boolean canautonum) {
		this.canautonum = canautonum;
	}

}
