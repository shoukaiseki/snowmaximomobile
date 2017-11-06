package org.shoukaiseki.jfinal.kernel.http;

import java.io.IOException;

import javax.servlet.ServletOutputStream;

import com.jfinal.render.Render;

public class RenderXml  extends Render {
	
	private String xml;

	public RenderXml(String xml) {
		// TODO Auto-generated constructor stub
		super();
		this.xml=xml;
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/xml;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			ServletOutputStream out = response.getOutputStream();
			out.write(xml.toString().getBytes("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
	}

}
