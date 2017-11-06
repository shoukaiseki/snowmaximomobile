package com.app.jfinal.service.test.module;

import java.util.HashMap;

import com.app.jfinal.service.mobileapp.model.Phoneversion;
import com.app.jfinal.service.test.NavigationTest;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;

public class MobileAppUploadappinfoNT extends NavigationTest {
	
	public MobileAppUploadappinfoNT() {
		// TODO Auto-generated constructor stub
		super("mobileapp/uploadappinfo","mobileapp/uploadappinfo",
				"上传客户端信息"
				+ "<br>登陆时候触发"
				);
	}
	
	@Override
	public JsonModel getJsonModel(HashMap<String, String> paras) {
		// TODO Auto-generated method stub
		JsonModel jsonModel = super.getJsonModel(paras);
		Phoneversion obj=new Phoneversion();
		obj.setIsandroid(1L);
		
		obj.setAvailablespace(12312312L);
		jsonModel.addDatas( obj);
		return jsonModel;
	}

}

/**
    private Phoneversion getPhoneversion(){
    	Phoneversion obj=new Phoneversion();
    	
    	try {
			
    	TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
    	String deviceSoftwareVersion = tm.getDeviceSoftwareVersion();
    	
    	String imei = tm.getDeviceId();//String   
    	
    	obj.setImei(imei);
    	
    	String remark="deviceSoftwareVersion="+deviceSoftwareVersion+",sdk="+android.os.Build.VERSION.SDK
    			+";sdk_int="+android.os.Build.VERSION.SDK_INT;
    	
    	obj.setRemark(remark);
    	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	obj.setModel( android.os.Build.MODEL);
    	obj.setVersion( android.os.Build.VERSION.RELEASE);
    	obj.setTotalmemory( getTotalMemory());
    	
    	
    	try {
			
    		// 获得一个磁盘状态对象  
    		StatFs stat = new StatFs(Environment.getDataDirectory().getPath());  

    		long blockSize = stat.getBlockSize();   // 获得一个扇区的大小  

    		long totalBlocks = stat.getBlockCount();    // 获得扇区的总数  

    		long availableBlocks = stat.getAvailableBlocks();   // 获得可用的扇区数量  

    		// 总空间  
    		long totalspace =   totalBlocks * blockSize;  
    		// 可用空间  
    		long availablespace = availableBlocks * blockSize;  
    		
    		obj.setTotalspace(totalspace);
    		obj.setAvailablespace(availablespace);
        
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	
    	ActivityManager am = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
    	MemoryInfo mi = new MemoryInfo();
    	am.getMemoryInfo(mi);
    	
    	obj.setAvailmemory(mi.availMem);
    		  
    	
    	
    	return obj;
    }
    
    
    private long getTotalMemory() {  
    	long initial_memory=0L;
    	 try {
    		 String dir = "/proc/meminfo";
             FileReader fr = new FileReader(dir);
             BufferedReader br = new BufferedReader(fr, 2048);
             String memoryLine = br.readLine();
             String subMemoryLine = memoryLine.substring(memoryLine.indexOf("MemTotal:"));
             br.close();
             initial_memory= Long.parseLong(subMemoryLine.replaceAll("\\D+", "")) * 1024L;
         } catch (IOException e) {
             e.printStackTrace();
         }
         return  initial_memory;// Byte转换为KB或者MB，内存大小规格化  
    }  
    
    
    //获取可用运存大小
    private long getAvailMemory(Context context){
    	// 获取android当前可用内存大小 
    	ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    	MemoryInfo mi = new MemoryInfo();
    	am.getMemoryInfo(mi);
    	
    	return mi.availMem;
    }


 **/ 
