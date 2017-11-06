package com.app.jfinal.service.developerutils;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.app.jfinal.service.common.model.Maxattributecfg;
import com.app.jfinal.service.mobileapp.model.Phoneversion;
import org.shoukaiseki.jfinal.kernel.AbstractController;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowFieldProp;
import org.shoukaiseki.jfinal.kernel.http.RenderXml;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;
import org.shoukaiseki.jfinal.kernel.utils.FileUtils;

/**
 * com.app.jfinal.service.developerutilDeveloperUtilsControllerer <br>
 *
 * @author 蒋カイセキ    Japan-Tok2017-06-07609:57:377:35<br>
 *         ブログ http://shoukaiseki.blog.163.com/<br>
 *         E-メール jiang28555@Gmail.com<br>
 */

public class DeveloperUtilsController extends AbstractController{
	
	public static final String TAG = "utils";
	
	public static final String VIEWPATH="utils";
	
	public static final Logger logger = Logger.getLogger(DeveloperUtilsController.class);
	
	public void index() {
		// TODO Auto-generated method stub
		renderJsp("index.jsp");

	}
	
	public void getphoneversiondata(){
		Integer rows= getParaToInt("rows",50);
		Integer page= getParaToInt("page",1);
		
		String sql=" select * from phoneversion order by phoneversionid desc";
		
		StringBuffer sb=new StringBuffer("select * from (select a1.*,rownum snow_rn from (");
		sb.append(sql);
		sb.append(") a1 where rownum <=");
		sb.append(page*rows).append(") where snow_rn>").append((page-1)*rows);
		sql=sb.toString();
		
		
		
		
		LinkedList<Object> pvs = Lists.newLinkedList();
		List<Record> list = Db.find(sql);
		String[] columnNames =null;
		for (Record record : list) {
			Phoneversion pv = BaseModel.Companion.recordTo(record, Phoneversion.class);
			pvs.add(pv);
			
			if(columnNames==null){
				columnNames = record.getColumnNames();
			}
			
		}
		if(columnNames==null){
			columnNames =new String[]{};
		}
		
		HashMap<Object, Object> datas = Maps.newHashMap();
		
		datas.put("rows", pvs.toArray());
		datas.put("columns", columnNames);
		
		String jsonString = JSONObject.toJSONString(datas);
		renderText(jsonString);
		
		
	}
	
	
	public void viewsnowfieldprop(){
		Map<String, HashMap<String, SnowFieldProp>> map = BaseModel.Companion.loadSnowfieldMap();
		for(String key:map.keySet()){
//			System.out.println("----------------"+key);
			HashMap<String,SnowFieldProp> ssmap =map.get(key);
			Set<String> k=new TreeSet<String>(ssmap.keySet());
			for (Object object : k) {
//				System.out.println("key="+object);
			}
		}
		
		renderJsp("viewsnowfieldprop.jsp");
	}
	
	public void viewmaxappxml(){
		if(StrKit.isBlank(getPara("appname"))){
			renderText("出现错误,参数 appname 不存在");
			return ;
		}
		String appname=getPara("appname").toUpperCase();
		String sql = "select * from  maxpresentation where app='"+appname+"'";
		Record record = Db.findFirst(sql);
		if(record!=null){
			final Object xml = record.get("PRESENTATION");
			render(new RenderXml(xml.toString()));
		}else{
			renderText("出现错误,没有有效记录:\n"+sql);
		}
		
	}
	
