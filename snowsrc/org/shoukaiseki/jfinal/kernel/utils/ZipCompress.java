package org.shoukaiseki.jfinal.kernel.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.jfinal.kit.StrKit;

/** org.shoukaiseki.jfinal.kernel.utils.StringCompress
 * @author 蒋カイセキ    Japan-Tokyo  2017年3月26日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class ZipCompress {
	
	static Logger logger=Logger.getLogger(ZipCompress.class);
	
	// 压缩
	public static String compress(String str) throws IOException {
		if (StrKit.isBlank(str)) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes());
		gzip.close();
		return out.toString("UTF-8");
	}

	// 解压缩
	public static String uncompress(String str) {
		if (StrKit.isBlank(str)) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in;
		try {
//			ISO-8859-1
			in = new ByteArrayInputStream(str.getBytes("UTF-8"));
			GZIPInputStream gunzip = new GZIPInputStream(in);
			byte[] buffer = new byte[256];
			int n;
			while ((n = gunzip.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
			//TODO toString()使用平台默认编码，也可以显式的指定如toString("GBK")
			str = out.toString("UTF-8");
		} catch (IOException e) {
			//
			e.printStackTrace();
		}		
		return str;
	}
	
	
	public static String ebzToString(String str){
		if (StrKit.isBlank(str)) {
			return null;
		}
		
		try {
			return ebzToString(str.getBytes("UTF-8")).replaceAll("\\+", "!");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String ebzToString(byte[] bytes){
		String str=null;
		ByteArrayOutputStream os = zipCompressToByteArrayOutputStream(bytes);
		str=Base64.encodeBase64URLSafeString(os.toByteArray());
		return str;
	}
	
	/** 压缩
	 * @param str
	 * @return
	 */
	public static ByteArrayOutputStream compressToStream(String str)  {
		if (StrKit.isBlank(str)) {
			return null;
		}
		try {
			return zipCompressToByteArrayOutputStream(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/** 压缩
	 * @param bytes
	 * @return
	 */
	public static ByteArrayOutputStream zipCompressToByteArrayOutputStream(byte[] bytes){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip;
		try {
			gzip = new GZIPOutputStream(out);
			gzip.write(bytes);
			gzip.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return out;
	}
	
	
	// 解压缩
	public static ByteArrayOutputStream uncompressToStream(String str) {
		if (StrKit.isBlank(str)) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in;
		try {
//			ISO-8859-1
			in = new ByteArrayInputStream(str.getBytes("UTF-8"));
			GZIPInputStream gunzip = new GZIPInputStream(in);
			byte[] buffer = new byte[256];
			int n;
			while ((n = gunzip.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
			//TODO toString()使用平台默认编码，也可以显式的指定如toString("GBK")
		} catch (IOException e) {
			//
			e.printStackTrace();
		}		
		return out;
	}
	
	public static String uncompressToString(byte[] bytes) {
		ByteArrayOutputStream os = unCompressToStream(bytes);
		
		try {
			return os.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**解压缩
	 * @param str
	 * @return
	 */
	public static ByteArrayOutputStream unCompressToStream(byte[] bytes) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in;
		try {
			in = new ByteArrayInputStream(bytes);
			GZIPInputStream gunzip = new GZIPInputStream(in);
			byte[] buffer = new byte[256];
			int n;
			while ((n = gunzip.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
			//TODO toString()使用平台默认编码，也可以显式的指定如toString("GBK")
		} catch (IOException e) {
			logger.error("Zip解压缩异常",e);
		}		
		return out;
	}
	
	public static ByteArrayOutputStream dbuToOS(String base64String){
		byte[] zipBytes = Base64.decodeBase64(base64String);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in;
		try {
			in = new ByteArrayInputStream(zipBytes);
			GZIPInputStream gunzip = new GZIPInputStream(in);
			byte[] buffer = new byte[256];
			int n;
			while ((n = gunzip.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
			//TODO toString()使用平台默认编码，也可以显式的指定如toString("GBK")
		} catch (IOException e) {
			//
			e.printStackTrace();
		}		
		
		return out;
	}
	
	/** decode base64 and unzip To String
	 *  解码
	 * @param base64String
	 * @return
	 */
	public static String dbuToString(String base64String){
		ByteArrayOutputStream os = dbuToOS(base64String);
		try {
			return new String(os.toByteArray(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
