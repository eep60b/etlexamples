package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;

/**
 * The MetDaemon class is a JVSC daemon which can be run as a linux service.
 *
 * @author zc
 */
public final class MetDaemon implements Daemon {

    static {
        System.setProperty(APPLICATION_USERHOME_KEY, DEFAULT_APPLICATION_LOGHOME);
    }

    private final MetThreadService service = new MetThreadService();

    @Override
    public void init(DaemonContext daemonContext) throws Exception {

        /*
         * Construct objects and initialize variables here.
         * You can access the command line arguments that would normally be passed to your main() 
         * method as follows:
         */
        String[] args = daemonContext.getArguments();
        service.init(args);
    }

    @Override
    public void start() {

        service.start();
    }

    @Override
    public void stop() {

        service.stop();
    }

    @Override
    public void destroy() {
        service.destroy();
    }
}
