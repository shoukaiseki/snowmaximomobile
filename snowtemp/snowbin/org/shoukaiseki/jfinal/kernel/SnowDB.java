package org.shoukaiseki.jfinal.kernel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.common.collect.Lists;
import com.jfinal.plugin.activerecord.DbKit;
import com.jfinal.plugin.activerecord.ModelBuilder;
import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;
import org.shoukaiseki.jfinal.kernel.logger.SnowLogger;
import org.jetbrains.annotations.NotNull;

/** org.shoukaiseki.jfinal.kernel.SnowDb
 * 非共享 sql 数据库操作 , 最后需要 commit, rollback 
 * 在执行完 commit ,rollback 之后会 close 掉 connection
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月17日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class SnowDB{
	public static final Logger logger = Logger.getLogger(SnowDB.class);
	
	public static final Logger sqllogger = SnowLogger.SQLLogger;
	
	private Connection conn=null;
		
		/**
		 * 在执行sql过程中是否存在执行错误
		 */
		boolean hasError=false;
	
	public SnowDB() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbKit.getConfig().getDataSource().getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SnowException(10002, e);
		}
	}
	
	public SnowDB(Connection conn){
		this.conn=conn;
	}
	
	public int update(String sql,Object... paras) throws SnowException{
		int result =0;
		PreparedStatement st =null;
		int i=0;
		Object attname=null;
		StringBuffer sb=new StringBuffer("*************************\npara=");
		try {
			sqllogger.debug(sql);
			st = conn.prepareStatement(sql);
			for (; i<paras.length; i++) {
				sqllogger.debug(paras[i]);
				attname=paras[i];
				sb.append("i="+i).append(",value="+paras[i]).append("\n");
				st.setObject(i + 1, paras[i]);

			}
			result = st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			hasError=true;
			closeStatement(st);
			sb.append("***********************");
			logger.error(sb.toString());
			throw new SnowException(30001,e).setParams(i,attname);
		}
		return result;
	}
	
	public int update(String sql) throws SnowException{
		int result =0;
		Statement st =null;
		try {
			st = conn.createStatement();
			sqllogger.debug(sql);
			result = st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			hasError=true;
			closeStatement(st);
			throw new SnowException(10003, e);
		}
		return result;
	}
	
	
	public Record findFirst(String sql) {
		sqllogger.debug(sql);
		List<Record> result = find(sql);
		return result.size() > 0 ? result.get(0) : null;
	}
	
	public List<Record> find(String sql,Object... paras){
		List<Record> result = Lists.newArrayList();
		PreparedStatement pst =null;
		ResultSet rs =null;
		try {
			sqllogger.debug(sql);
			pst = conn.prepareStatement(sql);
			for (int i=0; i<paras.length; i++) {
				sqllogger.debug(paras[i]);
				pst.setObject(i + 1, paras[i]);
			}
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			String[] labelNames = new String[columnCount + 1];
			int[] types = new int[columnCount + 1];
			buildLabelNamesAndTypes(rsmd, labelNames, types);
			while (rs.next()) {
				SnowRecord record = new SnowRecord();
				Map<String, Object> columns = record.getColumns();
				for (int i=1; i<=columnCount; i++) {
					Object value;
					if (types[i] < Types.BLOB)
						value = rs.getObject(i);
					else if (types[i] == Types.CLOB)
						value = ModelBuilder.handleClob(rs.getClob(i));
					else if (types[i] == Types.NCLOB)
						value = ModelBuilder.handleClob(rs.getNClob(i));
					else if (types[i] == Types.BLOB)
						value = ModelBuilder.handleBlob(rs.getBlob(i));
					else
						value = rs.getObject(i);

					columns.put(labelNames[i], value);
				}
				result.add(record);

			}

			
			closeResultSet(rs);
			closeStatement(pst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeResultSet(rs);
			closeStatement(pst);
			throw new SnowException(10000, e);
		}
		return result;
	}
	
	private static final void buildLabelNamesAndTypes(ResultSetMetaData rsmd, String[] labelNames, int[] types) throws SQLException {
		for (int i=1; i<labelNames.length; i++) {
			labelNames[i] = rsmd.getColumnLabel(i);
			types[i] = rsmd.getColumnType(i);
		}
	}
	
	private void closeResultSet(ResultSet rs) {
		// TODO Auto-generated method stub
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void closeStatement(Statement st){
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

	public Connection getConn() {
		return conn;
	}

	public boolean hasError() {
		return this.hasError;
	}

	public static void autoClose(SnowDB snowDb){
	    if(snowDb!=null)
			snowDb.autoClose();
	}
	
	public static void rollbackClose(SnowDB snowDb){
		if(snowDb!=null){
			snowDb.rollbackClose();
		}
	}
	
	public  void rollbackClose(){
		hasError=true;
		autoClose();
	}
	
	public void autoClose(){
		if(conn!=null){
			try {
				if(hasError){
					conn.rollback();
				}else{
					conn.commit();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
