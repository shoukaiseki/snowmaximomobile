package com.app.jfinal.service.test.module;

import com.app.jfinal.service.test.NavigationTest;
import com.app.jfinal.service.test.TestController;
import org.apache.http.message.BasicNameValuePair;

public class LoginNT extends NavigationTest {
	
	
	
	public LoginNT() {
		// TODO Auto-generated constructor stub
		super("login/loginmaximo","login/loginmaximo","登录接口:在app登录验证时使用的接口方案,返回值中的 json数据中的 json 字段,为登录人验证通过后的个人信息"
				+ "\nhttps://123.56.42.78:7543/svn/dunanmobileservice/"
				+ "\nhttps://vip2.svnspot.com/jiangxinyi21.dunanmobileservice/trunk/dunanjfinal");
		addParameter(new BasicNameValuePair("loginid", TestController.loginid));
		addParameter(new BasicNameValuePair("password", "170DB79B4BEE2D9670C8C117EE7862D7"));
	}
	

}
