package org.shoukaiseki.jfinal.kernel.maximo.utils;

import com.alibaba.fastjson.JSONObject;
import org.shoukaiseki.jfinal.kernel.login.model.User;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.SnowDB;
import org.shoukaiseki.jfinal.kernel.WebClient;
import org.shoukaiseki.jfinal.kernel.common.AnnotationUtils;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowFieldProp;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;
import org.shoukaiseki.jfinal.kernel.maximo.model.*;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;
import org.shoukaiseki.jfinal.kernel.utils.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

public class MaximoDB {

	public static final Logger logger = Logger.getLogger(MaximoDB.class);

	public final static SimpleDateFormat filenamesdf=new SimpleDateFormat("yyyy'y'MM'm'dd'd'HH'h'mm'm'ss's'SSS'ms'");

	private SnowDB snowDb=null;

	public void uploadDocFile(List<DocFile> dfs, BaseModel owner){
		if(dfs!=null){
			Map<String, SnowFieldProp> sfpdoclinksMap = BaseModel.Companion.loadSnowFieldPropMap(Doclinks.class);
			for (DocFile docFile : dfs) {
				if(docFile.getMs_toadd()){
					String base64 = docFile.getBase64();
//					logger.debug("base64="+base64);
					if(StrKit.isBlank(base64)){
						throw new SnowException(20100).setParams("base64");
					}
					String ownertable = docFile.getOwnertable();
					if(ownertable==null){
						try {
							ownertable =AnnotationUtils.getMaxObjectName(owner.getClass());
							docFile.setOwnertable(ownertable);
						} catch (Exception e) {
							// TODO: handle exception
							throw new SnowException(20100).setParams("ownertable");
						}
					}

					Long ownerid = docFile.getOwnerid();
					if(ownerid==null){
						ownerid=owner.showMaxUniqueIDValue();
						docFile.setOwnerid(ownerid);
					}

					byte[] bytes = Base64Utils.decodeBase64(base64);
//					logger.debug("MaximoDB.docfile.bytes.length="+bytes.length);
					String fn = docFile.getFileName();
					if(StrKit.isBlank(fn)||fn.indexOf(".")==-1){
						throw new SnowException(20100).setParams("filename[文件名]");
					}
					 String suffix = fn.substring(fn.lastIndexOf(".") + 1);

					String fileName= ownertable+"_"+filenamesdf.format(DBUtils.getDate())+"_"+UUID.randomUUID().toString().replaceAll("-", "")+"."+suffix;
					try {
						FileUtils.writeFile(new File(PropKit.get("mxe.doclink.doctypes.topLevelPaths")), fileName, bytes);
						Doclinks doclinks=new Doclinks();
						Long doclinksid = DBUtils.nextSequenceValue(Doclinks.class);
						Long docinfoid = DBUtils.nextSequenceValue(Docinfo.class);
						doclinks.setDoclinksid(doclinksid);
						doclinks.setDocinfoid(docinfoid);

						doclinks.setOwnerid(owner.showMaxUniqueIDValue());
						doclinks.setOwnertable(docFile.getOwnertable());
						String document = docFile.getDocument();
						if(StrKit.isBlank(document)){
							String prefix = fn.substring(0,fn.lastIndexOf("."));
							document=prefix;
						}
						String description = docFile.getDescription();
						if(StrKit.isBlank(description)){
							description=document;
						}
						doclinks.setDocument(document);

						Map insertMap = doclinks.toInsertMap(1);
						logger.debug("MaximoDB.doclinks.insertMap="+JSONObject.toJSONString(insertMap));

						User user=WebClient.getWebClient().getUser();
						//设置默认值
						doclinks.insertDefaultValueToNull(insertMap,user);
						Map<String, Object> maxdefMap= getInsertDefaultValue(AnnotationUtils.getMaxObjectName(Doclinks.class),user);
						logger.debug("maxdefMap="+JSONObject.toJSONString(maxdefMap));

						Map<String, Object> map = DBUtils.mergeInsertMap(insertMap, maxdefMap, sfpdoclinksMap);
						DBUtils.saveInsertByMap(snowDb,AnnotationUtils.getMaxEntityName(Doclinks.class), map);

						Docinfo docinfo=new Docinfo();
						docinfo.setDocinfoid(docinfoid);
						docinfo.setContentuid(String.valueOf(docinfoid));
						docinfo.setDocument(document);
						docinfo.setDescription(description);

						String urlname=PropKit.get("mxe.doclink.doctypes.urlNamePath")+fileName;
						logger.debug("urlname="+urlname);
						logger.debug("path="+PropKit.get("mxe.doclink.doctypes.topLevelPaths"));
						docinfo.setUrlname(urlname);
						insertMap = docinfo.toInsertMap(1);
						docinfo.insertDefaultValueToNull(insertMap, user);
						maxdefMap= getInsertDefaultValue(AnnotationUtils.getMaxObjectName(Docinfo.class),user);
						logger.debug("maxdefMap="+JSONObject.toJSONString(maxdefMap));

						map = DBUtils.mergeInsertMap(insertMap, maxdefMap, sfpdoclinksMap);
						DBUtils.saveInsertByMap(snowDb,AnnotationUtils.getMaxEntityName(Docinfo.class), map);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new SnowException(20101,e).setParams(e.getMessage());
					}
				}
			}
		}
	}


