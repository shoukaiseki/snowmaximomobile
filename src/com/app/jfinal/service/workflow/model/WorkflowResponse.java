package com.app.jfinal.service.workflow.model;

import java.util.LinkedHashMap;

/** 流程操作返回消息类
 * com.shuto.mam.webclient.beans.common.workflow.WorkflowResponse
 * @author 蒋カイセキ    Japan-Tokyo  2015-9-16
 * @ブログ http://shoukaiseki.blog.163.com/
 * @E-メール jiang28555@Gmail.com
 */
public class WorkflowResponse {
	
	/**
	 * 错误消息
	 */
	private String errormsg;
	
	private boolean isError=false;
	
	private String wfsessionid;
	
	private int assignid;
	
	private String assignmentDescription="";
	
	private LinkedHashMap<String,WorkflowResponseAction> lhm;
	
	/**
	 * 显示操作对话框类型
	 */
	private String maxdialog=null;
	
	
	/**
	 * 位于maximo 保存按钮上方的提示消息,例: BMXAA4205I - 记录已保存。
	 */
	private String messageBoxSTATUS=null;
	
	
	/**
	 * 提示框,弹出的消息提示框
	 */
	private String messageBoxMSGBox=null;
	
	
	/**
	 * 暂时未见过此类提示,预留, 预计是显示在页面中的提示
	 */
	private String messageBoxTEXT=null;
	
	
	/**
	 * 流程是否已启用
	 */
	private boolean isActive=false;

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getWfsessionid() {
		return wfsessionid;
	}

	public void setWfsessionid(String wfsessionid) {
		this.wfsessionid = wfsessionid;
	}
	
	
	public int getAssignid() {
		return assignid;
	}

	public void setAssignid(int assignid) {
		this.assignid = assignid;
	}


	public LinkedHashMap<String, WorkflowResponseAction> getLhm() {
		return lhm;
	}

	public void setLhm(LinkedHashMap<String, WorkflowResponseAction> lhm) {
		this.lhm = lhm;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getAssignmentDescription() {
		return assignmentDescription;
	}

	public void setAssignmentDescription(String assignmentDescription) {
		this.assignmentDescription = assignmentDescription;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public String getMessageBoxSTATUS() {
		return messageBoxSTATUS;
	}

	public void setMessageBoxSTATUS(String messageBoxSTATUS) {
		this.messageBoxSTATUS = messageBoxSTATUS;
	}

	public String getMessageBoxMSGBox() {
		return messageBoxMSGBox;
	}

	public void setMessageBoxMSGBox(String messageBoxMSGBox) {
		this.messageBoxMSGBox = messageBoxMSGBox;
	}

	public String getMessageBoxTEXT() {
		return messageBoxTEXT;
	}

	public void setMessageBoxTEXT(String messageBoxTEXT) {
		this.messageBoxTEXT = messageBoxTEXT;
	}

	public String getMaxdialog() {
		return maxdialog;
	}

	public void setMaxdialog(String maxdialog) {
		this.maxdialog = maxdialog;
	}

	


}
