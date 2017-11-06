package com.app.jfinal.service.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSONObject;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.utils.ZipCompress;

public class TestClient {
	   /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static byte[] sendPost2(String url, String param) {
    	byte[] respBuffer =null;
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            OutputStream outputStream = conn.getOutputStream();
            out = new PrintWriter(outputStream);
            // 发送请求参数
            
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            InputStream inputStream = conn.getInputStream();
			in = new BufferedReader(new InputStreamReader(inputStream));
            ByteArrayOutputStream sd=new ByteArrayOutputStream();
            int respBodySize = inputStream.available();  
            if (respBodySize > 0){
            	respBuffer = new byte[respBodySize];  
                if (inputStream.read(respBuffer) != respBodySize) {
                	
                }
            }
//            ZipCompress.uncompressToStream(in.)
            
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return respBuffer;
    }    
    
    /**
     * 向指定 URL 发送POST方法的请求
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     * @throws IOException 
     */
    public static byte[] sendPost(String url, String param) throws Exception {
    	byte[] respBuffer =null;
    	PrintWriter out = null;
    	BufferedReader in = null;
    	String result = "";
    		URL realUrl = new URL(url);
    		// 打开和URL之间的连接
    		HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();

    		// 发送POST请求必须设置如下两行
    		conn.setDoOutput(true);//允许输入流，即允许下载
    		conn.setDoInput(true);//允许输出流，即允许上传
    		conn.setUseCaches(false); //不使用缓冲
    		conn.setRequestMethod("POST"); //使用get请求
    		// 发送请求参数

    		// 获取URLConnection对象对应的输出流
    		OutputStream outputStream = conn.getOutputStream();
    		out = new PrintWriter(outputStream);
    		out.print(param);
    		// flush输出流的缓冲
    		out.flush();

    		// 定义BufferedReader输入流来读取URL的响应
    		InputStream inputStream = conn.getInputStream();
    		in = new BufferedReader(new InputStreamReader(inputStream));
    		int respBodySize = inputStream.available();  
    		if (respBodySize > 0){
    			respBuffer = new byte[respBodySize];  
    			if (inputStream.read(respBuffer) != respBodySize) {

    			}
    		}

    		String line;
    		while ((line = in.readLine()) != null) {
    			result += line;
    		}
    	//使用finally块来关闭输出流、输入流
    			if(out!=null){
    				out.close();
    			}
    			if(in!=null){
    				in.close();
    			}
    	return respBuffer;
    }    

    
	public static void main(String[] args) throws Exception {
		System.out.println("asus");
		 //发送 POST 请求
        String url = "http://127.0.0.1:8080/dunanjfinal/testac/param";
//        url = "http://127.0.0.1:8080/dunanjfinal/testinputstream.jsp";
        
        url=url+"?";
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < 200; i++) {
			sb.append("a").append(i).append("=a").append(i).append("&");
		}
//        url=sb.toString();
        
		String json = "status=123&v=456";
		JsonModel jm=new JsonModel();
		json=sb.toString();
		jm.setJson(JSONObject.toJSONString(json));
		System.out.println("json="+json);

		NameValuePair person = new BasicNameValuePair("loginid", "asus");
		jm.addParameters(person);
		json=JSONObject.toJSONString(jm);
		
		String decodeBase64 =null;
//		ByteArrayOutputStream os = ZipCompress.compressToStream(json);
//        decodeBase64 = Base64.encodeBase64String(os.toByteArray());
		
		
		
		
        
        decodeBase64=ZipCompress.ebzToString(json);
        
        
        System.out.println("decodeBase64="+decodeBase64);
        System.out.println("url="+url);
        
        
		String as=ZipCompress.dbuToString(decodeBase64);
		System.out.println("as="+as);
        
        
        
		byte[] sr=null;
		String str = null;
		
        decodeBase64="jsonmodeldata="+decodeBase64;
        
        
        url="http://192.168.1.103:8080/dunanjfinal/login/loginmaximo?2131361798";
        url="http://192.168.1.103:8080/dunanjfinal/login/loginmaximo?_http_communication_key_=KLJASD5646SAD5ASASD5ADS5ASD56ASD54FSD2F1S45FWQ54ER4WD";
        
        
		sr=TestClient.sendPost(url, decodeBase64);
        str = ZipCompress.uncompressToString(sr);
        System.out.println("str="+str);
        
        
        if(str!=null){
        	System.out.println(sr);
        	System.out.println(str);
        }
        
	}

	
	
    
}
