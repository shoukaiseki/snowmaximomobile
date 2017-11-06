package org.shoukaiseki.jfinal.kernel.maximo.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowField;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.Date;
import java.util.HashMap;

/** Doclinks
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月23日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
@SnowTable(maxObjecxtName = "DOCLINKS",maxSequenceName="DOCLINKSSEQ")
public class Doclinks extends BaseModel{



	//Anywhere 引用标识
	private Long anywhererefid;

	//变更人
	private String changeby;

	//变更日期
	private Date changedate;

	//复制链接到工单
	private Boolean copylinktowo;

	//创建人
	private String createby;

	//创建日期
	private Date createdate;

	//文档信息标识
	private Long docinfoid;

	//DOCLINKSID
	private Long doclinksid;

	//文档文件夹
	private String doctype;

	//文档
	private String document;

	//文档版本
	private String docversion;

	//最新版本
	private Boolean getlatestversion;

	//所有者标识
	private Long ownerid;

	//所有者表
	private String ownertable;

	//批处理打印
	private Boolean printthrulink;

	//引用
	private String reference;
	
	@SnowField(isPersistent=false)
	private String orgid;
	
	@SnowField(isPersistent=false)
	private String siteid;

	public Long getAnywhererefid() {
		return anywhererefid;
	}

	public void setAnywhererefid(Long anywhererefid) {
		this.anywhererefid = anywhererefid;
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

	public Boolean getCopylinktowo() {
		return copylinktowo;
	}

	public void setCopylinktowo(Boolean copylinktowo) {
		this.copylinktowo = copylinktowo;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Long getDocinfoid() {
		return docinfoid;
	}

	public void setDocinfoid(Long docinfoid) {
		this.docinfoid = docinfoid;
	}

	public Long getDoclinksid() {
		return doclinksid;
	}

	public void setDoclinksid(Long doclinksid) {
		this.doclinksid = doclinksid;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDocversion() {
		return docversion;
	}

	public void setDocversion(String docversion) {
		this.docversion = docversion;
	}

	public Boolean getGetlatestversion() {
		return getlatestversion;
	}

	public void setGetlatestversion(Boolean getlatestversion) {
		this.getlatestversion = getlatestversion;
	}

	public Long getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}

	public String getOwnertable() {
		return ownertable;
	}

	public void setOwnertable(String ownertable) {
		this.ownertable = ownertable;
	}

	public Boolean getPrintthrulink() {
		return printthrulink;
	}

	public void setPrintthrulink(Boolean printthrulink) {
		this.printthrulink = printthrulink;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}



	@Override
	public HashMap<String, Object> ifNullDefaultValueMap() {
		// TODO Auto-generated method stub
		HashMap<String,Object> defvalmap = super.ifNullDefaultValueMap();
		defvalmap.put("DOCTYPE", "mobileupload");
		defvalmap.put("CREATEDATE", "&SYSDATE&");
		defvalmap.put("CHANGEDATE", "&SYSDATE&");
		defvalmap.put("CHANGEBY", "&PERSONID&");
		defvalmap.put("CREATEBY", "&PERSONID&");
		defvalmap.put("GETLATESTVERSION", "1");
		defvalmap.put("PRINTTHRULINK", "1");
		return defvalmap;
	}
	

}
