package org.shoukaiseki.jfinal.kernel.exception;

import java.text.MessageFormat;
import java.util.Locale;

import org.shoukaiseki.jfinal.kernel.http.ErrorCode;

/** org.shoukaiseki.jfinal.kernel.exception.SnowException
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月21日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
public class SnowException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer errorcode=ErrorCode.DEFAERROR;
	public Throwable detail = null;

	private String message=null;
	private Object[] params=null;

	public SnowException(Integer errorcode) {
		// TODO Auto-generated constructor stub
		super();
		this.errorcode=errorcode;
		if(errorcode==null)
			this.errorcode=ErrorCode.DEFAERROR;
	}
	
	public SnowException(Integer errorcode,Throwable cause){
		super(cause);
		this.errorcode=errorcode;
		this.detail=cause;
		if(errorcode==null)
			this.errorcode=ErrorCode.DEFAERROR;
	}
	
	public SnowException(Integer errorcode,String message){
		super(message);
		this.message=message;
		this.errorcode=errorcode;
		if(errorcode==null)
			this.errorcode=ErrorCode.DEFAERROR;
	}

	public Integer getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}
	
	
	public Object[] getParams() {
		return params;
	}

	public SnowException setParams(Object... params) {
		this.params = params;
		return this;
	}
	
	public String formatMessage(){
		StringBuffer sb=new StringBuffer();
		String errorinfo = ErrorCode.codemap.get(errorcode);
		if(params!=null){
			MessageFormat fmt = new MessageFormat(errorinfo, getLocale());
			errorinfo=fmt.format(params);
		}
		sb.append("错误编码:["+errorcode+"],错误描述:["+errorinfo+"]");
		if(message!=null){
			sb.append(","+message);
		}
		sb.append(";");
       if (detail != null) {
    	   String detailMsg="";
         if(detail instanceof SnowException){
        	 detailMsg=detail.getMessage();
         }else{
        	 detailMsg=detail.getLocalizedMessage();
         }
         sb.append(  "\n\t").append(detailMsg);
       }
		
		return sb.toString();
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return formatMessage();
	}
	
	
	Locale locale=null;
	public Locale getLocale()
	{
		if (locale == null) {
			return Locale.getDefault();
		}
		return locale;
	}
	


}
