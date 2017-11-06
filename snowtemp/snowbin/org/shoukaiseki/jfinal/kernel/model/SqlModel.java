package org.shoukaiseki.jfinal.kernel.model;

public class SqlModel {
	
	/**
	 * 
	 */
	private String id;
	
	/**
	 * sql内容
	 */
	private String sql;
	
	/**
	 * 使用的解析器,例如:freemarker
	 */
	private String parser;
	
	public SqlModel(){
		
	}
	
	public SqlModel(String id,String sql,String parser) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.sql=sql;
		this.parser=parser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getParser() {
		return parser;
	}

	public void setParser(String parser) {
		this.parser = parser;
	}

	
}
