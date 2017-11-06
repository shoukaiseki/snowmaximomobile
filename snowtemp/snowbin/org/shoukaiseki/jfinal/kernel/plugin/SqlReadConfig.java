package org.shoukaiseki.jfinal.kernel.plugin;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.beetl.core.BeetlKit;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.google.common.base.Preconditions;
import com.jfinal.kit.PathKit;
import org.shoukaiseki.jfinal.kernel.model.SqlModel;
import org.shoukaiseki.jfinal.kernel.utils.FileUtils;

import freemarker.cache.StringTemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class SqlReadConfig {
	
	static Logger logger=Logger.getLogger(SqlReadConfig.class);
	
	static StringTemplateLoader stl = new StringTemplateLoader();  
	static Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);  
	
	static{
			config.setTemplateLoader(stl);  
			config.setDefaultEncoding("UTF-8"); 
		
	}
	
	
	/**
	 * xml中所有的sql语句
	 */
	private static final Map<String, SqlModel> sqlMap = new HashMap<String, SqlModel>();

	public static boolean init() {
		sqlMap.clear();
		// TODO Auto-generated method stub
		logger.debug("------SqlReadConfig.init");
		List<File> files = FileUtils.loadSqlFile(null);
		SAXReader reader = new SAXReader();
		for (File file : files) {
			String fileName = file.getName();
			try {
				logger.debug("SqlReadConfig.init.file="+fileName);
				Document doc = reader.read(file);
				Element root = doc.getRootElement();
				String namespace = root.attributeValue("namespace");
				if (null == namespace || namespace.trim().isEmpty()) {
					logger.error("无效的sql配置xml文件:" + fileName + ";namespace (命名空间) 属性不能为空");
					continue;
				}
				
				for (Iterator<?> iterTemp = root.elementIterator(); iterTemp
						.hasNext();) {
					Element element = (Element) iterTemp.next();
					if (element.getName().equalsIgnoreCase("sql")) {
						String id = element.attributeValue("id");
						if (null == id || id.trim().isEmpty()) {
							logger.error("无效的sql配置xml文件:" + fileName + ",sql节点中id属性不存在");
							continue;
						}

						String sql = element.getText();
						if (null == sql || sql.trim().isEmpty()) {
							logger.error("无效的sql配置xml文件:" + fileName + ",sql节点中内容不存在");
							continue;
						}

						String key = namespace + "." + id;
						if (sqlMap.containsKey(key)) {
							logger.error("无效的sql配置xml文件:" + fileName + "的sql语句" + key
									+ "的存在重复命名空间和ID");
						}

						
						logger.debug("sql加载, sql file = " + fileName
								+ ", sql key = " + key + ", sql content = "
								+ sql);
						
						String parser = element.attributeValue("parser");
						SqlModel sm=new SqlModel(key,sql,parser);
						sqlMap.put(key, sm);
						
						if("freemarker".equalsIgnoreCase(parser)){
							if(stl.findTemplateSource(key)==null){
								stl.putTemplate(key,sql);
							}
						}
						
						
					}
				}
				
			} catch (DocumentException e) {
				logger.error("无效的sql配置xml文件:"+fileName);
				e.printStackTrace();
			}
			
			
			
		}
		return true;
		
	}
	
	
	





	public static boolean destory() {
		// TODO Auto-generated method stub
		sqlMap.clear();
		System.out.println("SqlReadConfig.destory");
		return true;
	}

	/**获取sql语句,不进行任何处理
	 * @param sqlId  sql标识
	 * @return
	 */
	public static String getSqlText(String sqlId) {
		String sql = sqlMap.get( sqlId).getSql();
		if (null == sql || sql.isEmpty()) {
			logger.error("sql语句不存在：sql id是" + sqlId);
			logger.error("存在的sql语句有--------------");
			for (String key : sqlMap.keySet()) {
				logger.error("sql语句 key="+key+" 语句="+sqlMap.get(key));
			}
		}

		return sql;
	}
	
	
	
	/**获取 使用 beetl 解析之后的语句
	 * @param sqlid sql标识
	 * @param model	只能为Map
	 * @return
	 */
	public static String getSqlParserBeetl(String sqlid, Map<String, Object>  model){
		SqlModel sqlModel = sqlMap.get(sqlid);
		if(sqlModel==null){
			logger.error(sqlid+"对应的SQL语句不存在");
			return null;
		}
		String sql=sqlModel.getSql();
		try {
			StringWriter sw = new StringWriter();  
			
			BeetlKit.renderTo(sql,sw,model);
			sql=sw.toString(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return sql;
	}
	
	/**获取 使用 freemarker 解析之后的语句
	 * @param sqlid sql标识
	 * @param model	可以为Map,也可以为POJO对象
	 * @return
	 */
	public static String getSqlParserFreemarker(String sqlid,Object  model){
		String sql=null;
		try {
			StringWriter sw = new StringWriter();  
			Template template = config.getTemplate(sqlid);
			template.process(model,sw);
			sql=sw.toString(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return sql;
	}
	
	
	/**
	 * @param sqlid sql标识
	 * @param model	可以为Map,也可以为POJO对象
	 * @return
	 */
	public static String getSql(String sqlid,Object  model){
		String sql=null;
		SqlModel sqlModel = sqlMap.get(sqlid);
		
		Preconditions.checkNotNull(sqlModel,sqlid+"对应的SQL语句不存在");
//		if(sqlModel==null){
//			logger.error(sqlid+"对应的SQL语句不存在");
//			return null;
//		}
		if("freemarker".equalsIgnoreCase(sqlModel.getParser())){
			sql=getSqlParserFreemarker(sqlid, model);
		}else if("beetl".equalsIgnoreCase(sqlModel.getParser())){
			sql=getSqlParserBeetl(sqlid, (Map<String, Object>) model);
		}else{
			sql=sqlModel.getSql();
		}
		logger.debug("sql="+sql);
		
		return sql;
	}
	
	
	/**
	 * @param sqlid sql标识
	 * @param model	可以为Map,也可以为POJO对象
	 * @return
	 */
	public static String getSql(String sqlid){
		
		return getSql(sqlid,new HashMap<String, Object>());
	}
	

}
