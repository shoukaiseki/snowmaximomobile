package org.shoukaiseki.jfinal.kernel.common;

import java.lang.annotation.*;

/** org.shoukaiseki.jfinal.kernel.common.SnowField
 *@Title: 自定义注释：字段属性是否虚拟化，相应持久化则在toMap中 组装，否则不进行组装,则在属性这里定义 <code>@SnowField('')</code>
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月12日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SnowField {
	
	
	/**
	 * 是否持久化字段/虚拟字段: false 虚拟字段
	 * <br>
	 * 					 true 持久化字段
	 * <br>
	 * 默认为 true持久化字段
	 * 
	 * @return
	 */
	public abstract boolean isPersistent() default true;
	
	/**
	 * 是否主键，true=主键，默认都是false
	 * @return
	 * @Description:
	 */
	public abstract boolean isPrimary() default false;
	
	/** 是否必填,如果为 true 则必填,默认为false
	 * @return
	 */
	public abstract boolean isRequired() default false;

	/**
	 * 格式？
	 * 
	 * @return
	 */
	public abstract String format() default "";
	
	
	/**
	 * insert插入时是否忽略该字段,比如 maximo中有 AUTOKEY 字段,不需要生成插入语句时设置
	 * <br>
	 * true  忽略
	 * <br>
	 * false 不忽略,默认该值
	 * 
	 * @return
	 */
	public abstract boolean isInsertIgnore() default false;

	/**
	 * update插入时是否忽略该字段,比如 主键,不需要生成 update 语句时更新该字段
	 * <br>
	 * true  忽略
	 * <br>
	 * false 不忽略,默认该值
	 * 
	 * @return
	 */
	public abstract boolean isUpdateIgnore() default false;
}
