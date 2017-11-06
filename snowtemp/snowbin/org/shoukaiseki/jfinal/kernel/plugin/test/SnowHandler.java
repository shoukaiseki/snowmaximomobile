package org.shoukaiseki.jfinal.kernel.plugin.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;
import com.jfinal.kit.StrKit;

public class SnowHandler extends Handler {

	private Pattern skipedUrlPattern;
	 
	/** 
	 * @param skipedUrlRegx 正则表达式
	 * @param isCaseSensitive 是否区分大小写,false:不区分,不代表能够转到正确的servlet,因为servlet区分大小写
	 */
	public SnowHandler(String skipedUrlRegx, boolean isCaseSensitive) {
	 
		if (StrKit.isBlank(skipedUrlRegx))
			throw new IllegalArgumentException("The para excludedUrlRegx can not be blank.");
		skipedUrlPattern = isCaseSensitive ? Pattern.compile(skipedUrlRegx) : Pattern.compile(skipedUrlRegx, Pattern.CASE_INSENSITIVE);
	 
	}
	 
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		
		System.out.println("target="+target);
		System.out.println("判断="+skipedUrlPattern.matcher(target).matches());
		if (skipedUrlPattern.matcher(target).matches())
			return ;
		else
			nextHandler.handle(target, request, response, isHandled);
		
//		int index = target.indexOf(".xx");
//		if (index != -1){
//			nextHandler.handle(target, request, response, new boolean[]{true});
//		}

	}

}