	public void viewmodelsrc(){
		StringBuffer modelsrc=new StringBuffer();
		StringBuffer modelsnowtable=new StringBuffer();
		StringBuffer androidsrc=new StringBuffer();
		StringBuffer iossrc=new StringBuffer();
		HashMap<Object, Object> paramap = Maps.newHashMap();
		paramap.put("tablename", getPara("tablename","").toUpperCase());
		String sql=SqlReadConfig.getSql("utilsdeveloper.viewmodelsrc_listmaxattributecfg",paramap);
		
		List<Record> list = Db.find(sql);

		sql=SqlReadConfig.getSql("utilsdeveloper.viewmodelsrc_listmaxsequence_and_maxobject",paramap);
		Record maxseq = Db.findFirst(sql);
		if(maxseq!=null){
		    String entityname=maxseq.getStr("ENTITYNAME");
		    String sequencename=maxseq.getStr("SEQUENCENAME");
		    String objectname=maxseq.getStr("OBJECTNAME");
		    String uniqueidname=maxseq.getStr("NAME");
		    String name=maxseq.getStr("NAME");
		    modelsnowtable.append("\n");
			modelsnowtable.append("@SnowTable(");
			modelsnowtable.append("maxObjecxtName = \"" +objectname+ "\",maxSequenceName =\""+sequencename+"\",maxEntityName = \""+entityname+"\"");
			modelsnowtable.append(",maxUniqueIDName = \"" +uniqueidname+ "\"");
			modelsnowtable.append(")");
			modelsnowtable.append("\n\n");
			modelsnowtable.append("\t@Override\n" +
					"\tpublic String showMaxTableName() {\n" +
					"\t\t// TODO Auto-generated method stub\n" +
					"\t\treturn \""+entityname+"\";\n" +
					"\t}\n" +
					"\n" +
					"\tpublic String showMaxUniqueIDName() {\n" +
					"\t\t// TODO Auto-generated method stub\n" +
					"\t\treturn \""+name+"\";\n" +
					"\t}\n" +
					"\n" +
					"\tpublic Long showMaxUniqueIDValue() {\n" +
					"\t\treturn "+name.toLowerCase()+";\n" +
					"\t}");

		}



		for (Record record : list) {
			String title = "\n    /**\n     *"+record.getStr("TITLE")+"\n     **/";
			String att=record.getStr("TYPE")+" "+record.getStr("LOWERATTRIBUTENAME");
			modelsrc.append("\n    ").append(title);
			modelsrc.append("\n    ").append(att);
			modelsrc.append("\n");
			
			androidsrc.append("\n    ").append(title);
			androidsrc.append("\n    ").append((Object)record.get("DATABASEFIELDATTRIBUTENAME"));
			androidsrc.append("\n    ").append(att);
			androidsrc.append("\n");

			String lowerAttributeName=record.getStr("LOWERATTRIBUTENAME");
			if("description".equalsIgnoreCase(lowerAttributeName)){
				lowerAttributeName="Description";
			}
			iossrc.append("\n").append(title);
			iossrc.append("\n    ").append((Object)record.get("OCTYPE")).append(" "+lowerAttributeName);
			iossrc.append("\n");

		}
		
		if(list.size()==0){
			modelsrc.append("\n找不到有效的数据").append("\nsql="+sql);
			androidsrc.append("\n找不到有效的数据").append("\nsql="+sql);
			iossrc.append("\n找不到有效的数据").append("\nsql="+sql);

		}
		
		setAttr("src", "src");
		setAttr("path", "path");
		setAttr("modelsrc", modelsrc.toString());
		setAttr("modelsnowtable",modelsnowtable.toString());
		setAttr("androidsrc",androidsrc.toString());
		setAttr("iossrc",iossrc.toString());
		renderJsp("viewmodelsrc.jsp");
		
	}
	
	
	public void viewdefaultvaluesource(){
		String classkey = getPara("classkey");
		//获取自定义 JsonModel start
		StringBuffer java=new StringBuffer("\n");
		Map<String, HashMap<String, SnowFieldProp>> map = BaseModel.Companion.loadSnowfieldMap();
		HashMap<String, SnowFieldProp> ssmap = map.get(classkey);
		if(ssmap!=null){
			Set<String> treekey=new TreeSet<String>(ssmap.keySet());
			for(Object sskey:treekey){
				SnowFieldProp sfp=ssmap.get(sskey);	
				boolean hasrequired=false;
				boolean hasdefval=false;
				if(sfp.isRequired()){
					hasrequired=true;
				}
				if(sfp.getSnowdefval()!=null){
					hasdefval=true;
				}
				if(sfp.hasMaxatt()){
					Maxattributecfg maxatt=sfp.outMaxatt();
					if(maxatt.getRequired()!=null&&maxatt.getRequired()){
						hasrequired=true;
					}
					if(maxatt.getDefaultvalue()!=null){
						hasdefval=true;
					}
					
					//必填字段且无默认值,也不是主键 显示红色
					if(hasrequired&&!hasdefval&&!sfp.isPrimary()){
						String val="";
						switch (maxatt.getMaxtype()) {
						case "YORN":
							val="false";
							break;
						case "AMOUNT":
							val="0.00D";
							break;
						case "DURATION":
							val="0";
							break;

						default:
							break;
						}
						java.append("defvalmap.put(\"").append(sskey.toString().toUpperCase())
						.append("\",").append(val).append(");");
						java.append("\n");
					}
				}
			}
		}else{
			java.append("无效的classkey:"+classkey);
		}
		
		setAttr("src", "src");
		setAttr("path", "path");
		setAttr("java", java);
		renderJsp("viewsrc.jsp");
	}
	
	public void viewclasssource(){
		String classname = getPara("classkey");
		String path = PathKit.getRootClassPath();
		
		path=path+"/../../../src/"+classname.replaceAll("\\.", "/")+".java";
		if(!new File(path).exists()){
			path=PathKit.getRootClassPath()+"/../../../src/"+classname.replaceAll("\\.", "/")+".kt";
		}
		String java=FileUtils.readFileToString(path,"UTF-8");
		
		setAttr("src", classname);
		setAttr("path", path);
		setAttr("java", java);
		renderJsp("viewsrc.jsp");
	}

}
