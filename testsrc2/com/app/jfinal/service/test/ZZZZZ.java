package com.app.jfinal.service.test;

import org.shoukaiseki.jfinal.kernel.exception.SnowException;
import org.shoukaiseki.jfinal.kernel.utils.Base64Utils;
import org.shoukaiseki.jfinal.kernel.utils.ZipCompress;
import org.shoukaiseki.mxpassword.MXCipherX;
import org.shoukaiseki.mxpassword.PropertiesUtil;

public class ZZZZZ {
	
	public static void main(String[] args) throws Exception {
		String password="123456";
		password=Base64Utils.encodeBase64(password.getBytes());
		System.out.println("pw="+password);
		
		password=new String(Base64Utils.decodeBase64(password),"UTF-8");
		System.out.println("pw.de="+password);
		
		PropertiesUtil pu = new PropertiesUtil();
		MXCipherX dmx = new MXCipherX(true, pu);
		try {
			password = dmx.encData(password);
			System.out.println("password="+password);
		} catch (Exception e) {
			throw new SnowException(10000,e);
		}
		
		
		String asus="{\"password\":\"MTIzNDU2\",\"loginid\":\"chenn621\"}";
		
		String decodeBase64=ZipCompress.ebzToString(asus);
		System.out.println("decodeBase64="+decodeBase64);
		
		
	}
	
	
	
}
