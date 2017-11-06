package com.app.jfinal.service.test.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.IBean;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowField;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

@SnowTable(maxObjecxtName="TEST3",maxSequenceName="TEST3IDSEQ")
public class Test3 extends BaseModel  {


	private Long rowstamp;

	//Aln01
	private String aln01;

	//Amount01
	private Double amount01;

	//Bigint01
	private Long bigint01;

	//Date01
	private Date date01;

	//Datetime01
	private Date datetime01;

	//Decimal01
	private Double decimal01;

	//描述
	private String description;

	//Duration01
	private Double duration01;

	//Float01
	private Double float01;

	//Hasld
	private Boolean hasld;

	//Integer01
	private Integer integer01;

	//Lower01
	private String lower01;

	//Orgid
	private String orgid;

	//Siteid
	private String siteid;

	//Smallint01
	private Integer smallint01;

	//Test3id
	private Long test3id;

	//Time01
	private Date time01;

	//Upper01
	private String upper01;

	//Yorn01
	private Boolean yorn01;

	public String getAln01() {
		return aln01;
	}

	public void setAln01(String aln01) {
		this.aln01 = aln01;
	}

	public Double getAmount01() {
		return amount01;
	}

	public void setAmount01(Double amount01) {
		this.amount01 = amount01;
	}

	public Long getBigint01() {
		return bigint01;
	}

	public void setBigint01(Long bigint01) {
		this.bigint01 = bigint01;
	}

	public Date getDate01() {
		return date01;
	}

	public void setDate01(Date date01) {
		this.date01 = date01;
	}

	public Date getDatetime01() {
		return datetime01;
	}

	public void setDatetime01(Date datetime01) {
		this.datetime01 = datetime01;
	}

	public Double getDecimal01() {
		return decimal01;
	}

	public void setDecimal01(Double decimal01) {
		this.decimal01 = decimal01;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDuration01() {
		return duration01;
	}

	public void setDuration01(Double duration01) {
		this.duration01 = duration01;
	}

	public Double getFloat01() {
		return float01;
	}

	public void setFloat01(Double float01) {
		this.float01 = float01;
	}

	public Boolean getHasld() {
		return hasld;
	}

	public void setHasld(Boolean hasld) {
		this.hasld = hasld;
	}

	public Integer getInteger01() {
		return integer01;
	}

	public void setInteger01(Integer integer01) {
		this.integer01 = integer01;
	}

	public String getLower01() {
		return lower01;
	}

	public void setLower01(String lower01) {
		this.lower01 = lower01;
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

	public Integer getSmallint01() {
		return smallint01;
	}

	public void setSmallint01(Integer smallint01) {
		this.smallint01 = smallint01;
	}

	public Long getTest3id() {
		return test3id;
	}

	public void setTest3id(Long test3id) {
		this.test3id = test3id;
	}

	public Date getTime01() {
		return time01;
	}

	public void setTime01(Date time01) {
		this.time01 = time01;
	}

	public String getUpper01() {
		return upper01;
	}

	public void setUpper01(String upper01) {
		this.upper01 = upper01;
	}

	public Boolean getYorn01() {
		return yorn01;
	}

	public void setYorn01(Boolean yorn01) {
		this.yorn01 = yorn01;
	}

	public Long getRowstamp() {
		return rowstamp;
	}

	public void setRowstamp(Long rowstamp) {
		this.rowstamp = rowstamp;
	}



}
