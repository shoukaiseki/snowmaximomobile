package org.shoukaiseki.jfinal.kernel.logger;

import org.apache.log4j.Logger;

public class SnowLogger {
	
	/**
	 * sql 类的日志
	 */
	public static final Logger SQLLogger = Logger.getLogger("snow.sql");
	
	/**
	 * DB 类的日志
	 */
	public static final Logger DBLogger = Logger.getLogger("snow.db");

	
}
