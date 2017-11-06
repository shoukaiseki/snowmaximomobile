package com.app.jfinal.service.checkversion;

import java.io.IOException;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.app.jfinal.service.checkversion.model.Version;
import org.shoukaiseki.jfinal.kernel.AbstractController;
import org.shoukaiseki.jfinal.kernel.SnowConfig;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;
import org.shoukaiseki.jfinal.kernel.utils.ZipCompress;

public class VersionController extends AbstractController{
	
	public static String TAG="version";
	
	public void checkversion() {
		// TODO Auto-generated method stub
		try{
			logger.debug("setHttpServletRequest");
			jm=new JsonModel();
			String data = getPara("jsonmodeldata");
			if(data!=null){
				String jsonStr=ZipCompress.dbuToString(data);
				if(jsonStr!=null&&!jsonStr.trim().isEmpty()){
					jm=JSON.parseObject(jsonStr, JsonModel.class);
					HashMap<String, ?> parameters = jm.getParameters();
					if(parameters==null){
						parameters=new HashMap<String, Object>();
					}
				}
				if(SnowConfig.snow_jfinal_devMode){
					HashMap map=jm.getParameters();
					StringBuffer sb=new StringBuffer("------------------------------------------------------------------------------------\n");
					sb.append("parameters : ");
					for (Object key : map.keySet()) {
						sb.append(key).append(" = ").append(map.get(key)).append("  ;");
					}
					sb.append("\n------------------------------------------------------------------------------------");
					System.out.println(sb.toString());
				}
			}

			String version = getCanshu("version");
			if(version==null){
				throw new SnowException(4);
			}
			String systemtype = getCanshu("systemtype");
			Version v=new Version();
			v.setUrl("http://xnymaximotest1.dunanchina.net:8000/dunanjfinal/apk/wmccnmobile.apk");
			v.setUpdated(false);
			v.setForced(false);;
			v.setVersion("1.1.1");
			v.setVersion1(1);
			v.setVersion2(1);
			v.setVersion3(1);
			Record record = Db.findFirst(SqlReadConfig.getSql("checkversion.getmaxversion", jm.getParameters()));
			if(record==null){
				throw new SnowException(5);
			}
			v= BaseModel.Companion.recordTo(record, Version.class);
			if("android".equalsIgnoreCase(systemtype)){
				String[] split = version.split("\\.");
				if(new Integer(split[0])<v.getVersion1()){
					v.setForced(true);
					v.setUpdated(true);
				}
				if(new Integer(split[1])<v.getVersion2()){
					v.setForced(true);
					v.setUpdated(true);
				}
				if(new Integer(split[2])<v.getVersion3()){
					v.setUpdated(true);
				}
				jsonModel.addDatas( v);
			}else if("ios".equalsIgnoreCase(systemtype)){
				String[] split = version.split("\\.");
				if(new Integer(split[0])<v.getVersion1()){
					v.setForced(true);
					v.setUpdated(true);
				}
				if(new Integer(split[1])<v.getVersion2()){
					v.setForced(true);
					v.setUpdated(true);
				}
				if(new Integer(split[2])<v.getVersion3()){
					v.setUpdated(true);
				}
				jsonModel.addDatas(v);
			}

			render(jsonModel);
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(new SnowException(10000,e));
		}

	}
	
	public void downloadandroid(){
		try {
			Record record = Db.findFirst(SqlReadConfig.getSql("checkversion.getmaxversion_android"));
			if(record!=null){
				Version v= BaseModel.Companion.recordTo(record, Version.class);
				getResponse().sendRedirect(v.getUrl());
			}else{
				renderText("获取新版本信息失败");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderText("没有可用的版本信息");
		}
	}
	
	public void downloadios(){
		try {
			Record record = Db.findFirst(SqlReadConfig.getSql("checkversion.getmaxversion_ios"));
			if(record!=null){
				Version v= BaseModel.Companion.recordTo(record, Version.class);
				getResponse().sendRedirect(v.getUrl());
			}else{
				renderText("获取新版本信息失败");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderText("没有可用的版本信息");
		}
	}

}
