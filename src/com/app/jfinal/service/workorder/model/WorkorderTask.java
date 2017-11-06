package com.app.jfinal.service.workorder.model;

import java.math.BigDecimal;
import java.util.Date;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;


/** WorkorderTask
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月5日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class WorkorderTask extends BaseModel {

	// 工单编号
	private String wonum;

	// 任务标号
	private Long workorderid;

	// 序号
	private String sn;

	// 检查部位
	private String jcbw;

	// 检查内容
	private String jcnr;

	// 检查方法
	private String jcff;

	// 正确状态
	private String zqzt;

	// 是否检查：=0待检查，=1已检查
	private BigDecimal jcstatus;
	
	//检查情况：完成/有问题
	private String jczt;

	// 检查人
	private String jcperson;

	// 备注
	private String remark;

	// 是否检查完成
	private Boolean oplog_yesorno = false;

	// 检查时间
	private Date oplog_zxdate = null;

	public String getWonum() {
		return wonum;
	}

	public void setWonum(String wonum) {
		this.wonum = wonum;
	}

	/**
	 * @return the sn
	 */
	public String getSn() {
		return sn;
	}

	/**
	 * @param sn
	 *            the sn to set
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}

	/**
	 * @return the jcbw
	 */
	public String getJcbw() {
		return jcbw;
	}

	/**
	 * @param jcbw
	 *            the jcbw to set
	 */
	public void setJcbw(String jcbw) {
		this.jcbw = jcbw;
	}

	/**
	 * @return the jcnr
	 */
	public String getJcnr() {
		return jcnr;
	}

	/**
	 * @param jcnr
	 *            the jcnr to set
	 */
	public void setJcnr(String jcnr) {
		this.jcnr = jcnr;
	}

	/**
	 * @return the jcff
	 */
	public String getJcff() {
		return jcff;
	}

	/**
	 * @param jcff
	 *            the jcff to set
	 */
	public void setJcff(String jcff) {
		this.jcff = jcff;
	}

	/**
	 * @return the zqzt
	 */
	public String getZqzt() {
		return zqzt;
	}

	/**
	 * @param zqzt
	 *            the zqzt to set
	 */
	public void setZqzt(String zqzt) {
		this.zqzt = zqzt;
	}

	/**
	 * @return the jcstatus
	 */
	public BigDecimal getJcstatus() {
		return jcstatus;
	}

	/**
	 * @param jcstatus
	 *            the jcstatus to set
	 */
	public void setJcstatus(BigDecimal jcstatus) {
		this.jcstatus = jcstatus;
	}

	/**
	 * @return the jcperson
	 */
	public String getJcperson() {
		return jcperson;
	}

	/**
	 * @param jcperson
	 *            the jcperson to set
	 */
	public void setJcperson(String jcperson) {
		this.jcperson = jcperson;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the oplog_yesorno
	 */
	public Boolean getOplog_yesorno() {
		return oplog_yesorno;
	}

	/**
	 * @param oplog_yesorno
	 *            the oplog_yesorno to set
	 */
	public void setOplog_yesorno(Boolean oplog_yesorno) {
		this.oplog_yesorno = oplog_yesorno;
	}

	/**
	 * @return the oplog_zxdate
	 */
	public Date getOplog_zxdate() {
		return oplog_zxdate;
	}

	/**
	 * @param oplog_zxdate
	 *            the oplog_zxdate to set
	 */
	public void setOplog_zxdate(Date oplog_zxdate) {
		this.oplog_zxdate = oplog_zxdate;
	}

	/**
	 * @return the workorderid
	 */
	public Long getWorkorderid() {
		return workorderid;
	}

	/**
	 * @param workorderid
	 *            the workorderid to set
	 */
	public void setWorkorderid(Long workorderid) {
		this.workorderid = workorderid;
	}

	/**
	 * @return the jczt
	 */
	public String getJczt() {
		return jczt;
	}

	/**
	 * @param jczt the jczt to set
	 */
	public void setJczt(String jczt) {
		this.jczt = jczt;
	}
	

}
