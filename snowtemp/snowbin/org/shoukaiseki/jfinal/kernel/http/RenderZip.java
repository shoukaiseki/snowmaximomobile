package org.shoukaiseki.jfinal.kernel.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jfinal.render.Render;
import org.shoukaiseki.jfinal.kernel.utils.ZipCompress;


/**
 * org.shoukaiseki.jfinal.kernel.http.RenderZip <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-07-13 15:25:02<br>
 *         ブログ http://shoukaiseki.blog.163.com/<br>
 *         E-メール jiang28555@Gmail.com<br>
 **/

public class RenderZip extends Render {
	Logger logger=Logger.getLogger(RenderZip.class);
	JsonModel jsonModel;
	public RenderZip(JsonModel jsonModel) {
		// TODO Auto-generated constructor stub
		this.jsonModel=jsonModel;
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		response.setContentType("text/x-msdownload");
		response.addHeader("Content-Disposition","attachment; filename='download.zip'");
		try {
			ServletOutputStream out = response.getOutputStream();
			//转换时显示 null 值
			String jsonStr = JSONObject.toJSONString(jsonModel,SerializerFeature.WriteMapNullValue);
			ByteArrayOutputStream zip = ZipCompress.compressToStream(jsonStr);
			byte[] byteArray = zip.toByteArray();
			logger.debug("renderzip.byte.length="+byteArray.length);
			logger.info("renderzip.jsonStr="+jsonStr);
			out.write(byteArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("出现异常:",e);
		}
	}

}
