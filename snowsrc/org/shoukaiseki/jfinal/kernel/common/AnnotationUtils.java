package org.shoukaiseki.jfinal.kernel.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.google.common.base.Preconditions;
import com.jfinal.kit.StrKit;

public class AnnotationUtils {
	
    /**
	 * 是否持久化字段/虚拟字段: false 虚拟字段
	 * <br>
	 * 					 true 持久化字段
	 * <br>
	 * 默认为 true持久化字段
     * @param fi
     * @return
     * @Description:
     */
    public static boolean isPersistent(Field fi){
    	Annotation[] as = fi.getAnnotations();
		SnowField ff;
		boolean form=true ;
		try{
			for(int i=0;i<as.length;i++){
				if(as[i].annotationType().equals((SnowField.class))){
					ff = (SnowField) as[i];
					form = ff.isPersistent();
					break;
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		return form;
    }


    
    /**
	 * 是否主键，true=主键，默认都是false
     * @param fi
     * @return
     */
    public static boolean isPrimary(Field fi){
    	Annotation[] as = fi.getAnnotations();
		SnowField ff;
		boolean form=false ;
		try{
			for(int i=0;i<as.length;i++){
				if(as[i].annotationType().equals((SnowField.class))){
					ff = (SnowField) as[i];
					form = ff.isPrimary();
					break;
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		return form;
    }
    
    
    /**
	 * 格式化 如果为 Date 格式字段,则采用 SimpleDateFormat 进行格式化,格式化方式设定String值
     * @param fi
     * @return
     */
    public static String format(Field fi){
    	Annotation[] as = fi.getAnnotations();
		SnowField ff;
		String form="";
		try{
			for(int i=0;i<as.length;i++){
				if(as[i].annotationType().equals((SnowField.class))){
					ff = (SnowField) as[i];
					form = ff.format();
					break;
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		return form;
    }
    
    /**
	 * 是否必填,如果为 true 则必填,默认为false
     * @param fi
     * @return
     */
    public static boolean isRequired(Field fi){
    	Annotation[] as = fi.getAnnotations();
		SnowField ff;
		boolean form=false ;
		try{
			for(int i=0;i<as.length;i++){
				if(as[i].annotationType().equals((SnowField.class))){
					ff = (SnowField) as[i];
					form = ff.isRequired();
					break;
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		return form;
    }
	
    /**
	 * insert插入时是否忽略该字段,比如 maximo中有 AUTOKEY 字段,不需要生成插入语句时设置
	 * <br>
	 * true  忽略
	 * <br>
	 * false 不忽略,默认该值
     * @param fi
     * @return
     * @Description:
     */
    public static boolean isInsertIgnore(Field fi){
    	Annotation[] as = fi.getAnnotations();
		SnowField ff;
		boolean form=false ;
		try{
			for(int i=0;i<as.length;i++){
				if(as[i].annotationType().equals((SnowField.class))){
					ff = (SnowField) as[i];
					form = ff.isInsertIgnore();
					break;
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		return form;
    }
    
    /**
	 * update插入时是否忽略该字段,比如 主键,不需要生成 update 语句时更新该字段
	 * <br>
	 * true  忽略
	 * <br>
	 * false 不忽略,默认该值
     * @param fi
     * @return
     * @Description:
     */
    public static boolean isUpdateIgnore(Field fi){
    	Annotation[] as = fi.getAnnotations();
		SnowField ff;
		boolean form=false ;
		try{
			for(int i=0;i<as.length;i++){
				if(as[i].annotationType().equals((SnowField.class))){
					ff = (SnowField) as[i];
					form = ff.isUpdateIgnore();
					break;
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		return form;
    }

	public static String getMaxUniqueIDName(Class<?> clazz){
		SnowTable st=getSnowTable(clazz);
		String name = st.maxUniqueIDName();
		if(StrKit.isBlank(name)){
			Preconditions.checkNotNull(null,clazz.getName()+" 类的 SnowTable 注释信息 未设置 maxUniqueIDName 信息");
		}

		return name;
	}

    public static String getMaxObjectName(Class<?> clazz){
    	SnowTable st=getSnowTable(clazz);
    	String maxObjecxtName = st.maxObjecxtName();
    	if(StrKit.isBlank(maxObjecxtName)){
    		Preconditions.checkNotNull(null,clazz.getName()+" 类的 SnowTable 注释信息 未设置 maxObjecxtName 信息");
    	}
    	
    	return maxObjecxtName;
    }
    
    public static String getMaxEntityName(Class<?> clazz){
    	SnowTable st=getSnowTable(clazz);
    	String maxObjecxtName = st.maxObjecxtName();
    	if(StrKit.isBlank(maxObjecxtName)){
    		Preconditions.checkNotNull(null,clazz.getName()+" 类的 SnowTable 注释信息,未设置 maxObjecxtName 信息");
    	}
    	
    	String name = st.maxEntityName();
    	if(StrKit.isBlank(name)){
    		name=maxObjecxtName;
    	}
    	
    	return name;
    }
    
    
    public static String getMaxSequenceName(Class<?> clazz){
    	SnowTable st=getSnowTable(clazz);
    	String name = st.maxSequenceName();
    	if(StrKit.isBlank(name)){
    		Preconditions.checkNotNull(null,clazz.getName()+" 类的 SnowTable 注释信息,未设置 maxSequenceName 信息");
    	}
		return name;
    	
    }
    
    public static SnowTable getSnowTable(Class<?> clazz){
    	//这样就会报错
//    	SnowTable st = clazz.getClass().getAnnotation(SnowTable.class);
    	SnowTable st = clazz.getAnnotation(SnowTable.class);
    	Preconditions.checkNotNull(st,clazz.getName()+" 类没有声明 SnowTable 注释信息,请在注释中声明 maximo 对应的表名才能使用一些功能");
    	return st;
    }

}
