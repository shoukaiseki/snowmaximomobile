package com.app.jfinal.service.login;

import com.alibaba.fastjson.JSONObject;
import org.shoukaiseki.jfinal.kernel.login.LdapUtilVerification;
import org.shoukaiseki.jfinal.kernel.login.model.User;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.AbstractController;
import org.shoukaiseki.jfinal.kernel.SnowConfig;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;
import org.shoukaiseki.jfinal.kernel.utils.Base64Utils;
import org.shoukaiseki.mxpassword.MXCipherX;
import org.shoukaiseki.mxpassword.PropertiesUtil;

/** LoginService
 * @author 蒋カイセキ    Japan-Tokyo  2017年3月30日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class LoginService extends AbstractController{
	
	public static String TAG="login";
	
	public void loginmaximo() {
		// TODO Auto-generated method stub
		try{
			initJsonModel();
			String json = jm.getJson();
			logger.debug("json="+json);
			String login = getCanshu("loginid");
			String password = getCanshu("password");



			logger.debug("loginid="+login);

			String sql = SqlReadConfig.getSql("login.verifypassword",jm.getParameters());
			logger.debug("sql="+sql);
			Record userRecord = Db.findFirst(sql);
			User user =null;
			if(userRecord!=null){
				String jsonString = JSONObject.toJSONString(userRecord);
				logger.debug("jsonString="+jsonString);

				user = User.recordToObject(userRecord);
				jsonString = JSONObject.toJSONString(user);
				logger.debug("user="+jsonString);
				logger.debug("password=["+password+"],user.password="+user.getPassword());

				if(SnowConfig.mxe_authentication_ldap){
					PropertiesUtil pu = new PropertiesUtil();
					MXCipherX dmx = new MXCipherX(false, pu);
					String pas="";
					try {
						pas = dmx.decData(password);
						logger.debug("max.decode.password="+pas);
					} catch ( Exception e) {
						e.printStackTrace();
						logger.debug("解码出错",e);
					}
					pas= LdapUtilVerification.INSTANCE.encodeMD5(pas);
				   String reStr=LdapUtilVerification.INSTANCE.verification(login,pas);
				   if("SUCCESS".equalsIgnoreCase(reStr)){
					   jsonModel.setStatus(JsonModel.SUCCESS);
					   jsonModel.setErrorinfo("LDAP认证成功..");
				   }else{
					   jsonModel.setErrorinfo("LDAP验证失败:"+reStr);
					   jsonModel.setStatus(JsonModel.ERROR);
				   }
				}else{
					if(password.equalsIgnoreCase(user.getPassword())){
						jsonModel.setErrorinfo("登陆成功..");
						jsonModel.setStatus(JsonModel.SUCCESS);
					}else{
						jsonModel.setErrorinfo("密码错误.");
						jsonModel.setStatus(JsonModel.ERROR);
					}
				}

			}else{
				jsonModel.setErrorinfo("用户名不存在.");
				jsonModel.setStatus(JsonModel.ERROR);
			}

			jsonModel.setJson(JSONObject.toJSONString(user));
			render(jsonModel);
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(new SnowException(10000,e));
		}

	}
	
	public void loginmaximoios() {
		// TODO Auto-generated method stub
		try{
			initJsonModel();
			String json = jm.getJson();
			logger.debug("json="+json);
			String login = getCanshu("loginid");
			String password = getCanshu("password");

			logger.debug("loginid="+login);
			logger.debug("password01="+password);
			
			password=new String(Base64Utils.decodeBase64(password),"UTF-8");
			logger.debug("password02="+password);
			
			PropertiesUtil pu = new PropertiesUtil();
			MXCipherX dmx = new MXCipherX(true, pu);
			try {
				password = dmx.encData(password);
				logger.debug("password03="+password);
			} catch (Exception e) {
				throw new SnowException(10000,e);
			}

			String sql = SqlReadConfig.getSql("login.verifypassword",jm.getParameters());
			logger.debug("sql="+sql);
			Record userRecord = Db.findFirst(sql);
			User user =null;
			if(userRecord!=null){
				String jsonString = JSONObject.toJSONString(userRecord);
				logger.debug("jsonString="+jsonString);

				user = User.recordToObject(userRecord);
				jsonString = JSONObject.toJSONString(user);
				logger.debug("user="+jsonString);
				logger.debug("password=["+password+"],user.password="+user.getPassword());

				if(SnowConfig.mxe_authentication_ldap){
					PropertiesUtil pu2 = new PropertiesUtil();
					MXCipherX dmx2 = new MXCipherX(false, pu2);
					String pas="";
					try {
						pas = dmx2.decData(password);
						logger.debug("max.decode.password="+pas);
					} catch ( Exception e) {
						e.printStackTrace();
						logger.debug("解码出错",e);
					}
					pas=LdapUtilVerification.INSTANCE.encodeMD5(pas);
					String reStr=LdapUtilVerification.INSTANCE.verification(login,pas);
					if("SUCCESS".equalsIgnoreCase(reStr)){
						jsonModel.setStatus(JsonModel.SUCCESS);
						jsonModel.setErrorinfo("LDAP认证成功..");
					}else{
						jsonModel.setErrorinfo("LDAP验证失败:"+reStr);
						jsonModel.setStatus(JsonModel.ERROR);
					}
				}else {
					if (password.equalsIgnoreCase(user.getPassword())) {
						jsonModel.setErrorinfo("登陆成功..");
						jsonModel.setStatus(JsonModel.SUCCESS);
					} else {
						jsonModel.setErrorinfo("密码错误.");
						jsonModel.setStatus(JsonModel.ERROR);
					}
				}
			}else{
				jsonModel.setErrorinfo("用户名不存在.");
				jsonModel.setStatus(JsonModel.ERROR);
			}

			jsonModel.setJson(JSONObject.toJSONString(user));
			render(jsonModel);
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(new SnowException(10000,e));
		}

	}
	
	public void invalid() {
		// TODO Auto-generated method stub
		
		
		renderText("invalid");

	}
	

}
