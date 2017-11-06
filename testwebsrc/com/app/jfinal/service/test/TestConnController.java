package com.app.jfinal.service.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Record;
import com.app.jfinal.service.test.model.Test3;
import org.shoukaiseki.jfinal.kernel.AbstractController;
import org.shoukaiseki.jfinal.kernel.SnowDB;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;
import org.shoukaiseki.jfinal.kernel.http.JsonModel;
import org.shoukaiseki.jfinal.kernel.testkit.RandomModel;
import org.shoukaiseki.jfinal.kernel.utils.DBUtils;
import org.shoukaiseki.jfinal.kernel.utils.StringUtils;

public class TestConnController extends AbstractController {

	public static final String TAG = "testconn";
	boolean result=false;
	
	public void workorder(){
		initJsonModel();
		StringBuffer sb=new StringBuffer();
		int i=Db.update("update workorder set status='等待核准' ,HISTORYFLAG=0 where workorderid=10863");
		sb.append("更新行数:"+i);
		i=Db.update("delete from AssetHierarchy where wonum in (select wonum from workorder where workorderid=10863)");
		sb.append(",删除AssetHierarchy行数:"+i);
		
		i=Db.update("update workorder set status='等待核准' ,HISTORYFLAG=0 where workorderid=11109");
		sb.append(",更新行数:"+i);
		i=Db.update("delete from AssetHierarchy where wonum in (select wonum from workorder where workorderid=11109)");
		sb.append(",删除AssetHierarchy行数:"+i);
		
		jsonModel.setErrorinfo(sb.toString());
		
		render(jsonModel);
		
	}
	
	public void wfassignment(){
		initJsonModel();
		StringBuffer sb=new StringBuffer();
		int j=Db.update("update wfassignment set ASSIGNCODE = (select personid from maxuser where loginid='qiaosh') "
				+ " where ownerid=10863 and ownertable='WORKORDER' and ASSIGNSTATUS='活动' and rownum<=1");
		sb.append("更新行数:"+j);
		j=Db.update("update wfassignment set ASSIGNCODE = (select personid from maxuser where loginid='qiaosh') "
				+ " where ownerid=11109 and ownertable='WORKORDER' and ASSIGNSTATUS='活动' and rownum<=1");
		sb.append(",更新行数:"+j);
		jsonModel.setErrorinfo(sb.toString());
		
		render(jsonModel);
		
	}
	
	public void reloadFailurecode(){
		initJsonModel();
		StringBuffer sb=new StringBuffer();
		int i=Db.update("update FAILURECODE set rowstamp='asas'");
		sb.append("failurecode 更新行数:"+i);

		i=Db.update("  update item set rowstamp='asas'");
		sb.append(",item 更新行数:"+i);
		i=Db.update("update person set rowstamp='asas'");
		sb.append(",person 更新行数:"+i);
		i=Db.update("update asset set rowstamp='asas'");
		sb.append(",asset 更新行数:"+i);
		i=Db.update("update Alndomain set rowstamp='asas'");
		sb.append(",alndomain 更新行数:"+i);
		i=Db.update("update locations set rowstamp='asas'");
		sb.append(",locations 更新行数:"+i);
		
		jsonModel.setErrorinfo(sb.toString());
		
		render(jsonModel);
		
	}
	
	public void testinteger(){
		initJsonModel();
	    for (int i = 0; i < 10; i++) {
	      System.out.println((Integer) i);
	      System.out.println(i);
	      Integer sd=new Integer(i);
	      System.out.println(sd);
	      HashMap<Object, Object> map = Maps.newHashMap();
	      map.put("i", i);
	      map.put("(Integer)i", (Integer)i);
	      map.put("Integer.valueOf(i)", Integer.valueOf(i));
	      map.put("new Integer(i)", new Integer(i));
	     ;
	      jsonModel.addDatas( map);
	    }		
	    render(jsonModel);
	}
	
