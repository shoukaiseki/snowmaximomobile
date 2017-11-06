package org.shoukaiseki.jfinal.kernel.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.jfinal.plugin.activerecord.Record;

/** com.shuto.iservice.utils.StringUtils
 * @author 蒋カイセキ    Japan-Tokyo  2016-4-25
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class StringUtils {
	public static final Logger log = Logger.getLogger(StringUtils.class);

	private StringUtils() {
		throw new AssertionError();
	}

	/**
	 * is null or its length is 0 or it is made by space
	 * 
	 * <pre>
	 * isBlank(null) = true;
	 * isBlank(&quot;&quot;) = true;
	 * isBlank(&quot;  &quot;) = true;
	 * isBlank(&quot;a&quot;) = false;
	 * isBlank(&quot;a &quot;) = false;
	 * isBlank(&quot; a&quot;) = false;
	 * isBlank(&quot;a b&quot;) = false;
	 * </pre>
	 * 
	 * @param str
	 * @return if string is null or its size is 0 or it is made by space, return
	 *         true, else return false.
	 */
	public static boolean isBlank(String str) {
		return (str == null || str.trim().length() == 0);
	}

	/**
	 * is null or its length is 0
	 * 
	 * <pre>
	 * isEmpty(null) = true;
	 * isEmpty(&quot;&quot;) = true;
	 * isEmpty(&quot;  &quot;) = false;
	 * </pre>
	 * 
	 * @param str
	 * @return if string is null or its size is 0, return true, else return
	 *         false.
	 */
	public static boolean isEmpty(CharSequence str) {
		return (str == null || str.length() == 0);
	}

	/**
	 * compare two string
	 * 
	 * @param actual
	 * @param expected
	 * @return
	 * @see ObjectUtils#isEquals(Object, Object)
	 */
	public static boolean isEquals(String actual, String expected) {
		return ObjectUtils.isEquals(actual, expected);
	}

	/**
	 * null Object to empty string
	 * 
	 * <pre>
	 * nullStrToEmpty(null) = &quot;&quot;;
	 * nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
	 * nullStrToEmpty(&quot;aa&quot;) = &quot;aa&quot;;
	 * </pre>
	 * 
	 * @param str
	 * @return
	 */
	public static String nullStrToEmpty(Object str) {
		return (str == null ? "" : (str instanceof String ? (String) str : str
				.toString()));
	}

	/**
	 * capitalize first letter
	 * 
	 * <pre>
	 * capitalizeFirstLetter(null)     =   null;
	 * capitalizeFirstLetter("")       =   "";
	 * capitalizeFirstLetter("2ab")    =   "2ab"
	 * capitalizeFirstLetter("a")      =   "A"
	 * capitalizeFirstLetter("ab")     =   "Ab"
	 * capitalizeFirstLetter("Abc")    =   "Abc"
	 * </pre>
	 * 
	 * @param str
	 * @return
	 */
	public static String capitalizeFirstLetter(String str) {
		if (isEmpty(str)) {
			return str;
		}

		char c = str.charAt(0);
		return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str
				: new StringBuilder(str.length())
						.append(Character.toUpperCase(c))
						.append(str.substring(1)).toString();
	}

	/**
	 * encoded in utf-8
	 * 
	 * <pre>
	 * utf8Encode(null)        =   null
	 * utf8Encode("")          =   "";
	 * utf8Encode("aa")        =   "aa";
	 * utf8Encode("啊啊啊啊")   = "%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A";
	 * </pre>
	 * 
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 *             if an error occurs
	 */
	public static String utf8Encode(String str) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(
						"UnsupportedEncodingException occurred. ", e);
			}
		}
		return str;
	}

	/**
	 * encoded in utf-8, if exception, return defultReturn
	 * 
	 * @param str
	 * @param defultReturn
	 * @return
	 */
	public static String utf8Encode(String str, String defultReturn) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return defultReturn;
			}
		}
		return str;
	}

	/**
	 * get innerHtml from href
	 * 
	 * <pre>
	 * getHrefInnerHtml(null)                                  = ""
	 * getHrefInnerHtml("")                                    = ""
	 * getHrefInnerHtml("mp3")                                 = "mp3";
	 * getHrefInnerHtml("&lt;a innerHtml&lt;/a&gt;")                    = "&lt;a innerHtml&lt;/a&gt;";
	 * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
	 * getHrefInnerHtml("&lt;a&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
	 * getHrefInnerHtml("&lt;a href="baidu.com"&gt;innerHtml&lt;/a&gt;")               = "innerHtml";
	 * getHrefInnerHtml("&lt;a href="baidu.com" title="baidu"&gt;innerHtml&lt;/a&gt;") = "innerHtml";
	 * getHrefInnerHtml("   &lt;a&gt;innerHtml&lt;/a&gt;  ")                           = "innerHtml";
	 * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                      = "innerHtml";
	 * getHrefInnerHtml("jack&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                  = "innerHtml";
	 * getHrefInnerHtml("&lt;a&gt;innerHtml1&lt;/a&gt;&lt;a&gt;innerHtml2&lt;/a&gt;")        = "innerHtml2";
	 * </pre>
	 * 
	 * @param href
	 * @return <ul>
	 *         <li>if href is null, return ""</li>
	 *         <li>if not match regx, return source</li>
	 *         <li>return the last string that match regx</li>
	 *         </ul>
	 */
	public static String getHrefInnerHtml(String href) {
		if (isEmpty(href)) {
			return "";
		}

		String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
		Pattern hrefPattern = Pattern
				.compile(hrefReg, Pattern.CASE_INSENSITIVE);
		Matcher hrefMatcher = hrefPattern.matcher(href);
		if (hrefMatcher.matches()) {
			return hrefMatcher.group(1);
		}
		return href;
	}

