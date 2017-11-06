package org.shoukaiseki.jfinal.kernel.testkit;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RandomData {
	private static Random random = new Random();
	public static int randomInt(){
		return random.nextInt();
	}
	
	public static long randomLong(){
		return random.nextLong();
	}
	
	public static double randomDouble(){
        
		return random.nextDouble();
	}
	
	public static boolean randomBoolean(){
        
		return random.nextBoolean();
	}
	
	public static Date randomDate(){  
	       Calendar calendar = Calendar.getInstance();  
	       //注意月份要减去1  
	       calendar.set(1990,11,31);  
	       calendar.getTime().getTime();  
	       //根据需求，这里要将时分秒设置为0  
	       calendar.set(Calendar.HOUR_OF_DAY, 0);  
	       calendar.set(Calendar.MINUTE, 0);  
	       calendar.set(Calendar.SECOND,0);  
	       long min = calendar.getTime().getTime();;  
	       Calendar cal=Calendar.getInstance();
	       cal.setTimeInMillis(System.currentTimeMillis());
	       
	       calendar.set(cal.get(Calendar.YEAR)+10,12,31);  
	       calendar.set(Calendar.HOUR_OF_DAY,0);  
	       calendar.set(Calendar.MINUTE,0);  
	       calendar.set(Calendar.SECOND,0);  
	       calendar.getTime().getTime();  
	       long max = calendar.getTime().getTime();  
	       //得到大于等于min小于max的double值  
	       double randomDate = Math.random()*(max-min)+min;  
	       //将double值舍入为整数，转化成long类型  
	       calendar.setTimeInMillis(Math.round(randomDate));  
	       return calendar.getTime();  
	   }  
	
	/** 随机生成中文名称
	 * @return
	 */
	public static String randomChineseName(){
		String name=ChineseName.randomChineseName();
		return name;
	}
	
	public static String randomChineseByte() {
		// TODO Auto-generated method stub
		return randomChineseByte(1, 30, 1);

	}
	
	public static String randomChineseByte(int min,int max){
		return randomChineseByte(min, max, 1);
	}
	
	/**随机生成一个中文字符
	 * @param min  最小长度
	 * @param max  最大长度
	 * @param singleLength 单个中文字符占用长度,oracle数据库中 UTF-8 字符类型每个中文占用 3 个长度 
	 * 				VARCHAR2(8 CHAR) 这种类型每个字符 1个长度
	 * @return
	 */
	public static String randomChineseByte(int min,int max,int singleLength){
		int changdu=random.nextInt((max-min))+min;
		System.out.println("changdu="+changdu);
		StringBuffer sb=new StringBuffer();
		int dqchangdu=0;
		while(dqchangdu<=changdu){
			String chinese = randomZH_CN();
			dqchangdu=dqchangdu+singleLength;
			if(dqchangdu<=changdu){
				sb.append(chinese);
			}else{
				break;
			}
		}
		return sb.toString();
	}

	 /**
     * 获取指定长度随机简体中文
     * @param len int
     * @return String
     */
    public static String randomZH_CN()
    {
    	String str = "";
    	int hightPos, lowPos; // 定义高低位
    	hightPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
    	lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
    	byte[] b = new byte[2];
    	b[0] = (new Integer(hightPos).byteValue());
    	b[1] = (new Integer(lowPos).byteValue());
    	try
    	{
    		str = new String(b, "GBk"); //转成中文
    	}
    	catch (UnsupportedEncodingException ex)
    	{
    		ex.printStackTrace();
    	}
      return str;
    }
    
	/** 随机生成英文字符
	 * @param length 需要的长度
	 * @return
	 */
	public static String randomEN(int length){
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(52);// [0,51)
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
