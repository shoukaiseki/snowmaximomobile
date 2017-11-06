package com.app.jfinal.service.workflow;

import com.app.jfinal.service.workflow.model.Wfassignment;
import com.app.jfinal.service.workflow.model.Wftransaction;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.render.Render;
import org.shoukaiseki.jfinal.kernel.AbstractController;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.List;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import com.alibaba.fastjson.JSONObject;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.http.RenderBytes;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;
import org.shoukaiseki.jfinal.kernel.utils.ZipCompress;

/** WorkflowController
 * 流程类接口
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月18日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class WorkflowController extends AbstractController{

	public static final String TAG = "workflow";
	
	public void listassignwf(){
		try{
			initJsonModel();
			String sql = SqlReadConfig.getSql("workflow.listassignwf",jm.getParameters());
			List<Record> list = Db.find(sql);
			Wfassignment obj=null;
			for (Record record : list) {
				obj= BaseModel.Companion.recordTo(record,Wfassignment.class);
				jsonModel.addDatas(obj);
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
	
	public void listapprovalhistory(){
		try{
			initJsonModel();
			String sql = SqlReadConfig.getSql("workflow.listapprovalhistory",jm.getParameters());
			List<Record> list = Db.find(sql);
			Wftransaction obj=null;
			for (Record record : list) {
				obj= BaseModel.Companion.recordTo(record,Wftransaction.class);
				jsonModel.addDatas( obj);
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

	public void process() {
		// TODO Auto-generated method stub
		
		initJsonModel();
		String data = getPara("jsonmodeldata");
		if(data==null){
			renderException(new SnowException(20000));
			return;
		}
		String jsonStr=ZipCompress.dbuToString(data);
		if(StrKit.isBlank(jsonStr)){
			renderException(new SnowException(20001));
			return;
		}
		
		String webserviceurl = PropKit.get("webservice.mxservice.url");

		Service server = new Service();

		Call call;
		try {
			call = (Call) server.createCall();
			call.setTargetEndpointAddress(new URL(webserviceurl));

			String json = JSONObject.toJSONString(jm);

			Object obj ;

			obj=null;
				obj=call.invoke("send",new Object[]{json});
			System.out.println("send="+obj);
			if (obj != null) {
				ByteArrayOutputStream zip = ZipCompress.compressToStream(obj.toString());
				byte[] byteArray = zip.toByteArray();
				Render render = new RenderBytes(byteArray);
				render(render);
			}else{
				jsonModel.setStatus(JsonModel.ERROR);
				jsonModel.setErrorinfo("maximo 接口调用返回值为空");
				render(jsonModel);
			}
			
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


}
