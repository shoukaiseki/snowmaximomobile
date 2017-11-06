package org.shoukaiseki.jfinal.kernel;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	
	public void index() {
	    HttpServletRequest request = getRequest();
        String path = request.getContextPath();
	   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

       System.out.println("path="+path);
       System.out.println("basePath="+basePath);
       setAttr("path", path);
       setAttr("basePath", basePath);
       
       renderJsp("index.jsp");

	}
}
