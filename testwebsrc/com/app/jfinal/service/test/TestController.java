package com.app.jfinal.service.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.app.jfinal.service.test.module.LoginNT;
import com.app.jfinal.service.test.module.MobileAppUploadappinfoNT;
import com.app.jfinal.service.test.module.WorkflowNT;
import com.app.jfinal.service.test.module.WorkorderupdateworkorderNT;
import com.jfinal.kit.PathKit;
import com.app.jfinal.service.test.module.*;
import org.shoukaiseki.jfinal.kernel.AbstractController;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;
import org.shoukaiseki.jfinal.kernel.utils.FileUtils;
import org.shoukaiseki.jfinal.kernel.utils.StringUtils;
import org.shoukaiseki.jfinal.kernel.utils.ZipCompress;
import org.apache.http.message.BasicNameValuePair;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** TestController
 * @author 蒋カイセキ    Japan-Tokyo  2017年6月3日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class TestController extends AbstractController{
	
	List<NavigationTest> navroot=new ArrayList<NavigationTest>();
	public static String loginid="yangch";
	public static String personid="77001447";
	public static String siteid="GFKJ";
	
	public static final String TAG = "test";
	
	public static final String VIEWPATH="test";
	
	
	public TestController() {
		// TODO Auto-generated constructor stub
		
		
		NavigationTest nav=new NavigationTest("login","login类接口","登录相关");
		NavigationTest node;
		nav.addChildren(new LoginNT());
		
		node = new NavigationTest("login/loginmaximoios","IOS登录接口","登录接口:在app登录验证时使用的接口方案,返回值中的 json数据中的 json 字段,为登录人验证通过后的个人信息"
				+ "\nhttps://123.56.42.78:7543/svn/dunanmobileservice/" );
		node.addParameter(new BasicNameValuePair("loginid", "chenn621"));
		node.addParameter(new BasicNameValuePair("password", "MTIzNDU2"));
		nav.addChildren(node);
		
		nav.addChildren(new MobileAppUploadappinfoNT());
		
		node = new NavigationTest("version/checkversion","检查更新",""
				+ "必须参数:version,systemtype");
		node.addParameter(new BasicNameValuePair("systemtype", "android"));
		node.addParameter(new BasicNameValuePair("version", "1.1.0"));
		nav.addChildren(node);

		node = new NavigationTest("testldap/getldappassword","查找用户",""
				+ "必须参数:loginid");
		node.addParameter(new BasicNameValuePair("loginid",loginid));
		nav.addChildren(node);
		navroot.add(nav);



		
		nav=new NavigationTest("lookup","查找类接口","登录相关");
		node = new NavigationTest("lookup/checksync","lookup/checksync","获取同步标志位");
		node.addParameter(new BasicNameValuePair("siteid", siteid));
		nav.addChildren(node);
		
		
		
		
		node = new NavigationTest("lookup/listlocations","位置同步","获取离线数据location表的数据;"
				+ "rowstamp 参数选择app端数据库 rowstamp 字段的最大值,如果为空则设置为0,app端保存时按照 rowstamp 排序,先将最小的保存;"
				+ "这样即使中途出现问题,也能够起到断点续传的功能");
		node.addParameter(new BasicNameValuePair("rowstamp", "0"));
		node.addParameter(new BasicNameValuePair("siteid", siteid));
		nav.addChildren(node);
		
		node = new NavigationTest("lookup/listfailurelist","故障代码同步","获取故障代码,故障类过滤   parent is null,选取故障类之后,故障代码过滤条件为  parent= 故障类的 FAILURELIST");
		node.addParameter(new BasicNameValuePair("siteid", siteid));
		node.addParameter(new BasicNameValuePair("rowstamp", "0"));
		nav.addChildren(node);
		
		node = new NavigationTest("lookup/listperson","人员同步","获取人员");
		node.addParameter(new BasicNameValuePair("siteid", siteid));
		node.addParameter(new BasicNameValuePair("rowstamp", "0"));
		nav.addChildren(node);
		
		node = new NavigationTest("lookup/listasset","资产同步","");
		node.addParameter(new BasicNameValuePair("siteid", siteid));
		node.addParameter(new BasicNameValuePair("rowstamp", "0"));
		nav.addChildren(node);
		
		node = new NavigationTest("lookup/listalndomain","域同步","");
		node.addParameter(new BasicNameValuePair("siteid", siteid));
		node.addParameter(new BasicNameValuePair("rowstamp", "0"));
		nav.addChildren(node);

		node = new NavigationTest("lookup/listdepartment","部门同步","");
		node.addParameter(new BasicNameValuePair("siteid", siteid));
		node.addParameter(new BasicNameValuePair("rowstamp", "0"));
		nav.addChildren(node);

		navroot.add(nav);
		
		
		nav=new NavigationTest("workorder","工单相关","工单相关");
		/**
		node = new NavigationTest("workorder/findallwotrackbythissiteid","查看所有工单","根据siteid获取指定的workorder"
				+ "<br>显示siteid下面的所有工单,也可以进行搜索"
				+ "<br>必须参数:siteid"
				+ "<br>可选参数:findword[and (wonum like '%${findword}%' or DESCRIPTION  like '%${findword}%' "
				+ " or DA_WONUM like '%${findword}%')]"
				+ ""
				+ "");
		node.addParameter(new BasicNameValuePair("findword", ""));
		node.addParameter(new BasicNameValuePair("siteid", siteid));
		nav.addChildren(node);
		
		
		
		node = new NavigationTest("workorder/listweiwanchengwotrack","查看未完成工单","获取未完成的工单\npersonid 如果为空则不进行personid过滤,不为空则进行创建人过滤");
		node.addParameter(new BasicNameValuePair("personid", personid));
		node.addParameter(new BasicNameValuePair("siteid", siteid));
		nav.addChildren(node);
		
		

		
		node = new NavigationTest("workorder/findwotrack","搜索工单(不包含关闭的)",
				"根据 findword 参数搜索 wonum,da_wonum或者 description 含有该字符的记录"
				+ "<br>wonum=11805"
				+ "<br>B-0,B-06#机组巡检,DMB2017030155"
				+ "");
		node.addParameter(new BasicNameValuePair("findword", "11805"));
		node.addParameter(new BasicNameValuePair("siteid", siteid));
		nav.addChildren(node);
		 **/

		node = new NavigationTest("workorder/findwotrackbywoid","获取工单详情","根据workorderid获取指定的workorder"
				+ "<br>信息中包含所需的子表信息"
				+ "<br>workorder=9881,缺陷,多资产,计划工具,工单任务,实际外包工具"
				+ "<br>workorder=11109(wonum=11805),基本都有子表数据"
				+ ""
				+ "");

		node.addParameter(new BasicNameValuePair("workorderid", "64830"));
		nav.addChildren(node);

		node = new NavigationTest("workorder/findallwotrack","搜索所有工单(不包含关闭的)",
				"根据 findword 参数搜索 wonum,da_wonum或者 description 含有该字符的记录"
				+ "<br>wonum=9932"
				+ "<br>B-0,B-06#机组巡检,DMB2017030155"
				+ "");
		node.addParameter(new BasicNameValuePair("findword", "804A28"));
		node.addParameter(new BasicNameValuePair("siteid", siteid));
		nav.addChildren(node);

		nav.addChildren(new WorkorderupdateworkorderNT());

		navroot.add(nav);
		
		
		nav=new NavigationTest("worktodo","待办相关","待办相关");
		node = new NavigationTest("worktodo/queryworktodounsigncount","获取待办条数","待办条数存放在 SyncDate.tiaoshu 字段");
		node.addParameter(new BasicNameValuePair("personid", personid));
		nav.addChildren(node);
		
		node = new NavigationTest("worktodo/queryworktodounsignbypersonid","worktodo/queryworktodounsignbypersonid","根据 personid 和 rowstamp 获取"
				+ "<br> queryall 属性默认为'no',如果不为'no'则查询所有,主要用于待办发送完之后的待办任务表更新"
				+ "<br> 发送待办方案:"
				+ "<br>  发送请求时判断 rowstamp 是否>0,如果大于0,则发送 queryall 为 yes 的请求,返回信息中会包含已完成的待办,用于更新本地数据库中仍然显示着未完成的待办"
				+ "<br> 如果 rowstamp<=0  则发送 queryall 为  no 的请求,因为 rowstamp 为<0证明之前没有待办信息存在,只需要下载现在分配到的待办任务就可以"
				+ "<br>queryall为 no,只下载该 personid 对应的状态为 '活动'的待办任务"
				+ "<br>queryall为 yes,下载所有该 personid 的待办任务"
				+ ""
				);
		node.addParameter(new BasicNameValuePair("personid", personid));
		node.addParameter(new BasicNameValuePair("rowstamp", "0"));
		node.addParameter(new BasicNameValuePair("queryall", "no"));
		nav.addChildren(node);
		
		navroot.add(nav);
		
		nav=new NavigationTest("workflow","工作流相关","工作流相关");
		nav.addChildren(new WorkflowNT());
		
		node = new NavigationTest("workflow/listapprovalhistory","审批历史记录",""
				+ "审批历史记录"
				+ "<br>ownerid 转换为String的时候不能含有逗号 ',' "
				+ "<br>WORKORDER,9206");
		node.addParameter(new BasicNameValuePair("ownerid", "9206"));
		node.addParameter(new BasicNameValuePair("ownertable", "WORKORDER"));
		nav.addChildren(node);
		
		node = new NavigationTest("workflow/listassignwf","流程任务分配",""
				+ "流程任务分配"
				+ "<br>ownerid 转换为String的时候不能含有逗号 ',' "
				+ "<br>WORKORDER,9384");
		node.addParameter(new BasicNameValuePair("ownerid", "9384"));
		node.addParameter(new BasicNameValuePair("ownertable", "WORKORDER"));
		nav.addChildren(node);
		
		
		//工作流测试用,设置工单状态
		node = new NavigationTest("testconn/workorder","testconn/workorder","update workorder set status='等待核准' ,HISTORYFLAG=0 where workorderid=10863");
		nav.addChildren(node);
		
		node = new NavigationTest("testconn/wfassignment","testconn/wfassignment","update wfassignment set ASSIGNCODE = (select personid from maxuser where loginid='qiaosh') "
				+ " where ownerid=10863 and ownertable='WORKORDER' and ASSIGNSTATUS='活动' and rownum<=1");
		nav.addChildren(node);
		
		node = new NavigationTest("testconn/reloadFailurecode","同步代码rowstamp全部更新",""
				+ "update FAILURECODE set rowstamp='asas'");
		nav.addChildren(node);
		
		node = new NavigationTest("testconn/testinteger","测试integer",""
				+ "如果把VirusCode放入classpath下面就好有这问题");
		nav.addChildren(node);
		
		
		
		navroot.add(nav);
		
		
		
		nav=new NavigationTest("testinsert","测试","测试");
		node = new NavigationTest("testconn/testinsert","测试新建",""
				+ "对于 含有 ' 等符号的字段更新,会出现错误"
				+ "<br>进行sql语句重构");
		
		node.addParameter(new BasicNameValuePair("value", "asus"));
		nav.addChildren(node);
		
		
		node = new NavigationTest("testconn/testupdate","测试更新",""
				+ "对于 含有 ' 等符号的字段更新,会出现错误"
				+ "<br>进行sql语句重构");
		
		node.addParameter(new BasicNameValuePair("value", "asus"));
		nav.addChildren(node);
		
		
		
		
		navroot.add(nav);
		
	}
	
	

	public void index() throws Exception {
	    HttpServletRequest request = getRequest();
        String path = request.getContextPath();
	   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

       System.out.println("path="+path);
       System.out.println("basePath="+basePath);
       setAttr("path", path);
       setAttr("basePath", basePath);
       String sqlid = "test.list";
			Map cond = new HashMap<String, Object>();  
			cond.put("id", "'1'");  
       String sql="";
//       sql=SqlReadConfig.getSql(sqlid,cond);
			
//       renderJsp("index.jsp");
       
       Test test=new Test();
       test.setId(3);
       test.setA(null);
			
       sql+=SqlReadConfig.getSql(sqlid,test);
       sqlid = "test.list1";
			cond.put("a", null);  
       sql+=SqlReadConfig.getSql(sqlid,cond);
       
       renderText(sql);

	}
	
	
	public void list(){
		System.out.println("test.list11");
		
	}
	
	public  void client() {
		// TODO Auto-generated method stub
		renderJsp("index.jsp");
	}
	
	
	public void getnavigationtest(){
		renderJson(navroot);
	}
	
	
	public void viewsource(){
		String jiekouurl = getPara("jiekouurl");
		//获取自定义 JsonModel start
		Map<String, NavigationTest> map=NavigationTest.map;
		System.out.println("*********************************************************");
		for (NavigationTest obj : map.values()) {
			System.out.println("nt="+obj.getClass().getName());
		}
		System.out.println("*********************************************************");
		NavigationTest nt = map.get(jiekouurl);
		//获取自定义 JsonModel end 
		String classpath = PathKit.getRootClassPath();
		
		String str = "as="+nt.getClass().getName();
		String path=classpath+"/../../../src/"+nt.getClass().getName().replaceAll("\\.", "/")+".java";
		if(!new File(path).exists()){
			path=classpath+"/../../../testsrc/"+nt.getClass().getName().replaceAll("\\.", "/")+".java";
		}
		if(!new File(path).exists()){
			path=classpath+"/../../../testwebsrc/"+nt.getClass().getName().replaceAll("\\.", "/")+".java";
		}
		
		String java=FileUtils.readFileToString(path,"UTF-8");
		
		setAttr("src", str);
		setAttr("path", path);
		setAttr("java", java);
		renderJsp("viewsrc.jsp");
	}
	
	

	public void testsend(){
		try {


			System.out.println("testsend");
			String paras = getPara("parameters");
			System.out.println("parameters="+paras);
			System.out.println("asus="+getPara("asus"));
			String jiekouurl = getPara("jiekouurl");
			JsonModel jsonModel=new JsonModel();
			if(paras!=null){
				JSONArray parseArray = JSON.parseArray(paras);
				for (Object object : parseArray) {
					System.out.println("object="+object+",classname="+object.getClass().getName());
					HashMap paramap=JSON.parseObject(object.toString(),HashMap.class);
					BasicNameValuePair bnvp = new BasicNameValuePair(paramap.get("name").toString(), paramap.get("value").toString());
					jsonModel.addParameters(bnvp);
				}
			}
			//获取自定义 JsonModel start
			Map<String, NavigationTest> map=NavigationTest.map;
			System.out.println("*********************************************************");
			for (NavigationTest obj : map.values()) {
				System.out.println("nt="+obj.getClass().getName());
			}
			System.out.println("*********************************************************");
			String jiekouurlid = getPara("jiekouurlid");
			System.out.println("jiekouurlid="+jiekouurlid);
			NavigationTest nt = map.get(jiekouurlid);
			if(nt!=null){
				jsonModel=nt.getJsonModel(jsonModel.getParameters());
				//			System.out.println("sendJsonModel001="+JSONObject.toJSONString(jsonModel));
			}
			//获取自定义 JsonModel end 

			//		System.out.println("sendJsonModel002="+JSONObject.toJSONString(jsonModel));

			String json=JSONObject.toJSONString(jsonModel);

			System.out.println("testsend.json="+json);
			String decodeBase64 =null;
			decodeBase64=ZipCompress.ebzToString(json);

			decodeBase64="jsonmodeldata="+decodeBase64;

			System.out.println("jiekouurlis="+jiekouurl);
			byte[] sr=null;
			try {
				sr = sendPost(jiekouurl,decodeBase64);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("sr="+sr.length);
			String str = ZipCompress.uncompressToString(sr);
			System.out.println("str="+str);


			renderText(str);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			renderText(JSONObject.toJSONString(StringUtils.getErrorInfoFromException(e)));
		}
		System.out.println("-----------------------*******************   TestController.end");
	}
	
	
	
	
	
	
	
    
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
        
        ByteArrayOutputStream sd=new ByteArrayOutputStream();
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
            
            
			byte[] buffer = new byte[256];
			int n;
			while ((n = inputStream.read(buffer)) != -1) {
				sd.write(buffer, 0, n);
			}
            
            
//            int respBodySize = inputStream.available();  
//            if (respBodySize > 0){
//            	respBuffer = new byte[respBodySize];  
//                if (inputStream.read(respBuffer) != respBodySize) {
//                	
//                }
//            }
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
        return sd.toByteArray();
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
	public  byte[] sendPost(String url, String param) throws Exception {
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
		conn.setConnectTimeout(30000);
		// 发送请求参数

		// 获取URLConnection对象对应的输出流
		OutputStream outputStream = conn.getOutputStream();
		out = new PrintWriter(outputStream);
		out.print(param);
		// flush输出流的缓冲
		out.flush();

		// 定义BufferedReader输入流来读取URL的响应
		InputStream inputStream = conn.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(inputStream);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int c;
		byte[] respBuffer =null;
		respBuffer = new byte[2048];
		while (true) {
			c = bis.read(respBuffer);
			if (c == -1)
				break;

			baos.write(respBuffer, 0, c);
		}


		conn.disconnect();
		inputStream.close();

		//使用finally块来关闭输出流、输入流
		if(out!=null){
			out.close();
		}
		byte[] data = baos.toByteArray();
		baos.flush();

		return data;

	}    


    
    
}
