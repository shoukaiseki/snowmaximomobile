package org.shoukaiseki.jfinal.kernel.utils;

import java.util.Arrays;

public class StringExpand {
	
	/**将Stirng数组转换为String显示
	 * @param strs 要转换的字符串数组
	 * @param ifnullDefault 如果数组为空时转换为的String数据
	 * @return 返回数组形式为: 字符串1;字符串2;
	 */
	public static String strsToString(String[] strs,String ifnullDefault){
		StringBuffer sb=new StringBuffer();
		if(strs.length==0){
			if(ifnullDefault==null){
				return null;
			}
			sb.append(ifnullDefault);
		}
		
		for (String str:strs) {
			sb.append(str).append(";");
			
		}
		return sb.toString();
	}

	
	/**将Stirng数组的第一个成员转换为String显示
	 * @param strs 要转换的字符串数组
	 * @param ifnullDefault 如果数组为空时转换为的String数据
	 * @return 返回数组形式为: 字符串1
	 */
	public static String strToString(String[] strs,String ifnullDefault){
		if(strs==null){
			return ifnullDefault;
		}
		
		if(strs.length==0){
			return ifnullDefault;
		}else{
			return strs[0];
		}
		
	}
	
	/**
	 * @param strs 数组,不包含null元素
	 * @param str  可以为null,为null时有空字符串代替
	 * @return 如果该数组有该字符串则返回true
	 */
	public static boolean binarySearch(String[] strs,String str){
		Arrays.sort(strs);
		return Arrays.binarySearch(strs, str==null?"":str)>=0;
	}
	
	
	/*
	**  
    * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1  
    * @param String s 需要得到长度的字符串  
    * @return int 得到的字符串长度  
    */   
   public static int length(String s) {  
       if (s == null)  
           return 0;  
       char[] c = s.toCharArray();  
       int len = 0;  
       for (int i = 0; i < c.length; i++) {  
           len++;  
           if (!isLetter(c[i])) {  
               len++;  
           }  
       }  
       return len;  
   }  
   
   public static boolean isLetter(char c) {   
       int k = 0x80;   
       return c / k == 0 ? true : false;   
   } 

}
