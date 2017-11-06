package org.shoukaiseki.jfinal.kernel.plugin;

import com.jfinal.plugin.IPlugin;

public class SqlReadPlugin implements IPlugin {

	@Override
	public boolean start() {
		// TODO Auto-generated method stub
		
		
		return SqlReadConfig.init();
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
    	
		return SqlReadConfig.destory();
	}

}
