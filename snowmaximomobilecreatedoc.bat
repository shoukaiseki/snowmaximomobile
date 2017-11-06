@REM set JAVA_HOME=D:/usr/java/jdk1.8.0_131
@REM 去除系统环境变量中的classpath,不然会引发 java.lang.IllegalArgumentException 异常
set CLASSPATH=
set JAVA_HOME=D:/usr/java/jdk1.7.0_51
call ant -f buildWin.xml createdoc
pause