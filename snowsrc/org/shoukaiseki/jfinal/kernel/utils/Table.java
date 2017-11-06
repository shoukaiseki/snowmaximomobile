package org.shoukaiseki.jfinal.kernel.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.TYPE })
public @interface Table {
	/**
	 * Model对应的数据库
	 * 
	 * @return
	 */
	String dataSourceName();

	/**
	 * Model对应的表
	 * 
	 * @return
	 */
	String tableName();

	/**
	 * Model的主键列名称 描述：列明可以不是ids，但是在建立model的时候那就必须用pkName="xxx"注明
	 * 
	 * @return
	 */
	String pkName() default "ids";
}