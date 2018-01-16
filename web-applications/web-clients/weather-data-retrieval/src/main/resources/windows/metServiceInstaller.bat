set SERVICE_NAME=MyWeatherService
set PR_INSTALL=C:\Programs\metd\service.exe
 
set PR_JVM="C:\Program Files\Java\jre1.8.0_151\bin\server\jvm.dll"

%PR_INSTALL% //IS//%SERVICE_NAME%  --DisplayName="%SERVICE_NAME%" --Description="Met office weather service" ^
    --Install=%PR_INSTALL% ^
    --Startup=auto ^
    --Jvm="C:\Program Files\Java\jre1.8.0_151\bin\server\jvm.dll" ^
    --Classpath="C:\Programs\metd\lib\metd.jar" ^
    --StartMode=jvm ^
    --StartClass=com.etlsolutions.examples.weather.ProcrunService ^
    --StartParams="-intervalMinutes;10;-configFilePath;/Programs/metd/props/config.properties" ^
    --StartMethod=start ^
    --StopMode=jvm ^
    --StopClass=com.etlsolutions.examples.weather.ProcrunService ^
    --StopMethod=stop