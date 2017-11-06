package org.shoukaiseki.jfinal.kernel.utils;

import java.math.BigDecimal;

public class TypeConversionUtils {
	
	public static Double doubleByObject(Object value){
		Double d=null;
		if(value!=null){
			if(value instanceof BigDecimal){
				d=((BigDecimal)value).doubleValue();
			}else if(value instanceof Double){
				d=((Double)value).doubleValue();
			}else if(value instanceof String){
				d=Double.parseDouble(value.toString());
			} else{
				d=Double.parseDouble(value.toString());
				try {
					throw new RuntimeException("TypeConversionUtils.doubleByObject.value.class="+value.getClass().getName());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return d;
	}
	
	public static Long longByObject(Object value){
		Long d=null;
		if(value!=null){
			if(value instanceof BigDecimal){
				d=((BigDecimal)value).longValue();
			}else if(value instanceof Double){
				d=((Double)value).longValue();
			}else if(value instanceof String){
				d=Long.parseLong(value.toString());
			}else if(value instanceof Long){
				d=(Long) value;
			} else{
				d=Long.parseLong(value.toString());
				System.out.println("TypeConversionUtils.longByObject.value.class="+value.getClass().getName());
			}
		}
		return d;
	}
	
	public static Boolean booleanByObject(Object value){
		Boolean d=null;
		if(value!=null){
			if(value instanceof BigDecimal){
				d=((BigDecimal)value).intValue()>=1;
			}else if(value instanceof Double){
				d=((Double)value).intValue()>=1;
			}else if(value instanceof String){
				String vs=value.toString();
				d="yes".equalsIgnoreCase(vs)||"1".equalsIgnoreCase(vs)||"y".equalsIgnoreCase(vs);
			}else if(value instanceof Long){
				d=(Long) value>=1L;
			} else{
				d=Integer.parseInt(value.toString()) >= 1;
				System.out.println("TypeConversionUtils.booleanByObject.value.class="+value.getClass().getName());
			}
		}
		return d;
	}

}
