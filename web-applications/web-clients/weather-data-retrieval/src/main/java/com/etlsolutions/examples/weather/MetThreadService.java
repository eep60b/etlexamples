package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.util.Date;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

/**
 * The MetThreadService class is a JVSC daemon which can be run as a linux
 * service.
 *
 * @author zc
 */
public final class MetThreadService {

    private final Logger logger = Logger.getLogger(MetThreadService.class);
    private final MetServiceExceptionHandler exceptionHandler = new MetServiceExceptionHandler(logger);
    private final PrintStream printStream = System.out;
    private Thread myThread;
    private boolean stopped;
    private final SingleProcessor singleProcessor = new SingleProcessor();
    private int count = 1;

    /**
     * Initialise this service so it can be used.
     *
     * @param args - The command line arguments passed in from the main class.
     * @return a newly created ApplicationParameters object which contains all
     * the parameters.
     * @throws org.apache.commons.cli.ParseException if the command line
     * arguments cannot be parsed.
     * @throws java.io.IOException if an IO error occur.
     * @throws javax.xml.parsers.ParserConfigurationException if the property
     * XML file cannot be parsed.
     * @throws org.xml.sax.SAXException if the property XML file is not well
     * formatted.
     */
    public ApplicationParameters init(String[] args) throws ParseException, IOException, ParserConfigurationException, SAXException  {

        logger.info("\n\nStart to load the configurations...");
        logger.info(new Date().toString());
        ApplicationParametersFactory factory = ApplicationParametersFactory.getInstance();
        final ApplicationParameters parameters = factory.loadApplicationParameters(args);
        logger.info("\nConfigurations:");
        logger.info(parameters.toString() + "\n");

        myThread = new Thread() {

            @Override
            public synchronized void start() {
                MetThreadService.this.stopped = false;
                super.start();
            }

            @Override
            @SuppressWarnings({"SleepWhileInLoop"})
            public void run() {

                logger.info("\nStart to retrieve data...");
                int minutes = parameters.getIntervalInMinutes();
                while (!stopped) {

                    String currentTime = new Date().toString();

                    try {

                        if (minutes >= parameters.getIntervalInMinutes()) {

                            logger.info("\nNo." + count);
                            boolean success = singleProcessor.process(parameters);

                            if (success) {
                                logger.info("Data successfully recorded at " + currentTime);
                                logger.info("Data location:            " + parameters.getDataDirectoryPath());
                                logger.info("Data additional location: " + parameters.getAdditionalDataDirectoryPaths());
                            } else {
                                logger.warn("Failed to record data at " + currentTime);
                            }

                            count++;
                            minutes = 0;

                        } else {
                            minutes++;
                            Thread.sleep(THREAD_SLEEP_TIME);
                        }

                    } catch (ConnectException ex) {

                        exceptionHandler.handleWarning(ex);

                    } catch (ParserConfigurationException | java.text.ParseException | IOException | InterruptedException | RuntimeException | Error ex) {
                        exceptionHandler.handleError(ex, "Process error occured");
                        return;
                    }
                }
            }
        };

        return parameters;
    }

    /**
     * Start this service.
     */
    public void start() {

        stopped = false;
        String startMessage = new Date().toString() + ":  Start the metd service.";
        logger.info(startMessage);
        printStream.println(startMessage);
        myThread.start();
        String startSuccessMessage = new Date().toString() + ":  The metd service has been successfully started.";
        logger.info(startSuccessMessage);
        printStream.println(startSuccessMessage);
    }

    /**
     * Stop this service.
     */
    public void stop() {

        stopped = true;
        try {
            String stopServiceMessage = "\n\n" + new Date().toString() + ":  Stop the metd service.";
            logger.info(stopServiceMessage);
            printStream.println(stopServiceMessage);
            myThread.join(THREAD_JOIN_DELAY_TIME);
            String stopSuccessMessage = new Date().toString() + ":  The metd service has been successfully stopped.";
            logger.info(stopSuccessMessage);
            printStream.println(stopSuccessMessage);

        } catch (Exception ex) {

            exceptionHandler.handleError(ex, "Failed to stop the metd service");
        }
    }

    /**
     * Destroy this resources used by this service.
     */
    public void destroy() {
        myThread = null;
        String destroyMessage = "The metd service thread has been destroyed.";
        logger.info(destroyMessage);
        printStream.println(destroyMessage);
    }
}
