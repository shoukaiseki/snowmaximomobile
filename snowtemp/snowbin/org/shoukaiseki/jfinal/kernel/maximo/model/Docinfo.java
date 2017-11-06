package org.shoukaiseki.jfinal.kernel.maximo.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowField;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.Date;
import java.util.HashMap;

/** Docinfo
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月23日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
@SnowTable(maxObjecxtName = "DOCINFO",maxSequenceName="DOCINFOSEQ")
public class Docinfo extends BaseModel{



	//应用程序
	private String application;

	//变更人
	private String changeby;

	//变更日期
	private Date changedate;

	//内容的唯一标识
	private String contentuid;

	//创建人
	private String createby;

	//创建日期
	private Date createdate;

	//描述
	private String description;

	//DMS
	private String dmsname;

	//DOCINFOID
	private Long docinfoid;

	//文档位置
	private String doclocation;

	//文档文件夹
	private String doctype;

	//文档
	private String document;

	//具有详细描述
	private Boolean hasld;

	//语言代码
	private String langcode;

	//缺省的批处理打印
	private Boolean printthrulinkdflt;

	//修订
	private Integer revision;

	//显示
	private Boolean show;

	//状态
	private String status;

	//状态日期
	private Date statusdate;

	//URL/文件名
	private String urlname;

	//URL 参数 1
	private String urlparam1;

	//URL 参数 2
	private String urlparam2;

	//URL 参数 3
	private String urlparam3;

	//URL 参数 4
	private String urlparam4;

	//URL 参数 5
	private String urlparam5;

	//URL 类型
	private String urltype;

	//缺省文档文件路径
	private Boolean usedefaultfilepath;
	
	@SnowField(isPersistent=false)
	private String orgid;
	
	@SnowField(isPersistent=false)
	private String siteid;

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
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

	public String getContentuid() {
		return contentuid;
	}

	public void setContentuid(String contentuid) {
		this.contentuid = contentuid;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDmsname() {
		return dmsname;
	}

	public void setDmsname(String dmsname) {
		this.dmsname = dmsname;
	}

	public Long getDocinfoid() {
		return docinfoid;
	}

	public void setDocinfoid(Long docinfoid) {
		this.docinfoid = docinfoid;
	}

	public String getDoclocation() {
		return doclocation;
	}

	public void setDoclocation(String doclocation) {
		this.doclocation = doclocation;
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

	public Boolean getHasld() {
		return hasld;
	}

	public void setHasld(Boolean hasld) {
		this.hasld = hasld;
	}

	public String getLangcode() {
		return langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public Boolean getPrintthrulinkdflt() {
		return printthrulinkdflt;
	}

	public void setPrintthrulinkdflt(Boolean printthrulinkdflt) {
		this.printthrulinkdflt = printthrulinkdflt;
	}

	public Integer getRevision() {
		return revision;
	}

	public void setRevision(Integer revision) {
		this.revision = revision;
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	public String getUrlname() {
		return urlname;
	}

	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}

	public String getUrlparam1() {
		return urlparam1;
	}

	public void setUrlparam1(String urlparam1) {
		this.urlparam1 = urlparam1;
	}

	public String getUrlparam2() {
		return urlparam2;
	}

	public void setUrlparam2(String urlparam2) {
		this.urlparam2 = urlparam2;
	}

	public String getUrlparam3() {
		return urlparam3;
	}

	public void setUrlparam3(String urlparam3) {
		this.urlparam3 = urlparam3;
	}

	public String getUrlparam4() {
		return urlparam4;
	}

	public void setUrlparam4(String urlparam4) {
		this.urlparam4 = urlparam4;
	}

	public String getUrlparam5() {
		return urlparam5;
	}

	public void setUrlparam5(String urlparam5) {
		this.urlparam5 = urlparam5;
	}

	public String getUrltype() {
		return urltype;
	}

	public void setUrltype(String urltype) {
		this.urltype = urltype;
	}

	public Boolean getUsedefaultfilepath() {
		return usedefaultfilepath;
	}

	public void setUsedefaultfilepath(Boolean usedefaultfilepath) {
		this.usedefaultfilepath = usedefaultfilepath;
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
		defvalmap.put("LANGCODE", "ZH");
		defvalmap.put("URLTYPE", "文件");
		defvalmap.put("USEDEFAULTFILEPATH", 0);
		
		return defvalmap;
	}

}
