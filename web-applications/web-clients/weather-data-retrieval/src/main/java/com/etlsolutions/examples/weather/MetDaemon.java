package com.etlsolutions.examples.weather;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

/**
 *
 * @author zc
 */
public class MetDaemon implements Daemon {

    private Thread myThread;
    private boolean stopped = false;

    @Override
    public void init(DaemonContext daemonContext) throws DaemonInitException, Exception {
        /*
         * Construct objects and initialize variables here.
         * You can access the command line arguments that would normally be passed to your main() 
         * method as follows:
         */
        String[] args = daemonContext.getArguments();

        myThread = new Thread() {
            
            @Override
            public synchronized void start() {
                MetDaemon.this.stopped = false;
                super.start();
            }

            @Override
            public void run() {
                while (!stopped) {
                    MetWeatherCommandLineRunner.main(args);
                }
            }
        };
    }

    @Override
    public void start() throws Exception {
        myThread.start();
    }

    @Override
    public void stop() throws Exception {
        stopped = true;
        try {
            myThread.join(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public void destroy() {
        myThread = null;
    }
}
