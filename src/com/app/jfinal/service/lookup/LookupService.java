package com.app.jfinal.service.lookup;

import com.app.jfinal.service.lookup.model.*;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.app.jfinal.service.lookup.model.*;
import org.shoukaiseki.jfinal.kernel.AbstractController;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;
import org.shoukaiseki.jfinal.kernel.sql.oracle.SqlPagingFormat;

import java.util.List;

public class LookupService  extends AbstractController{
	
	public static String TAG="lookup";
	
	
	public void checksync() {
		try {
			initJsonModel();
			String json = jm.getJson();
			logger.debug("json="+json);
			String siteid = getCanshu("siteid");
			logger.debug("siteid="+siteid);

			String sql = SqlReadConfig.getSql("lookup.checksync",jm.getParameters());
			logger.debug("sql="+sql);
			List<Record> list = Db.find(sql);
			SyncDate obj =null;
			for (Record record : list) {
				obj = SyncDate.recordToObject(record);
				jsonModel.addDatas( obj);
			}
			jsonModel.setStatus(JsonModel.SUCCESS);
			render(jsonModel);
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(e);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			renderException(new SnowException(10000,ex));
		}
		
	}
	
	public void listlocations() {
		// TODO Auto-generated method stub
		try{
			initJsonModel();
			String json = jm.getJson();
			logger.debug("json="+json);
			String personid = getCanshu("personid");
			String siteid = getCanshu("siteid");
			Long rowstamp = getCanshuToLong("rowstamp");


			String sql = SqlReadConfig.getSql("lookup.listlocation",jm.getParameters());
			sql = SqlPagingFormat.pagingFormat(99999999, 1, sql, jsonModel);
			logger.debug("sql="+sql);
			List<Record> list = Db.find(sql);
			Locations loc =null;
			for (Record record : list) {
				jsonModel.setColumnNames(record.getColumnNames());
				loc = Locations.Companion.recordTo(record,Locations.class);
				jsonModel.addDatas( loc);
			}
			jsonModel.setStatus(JsonModel.SUCCESS);
			render(jsonModel);
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(e);

		} catch (Exception ex) {
			ex.printStackTrace();
			renderException(new SnowException(10000,ex));
		}

	}
	
	
	public void listasset() {
		// TODO Auto-generated method stub
		try{
			initJsonModel();

			String json = jm.getJson();
			logger.debug("json="+json);
			String personid = getCanshu("personid");
			String siteid = getCanshu("siteid");
			Long rowstamp = getCanshuToLong("rowstamp");


			String sql = SqlReadConfig.getSql("lookup.listasset",jm.getParameters());
			sql = SqlPagingFormat.pagingFormat(99999999, 1, sql, jsonModel);
			logger.debug("sql="+sql);
			List<Record> list = Db.find(sql);
			Asset obj =null;
			for (Record record : list) {
				jsonModel.setColumnNames(record.getColumnNames());
				obj = Asset.Companion.recordTo(record,Asset.class);
				jsonModel.addDatas( obj);
			}
			jsonModel.setStatus(JsonModel.SUCCESS);
			render(jsonModel);
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(e);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			renderException(new SnowException(10000,ex));
		}
	}
	
	
	public void listalndomain() {
		// TODO Auto-generated method stub
		try{
			initJsonModel();
			String json = jm.getJson();
			logger.debug("json="+json);
			String personid = getCanshu("personid");
			String siteid = getCanshu("siteid");
			Long rowstamp = getCanshuToLong("rowstamp");


			String sql = SqlReadConfig.getSql("lookup.listalndomain",jm.getParameters());
			sql = SqlPagingFormat.pagingFormat(99999999, 1, sql, jsonModel);
			logger.debug("sql="+sql);
			List<Record> list = Db.find(sql);
			Alndomain obj =null;
			for (Record record : list) {
				jsonModel.setColumnNames(record.getColumnNames());
				obj = Alndomain.Companion.recordTo(record,Alndomain.class);
				jsonModel.addDatas( obj);
			}
			jsonModel.setStatus(JsonModel.SUCCESS);
			render(jsonModel);
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(e);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			renderException(new SnowException(10000,ex));
		}
	}
	
	
	public void listperson() {
		// TODO Auto-generated method stub
		try{
			initJsonModel();
			String json = jm.getJson();
			logger.debug("json="+json);


			String sql = SqlReadConfig.getSql("lookup.listperson",jm.getParameters());
			sql = SqlPagingFormat.pagingFormat(99999999, 1, sql, jsonModel);
			logger.debug("sql="+sql);
			List<Record> list = Db.find(sql);
			Person obj =null;
			for (Record record : list) {
				jsonModel.setColumnNames(record.getColumnNames());
				obj = Person.Companion.recordTo(record,Person.class);
				jsonModel.addDatas( obj);
			}
			jsonModel.setStatus(JsonModel.SUCCESS);
			render(jsonModel);
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(e);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			renderException(new SnowException(10000,ex));
		}
	}
	
	public void listfailurelist() {
		// TODO Auto-generated method stub
		try {
			initJsonModel();
			String json = jm.getJson();
			logger.debug("json="+json);


			String sql = SqlReadConfig.getSql("lookup.listfailurelist",jm.getParameters());
			sql = SqlPagingFormat.pagingFormat(99999999, 1, sql, jsonModel);
			logger.debug("sql="+sql);
			List<Record> list = Db.find(sql);
			Failurecode obj =null;
			for (Record record : list) {
				jsonModel.setColumnNames(record.getColumnNames());
				obj = Failurecode.Companion.recordTo(record,Failurecode.class);
				jsonModel.addDatas( obj);
			}
			jsonModel.setStatus(JsonModel.SUCCESS);
			render(jsonModel);
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(e);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			renderException(new SnowException(10000,ex));
		}
	}


	public void listdepartment() {
		// TODO Auto-generated method stub
		try{
			initJsonModel();
			String json = jm.getJson();
			logger.debug("json="+json);
			String personid = getCanshu("personid");
			String siteid = getCanshu("siteid");
			Long rowstamp = getCanshuToLong("rowstamp");


			String sql = SqlReadConfig.getSql("lookup.listdepartment",jm.getParameters());
			sql = SqlPagingFormat.pagingFormat(99999999, 1, sql, jsonModel);
			logger.debug("sql="+sql);
			List<Record> list = Db.find(sql);
			Da_department obj =null;
			for (Record record : list) {
				jsonModel.setColumnNames(record.getColumnNames());
				obj = BaseModel.Companion.recordTo(record,Da_department.class);
				jsonModel.addDatas( obj);
			}
			jsonModel.setStatus(JsonModel.SUCCESS);
			render(jsonModel);
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderException(e);

		} catch (Exception ex) {
			ex.printStackTrace();
			renderException(new SnowException(10000,ex));
		}
	}

}
