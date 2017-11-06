package org.shoukaiseki.jfinal.kernel.exception;


import java.util.LinkedHashMap;
import java.util.Map;



























public class MXExceptionMediator
{
  private static final Map<Class<? extends Exception>, MXExceptionAdapter> exceptionAdapters = new LinkedHashMap();
  













  public static synchronized void registerExceptionAdapter(Class<? extends Exception> exceptionClass, MXExceptionAdapter exceptionAdapter)
    throws SnowException
  {
    exceptionAdapters.put(exceptionClass, exceptionAdapter);
  }
  



  public static synchronized void unregisterExceptionAdapter(Class<? extends Exception> exceptionClass)
    throws SnowException
  {
    exceptionAdapters.remove(exceptionClass);
  }
  




  









  public static synchronized String getMessage(Throwable throwable, String langCode)
  {
    if (!(throwable instanceof Exception))
    {

      return throwable.getLocalizedMessage();
    }
    
    Exception exception = (Exception)throwable;
    MXExceptionAdapter exceptionAdapter = getExceptionAdapter(exception);
    if (exceptionAdapter != null)
    {
      String message = exceptionAdapter.getMessage(exception, langCode);
      if (message != null) {
        return message;
      }
    }
    
    return exception.getLocalizedMessage();
  }
  








  public static synchronized SnowException toMXException(Throwable throwable)
  {
    if (!(throwable instanceof Exception))
    {

      return null;
    }
    
    Exception exception = (Exception)throwable;
    MXExceptionAdapter exceptionAdapter = getExceptionAdapter(exception);
    if (exceptionAdapter == null)
    {
      return null;
    }
    
    return exceptionAdapter.toMXException(exception);
  }
  




  private static MXExceptionAdapter getExceptionAdapter(Exception exception)
  {
    for (Class exceptionClass : exceptionAdapters.keySet())
    {
      if (exceptionClass == exception.getClass())
      {
        return (MXExceptionAdapter)exceptionAdapters.get(exceptionClass);
      }
    }
    


    for (Class exceptionClass : exceptionAdapters.keySet())
    {
      if (exceptionClass.isAssignableFrom(exception.getClass()))
      {
        return (MXExceptionAdapter)exceptionAdapters.get(exceptionClass);
      }
    }
    
    return null;
  }
  



  static synchronized void unregisterAllForUnitTests()
  {
    exceptionAdapters.clear();
  }
}

