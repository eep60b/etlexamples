set SERVICE_NAME=MetWeatherService
set LIB_PATH=C:\home\zc\procrun\lib\;
set PR_INSTALL=C:\Programs\apache\commons-daemon\commons-daemon-1.1.0-bin-windows\prunsrv.exe
 
REM Service log configuration
set PR_LOGPREFIX=%SERVICE_NAME%
set PR_LOGPATH=C:\home\zc\procrun\metdata\logs
set PR_STDOUTPUT=C:\home\zc\procrun\metdata\logs\stdout.txt
set PR_STDERROR=C:\home\zc\procrun\metdata\logs\stderr.txt
set PR_LOGLEVEL=Info
 
REM Path to java installation
set PR_JVM=C:\Program Files\Java\jre1.8.0_151\bin\server\jvm.dll
set PR_CLASSPATH=%LIB_PATH%metprocrun.jar;%LIB_PATH%commons-daemon-1.0.15.jar;%LIB_PATH%commons-cli-1.2.jar;%LIB_PATH%commons-io-2.5.jar;%LIB_PATH%log4j-1.2.17.jar
 
REM Startup configuration
set PR_STARTUP=auto
set PR_STARTMODE=jvm
set PR_STARTCLASS=com.etlsolutions.examples.weather.ProcrunService
set PR_STARTMETHOD=start
 
REM Shutdown configuration
set PR_STOPMODE=jvm
set PR_STOPCLASS=com.etlsolutions.examples.weather.ProcrunService
set PR_STOPMETHOD=stop
 
REM JVM configuration
set PR_JVMMS=256
set PR_JVMMX=1024
set PR_JVMSS=4000
set PR_JVMOPTIONS=-Duser.language=EN;-Duser.region=uk

REM APPLICATION CONFIG
set PR_STARTPARAMS=-configFilePath;C:\\home\\zc\\procrun\\props\\config.properties
 
REM Install service
%PR_INSTALL% //TS//%SERVICE_NAME%