/**
     * process special char in html
     * 
     * <pre>
     * htmlEscapeCharsToString(null) = null;
     * htmlEscapeCharsToString("") = "";
     * htmlEscapeCharsToString("mp3") = "mp3";
     * htmlEscapeCharsToString("mp3&lt;") = "mp3<";
     * htmlEscapeCharsToString("mp3&gt;") = "mp3\>";
     * htmlEscapeCharsToString("mp3&amp;mp4") = "mp3&mp4";
     * htmlEscapeCharsToString("mp3&quot;mp4") = "mp3\"mp4";
     * htmlEscapeCharsToString("mp3&lt;&gt;&amp;&quot;mp4") = "mp3\<\>&\"mp4";
     * </pre>
     * 
     * @param source
     * @return
     */
	public static String htmlEscapeCharsToString(String source) {
		return StringUtils.isEmpty(source) ? source : source
				.replaceAll("&lt;", "<").replaceAll("&gt;", ">")
				.replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
	}

	/**
	 * transform half width char to full width char
	 * 
	 * <pre>
	 * fullWidthToHalfWidth(null) = null;
	 * fullWidthToHalfWidth("") = "";
	 * fullWidthToHalfWidth(new String(new char[] {12288})) = " ";
	 * fullWidthToHalfWidth("！＂＃＄％＆) = "!\"#$%&";
	 * </pre>
	 * 
	 * @param s
	 * @return
	 */
	public static String fullWidthToHalfWidth(String s) {
		if (isEmpty(s)) {
			return s;
		}

		char[] source = s.toCharArray();
		for (int i = 0; i < source.length; i++) {
			if (source[i] == 12288) {
				source[i] = ' ';
				// } else if (source[i] == 12290) {
				// source[i] = '.';
			} else if (source[i] >= 65281 && source[i] <= 65374) {
				source[i] = (char) (source[i] - 65248);
			} else {
				source[i] = source[i];
			}
		}
		return new String(source);
	}

	/**
	 * transform full width char to half width char
	 * 
	 * <pre>
	 * halfWidthToFullWidth(null) = null;
	 * halfWidthToFullWidth("") = "";
	 * halfWidthToFullWidth(" ") = new String(new char[] {12288});
	 * halfWidthToFullWidth("!\"#$%&) = "！＂＃＄％＆";
	 * </pre>
	 * 
	 * @param s
	 * @return
	 */
	public static String halfWidthToFullWidth(String s) {
		if (isEmpty(s)) {
			return s;
		}

		char[] source = s.toCharArray();
		for (int i = 0; i < source.length; i++) {
			if (source[i] == ' ') {
				source[i] = (char) 12288;
				// } else if (source[i] == '.') {
				// source[i] = (char)12290;
			} else if (source[i] >= 33 && source[i] <= 126) {
				source[i] = (char) (source[i] + 65248);
			} else {
				source[i] = source[i];
			}
		}
		return new String(source);
	}

	public static java.sql.Date toDate(String source, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new java.sql.Date(date.getTime());
	}

	public static java.sql.Date toDate(String source) {
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 获取UUID by jdk
	 * 
	 * @return
	 */
	public static String getUuidByJdk(boolean is32bit) {
		String uuid = UUID.randomUUID().toString();
		if (is32bit) {
			return uuid.toString().replace("-", "");
		}
		return uuid;
	}

	/**
	 * 一个通用的数据对象与Model对象转换类
	 * 
	 * @param rec
	 * @param model
	 * @return 
	 * @Description: 有异常不再抛出
	 */
	public static Object recordToObject(Record rec, Object model) {
		Field[] field = model.getClass().getFields();
		Field[] field2 = model.getClass().getDeclaredFields();
		List<Field> fields = new ArrayList<Field>();
		fields.addAll(Arrays.asList(field));
		fields.addAll(Arrays.asList(field2));
		// //获取该类中可以调用的方法
		// ArrayList<String> al=new ArrayList<String>();
		// Method[] methods = model.getClass().getMethods();
		// for (Method method2 : methods) {
		// al.add(method2.getName());
		// }
		String name;
		String attr;
		Method method = null;
		String type;
		// 遍历所有属性
		StringBuffer sb = new StringBuffer();
		Map<String,String> map2 = new HashMap<String,String>();
		for (Field fi : fields) {
			// 获取属性的名字
			name = fi.getName();
			if(map2.get(name) != null){
				continue;
			}
			map2.put(name, name);
			// 将属性的首字符大写，方便构造get，set方法
			attr = name.substring(0, 1).toUpperCase() + name.substring(1);
			// 获取属性的类型
			type = fi.getGenericType().toString();

			// //如果不存在该方法,则进行下次循环
			// //当然也可以通过 fi.getModifiers() 获取修饰符来判断是否为 FINAL 类型的进行过滤循环
			// if(al.indexOf("set"+attr)==-1){
			// continue;
			// }
			sb.append(name).append(":").append(type).append(" | ");
			// 判断修饰符,如果存在 final类型的则表示无对应的set方法,跳过此次循环
			if (Modifier.isFinal(fi.getModifiers())) {
				continue;
			}

			// 按照变量类型获取相应set方法,为空时如果变量为boolean类型,会报错
			try {
				method = model.getClass().getMethod("set" + attr,
						fi.getType());
			} catch (SecurityException e) {
				log.error(" SecurityException : " + e.toString());
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				log.error(" NoSuchMethodException : " + e.toString());
				e.printStackTrace();
			}
			Object object = null;
			try{
				object = rec.get(name);
			}catch(Exception e){
				log.error(" ERROR : " + name+"|" + e.getMessage());
				e.printStackTrace();
			}
			if (object == null) {
				//log.warn("属性值为NULL？" + name);
				continue;
			}

			log.info("type=" + type + ";name=" + name +";value="+rec.get(name));
			Object value=rec.get(name);
			log.info("valObj.class="+value.getClass().getName());

			// 如果type是类类型，则前面包含"class "，后面跟类名
			try {
				if (type.equals("class java.lang.String")) {
					method.invoke(model, rec.get(name).toString());
				} else if (type.equals("class java.lang.Integer")) {
					method.invoke(model, Integer.parseInt(value.toString()));
				} else if (type.equals("class java.lang.Short")) {
					method.invoke(model, rec.getInt(name));
				} else if (type.equals("class java.lang.Double")) {
					if (rec.getDouble(name) != null) {
						method.invoke(model, rec.getDouble(name));
					}
				}else if (type.equals("class java.math.BigDecimal")) {
					if (rec.getBigDecimal(name) != null) {
						method.invoke(model, rec.getBigDecimal(name));
					}
				}else if (type.equals("class java.lang.Long")) {
					//log.error(rec.get(name).getClass().getName());
					if(value instanceof BigDecimal){
						method.invoke(model, rec.getBigDecimal(name).longValue());
					}else if(value instanceof Long){
						method.invoke(model, rec.getLong(name));
					}else{
						method.invoke(model, Long.parseLong(value.toString()));
					}
				} else if (type.equals("class java.lang.Boolean")) {
					if(value instanceof BigDecimal){
						method.invoke(model, rec.getBigDecimal(name).intValue() == 1);
					}else if(value instanceof Long){
						method.invoke(model, rec.getLong(name) == 1);
					}else{
						method.invoke(model, Integer.parseInt(value.toString()) == 1);
					}
				} else if (type.equals("class java.util.Date")) {
					method.invoke(model, rec.getDate(name));
				} else if (type.equals("boolean")) {
					if (rec.getInt(name) != null) {
						method.invoke(model, rec.getInt(name) == 1);
					}
				} else {
					log.error("StringUtils.recordToObject 暂不支持转换的类型 : " + model.getClass().getName() + "|"
							+ name + "=" + rec.get(name).getClass().getName() +"| type=" + type);
				}
			} catch (Exception e) {
				log.error(" 错误转换 : type=" + type + ";name=" + name +";value="+rec.get(name) +"|"+  e.toString() );
				e.printStackTrace();
			} 
			//log.debug("recordToObject 设置值结束");
		}
		//log.info("所有属性：" + sb.toString());
		return model;
	}
	
	/**
	 * 对指定格式数据进行转换为MAP： key1,value1;key2,value2
	 * @param str
	 * @return
	 * @Description:
	 */
	public static Map<String,String> getMap(String str){
		Map<String,String> map = new HashMap<String,String>();
		String[] arr = str.split(";");
		String[] val = new String[]{};
		for(int i=0;i<arr.length;i++){
			val = arr[i].split(",");
			map.put(val[0], val[1]);
		}
		return map;
	}
	
    
    
    //定义统一的日期格式
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 数字格式化,不含逗号,用于数据库查询等操作 
	 */
	public static DecimalFormat numberFormat=new DecimalFormat("####");
	
	/**
	 * 数字格式化,不含逗号,用于数据库查询等操作 
	 */
	public static DecimalFormat doubleFormat=new DecimalFormat("####.######");
	
	public static String numberFormat(Object o) {
		// TODO Auto-generated method stub
			if(o instanceof Long||o instanceof Integer){
				return numberFormat.format(o);
			}else{
				return doubleFormat.format(o);

			}
	}
	
	public static String getErrorInfoFromException(Exception e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return "\r\n" + sw.toString() + "\r\n";
        } catch (Exception e2) {
            return "bad getErrorInfoFromException";
        }
    }
	

}
