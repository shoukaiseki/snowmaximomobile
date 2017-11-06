package com.app.jfinal.service.test;

import java.io.StringWriter;
import java.util.HashMap;

import com.app.jfinal.service.common.model.Autodatesitenum;
import com.app.jfinal.service.common.model.Autodatesitenum;
import com.app.jfinal.service.workorder.model.Workorder;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.*;

public class Testfreemarker {

	public static void main(String[] args) {
		String sql=null;
		
		sql="select * from LOCATIONS where siteid=${siteid} and rowstamp>${rowstamp}  and rownum <= 1000 order by rowstamp";
//		sql="select * from LOCATIONS where siteid=${siteid} and rowstamp${rowstamp}  and rownum = 1000 order by rowstamp";
		sql=""+"		select * from workorder where (ISTASK=0 and (worktype in ('GZWO','WO','OPPM','XJ','JGXM','SRWO')))"
		+"			and  status not in ('取消','关闭','等待核准','退回修改')"
		+"			and siteid='${siteid}'"
		+"			<#if personid?? && (personid!=\"\")>"
		+"				and REPORTEDBY = '${personid}'"
		+"			</#if>";
		
		sql="${siteid?c}";
		sql=""
				+	"  select * from workorder where  "
				+"  			<#if workorderid?exists > "
				+"  				workorderid = ${workorderid?c} "
				+"  			<#else> "
				+"  				workorderid = -1 "
				+"  			</#if> ";

		HashMap<String,Object> map=new HashMap<String, Object>();
//		map.put("personid", "");
//		map.put("rowstamp", "0");
		map.put("siteid", "DMB");
		map.put("siteid", 123123124L);
		map.put("workorderid", null);
//		sql=getSql(sql,map);

		sql="select * from autodatesitenum where  SITEID='${siteid}'  and ORGID='${orgid}' \n" +
				"\t\t\tand OWNERTABLE='${ownertable}' and OWNERATTRIBUTENAME='${ownerattributename}' \n" +
				"\t\t\tand YEAR=${year?c} and MONTH=${month}";

		
		
		Workorder wo=new Workorder();
		wo.setWorkorderid(123123123L);
        Autodatesitenum adsn=new Autodatesitenum( );
        adsn.setYear(2017);
		adsn.setMonth(7);
		adsn.setSiteid("");
		adsn.setOrgid("");
		adsn.setOwnertable("");
		adsn.setOwnerattributename("");
		sql=getSql(sql,adsn);
		System.out.println("sql=\n"+sql);
		
	}
	
	public static String getSql(String insql,Object obj) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);  
		StringTemplateLoader stl = new StringTemplateLoader();  
		config.setTemplateLoader(stl);  
		config.setDefaultEncoding("UTF-8"); 
		String sql=null;
		
		String sqlid="asas";
		
		stl.putTemplate(sqlid,insql);
		try {
			StringWriter sw = new StringWriter();  
			Template template = config.getTemplate(sqlid);
			template.process(obj,sw);
			sql=sw.toString(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return sql;

	}
}
