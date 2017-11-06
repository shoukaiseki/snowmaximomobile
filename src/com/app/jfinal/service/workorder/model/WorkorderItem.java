package com.app.jfinal.service.workorder.model;

import java.math.BigDecimal;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;


/** WorkorderItem
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月5日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class WorkorderItem extends BaseModel {

	// 工单编号
	private String wonum;

	private BigDecimal wpitemid;

	// 材料编号
	private String itemnum;

	// 材料名称
	private String description;

	// 规格
	private String s_modelnum;

	// 发放单位
	private String issueunit;

	// 数量
	private BigDecimal itemqty;

	// 单位成本
	private BigDecimal unitcost;

	// 行成本
	private BigDecimal linecost;

	// 已发放数量
	private BigDecimal quantity;

	// 准备发放/退回的数量，正数是发放，负数时发放
	private BigDecimal issueqty;

	// 库房
	private String location;

	private String orgid;
	
	private String siteid;
	
	public String getItemnum() {
		return itemnum;
	}

	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the wonum
	 */
	public String getWonum() {
		return wonum;
	}

	/**
	 * @param wonum
	 *            the wonum to set
	 */
	public void setWonum(String wonum) {
		this.wonum = wonum;
	}

	/**
	 * @return the s_modelnum
	 */
	public String getS_modelnum() {
		return s_modelnum;
	}

	/**
	 * @param s_modelnum
	 *            the s_modelnum to set
	 */
	public void setS_modelnum(String s_modelnum) {
		this.s_modelnum = s_modelnum;
	}

	/**
	 * @return the issueunit
	 */
	public String getIssueunit() {
		return issueunit;
	}

	/**
	 * @param issueunit
	 *            the issueunit to set
	 */
	public void setIssueunit(String issueunit) {
		this.issueunit = issueunit;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the wpitemid
	 */
	public BigDecimal getWpitemid() {
		return wpitemid;
	}

	/**
	 * @param wpitemid
	 *            the wpitemid to set
	 */
	public void setWpitemid(BigDecimal wpitemid) {
		this.wpitemid = wpitemid;
	}

	/**
	 * @return the itemqty
	 */
	public BigDecimal getItemqty() {
		return itemqty;
	}

	/**
	 * @param itemqty
	 *            the itemqty to set
	 */
	public void setItemqty(BigDecimal itemqty) {
		this.itemqty = itemqty;
	}

	/**
	 * @return the unitcost
	 */
	public BigDecimal getUnitcost() {
		return unitcost;
	}

	/**
	 * @param unitcost
	 *            the unitcost to set
	 */
	public void setUnitcost(BigDecimal unitcost) {
		this.unitcost = unitcost;
	}

	/**
	 * @return the linecost
	 */
	public BigDecimal getLinecost() {
		return linecost;
	}

	/**
	 * @param linecost
	 *            the linecost to set
	 */
	public void setLinecost(BigDecimal linecost) {
		this.linecost = linecost;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the preqty
	 */
	public BigDecimal getIssueqty() {
		return issueqty;
	}

	/**
	 * @param preqty
	 *            the preqty to set
	 */
	public void setIssueqty(BigDecimal preqty) {
		this.issueqty = preqty;
	}

	/**
	 * @return the orgid
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * @param orgid the orgid to set
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * @return the siteid
	 */
	public String getSiteid() {
		return siteid;
	}

	/**
	 * @param siteid the siteid to set
	 */
	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

}
