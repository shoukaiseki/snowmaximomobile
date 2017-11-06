package org.shoukaiseki.jfinal.kernel;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.shoukaiseki.jfinal.kernel.login.model.User;
import org.shoukaiseki.jfinal.kernel.exception.SnowException;

public class WebClient {
	
	private static final ThreadLocal<WebClient> threadClient = new ThreadLocal<WebClient>(); 
	
	HttpSession session;
	
	
	/**
	 * 登录人信息
	 */
	private User user;
	
	private String mobileid;
	
	
	/**
	 * 最后访问的世界
	 */
	private Date lastactivity;
	
	/**
	 * 登录时间
	 */
	private Date logindatetime;
	
	public WebClient(HttpSession session) {
		// TODO Auto-generated constructor stub
		this.session=session;
	}
	

	public HttpSession getSession() {
		return session;
	}



	public String getMobileid() {
		return mobileid;
	}

	public void setMobileid(String mobileid) {
		this.mobileid = mobileid;
	}

	public Date getLastactivity() {
		return lastactivity;
	}

	public void setLastactivity(Date lastactivity) {
		this.lastactivity = lastactivity;
	}

	public Date getLogindatetime() {
		return logindatetime;
	}

	public void setLogindatetime(Date logindatetime) {
		this.logindatetime = logindatetime;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public static ThreadLocal<WebClient> getThreadclient() {
		return threadClient;
	}
	

	public static WebClient getWebClient(){
		WebClient webClient = threadClient.get();
		if(webClient==null){
			throw new SnowException(2);
		}
		return webClient;
	}
	
}
