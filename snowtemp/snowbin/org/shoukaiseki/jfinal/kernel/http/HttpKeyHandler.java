package org.shoukaiseki.jfinal.kernel.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.JFinal;
import com.jfinal.handler.Handler;
import org.shoukaiseki.jfinal.kernel.SnowConfig;
import org.shoukaiseki.jfinal.kernel.utils.ZipCompress;

public class HttpKeyHandler extends Handler {
	Logger logger=Logger.getLogger(HttpKeyHandler.class);

	public HttpKeyHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		// TODO Auto-generated method stub
		
		
		if(SnowConfig.http_communication_key!=null){
			try {
				String key = request.getParameter("_http_communication_key_");

				if(!SnowConfig.http_communication_key.equals(key)){
					ServletOutputStream os;
					response.setContentType("text/x-msdownload");
					response.addHeader("Content-Disposition","attachment; filename='download.zip'");
					os = response.getOutputStream();
					JsonModel jm=new JsonModel();
					jm.setStatus(JsonModel.ERROR);
					jm.setErrorinfo("通讯密匙异常,请下载最新App");
					
					ByteArrayOutputStream zip = ZipCompress.compressToStream(JSONObject.toJSONString(jm));
					os.write(zip.toByteArray());
					os.flush();
					os.close();
					return;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}

		
		nextHandler.handle(target, request, response, isHandled);

	}



}
