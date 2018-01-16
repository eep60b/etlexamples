package com.etlsolutions.examples.weather;

import org.apache.log4j.Logger;

/**
 * The ProcrunService class provides methods which can be run by Windows
 * service.
 *
 * @author zc
 */
public final class ProcrunService {

    private static final MetThreadService MET_DAEMON = new MetThreadService();

    public static void start(String[] args) {
        try {

            MET_DAEMON.init(args);
            MET_DAEMON.start();
        } catch (Throwable th) {
            Logger.getLogger(ProcrunService.class).error("Failed to start ProcrunService", th);
            System.exit(-1);
        }
    }

    public static void stop(String[] args) {
        try {
            MET_DAEMON.stop();
        } catch (Throwable th) {
            Logger.getLogger(MetThreadService.class).error("Failed to stop ProcrunService", th);
            System.exit(-1);
        }
    }
}
