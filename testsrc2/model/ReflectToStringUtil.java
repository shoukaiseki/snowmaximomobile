package model;

import com.jfinal.template.ext.directive.Str;

import java.lang.reflect.Field;

public class ReflectToStringUtil {


    public static String toStringUtil(Object clazs,boolean isOutputNull) {
        StringBuffer sb=getParamAndValue(clazs, clazs.getClass(), isOutputNull);

        return sb.toString();
    }

    private static StringBuffer getParamAndValue(Object clazs, Class<?> clazz, boolean isOutputNull) {
        StringBuffer sb=null;

        Class<?> sc = clazz.getSuperclass();
        Field[] sfields = sc.getDeclaredFields();
        if (sfields.length > 0) {
            getParamAndValue(clazs, sc, isOutputNull);
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                if (null !=f.get(clazs) ||isOutputNull){
                    if(sb==null){
                        sb=new StringBuffer("{");
                    }else{
                        sb.append(",");
                    }
                    sb.append(f.getName() + ":" + f.get(clazs) );
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(sb==null){
            sb=new StringBuffer("{");
        }
        sb.append("}");
        return sb;
    }

}
