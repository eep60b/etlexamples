set PR_INSTALL=C:\Programs\metd\${service.name}

%PR_INSTALL% //IS//${windows.application.name} --DisplayName="${windows.application.name}" --Description="Met office weather service in normal mode" ^
    --Install=%PR_INSTALL% ^
    --Startup=auto ^
    --Jvm="C:\Program Files\Java\jre1.8.0_151\bin\server\jvm.dll" ^
    --Classpath="C:\Programs\metd\lib\${jar.name}.jar" ^
    --StartMode=jvm ^
    --StartClass=com.etlsolutions.examples.weather.ProcrunService ^
    --StartParams="-configFilePath;${config.properties.path}" ^
    --StartMethod=start ^
    --StopMode=jvm ^
    --StopClass=com.etlsolutions.examples.weather.ProcrunService ^
    --StopMethod=stop