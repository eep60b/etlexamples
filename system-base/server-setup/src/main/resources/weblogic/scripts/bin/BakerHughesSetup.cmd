@ECHO OFF
SETLOCAL

SET BASE_DIR=%1
SET WL_HOME=C:\Oracle\Middleware\wlserver_10.3
SET WLS_NOT_BRIEF_ENV=true
CALL "%WL_HOME%\server\bin\setWLSEnv.cmd"

if NOT "%WLST_HOME%"=="" (
	set WLST_PROPERTIES=-Dweblogic.wlstHome=%WLST_HOME% %WLST_PROPERTIES%
)

SET CLASSPATH=%CLASSPATH%;%FMWLAUNCH_CLASSPATH%;%DERBY_CLASSPATH%;%DERBY_TOOLS%;%POINTBASE_CLASSPATH%;%POINTBASE_TOOLS%

@echo.
@echo CLASSPATH=%CLASSPATH%

SET JVM_ARGS=-Dprod.props.file="%WL_HOME%\.product.properties" %WLST_PROPERTIES% %MEM_ARGS% %CONFIG_JVM_ARGS%

"%JAVA_HOME%\bin\java" %JVM_ARGS% weblogic.WLST src/main/resources/scripts/wlst/DeployBakerHughesMigrator.py