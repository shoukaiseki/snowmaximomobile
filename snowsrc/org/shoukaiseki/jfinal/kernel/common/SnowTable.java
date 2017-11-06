package org.shoukaiseki.jfinal.kernel.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface SnowTable {

	/**
	 * Model对应的 maximo 数据库配置表 MAXOBJECTCFG 中的 OBJECTNAME 名称
	 * 
	 * @return
	 */
	String maxObjecxtName();
	
	/**
	 * Model对应的 maximo 数据库配置表 MAXOBJECTCFG 中的 ENTITYNAME 名称,也就是数据库表名称
	 * @return
	 */
	 public String maxEntityName() default "";

	 
	/**
	 *  Model 主键对应的 MAXSEQUENCE 表中 SEQUENCENAME 字段
	 * @return
	 */
	public String maxSequenceName() default "";

	/**
	 * Model 对应的 maximo 数据库配置表 MAXOBJECTCFG 中的 UNIQUECOLUMNNAME虚拟字段,是该表的主键
	 * @return
	 */
	public String maxUniqueIDName() default "";

	/**
	 * 返回流程中使用的表名,如果为空,则使用 maxObjecxtName
	 * @return
	 */
	public String maxWFTableName() default  "";
}