package com.app.jfinal.service.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.HttpKit;
import org.shoukaiseki.jfinal.kernel.AbstractController;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.utils.StreamUtil;
import org.shoukaiseki.jfinal.kernel.utils.ZipCompress;

public class TestAC extends AbstractController{
	
	public static String TAG = "testac";
		JsonModel jsonModel = null;
	
	public void index() {
		// TODO Auto-generated method stub
		jsonModel=new JsonModel();
		String as="ass";
		String json = JSONObject.toJSONString(as);
		jsonModel.setJson(json);
		render(jsonModel);

	}
	
	public void test(){
		renderText("asus");
	}
	
	public void param() {
		initJsonModel();
		System.out.println("param22");
		String key = getPara("jsonmodeldata");
		System.out.println("status="+key);
		
//		key=key.replaceAll("!", "\\+");
////		key=JSONObject.parseObject(key,String.class);
//		System.out.println("key="+key);
//		String as=ZipCompress.dbuToString(key);
		String as=jm.getJson();
		System.out.println("as="+as);
		jsonModel=new JsonModel();
		String json = JSONObject.toJSONString(as);
		jsonModel.setJson(json);
		
		
		
		
		render(jsonModel);
	}

}
