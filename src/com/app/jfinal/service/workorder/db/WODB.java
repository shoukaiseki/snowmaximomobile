package com.app.jfinal.service.workorder.db;

import com.google.common.collect.Lists;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.app.jfinal.service.workorder.model.Labtrans;
import com.app.jfinal.service.workorder.model.Relatedrecord;
import com.app.jfinal.service.workorder.model.Workorder;
import com.app.jfinal.service.workorder.model.Wotask;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WODB {
	public static final Logger logger = Logger.getLogger(WODB.class);

	


	public List<Relatedrecord> findRelatedwo(Map<String,Object> wo) {
		// TODO Auto-generated method stub
		ArrayList<Relatedrecord> lists = Lists.newArrayList();
		String sql = SqlReadConfig.getSql("wodb.listrelatedwo",wo);
		List<Record> list = Db.find(sql);
		Relatedrecord obj=null;
		for (Record record : list) {
			obj= Relatedrecord.Companion.recordTo(record, Relatedrecord.class);
			lists.add(obj);
		}
		return lists;
	}
	

	public List<Relatedrecord> findRelatedticket(Map<String,Object> wo) {
		// TODO Auto-generated method stub
		ArrayList<Relatedrecord> lists = Lists.newArrayList();
		String sql = SqlReadConfig.getSql("wodb.listrelatedticket",wo);
		List<Record> list = Db.find(sql);
		Relatedrecord obj=null;
		for (Record record : list) {
			obj= Relatedrecord.Companion.recordTo(record, Relatedrecord.class);
			lists.add(obj);
		}
		return lists;
	}
	

	/** 获取 relatedrecord 关联的工单
	 * @param map
	 * @return
	 */
	public List<Workorder> findWo(Map<String,Object> map) {
		// TODO Auto-generated method stub
		ArrayList<Workorder> lists = Lists.newArrayList();
		String sql = SqlReadConfig.getSql("wodb.list_related_record_wo",map);
		List<Record> list = Db.find(sql);
		Workorder obj=null;
		for (Record record : list) {
			obj= Workorder.Companion.recordTo(record, Workorder.class);
			lists.add(obj);
		}
		return lists;
		
	}

	


	public List<Wotask> findWotask(Workorder wo) {
		// TODO Auto-generated method stub
		ArrayList<Wotask> lists = Lists.newArrayList();
		String sql = SqlReadConfig.getSql("workorder.list_wotask",wo);
		List<Record> list = Db.find(sql);
		Wotask obj=null;
		for (Record record : list) {
			obj= Wotask.Companion.recordTo(record, Wotask.class);
			lists.add(obj);
		}
		return lists;
		
	}




	public List<Labtrans> findLabtrans(Object para) {
		// TODO Auto-generated method stub
		ArrayList<Labtrans> lists = Lists.newArrayList();
		String sql = SqlReadConfig.getSql("wodb.list_labtrans",para);
		List<Record> list = Db.find(sql);
		Labtrans obj=null;
		for (Record record : list) {
			obj= BaseModel.Companion.recordTo(record, Labtrans.class);
			lists.add(obj);
		}
		return lists;
	}







}
