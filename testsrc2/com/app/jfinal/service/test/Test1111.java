package com.app.jfinal.service.test;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import org.shoukaiseki.jfinal.kernel.utils.Base64Utils;
import org.shoukaiseki.jfinal.kernel.utils.FileUtils;

public class Test1111 {
	
	static SimpleDateFormat filenamesdf=new SimpleDateFormat("yyyy'y'MM'm'dd'd'HH'h'mm'm'ss's'SSS'ms'");
	public static final Logger logger = Logger.getLogger(Test1111.class);
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		DecimalFormat numberFormat=new DecimalFormat("####");
		
		Long l=123L;
		l=11712L;
		System.out.println(numberFormat.format(l));
		
		String format = filenamesdf.format(new Date());
		System.out.println(format);
		
		
		String base64=null;
		
		String filename = "C:/temp/1.txt";
		filename="C:/temp/001.jpg";
		ByteArrayOutputStream out =	FileUtils.readFileToByteArrayOutputStream(filename);
		
		byte[] bytes = out.toByteArray();
//		System.out.println("bytes="+new String(bytes));
		
		logger.debug("docfile.bytes.length="+bytes.length);
		base64=Base64Utils.encodeBase64(bytes);
//		System.out.println("base64="+base64);
		
//		base64=Base64.encodeBase64URLSafeString(bytes);
//		System.out.println("base64="+base64);
		
		bytes=Base64Utils.decodeBase64(base64);
//		bytes=Base64.decodeBase64(base64);
		logger.debug("decodeBase64.docfile.bytes.length="+bytes.length);
		
	}

}
