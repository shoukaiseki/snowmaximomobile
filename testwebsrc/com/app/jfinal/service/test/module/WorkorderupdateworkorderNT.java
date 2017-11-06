package com.app.jfinal.service.test.module;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.app.jfinal.service.common.model.DocFile;
import com.app.jfinal.service.test.TestController;
import com.app.jfinal.service.workorder.model.WosafetylinkView;
import com.app.jfinal.service.workorder.model.WohazardprecView;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.google.common.collect.Lists;
import com.app.jfinal.service.test.NavigationTest;
import com.app.jfinal.service.workorder.db.WorkorderDB;
import com.app.jfinal.service.workorder.model.Workorder;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.utils.Base64Utils;

public class WorkorderupdateworkorderNT extends NavigationTest{
	
	public static final Logger logger = Logger.getLogger(WorkorderupdateworkorderNT.class);
	
	public WorkorderupdateworkorderNT() {
		// TODO Auto-generated constructor stub
		super("workorder/updateworkorder","新建/更新workorder至数据库","新建/更新workorder至数据库,"
				+ "<br>返回值: workorder 数据,ms_id字段有值,用于本地数据库更新"
				+ "<br>workorderid=11150 118服务器"
				+ "<br>app接口只需要  personid siteid 两个参数" );
		addParameter(new BasicNameValuePair("personid", "maxadmin"));
		addParameter(new BasicNameValuePair("siteid", TestController.siteid));
		addParameter(new BasicNameValuePair("workorderid", "64830"));
		addParameter(new BasicNameValuePair("description", "描述内容"));
		addParameter(new BasicNameValuePair("uploadfile", "C:/temp/001.jpg"));
		addParameter(new BasicNameValuePair("filename", "001.jpg"));
		
	}
	
	@Override
	public JsonModel getJsonModel(HashMap<String, String> paras) {
		// TODO Auto-generated method stub
		JsonModel jm=super.getJsonModel(paras);
		Workorder wo=new Workorder();
		/**
		 **/
		wo.setSiteid(paras.get("siteid"));
		wo.setReportedby(paras.get("personid"));
		wo.setReportdate(new Date());
//		wo.setWorktype("WO");
		//设置为新增
		wo.setMs_toadd(true);
		//"手机数据库唯一id编号"
		//手机数据库唯一id编号
		wo.setMs_id(UUID.randomUUID().toString());
		

		
		DocFile docfile=new DocFile();
		String base64=null;
		
		File file=new File(paras.get("uploadfile"));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = null;  
		try {  
			// 根据文件创建文件的输入流  
			in = new FileInputStream(file);  
			// 创建字节数组  
			// 读取内容，放到字节数组里面  
			byte[] buffer = new byte[256];
			int n;
			while ((n = in.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
			;
		} catch (Exception e) {  
			e.printStackTrace();  
		} finally {  
			try {  
				// 关闭输入流  
				in.close();  
			} catch (Exception e) {  
				e.printStackTrace();  
			}  
		}  
		
		byte[] bytes = out.toByteArray();
		
		logger.debug("docfile.bytes.length="+bytes.length);
		base64=Base64Utils.encodeBase64(bytes);
		bytes=Base64Utils.decodeBase64(base64);
		logger.debug("decodeBase64.docfile.bytes.length="+bytes.length);
		logger.debug("base64="+base64);
		docfile.setBase64(base64);
		docfile.setMs_toadd(true);
		docfile.setFileName(paras.get("filename"));
		docfile.setDescription(paras.get("filename"));
		
		ArrayList<DocFile> docfiles = Lists.newArrayList();
		docfiles.add(docfile);
		wo.setDfs(docfiles);
		
		jm.addDatas( wo);

		WorkorderDB workDB=new WorkorderDB();
		wo=workDB.findwotrackbywoid(paras);
		if(wo!=null){
			wo.setMs_id(UUID.randomUUID().toString());
			wo.setMs_tobemodify(true);
//			wo.setRowstamp(213123L);
			List<WosafetylinkView> wosafetylinks = wo.getWosafetylinks();
			WosafetylinkView ww=new WosafetylinkView();
			ww.setHazardid("WX1005");
			ww.setWohazard_description("气体窒息中毒");
			ww.setMs_toadd(true);
			wosafetylinks.add(ww);
			WohazardprecView wd=new WohazardprecView();
			wd.setHazardid("WX1005");
			wd.setPrecautionid("YF1031");
			wd.setWoprecaution_description("办理登高作业票，并要求各工序确定具备检修条件");
			wd.setMs_toadd(true);
			ww.getWohazardprecViews().add(wd);

			wo.setDescription(paras.get("description"));

//			jm.addDatas(wo);
		}

		logger.debug("send.jsonmodel="+ JSONObject.toJSONString(jm));
		return jm;
	}
	

}
