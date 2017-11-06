package org.shoukaiseki.jfinal.kernel.maximo.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowField;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

/** com.app.jfinal.service.common.Photo
 * 照片对象
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月5日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class DocFile extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  唯一id
	 */
	private Long docinfoid;

	/**
	 * 文件字节码转换为base64字符串
	 * 上传时有效,下载时根据 url 字段提供的链接下载
	 */
	private String base64;
	
	/**
	 * 文件下载地址
	 * 上传时无效,只限下载时使用
	 * 
	 */
	private String url;


	// 照片路径,app端在本地保存使用
	private String path;
	
	/**
	 * 文件显示名称 
	 */
	private String document;
	
	/**
	 * 
	 */
	private String urlname;


	 
	/**
	 * 文件所属表
	 */
	private String ownertable;
	
	/**
	 * 文件所属表 id
	 */
	private Long ownerid;

	// 创建时间
	private Date createdate;

	

	// 文件名
	private String fileName;

	/**
	 * 文件描述
	 */
	private String description;
	
	/**
	 * 创建人 personid
	 */
	private String createby;
	
	
	

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getUrlname() {
		return urlname;
	}

	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}

	public String getOwnertable() {
		return ownertable;
	}

	public void setOwnertable(String ownertable) {
		this.ownertable = ownertable;
	}

	public Long getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	// 是否是持久化属性
	@JSONField(serialize = false)
	private boolean persistence = true;

	public boolean isPersistence() {
		return persistence;
	}

	public void setPersistence(boolean persistence) {
		this.persistence = persistence;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}


	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}



	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDocinfoid() {
		return docinfoid;
	}

	public void setDocinfoid(Long docinfoid) {
		this.docinfoid = docinfoid;
	}

	
}
