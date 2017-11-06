package com.app.jfinal.service.mobileapp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.app.jfinal.service.mobileapp.model.Phoneversion;
import org.shoukaiseki.jfinal.kernel.AbstractController;
import org.shoukaiseki.jfinal.kernel.SnowDB;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.utils.DBUtils;

public class MobileAppController extends AbstractController{
	
	public static final String TAG = "mobileapp";
	
	/**
	 * 上传客户端信息
	 */
	public void uploadappinfo() {
		SnowDB snowDb=null;
		try {
			initJsonModel();
			List<Object> datas = jm.getData();
			if(datas!=null&&datas.size()>0){
				Date sysdate=DBUtils.getDate();
				snowDb=new SnowDB();
				for (Object data : datas) {
					Phoneversion obj = JSON.parseObject(data.toString(), Phoneversion.class);
					Map<String, Object> insertMap = obj.toInsertMap(Phoneversion.class);
					//方案一
					insertMap.put("PHONEVERSIONID", DBUtils.nextSequenceValue("phoneversionidseq"));
					insertMap.put("CREATEDATE", sysdate);
					//方案二
					insertMap.remove("PHONEVERSIONID");
					insertMap.remove("CREATEDATE");
					DBUtils.saveInsertByMap(snowDb,"PHONEVERSION", insertMap);
				}
			}else{
				jsonModel.setErrorinfo("无可用数据");
			}

			SnowDB.autoClose(snowDb);
			jsonModel.setStatus(JsonModel.SUCCESS);
			render(jsonModel);
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SnowDB.rollbackClose(snowDb);
			renderException(e);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			SnowDB.rollbackClose(snowDb);
			renderException(new SnowException(10000,ex));
		}
		
	}
	

}