	public Map<String,Maxattributecfg> getMaxattributecfg(String tablename){
		Map<String,Maxattributecfg> map=new HashMap<String, Maxattributecfg>();
		Map<String,Object> parasmap=new HashMap<String, Object>();
		parasmap.put("objectname", tablename);

		String sql = SqlReadConfig.getSql("maximo.listmaxattributecfgbyobjectname",parasmap);
		List<Record> list = Db.find(sql);
		Maxattributecfg obj=null;
		for (Record record : list) {
			obj = Maxattributecfg.Companion.recordTo(record,Maxattributecfg.class);
			map.put(obj.getColumnname(), obj);

		}
		return map;

	}

	/**
	 * @param tablename
	 * @param user
	 * @return
	 * @throws SnowException
	 */
	public Map<String,Object> getInsertDefaultValue(String tablename,User user) throws SnowException{
		Map<String,Object> map=new HashMap<String, Object>();
		Map<String,Object> parasmap=new HashMap<String, Object>();
		parasmap.put("objectname", tablename);

		String sql = SqlReadConfig.getSql("maximo.listmaxattributecfgbyobjectname",parasmap);
		List<Record> list = Db.find(sql);
		Maxattributecfg obj=null;
		Date sysdate=DBUtils.getDate();
		for (Record record : list) {
			obj = Maxattributecfg.Companion.recordTo(record,Maxattributecfg.class);
			Object value=null;
			String defvalue = obj.getDefaultvalue();
			if(!StrKit.isBlank(defvalue)){
				switch (defvalue.toString()) {
				case "&AUTOKEY&":
					value=null;
					//如果maximo端正在新增,则容易出现更新 autokey 失败
					//重试10次无效
					for (int i = 0; i < 10&&value==null; i++) {
						value = nextAutoKey(obj.getAutokeyname(),user.getDefsite());
					}
					if(value==null)
						throw new SnowException(1000,"attname="+obj.getColumnname()+"\nsql="+sql);

					break;
				case "&USERNAME&":
					value=user.getPersonid();
					break;

				case "&PERSONID&":
					value=user.getPersonid();
					break;
				case "&SYSDATE&":
					value=sysdate;
					break;

				default:
					if(StringExpand.binarySearch(new String[]{"ALN","LONGALN"}, obj.getMaxtype())){
						value=defvalue;
					}else if("UPPER".equalsIgnoreCase(obj.getMaxtype())){
						value=defvalue.toUpperCase();
					}else if("LOWER".equalsIgnoreCase(obj.getMaxtype())){
						value=defvalue.toLowerCase();
					}else{
						value=defvalue;
					}
					break;
				}

				if(value!=null){
					map.put(obj.getColumnname(), value);
				}
			};
		}
		return map;

	}


