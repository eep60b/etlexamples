package com.etlsolutions.examples.weather;

import org.apache.commons.daemon.support.DaemonLoader.Context;

/**
 *
 * @author zc
 */
public final class MetDaemonRunner {
    
    
    public static void main(String[] args) throws Exception {
        
        Context daemonContext = new Context();
        daemonContext.setArguments((args == null || args.length == 0)? new String[]{"-intervalMinutes", "4", "-configFilePath", "/home/zc/metd/props/config.properties"} : args);
        MetDaemon daemon = new MetDaemon();
        daemon.init(daemonContext);
        daemon.start();
        
        Thread.sleep(600000);
        daemon.stop();
        daemon.destroy();
    }
}
