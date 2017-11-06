package org.shoukaiseki.jfinal.kernel.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.render.Render;
import org.shoukaiseki.jfinal.kernel.utils.ZipCompress;

public class RenderBytes extends Render {
	Logger logger=Logger.getLogger(Render.class);
	byte[] byteArray;
	public RenderBytes(byte[] byteArray) {
		// TODO Auto-generated constructor stub
		this.byteArray=byteArray;
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		response.setContentType("text/x-msdownload");
		response.addHeader("Content-Disposition","attachment; filename='download.zip'");
		try {
			ServletOutputStream out = response.getOutputStream();
			logger.debug("renderzip.byte.length="+byteArray.length);
			out.write(byteArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("出现异常:",e);
		}
	}

}
