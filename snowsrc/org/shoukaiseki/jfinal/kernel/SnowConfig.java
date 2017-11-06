package org.shoukaiseki.jfinal.kernel;

import org.apache.log4j.Logger;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import org.shoukaiseki.jfinal.kernel.http.HttpKeyHandler;
import org.shoukaiseki.jfinal.kernel.plugin.BaseModelPlugin;
import org.shoukaiseki.jfinal.kernel.plugin.ControllerPlugin;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadPlugin;

import org.shoukaiseki.jfinal.kernel.plugin.test.SnowController;
import org.shoukaiseki.jfinal.kernel.plugin.test.SnowHandler;

/** org.shoukaiseki.jfinal.kernel.SnowConfig
 * @author 蒋カイセキ    Japan-Tokyo  2017年3月26日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class SnowConfig extends JFinalConfig {
	
	public static String http_communication_key="";
	public static boolean snow_jfinal_devMode=false;
	public static boolean mxe_authentication_ldap=false;
	Logger logger=Logger.getLogger(SnowConfig.class);

	
	
	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("snow.properties");
		http_communication_key=PropKit.get("http_communication_key");
		logger.debug("http_communication_key="+http_communication_key);
		snow_jfinal_devMode = PropKit.getBoolean("snow.jfinal.devMode", false);
		mxe_authentication_ldap=PropKit.getBoolean("mxe.authentication.ldap",false);
		me.setDevMode(snow_jfinal_devMode);
	}
	
	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add("/ui", SnowController.class, "/webclient/snow");	// 第三个参数为该Controller的视图存放路径
		me.add("/", IndexController.class);			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
//		me.add("/test", TestController.class,"/test");			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
//		me.add("/utils", DeveloperUtilsController.class,"/utils");			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
		
		logger.info("configRoute 路由扫描注册");
		new ControllerPlugin(me).start();
		//模型对象类初始化执行 init 方法
	}
	
	public void configEngine(Engine me) {

//		me.addSharedFunction("/common/_layout.html");
//		me.addSharedFunction("/common/_paginate.html");
	}
	
	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
	    DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		arp.setDialect(new OracleDialect());
		me.add(arp);
		
		me.add(new SqlReadPlugin()); 
		me.add(new BaseModelPlugin()); 
	}
	
	public static DruidPlugin createDruidPlugin() {
	    return new DruidPlugin(PropKit.get("snow.db.jdbcUrl"), PropKit.get("snow.db.user"), PropKit.get("snow.db.password").trim(),PropKit.get("snow.db.driver"));
	}
	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		
	}
	
	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		me.add(new SnowHandler("/plugins", false));
//		me.add(new SessionHandler());
		me.add(new HttpKeyHandler());
	}
	
}
