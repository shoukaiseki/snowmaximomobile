package org.shoukaiseki.jfinal.kernel.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.maximo.model.Maxattributecfg;
import org.shoukaiseki.jfinal.kernel.SnowDB;
import org.shoukaiseki.jfinal.kernel.common.AnnotationUtils;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowFieldProp;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;
import org.shoukaiseki.jfinal.kernel.logger.SnowLogger;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;
import org.shoukaiseki.jfinal.kernel.testkit.RandomColumnSetting;

public class DBUtils {
	public static final Logger logger = Logger.getLogger(DBUtils.class);
	public static final Logger sqllogger = SnowLogger.SQLLogger;
	
	public static void saveInsertByMap(SnowDB snowDb,String tablename,Map<String,Object> map){
		StringBuffer sbatt=null;
		StringBuffer sbvalue=null;
		Object[] values= new Object[map.size()];
		int i=0;
		for (String attname: map.keySet()) {
			Object value= map.get(attname);
			values[i]=value;
			if(sbatt==null){
				sbatt=new StringBuffer("insert into ").append(tablename)
						.append("(").append(attname);
				sbvalue=new StringBuffer(") values (").append("?");
			}else{
				sbatt.append(",").append(attname);
				sbvalue.append(",").append("?");
			}
			i++;
		}
		sbatt.append(sbvalue).append(")");
		Preconditions.checkNotNull(sbatt);
		sqllogger.debug("sql="+sbatt.toString());
		sqllogger.debug("map="+JSONObject.toJSONString(map,SerializerFeature.WriteMapNullValue));
		
		try {
			snowDb.update(sbatt.toString(), values);
		} catch (SnowException e) {
			// TODO: handle exception
			try {
				List<Record> list = snowDb.find("select * from dba_tab_columns where owner=(select user from dual) and table_name=upper(:tablename)",tablename);
				HashMap<Object, Object> rcsMap = Maps.newHashMap();
				for (Record record : list) {
					RandomColumnSetting rcs = BaseModel.Companion.recordTo(record, RandomColumnSetting.class);
					rcs.setMax_char_length(record.getBigDecimal("CHAR_LENGTH").intValue());
					rcsMap.put(rcs.getColumn_name().toLowerCase(), rcs);
				}
				
				for (Object attname: new TreeSet(map.keySet())) {
					StringBuffer errorSB=new StringBuffer();
					errorSB.append("attname:"+attname);
					if(rcsMap.get(attname)!=null){
						errorSB.append(",rcs="+JSONObject.toJSONString(rcsMap.get(attname)));
					}
					errorSB.append(",value="+map.get(attname));
					logger.error(errorSB.toString());
				}
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			logger.error("table["+tablename+"] insert error:\nsql="+sbatt.toString());
			logger.error("table["+tablename+"] insert error:\nvalues="+JSONObject.toJSONString(values));
			logger.error("table["+tablename+"] insert error:\nmap="+JSONObject.toJSONString(map,SerializerFeature.WriteMapNullValue));
			throw e;
		}
		
		
	}
	
	public static void saveUpdateByMap(SnowDB snowDb,String tablename,Map<String,Object> map,String where){
		StringBuffer sbatt=null;
		Object[] values= new Object[map.size()];
		int i=0;
		
		for (String attname: map.keySet()) {
			Object value= map.get(attname);
			values[i]=value;
			if(sbatt==null){
				sbatt=new StringBuffer("update ").append(tablename)
						.append(" set ").append(attname).append("=")
						.append("?");
				
			}else{
				sbatt.append(",").append(attname).append("=")
						.append("?");
			}
			i++;
		}
		sbatt.append(" where ").append(where);
		Preconditions.checkNotNull(sbatt);
		sqllogger.debug("sql="+sbatt.toString());
		sqllogger.debug("map="+JSONObject.toJSONString(map,SerializerFeature.WriteMapNullValue));
		try {
			snowDb.update(sbatt.toString(), values);
		} catch (SnowException e) {
			// TODO: handle exception
			logger.error("table["+tablename+"] insert error:\nsql="+sbatt.toString());
			logger.error("table["+tablename+"] insert error:\nvalues="+JSONObject.toJSONString(values));
			logger.error("table["+tablename+"] insert error:\nmap="+JSONObject.toJSONString(map,SerializerFeature.WriteMapNullValue));
			throw e;
		}
		
	}
	
	
	/**
	 * @param tablename
	 * @param map
	 * @return
	 */
	public static StringBuffer toInsertSqlStringByMap1(String tablename,Map<String,Object> map){
		StringBuffer sbatt=null;
		StringBuffer sbvalue=null;
		for (String attname: map.keySet()) {
			String value=(String) map.get(attname);
			if(sbatt==null){
				sbatt=new StringBuffer("insert into ").append(tablename)
						.append("(").append(attname);
				sbvalue=new StringBuffer(") values (").append(value);
			}else{
				sbatt.append(",").append(attname);
				sbvalue.append(",").append(value);
			}
		}
		sbatt.append(sbvalue).append(")");
		Preconditions.checkNotNull(sbatt);
		return sbatt;
	}
	
	
	public static StringBuffer toUpdateSqlStringByMap1(String tablename, Map<String, Object> map,String where) {
		// TODO Auto-generated method stub
		StringBuffer sbatt=null;
		for (String attname: map.keySet()) {
			String value=(String) map.get(attname);
			if(sbatt==null){
				sbatt=new StringBuffer("update ").append(tablename)
						.append(" set ").append(attname).append("=")
						.append(value);
				
			}else{
				sbatt.append(",").append(attname).append("=")
						.append(value);
			}
		}
		sbatt.append(" where ").append(where);
		Preconditions.checkNotNull(sbatt);
		return sbatt;
		
	}
	
	/** 下一个主键的序列值,有 model 对象的
	 * @SnowTable(maxSequenceName="xxxx") 指定
	 * @param clazz
	 * @return
	 */
	public static Long nextSequenceValue(Class<?> clazz){
		String maxSequenceName = AnnotationUtils.getMaxSequenceName(clazz);
		return nextSequenceValue(maxSequenceName);
	}
	
	/** 下一个主键的序列值,有 model 对象的
	 * @param maxSequenceName  序列名称
	 * @return
	 */
	public static Long nextSequenceValue(String maxSequenceName){
		Map<String,String> map=new HashMap<String, String>();
		map.put("sequencename",maxSequenceName);
		String sql = SqlReadConfig.getSql("maximo.sequence.nextval",map);
		Record record = Db.findFirst(sql);
		BigDecimal bd = new BigDecimal(record.get("VALUE").toString());
		return bd.longValue();
	}

	public static Long getFailurelist(String failurecode,String orgid){
		if(failurecode==null){
			return null;
		}
		Record record = Db.findFirst("select failurelist value from failurelist where failurecode=:failurecode and orgid=:orgid",failurecode,orgid);
		if(record!=null){
			return TypeConversionUtils.longByObject(record.get("VALUE"));
		}
		return null;
    }
	
	public static Long getFailurecodeid(String failurecode,String orgid){
	    if(failurecode==null){
			return null;
		}
		Record record = Db.findFirst("select failurecodeid value from failurecode where FAILURECODE=:failurecode and orgid=:orgid",failurecode,orgid);
		if(record!=null){
			return TypeConversionUtils.longByObject(record.get("VALUE"));
		}
		return null;
	}
	
	/** 获取数据库当前时间
	 * @return
	 */
	public static Date getDate(){
		String sql = SqlReadConfig.getSql("maximo.getsysdate");
		Record record = Db.findFirst(sql);
		Date date = record.get("VALUE");
		return date;
	}
	
	public static String getOrgid(String siteid){
		Map<String,String> map=new HashMap<String, String>();
		map.put("siteid",siteid);
		String sql = SqlReadConfig.getSql("maximo.getorgid",map);
		Record record = Db.findFirst(sql);
		String str = record.get("ORGID");
		return str;
	}
	
	
	/** 将 maximo 配置表中的字段默认值 map 与  model 类生成的 map 进行合并
	 * <br>
	 * 用于最终通过调用 toSqlStringByMap 生成sql语句
	 * @param insertMap
	 * @param maxdefMap
	 * @param sfpMap
	 * @return
	 * @throws SnowException
	 */
	public static Map<String,Object> mergeInsertMap(Map<String,Object> insertMap,Map<String, Object> maxdefMap
			,Map<String, SnowFieldProp> sfpMap ) throws SnowException{
		Map<String,Object> sqlMap=new HashMap<String,Object>();
		Map<String, Object> cloneMap = ClassUtils.cloneMap(maxdefMap);
		sqlMap.putAll(cloneMap);
		for (String attname : insertMap.keySet()) {
			Object value= insertMap.get(attname);
			SnowFieldProp sfp = sfpMap.get(attname.toLowerCase());
			//以下代码都用大写attname
			attname=attname.toUpperCase();
			if(sfp==null){
//				logger.error("sfpMap="+JSONObject.toJSONString(sfpMap));
//				logger.error("attname=["+attname.toLowerCase()+"]");
				value=mergeValue(value, cloneMap.get(attname));
				sqlMap.put(attname, value);
				continue;
			}
			
//			logger.debug("sfpMap="+JSONObject.toJSONString(sfp));
			if(!sfp.hasMaxatt()){
				value=mergeValue(value, cloneMap.get(attname));
				sqlMap.put(attname, value);
				if(sfp.isRequired()){
					if(isNull(value)){
						throw new SnowException(3000,"字段名为:"+attname);
					}
				}
				continue;
			}
			Maxattributecfg maxatt = sfp.outMaxatt();
			
			if(maxatt.getRequired()||sfp.isRequired()){
				if(isNull(value)){
					if(isNull(sqlMap.get(attname))){
						logger.error("attname=["+attname+"],value="+value);
						logger.error("insertMap="+JSONObject.toJSONString(insertMap));
						logger.error("maxdefMap="+JSONObject.toJSONString(cloneMap));
						logger.error("sqlMap="+JSONObject.toJSONString(sqlMap));
						throw new SnowException(3000,"字段名为:"+attname);
					}
				}else{
					sqlMap.put(attname, value);
				}
			}else{
				if(isNull(value)){
					if(!isNull(sqlMap.get(attname))){
						value=sqlMap.get(attname);
					}else{
						value=null;
					}
					sqlMap.put(attname, value);
				}else{
					sqlMap.put(attname, value);
				}
			};
		}
		
		return sqlMap;
	}

	
	public static boolean isNull(Object value){
		if(value==null){
			return true;
		}
		if("null".equalsIgnoreCase(value.toString())){
			return true;
		}
		
		return false;
	}

	public static Object mergeValue(Object str1,Object str2){
		Object str;
		if(isNull(str1)){
			if(isNull(str2)){
				str=null;
			}else{
				str=str2;
			}
		}else{
			str=str1;
		}
		return str;
	}
	
}
