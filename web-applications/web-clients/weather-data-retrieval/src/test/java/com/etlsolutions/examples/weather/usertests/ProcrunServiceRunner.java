package com.etlsolutions.examples.weather.usertests;

import com.etlsolutions.examples.weather.ProcrunService;

/**
 *
 * @author zc
 */
public final class ProcrunServiceRunner {
    
    public static void main(String[] args) throws Exception {
        
 //       String[] args1 = {"-intervalMinutes", "1", "-configFilePath", "/home/zc/metd/props/config.properties"};
        String[] args1 = {"-intervalMinutes", "1", "-configFilePath", "/home/zc/metd/props/config.properties", "-baseDataPath", "C:\\Users\\zc\\.m2\\repository/../../OneDrive/metdata"};
        ProcrunService.start(args1);
        Thread.sleep(300000);
        ProcrunService.stop(args1);
    }    
}
