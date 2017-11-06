package org.shoukaiseki.jfinal.kernel.login.model;

import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;

public class User extends BaseModel {

	private static final long serialVersionUID = 1L;

	public static final User dao = new User();

	// 中文名称
	private String displayname;
	// 所属站点
	private String defsite;
	// 用户id
	private String personid;

	// 用户登陆账号
	private String loginid;

	private String password;
	

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getDefsite() {
		return defsite;
	}

	public void setDefsite(String site) {
		this.defsite = site;
	}

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String dispalyName) {
		this.displayname = dispalyName;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public static User recordToObject(Record re) {
		// TODO Auto-generated method stub
		if(re==null)return null;
		User user=new User();
		user.setPassword(re.getStr("PASSWORD2"));
		user.setLoginid(re.getStr("LOGINID"));
		user.setDisplayname(re.getStr("DISPALYNAME"));
		user.setPersonid(re.getStr("PERSONID"));
		user.setDefsite(re.getStr("DEFSITE"));
		
		return user;
	}

}
