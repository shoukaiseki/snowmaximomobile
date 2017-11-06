package org.shoukaiseki.jfinal.kernel;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.JFinal;
import com.jfinal.handler.Handler;

public class SessionHandler extends Handler {
	Logger logger=Logger.getLogger(SessionHandler.class);

	private Pattern skipedUrlPattern;
	public SessionHandler() {
		// TODO Auto-generated constructor stub
		skipedUrlPattern=Pattern.compile("/login/.*", Pattern.CASE_INSENSITIVE);
	}

	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		// TODO Auto-generated method stub
		
		

		
		HttpSession session = request.getSession();
		String id = session.getId();
		logger.debug("session.id="+id);

		if (skipedUrlPattern.matcher(target).matches()){
			logger.debug("登录页面");
			nextHandler.handle(target, request, response, isHandled);
			return;
		}
		
		//输入流  start
//		try {
//			ServletInputStream inputStream = request.getInputStream();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		//输入流  end

		Object webclient = session.getAttribute("WebClient");
		logger.debug("webclient="+webclient);
		if(webclient==null){
			try {
				String path = request.getContextPath();
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
				
				//无登录状况转到失效提示页面
				String url = basePath+"login/invalid";
				response.sendRedirect(url);
				// 如果 sendRedirect 出现异常,网页访问不会出现其它数据,防止数据泄露
				nextHandler.handle(target, request, response, isHandled);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			// 如果 sendRedirect 出现异常,网页访问不会出现其它数据,防止数据泄露
			nextHandler.handle(target, request, response, isHandled);
		}

	}



}
