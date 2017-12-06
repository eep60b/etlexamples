package com.etlsolutions.examples.weather;

import org.apache.commons.daemon.support.DaemonLoader.Context;

/**
 *
 * @author zc
 */
public final class MetDaemonRunner {
    
    
    public static void main(String[] args) throws Exception {
        
        String[] args1 = {"-intervalMinutes", "1", "-configFilePath", "/home/zc/metd/props/config.properties"};
        Context daemonContext = new Context();
        daemonContext.setArguments(args1);
        MetDaemon daemon = new MetDaemon();
        daemon.init(daemonContext);
        daemon.start();
        
        Thread.sleep(300000);
        daemon.stop();
        daemon.destroy();
    }
}
