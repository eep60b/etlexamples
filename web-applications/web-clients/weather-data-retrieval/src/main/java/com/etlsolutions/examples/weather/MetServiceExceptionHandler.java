package com.etlsolutions.examples.weather;

import java.io.PrintStream;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * The MetServiceExceptionHandler class handle the exception generated in the
 * MetService class.
 *
 * @author zc
 */
public final class MetServiceExceptionHandler {

    private final Logger logger;
    private final PrintStream printStream = System.err;

    public MetServiceExceptionHandler(Logger logger) {

        this.logger = logger;
    }

    /**
     * Log or display the exception which is regarded as a warning.
     *
     * @param ex - The exception to be handled.
     */
    public void handleWarning(Exception ex) {

        String message = "Process error occured at " + new Date().toString() + ".\nThis error is treated as recoverable error.\nThe application is not shutdown.";
        logger.warn(message);
        logger.warn(ex);
        printStream.println(message);
        printStream.println(ex.getMessage());
    }

    /**
     * Log or display the exception which is regarded as an error.
     *
     * @param ex - The exception to be handled.
     * @param message - The extra message to be logged or displayed.
     */
    public void handleError(Throwable ex, String message) {

        String timedMessage = message + " at " + new Date().toString() + ".";
        logger.error(timedMessage, ex);
        printStream.println(timedMessage);
        printStream.println(ex.getMessage());
        printStream.println("Force to terminate the metd service.");
        System.exit(-1);
    }
}
