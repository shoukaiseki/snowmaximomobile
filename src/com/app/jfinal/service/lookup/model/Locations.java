package com.app.jfinal.service.lookup.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;


/** Locations
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月14日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
@SnowTable(maxObjecxtName = "LOCATIONS")
public class Locations extends BaseModel {





	/**
	 *自动生成工单
	 **/
	private Boolean autowogen;


	/**
	 *收款人地址
	 **/
	private String billtoaddresscode;


	/**
	 *收款方员工
	 **/
	private String billtolaborcode;


	/**
	 *变更人
	 **/
	private String changeby;


	/**
	 *变更日期
	 **/
	private Date changedate;


	/**
	 *类结构
	 **/
	private String classstructureid;


	/**
	 *GL 控制科目
	 **/
	private String controlacc;


	/**
	 *货币差异科目
	 **/
	private String curvaracc;


	/**
	 *创建日期
	 **/
	private Date da_createdate;


	/**
	 *创建人
	 **/
	private String da_createperson;


	/**
	 *部门
	 **/
	private String da_depnum;


	/**
	 *工序
	 **/
	private String da_process;


	/**
	 *描述
	 **/
	private String description;


	/**
	 *文本搜索类型
	 **/
	private String descriptiontext;


	/**
	 *禁用
	 **/
	private Boolean disabled;


	/**
	 *外部引用标识
	 **/
	private String externalrefid;


	/**
	 *GIS 参数 1
	 **/
	private String gisparam1;


	/**
	 *GIS 参数 2
	 **/
	private String gisparam2;


	/**
	 *图形信息系统参数 3
	 **/
	private String gisparam3;


	/**
	 *GL 科目
	 **/
	private String glaccount;


	/**
	 *具有详细描述
	 **/
	private Boolean hasld;


	/**
	 *内部员工科目
	 **/
	private String intlabrec;


	/**
	 *成本调整科目
	 **/
	private String invcostadjacc;


	/**
	 *发票差异科目
	 **/
	private String invoicevaracc;


	/**
	 *库存所有者
	 **/
	private String invowner;


	/**
	 *缺省库房
	 **/
	private Boolean isdefault;


	/**
	 *是否为维修设施
	 **/
	private Boolean isrepairfacility;


	/**
	 *语言代码
	 **/
	private String langcode;


	/**
	 *位置
	 **/
	private String location;


	/**
	 *LOCATIONSID
	 **/
	private Long locationsid;


	/**
	 *原 GL 控制科目
	 **/
	private String oldcontrolacc;


	/**
	 *原发票成本调整科目
	 **/
	private String oldinvcostadjacc;


	/**
	 *原损耗科目
	 **/
	private String oldshrinkageacc;


	/**
	 *组织
	 **/
	private String orgid;


	/**
	 *所有者系统标识
	 **/
	private String ownersysid;


	/**
	 *下一个校准到期日期
	 **/
	private Date pluscduedate;


	/**
	 *回路校准
	 **/
	private Boolean pluscloop;


	/**
	 *已延长到期日期
	 **/
	private Boolean pluscpmextdate;


	/**
	 *采购差价科目
	 **/
	private String purchvaracc;


	/**
	 *收据差异科目
	 **/
	private String receiptvaracc;


	/**
	 *服务地址
	 **/
	private String saddresscode;


	/**
	 *发送者系统标识
	 **/
	private String sendersysid;


	/**
	 *服务地址
	 **/
	private String serviceaddresscode;


	/**
	 *收货地址
	 **/
	private String shiptoaddresscode;


	/**
	 *收货员工
	 **/
	private String shiptolaborcode;


	/**
	 *损耗科目
	 **/
	private String shrinkageacc;


	/**
	 *地点
	 **/
	private String siteid;


	/**
	 *源系统标识
	 **/
	private String sourcesysid;


	/**
	 *状态
	 **/
	private String status;


	/**
	 *状态日期
	 **/
	private Date statusdate;


	/**
	 *工具控制科目
	 **/
	private String toolcontrolacc;


	/**
	 *类型
	 **/
	private String type;


	/**
	 *在 PO/PR 中使用
	 **/
	private Boolean useinpopr;

	public Boolean getAutowogen() {
		return autowogen;
	}

	public void setAutowogen(Boolean autowogen) {
		this.autowogen = autowogen;
	}

	public String getBilltoaddresscode() {
		return billtoaddresscode;
	}

	public void setBilltoaddresscode(String billtoaddresscode) {
		this.billtoaddresscode = billtoaddresscode;
	}

	public String getBilltolaborcode() {
		return billtolaborcode;
	}

	public void setBilltolaborcode(String billtolaborcode) {
		this.billtolaborcode = billtolaborcode;
	}

	public String getChangeby() {
		return changeby;
	}

	public void setChangeby(String changeby) {
		this.changeby = changeby;
	}

	public Date getChangedate() {
		return changedate;
	}

	public void setChangedate(Date changedate) {
		this.changedate = changedate;
	}

	public String getClassstructureid() {
		return classstructureid;
	}

	public void setClassstructureid(String classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getControlacc() {
		return controlacc;
	}

	public void setControlacc(String controlacc) {
		this.controlacc = controlacc;
	}

	public String getCurvaracc() {
		return curvaracc;
	}

	public void setCurvaracc(String curvaracc) {
		this.curvaracc = curvaracc;
	}

	public Date getDa_createdate() {
		return da_createdate;
	}

	public void setDa_createdate(Date da_createdate) {
		this.da_createdate = da_createdate;
	}

	public String getDa_createperson() {
		return da_createperson;
	}

	public void setDa_createperson(String da_createperson) {
		this.da_createperson = da_createperson;
	}

	public String getDa_depnum() {
		return da_depnum;
	}

	public void setDa_depnum(String da_depnum) {
		this.da_depnum = da_depnum;
	}

	public String getDa_process() {
		return da_process;
	}

	public void setDa_process(String da_process) {
		this.da_process = da_process;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptiontext() {
		return descriptiontext;
	}

	public void setDescriptiontext(String descriptiontext) {
		this.descriptiontext = descriptiontext;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getExternalrefid() {
		return externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
	}

	public String getGisparam1() {
		return gisparam1;
	}

	public void setGisparam1(String gisparam1) {
		this.gisparam1 = gisparam1;
	}

	public String getGisparam2() {
		return gisparam2;
	}

	public void setGisparam2(String gisparam2) {
		this.gisparam2 = gisparam2;
	}

	public String getGisparam3() {
		return gisparam3;
	}

	public void setGisparam3(String gisparam3) {
		this.gisparam3 = gisparam3;
	}

	public String getGlaccount() {
		return glaccount;
	}

	public void setGlaccount(String glaccount) {
		this.glaccount = glaccount;
	}

	public Boolean getHasld() {
		return hasld;
	}

	public void setHasld(Boolean hasld) {
		this.hasld = hasld;
	}

	public String getIntlabrec() {
		return intlabrec;
	}

	public void setIntlabrec(String intlabrec) {
		this.intlabrec = intlabrec;
	}

	public String getInvcostadjacc() {
		return invcostadjacc;
	}

	public void setInvcostadjacc(String invcostadjacc) {
		this.invcostadjacc = invcostadjacc;
	}

	public String getInvoicevaracc() {
		return invoicevaracc;
	}

	public void setInvoicevaracc(String invoicevaracc) {
		this.invoicevaracc = invoicevaracc;
	}

	public String getInvowner() {
		return invowner;
	}

	public void setInvowner(String invowner) {
		this.invowner = invowner;
	}

	public Boolean getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(Boolean isdefault) {
		this.isdefault = isdefault;
	}

	public Boolean getIsrepairfacility() {
		return isrepairfacility;
	}

	public void setIsrepairfacility(Boolean isrepairfacility) {
		this.isrepairfacility = isrepairfacility;
	}

	public String getLangcode() {
		return langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getLocationsid() {
		return locationsid;
	}

	public void setLocationsid(Long locationsid) {
		this.locationsid = locationsid;
	}

	public String getOldcontrolacc() {
		return oldcontrolacc;
	}

	public void setOldcontrolacc(String oldcontrolacc) {
		this.oldcontrolacc = oldcontrolacc;
	}

	public String getOldinvcostadjacc() {
		return oldinvcostadjacc;
	}

	public void setOldinvcostadjacc(String oldinvcostadjacc) {
		this.oldinvcostadjacc = oldinvcostadjacc;
	}

	public String getOldshrinkageacc() {
		return oldshrinkageacc;
	}

	public void setOldshrinkageacc(String oldshrinkageacc) {
		this.oldshrinkageacc = oldshrinkageacc;
	}

	@Override
	public String getOrgid() {
		return orgid;
	}

	@Override
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOwnersysid() {
		return ownersysid;
	}

	public void setOwnersysid(String ownersysid) {
		this.ownersysid = ownersysid;
	}

	public Date getPluscduedate() {
		return pluscduedate;
	}

	public void setPluscduedate(Date pluscduedate) {
		this.pluscduedate = pluscduedate;
	}

	public Boolean getPluscloop() {
		return pluscloop;
	}

	public void setPluscloop(Boolean pluscloop) {
		this.pluscloop = pluscloop;
	}

	public Boolean getPluscpmextdate() {
		return pluscpmextdate;
	}

	public void setPluscpmextdate(Boolean pluscpmextdate) {
		this.pluscpmextdate = pluscpmextdate;
	}

	public String getPurchvaracc() {
		return purchvaracc;
	}

	public void setPurchvaracc(String purchvaracc) {
		this.purchvaracc = purchvaracc;
	}

	public String getReceiptvaracc() {
		return receiptvaracc;
	}

	public void setReceiptvaracc(String receiptvaracc) {
		this.receiptvaracc = receiptvaracc;
	}

	public String getSaddresscode() {
		return saddresscode;
	}

	public void setSaddresscode(String saddresscode) {
		this.saddresscode = saddresscode;
	}

	public String getSendersysid() {
		return sendersysid;
	}

	public void setSendersysid(String sendersysid) {
		this.sendersysid = sendersysid;
	}

	public String getServiceaddresscode() {
		return serviceaddresscode;
	}

	public void setServiceaddresscode(String serviceaddresscode) {
		this.serviceaddresscode = serviceaddresscode;
	}

	public String getShiptoaddresscode() {
		return shiptoaddresscode;
	}

	public void setShiptoaddresscode(String shiptoaddresscode) {
		this.shiptoaddresscode = shiptoaddresscode;
	}

	public String getShiptolaborcode() {
		return shiptolaborcode;
	}

	public void setShiptolaborcode(String shiptolaborcode) {
		this.shiptolaborcode = shiptolaborcode;
	}

	public String getShrinkageacc() {
		return shrinkageacc;
	}

	public void setShrinkageacc(String shrinkageacc) {
		this.shrinkageacc = shrinkageacc;
	}

	@Override
	public String getSiteid() {
		return siteid;
	}

	@Override
	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getSourcesysid() {
		return sourcesysid;
	}

	public void setSourcesysid(String sourcesysid) {
		this.sourcesysid = sourcesysid;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	public String getToolcontrolacc() {
		return toolcontrolacc;
	}

	public void setToolcontrolacc(String toolcontrolacc) {
		this.toolcontrolacc = toolcontrolacc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getUseinpopr() {
		return useinpopr;
	}

	public void setUseinpopr(Boolean useinpopr) {
		this.useinpopr = useinpopr;
	}
}
