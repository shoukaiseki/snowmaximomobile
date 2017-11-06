import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import sun.security.krb5.internal.Ticket;

import java.text.DecimalFormat;
import java.util.List;

/** .Asus
 * @author 蒋カイセキ    Japan-Tokyo  2017年5月27日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class Asus {

	private  String asus;
	
	public static void main(String[] args) {

		String asus="";
		Asus();
		
	}
	
	private static void aaaaa() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		StringBuilder sb1=new StringBuilder();
		List assas=Lists.newArrayList();
		
		long startdate=System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			sb.append("asus士大夫撒打的防守打法");
//			sb1.append("asus士大夫撒打的防守打法");
		}
		long enddate=System.currentTimeMillis();
		long aa=enddate-startdate;
		System.out.println("sfd\nsd"+aa);
		sb.toString();
		
		
		int a=true?3:5;
		

	}
	
	
	public static void Asus(){
		String assetnum="0203040440001";
		int assetnumSeqDigits=4;
//		for (int i = 0; i < array.length; i++) {
//			
//		}
		DecimalFormat df=new DecimalFormat("0000");
		String prefix=assetnum.substring(0, assetnum.length()-assetnumSeqDigits);
		String suffix=assetnum.substring(assetnum.length()-assetnumSeqDigits);
		System.out.println(prefix);
		System.out.println(suffix);
		System.out.println(String.format("%04d", Integer.parseInt(suffix)+1));
		assetnum=prefix+String.format("%0"+assetnumSeqDigits+"d",Integer.parseInt(suffix)+1);
		System.out.println("assetnum="+assetnum);
		double maxvalue = Math.pow(10D, assetnumSeqDigits);
		System.out.println(maxvalue);
		
	}

}
