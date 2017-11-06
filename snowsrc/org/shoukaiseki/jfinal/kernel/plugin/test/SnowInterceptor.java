package org.shoukaiseki.jfinal.kernel.plugin.test;

import javax.servlet.http.HttpSession;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BlogInterceptor
 * 此拦截器仅做为示例展示，在本 demo 中并不需要
 */
public class SnowInterceptor implements Interceptor {
	
	public void intercept(Invocation inv) {
		System.out.println("Before invoking " + inv.getActionKey());
		inv.invoke();
		System.out.println("After invoking " + inv.getActionKey());
		// TODO Auto-generated method stub
		HttpSession session = inv.getController().getSession();
		System.out.println("session="+session);
		System.out.println("controller="+inv.getController());
		System.out.println("controller="+inv.getController());
		
//		if(session == null){
//			inv.getController().redirect("/");
//		}
//		else{
//			String nickname = (String) session.getAttribute("nickname");
//			if(nickname != null) {
//				//System.out.println("hello");
//			}
//			else {
//				inv.getController().redirect("/");
//			}
//		}
	}
}
