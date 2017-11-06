@REM taskkill /F /IM java.exe
@ECHO OFF
setlocal enabledelayedexpansion
for /f "eol=* tokens=*" %%i in ('netstat -an -o ^| findstr "8080"') do (
set a=%%i
set a=!a:~69,10!
taskkill /pid !a!
)
@REM taskkill /F /IM cmd.exe
pause