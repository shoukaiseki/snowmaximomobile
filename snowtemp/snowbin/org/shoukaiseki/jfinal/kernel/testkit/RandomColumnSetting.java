package org.shoukaiseki.jfinal.kernel.testkit;

import org.shoukaiseki.jfinal.kernel.utils.StringExpand;

/** org.shoukaiseki.jfinal.kernel.testkit.ColumnSetting
 * 随机数的字段长度设定
 * @author 蒋カイセキ    Japan-Tokyo  2017年5月10日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class RandomColumnSetting {
	
	/**
	 * 字段名称
	 */
	private String column_name;
	
	/**
	 * 字段类型
	 */
	private String data_type;
	
	/**
	 *  最小长度
	 */
	private int min_char_length=1;
	
	/**
	 * 最大长度
	 */
	private int max_char_length=30;
	
	public String getColumn_name() {
		return column_name;
	}
	
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public int getMin_char_length() {
		return min_char_length;
	}

	public void setMin_char_length(int min_char_length) {
		this.min_char_length = min_char_length;
	}

	public int getMax_char_length() {
		return max_char_length;
	}

	public void setMax_char_length(int max_char_length) {
		this.max_char_length = max_char_length;
	}
	
	public boolean isString(){
		return StringExpand.binarySearch(new String[]{"VARCHAR2"}, this.data_type);
	}

}
