package com.app.jfinal.service.test;


import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
/**
 * Hello world!
 *
 */
public class TestJfinalComm 
{
    public static void main( String[] args )
    {
    		String message="";
    		String resp = "";
    		try {
    			String endPoint = "http://127.0.0.1:7001/mxservice/services/saycxf";
    			endPoint="http://localhost:7001/mxservice/services/jfinalcomm";
    			Service server = new Service();
    			
    			Call call = (Call) server.createCall();
    			
    			call.setTargetEndpointAddress(new URL(endPoint));
    			
    			JsonModel jm=new JsonModel();
    			jm.setBusiness("WORKFLOW");
    			jm.addParameters(new BasicNameValuePair("loginid","qiaosh"));
    			jm.addParameters(new BasicNameValuePair("appname","WOTRACK"));
    			jm.addParameters(new BasicNameValuePair("ownerid","10863"));
    			jm.addParameters(new BasicNameValuePair("ownertable","WORKORDER"));
    			jm.addParameters(new BasicNameValuePair("DirectorInput","workflow"));
    			
    			
    			String json = JSONObject.toJSONString(jm);

    			Object obj ;
//    			obj= call.invoke("say",
//    					new Object[] { strxml });
//    			
//    			
    			
    			obj=null;
    			obj=call.invoke("send",new Object[]{json});
    			System.out.println("send="+obj);
    			if (obj != null) {
    				
    			}
    			
    			
    			

    			message="上傳數據完成:"+obj;
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    			message="上傳數據失敗:<br>"+e.getMessage();
    		}

    	}
}
