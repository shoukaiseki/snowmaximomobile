package org.shoukaiseki.jfinal.kernel;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.render.Render;
import org.shoukaiseki.jfinal.kernel.maximo.db.CommonDB;
import org.shoukaiseki.jfinal.kernel.maximo.utils.MaximoDB;
import org.shoukaiseki.jfinal.kernel.login.model.User;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.http.RenderZip;
import org.shoukaiseki.jfinal.kernel.logger.SnowLogger;
import org.shoukaiseki.jfinal.kernel.utils.StringUtils;
import org.shoukaiseki.jfinal.kernel.utils.ZipCompress;
import org.apache.log4j.Logger;

import java.text.DecimalFormat;
import java.util.HashMap;


/**
 * org.shoukaiseki.jfinal.kernel.AbstractController <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-06-21 15:08:47<br>
 *         ブログ http://shoukaiseki.blog.163.com/<br>
 *         E-メール jiang28555@Gmail.com<br>
 **/
public  class AbstractController extends Controller {
	
	public static final Logger logger = Logger.getLogger(AbstractController.class);
	
	public static final Logger sqllogger = SnowLogger.SQLLogger;
	
	protected CommonDB comDB = new CommonDB();
	
	protected MaximoDB maxDB=new MaximoDB();
	
	protected Integer ms_rows=null;
	
	protected Integer ms_page=null;
	
	/**
	 * 参数等信息 
	 */
	protected JsonModel jm=new JsonModel();
	
	protected JsonModel jsonModel=new JsonModel();
	
	HashMap<String, ?> parameters=null;
	
	
	/**
	 * 每个继承的Controller类，必须指定自己的<code>TAG</code>
	 * (public),这个也是接口请求的上下文，一个Controller对应一个唯一的上下文
	 */
	public static String TAG="TAG";
	
	/**
	 * 视图存放目录,Routes添加时候的第三个参数
	 * <br>
	 * 如果为空则该不使用第三个参数
	 */
	public static String VIEWPATH=null;
	
	protected DecimalFormat df=StringUtils.numberFormat;
	
	public AbstractController() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	public void renderException(SnowException e) {
		JsonModel jsonModel=new JsonModel();
		jsonModel.setErrorcode(e.getErrorcode());
		jsonModel.setStatus(JsonModel.ERROR);
		jsonModel.setErrorinfo(e.getMessage());
		jsonModel.setErrorexception(StringUtils.getErrorInfoFromException(e));;
		
		Render render = new RenderZip(jsonModel);
		render(render);
	}
	
	
	
	public void render(JsonModel jsonModel) {
		Render render = new RenderZip(jsonModel);
		render(render);
	}
	
	
	
	public JsonModel initJsonModel(){
		logger.debug("setHttpServletRequest");
		jm=new JsonModel();
		String data = getPara("jsonmodeldata");
		logger.info("jsonmodeldata="+data);
		if(data!=null){
			data=data.replaceAll("%3D","=");
			data.replaceAll("%2F", "/");
			String jsonStr=ZipCompress.dbuToString(data);
			logger.info("jsonstr="+jsonStr);
			if(jsonStr!=null&&!jsonStr.trim().isEmpty()){
				jm=JSON.parseObject(jsonStr, JsonModel.class);
				HashMap<String, ?> parameters = jm.getParameters();
				if(parameters==null){
					parameters=new HashMap<String, Object>();
				}
			}
			if(org.shoukaiseki.jfinal.kernel.SnowConfig.snow_jfinal_devMode){
				HashMap map=jm.getParameters();
				StringBuffer sb=new StringBuffer("------------------------------------------------------------------------------------\n");
				sb.append("parameters : ");
				for (Object key : map.keySet()) {
					sb.append(key).append(" = ").append(map.get(key)).append("  ;");
				}
				sb.append("\n------------------------------------------------------------------------------------");
				System.out.println(sb.toString());
			}
		}
		
		ms_rows= getCanshuToInt("ms_rows",10);
		ms_page= getCanshuToInt("ms_page",1);
		initWebClient();
		Record record = Db.findFirst("select VARVALUE from maxvars   where varname='ADMINRESTART'");
		if(record==null||"ON".equalsIgnoreCase(record.getStr("VARVALUE"))){
			throw new SnowException(3);
		}
		
		return jm;
	}
	
	/**
	 * 初始化 WebClient
	 */
	public void initWebClient(){
		User user=new User();
		user.setPersonid(getCanshu("personid"));
		user.setDefsite(getCanshu("siteid"));
		org.shoukaiseki.jfinal.kernel.WebClient webclient=new org.shoukaiseki.jfinal.kernel.WebClient(getRequest().getSession());
		webclient.setUser(user);
		org.shoukaiseki.jfinal.kernel.WebClient.getThreadclient().set(webclient);
		
	}
	
	
	protected Integer getCanshuToInt(String name,Integer defval){
		Integer value = getCanshuToInt(name);
		if(value==null){
			value=getParaToInt(name,defval);
		}
		return value==null?defval:value;
	}
	
	protected String getCanshu(String name){
		String value = jm.getParameter(name);
		if(value==null){
			value=getPara(name);
		}
		return value==null?"":value;
	}
	
	protected Integer getCanshuToInt(String name){
		Integer l=null;
		String value = getCanshu(name);
		if(!StrKit.isBlank(value)){
			try {
				l=Integer.parseInt(value);
			} catch (Exception e) {
				// TODO: handle exception
				l=null;
			}
		}
		return l;
	}
	
	protected Long getCanshuToLong(String name){
		Long l=null;
		String value = getCanshu(name);
		if(!StrKit.isBlank(value)){
			try {
				l=Long.parseLong(value);
			} catch (Exception e) {
				// TODO: handle exception
				l=null;
			}
		}
		return l;
	}
	
	

}
