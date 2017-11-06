package com.app.jfinal.service.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;

import org.shoukaiseki.jfinal.kernel.http.JsonModel;

public class NavigationTest {
	public static Map<String,NavigationTest> map=new HashMap<String, NavigationTest>(); 
	
	private String id;
	
	private String text;
	
	private String description;
	
	private List<NavigationTest> children;
	
	private List<NameValuePair> parameter;
	
	
	

	public NavigationTest() {
		
	}
	
	public NavigationTest(String id,String text,String description) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.text=text;
		this.description=description;
		map.put(id, this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

	public List<NavigationTest> getChildren() {
		return children;
	}

	public void setChildren(List<NavigationTest> children) {
		this.children = children;
	}
	
	
	
	public List<NameValuePair> getParameter() {
		return parameter;
	}

	public void setParameter(List<NameValuePair> parameter) {
		this.parameter = parameter;
	}
	
	public void addParameter(NameValuePair... parameters) {
		for (NameValuePair para : parameters) {
			if(parameter==null){
				parameter=new ArrayList<NameValuePair>(); 
			}
			parameter.add(para);
		}
	}

	public NavigationTest addChildren(NavigationTest... childrens) {
		for (NavigationTest node : childrens) {
			if(children==null){
				children=new ArrayList<NavigationTest>(); 
			}
			children.add(node);
			
		}
		return this;
	}

	public JsonModel getJsonModel(HashMap<String,String> paras){
		JsonModel jm=new JsonModel();
		jm.addParameters(paras);
		return jm;
	}
}
