/**
 *@Copyright:Copyright (c) 2015
 *@Company:SHUTO
 */
package org.shoukaiseki.jfinal.kernel.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 *@Title: 定义常量的注释类
 *@Description:
 *@Author:pilllar
 *@Since:2015年6月13日
 *@Version:1.1.0
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD,ElementType.METHOD })
public @interface ConstantAnnotation {
	
	/**
	 * 类别，默认都是字符string，特殊有数字型int
	 * @return
	 * @Description:
	 */
	String type() default "string";
	
	/**
	 * 注释
	 * @return
	 * @Description:
	 */
	String desc() default "";

}
