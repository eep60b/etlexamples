package com.etlsolutions.examples.weather;

/**
 *
 * @author zc
 */
public final class ProcrunServiceRunner {
    
    public static void main(String[] args) throws Exception {
        
        String[] args1 = {"-intervalMinutes", "1", "-configFilePath", "/home/zc/metd/props/config.properties"};
        ProcrunService.start(args1);
        Thread.sleep(300000);
        ProcrunService.stop(args1);
    }    
}