	public void test() {
		logger.debug("test000");
		initJsonModel();
		
		logger.debug("test001");
		
		jsonModel.setStatus(JsonModel.SUCCESS);
		final StringBuffer text=new StringBuffer("aaabc\n");
		logger.debug("test002");
		
//        try {
//        	DbKit.getConfig().setThreadLocalConnection(DbKit.getConfig().getConnection());
//        	logger.debug("test003");
//        	DbKit.getConfig().getThreadLocalConnection().setAutoCommit(false);
//        	logger.debug("test004");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
		String sql = "update test set a='"+StringUtils.sdf.format(new Date())+"' where id =1";
		Db.update(sql);
		
		text.append(sql);
		
		text.append("\n").append("DbKit.getConfig().getTransactionLevel()="+DbKit.getConfig().getTransactionLevel());
//		try {
//			text.append("\n").append("DbKit.getConfig().getThreadLocalConnection().getTransactionIsolation()="+DbKit.getConfig().getThreadLocalConnection().getTransactionIsolation());
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
		result=false;		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					DbKit.getConfig().setThreadLocalConnection(DbKit.getConfig().getConnection());
					logger.debug("test003");
					DbKit.getConfig().getThreadLocalConnection().setAutoCommit(false);
					logger.debug("test004");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					result=Db.tx(new IAtom() {

						@Override
						public boolean run() throws SQLException {
							// TODO Auto-generated method stub
							//					Connection conn=null;
							boolean error=false;
							try {
								//						conn=DbKit.getConfig().getDataSource().getConnection();
								String sql = "update test set a='"+StringUtils.sdf.format(new Date())+"' where id =2";
								text.append("\n").append(sql);
								Db.update(sql);

								sql = "update test set ab='"+StringUtils.sdf.format(new Date())+"' where id =2";
								text.append("\n").append(sql);
								Db.update(sql);

							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
								error=true;
							}


							// 返回true 最后执行commit;
							// 返回 false 最后执行rollback
							return !error;
						}
					});
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					text.append("\nerror:").append(e.getCause());
				}
				try {
					if(!result){
						DbKit.getConfig().getThreadLocalConnection().rollback();
					}else{
						DbKit.getConfig().getThreadLocalConnection().commit();
					}

					DbKit.getConfig().getThreadLocalConnection().setAutoCommit(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).run();
		
//        	try {
//        		if(!result){
//        			DbKit.getConfig().getThreadLocalConnection().rollback();
//        		}else{
//        			DbKit.getConfig().getThreadLocalConnection().commit();
//        		}
//        		
//				DbKit.getConfig().getThreadLocalConnection().setAutoCommit(true);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
		logger.debug("test005");
		renderText(text.toString());
		
	}
	
	
	public void test2() {
		// TODO Auto-generated method stub
		logger.debug("test000");
		initJsonModel();
		
		logger.debug("test001");
		
		jsonModel.setStatus(JsonModel.SUCCESS);
		final StringBuffer text=new StringBuffer("aaabc\n");
		logger.debug("test002");
		
//        
		String sql = "update test set a='"+StringUtils.sdf.format(new Date())+"' where id =1";
		text.append(sql);
		Db.update(sql);
		
		
		
				
		SnowDB snowDb=null;
		try {
			snowDb=new SnowDB();
			sql = "update test set a='"+StringUtils.sdf.format(new Date())+"' where id =2";
			text.append("\n").append(sql);
			int update = snowDb.update(sql);
			text.append("\nupdate.result=").append(update);
			
			sql = "update test set c='c."+StringUtils.sdf.format(new Date())+"'";
			text.append("\n").append(sql);
			update=snowDb.update(sql);
			text.append("\nupdate.result=").append(update);
			
			
			sql = "update test2 set value='"+StringUtils.sdf.format(new Date())+"' where id =1";
			text.append("\n").append(sql);
			update=Db.update(sql);
			text.append("\nupdate.result=").append(update);
			
			
			sql = "insert into test (id,a,b) values("+System.currentTimeMillis()+",'LINUX."+System.currentTimeMillis()+"','b."+StringUtils.sdf.format(new Date())+"' )";
			text.append("\n").append(sql);
			update=snowDb.update(sql);
			text.append("\nupdate.result=").append(update);
			
			
			sql = "update test set a='b."+StringUtils.sdf.format(new Date())+"' where id =2";
			text.append("\n").append(sql);
			update=snowDb.update(sql);
			text.append("\nupdate.result=").append(update);
			
			
		} catch (SnowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			text.append("\nSnowException.error=").append(e.getMessage());
			text.append("\n执行出错:").append(StringUtils.getErrorInfoFromException(e));
			text.append("\n");
		}
		SnowDB.autoClose(snowDb);
		sql = "update test2 set name='ASUS."+StringUtils.sdf.format(new Date())+"' where id =1";
		text.append("\n").append(sql);
		Db.update(sql);

		
		logger.debug("test005");
		renderText(text.toString());

	}
	
	public void testinsert() {
		// TODO Auto-generated method stub
		SnowDB snowDb=null;
		try {
			Map<String,Object> insertMap =Maps.newHashMap();
			initJsonModel();
			Test3 obj=new Test3();
			snowDb=new SnowDB();
			
			for (int i = 0; i < 100; i++) {
				obj = new RandomModel("TEST3",snowDb.getConn()).random(Test3.class, Test3.class);
				Long objid = DBUtils.nextSequenceValue(Test3.class);
				obj.setTest3id(objid);
				obj.setRowstamp(DBUtils.nextSequenceValue("MAXSEQ"));
				obj.setDescription(getCanshu("value"));
				obj.setDecimal01(null);


				insertMap = obj.toInsertMap(1);

				DBUtils.saveInsertByMap(snowDb, "TEST3", insertMap);
				
			}

			SnowDB.autoClose(snowDb);
			jsonModel.setJson(JSONObject.toJSONString(insertMap));
			render(jsonModel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			SnowDB.rollbackClose(snowDb);
			renderException(new SnowException(10000,e));
		}
		

	}

	
    
	public void testupdate() {
		// TODO Auto-generated method stub
		SnowDB snowDb=null;
		try {
			Map<String,Object> insertMap =Maps.newHashMap();
			initJsonModel();
			Test3 obj=new Test3();
			snowDb=new SnowDB();
			
			List<Record> list = Db.find("select * from test3");
			for (Record record : list) {
					obj= BaseModel.Companion.recordTo(record, Test3.class);
					obj.setDescription(getCanshu("value"));
					Map<String,Object> updateMap = obj.toUpdateMap();
					 DBUtils.saveUpdateByMap(snowDb,"TEST3", updateMap
							,"test3id  = "+StringUtils.numberFormat(obj.getTest3id()));
				
			}

			SnowDB.autoClose(snowDb);
			jsonModel.setJson(JSONObject.toJSONString(insertMap));
			render(jsonModel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			SnowDB.rollbackClose(snowDb);
			renderException(new SnowException(10000,e));
		}
		

	}

    
}
