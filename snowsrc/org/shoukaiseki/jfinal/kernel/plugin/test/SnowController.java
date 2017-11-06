package org.shoukaiseki.jfinal.kernel.plugin.test;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(SnowInterceptor.class)
public class SnowController extends Controller {
	
	
	public void index() {
	    HttpServletRequest request = getRequest();
        String path = request.getContextPath();
	   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

       System.out.println("path="+path);
       System.out.println("basePath="+basePath);
       setAttr("path", path);
       setAttr("basePath", basePath);
       
       renderJsp("snow.jsp");
	}


}
