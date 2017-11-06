package org.shoukaiseki.jfinal.kernel.exception;

public abstract interface MXExceptionAdapter<T extends Exception>
{

  public abstract String getMessage(T paramT, String paramString);
  
  public abstract SnowException toMXException(T paramT);
}