	public int nextAutoDateSiteNum(String ownertable,String autokeyname,String orgid,String siteid,Date date){
		int autoknum=1;
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);

		Autodatesitenum adsn=new Autodatesitenum();
		adsn.setOwnerattributename(autokeyname);
		adsn.setOwnertable(ownertable);
		adsn.setOrgid(orgid);
		adsn.setSiteid(siteid);
		adsn.setYear(cal.get(Calendar.YEAR));
		adsn.setMonth(cal.get(Calendar.MONTH)+1);
		String sql = SqlReadConfig.getSql("maximo.list_nextautodatesitenum_find",adsn);
		Record record = Db.findFirst(sql);
		boolean haserror=false;
		if(record==null){
			Long objid = DBUtils.nextSequenceValue(Autodatesitenum.class);
			adsn.setAutodatesitenumid(objid);
			adsn.setNum(autoknum);
			adsn.setMs_toadd(true);
			SnowDB snowDb =null;
			try {
				Connection connection = DbKit.getConfig().getDataSource().getConnection();
				connection.setAutoCommit(true);
				snowDb = new SnowDB(connection);
				adsn.setSnowDb(snowDb);
				adsn.setMaxDB(new MaximoDB());
				adsn.setBasemodelUser(WebClient.getWebClient().getUser());
				adsn.save();
			} catch (Exception e) {
				e.printStackTrace();
				haserror=true;
			}finally {
				SnowDB.autoClose(snowDb);
			}
			if(haserror){
				return  -1;
			}
		}else{
			adsn= BaseModel.Companion.recordTo(record,Autodatesitenum.class);
			autoknum=adsn.getNum();
			adsn.setNum(++autoknum);
			sql = SqlReadConfig.getSql("maximo.list_nextautodatesitenum_update",adsn);
			int update = Db.update(sql);

			//如果返回值不为 1 ,则说明更新失败;
			if(update!=1){
				return -1;
			}
		}
		return autoknum;

	}

	public String nextAutoKey(String autokeyname,String siteid){
		Map<String,Object> parasmap=new HashMap<String, Object>();
		parasmap.put("autokeyname", autokeyname);
		String sql = SqlReadConfig.getSql("maximo.listnextautokey.find",parasmap);
		List<Record> list = Db.find(sql);
		Autokey obj=null;
		String num="";
		for (Record record : list) {
			Autokey  ak= Autokey.Companion.recordTo(record,Autokey.class);
			if(obj==null){
				obj=ak;
			}else{
				if(siteid.equalsIgnoreCase(ak.getSiteid())){
					obj=ak;
				}
			}
		}
		if(obj!=null){
			if(!StrKit.isBlank(obj.getPrefix())){
				num=obj.getPrefix();
			}
			obj.setSeed(obj.getSeed()+1L);;
			System.out.println("obj="+JSONObject.toJSONString(obj));
			System.out.println("num1=["+num+"]");
			num+= StringUtils.numberFormat(obj.getSeed());
			System.out.println("num2=["+num+"]");
			sql = SqlReadConfig.getSql("maximo.listnextautokey.update",obj);

			int update = Db.update(sql);

			//如果返回值不为 1 ,则说明更新失败;
			if(update!=1){
				return null;
			}
		}
		return num;
	}


	public void setSnowDb(SnowDB snowDb) {
		// TODO Auto-generated method stub
		this.snowDb=snowDb;

	}


	/**
	 * 获取 siteid 对应的 wotnum
	 * @param siteid
	 * @return
	 */
	public String getSiteWotnum(String siteid){
		Map<String,Object> parasmap=new HashMap<String, Object>();
		parasmap.put("siteid", siteid);
		String sql=SqlReadConfig.getSql("maximo.getsitewotnum",parasmap);
		Record record = Db.findFirst(sql);
		String sitewotnum="";
		if(record==null){
			return "";
		}
		if(record.getStr("WOTNUM")==null){
			return "";
		}
		return record.getStr("WOTNUM");
	}

}
