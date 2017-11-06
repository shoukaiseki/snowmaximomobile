package com.app.jfinal.service.test.module;

import java.util.HashMap;

import org.apache.http.message.BasicNameValuePair;

import com.app.jfinal.service.test.NavigationTest;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;

public class WorkflowNT extends NavigationTest{
	
	public WorkflowNT() {
		// TODO Auto-generated constructor stub
		
		super("workflow/process","workflow/process","发送工作流接口"
				+ "<br>"
				);
		addParameter(new BasicNameValuePair("ownerid", "64818"));
		addParameter(new BasicNameValuePair("ownertable", "WORKORDER"));
		addParameter(new BasicNameValuePair("appname", "WOTRACK"));
		addParameter(new BasicNameValuePair("loginid", "zhaod441"));
		addParameter(new BasicNameValuePair("DirectorInput", "workflow"));
		
	}
	
	@Override
	public JsonModel getJsonModel(HashMap<String, String> paras) {
		// TODO Auto-generated method stub
		JsonModel jm=super.getJsonModel(paras);
		//工作流必须设置该属性为 WORKFLOW
		jm.setBusiness("WORKFLOW");
		
		return jm;
	}
	

}
