package com.etlsolutions.examples.weather.integrationtests;

import com.etlsolutions.examples.weather.ProcrunService;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.*;
import static org.junit.Assert.fail;
import org.junit.experimental.categories.Category;

/**
 * Integration test of class ProcrunService.
 *
 * @author zc
 */
@Category(IntegrationTestMarker.class)
public class ProcrunServiceIntegrationTest {

    private final Logger logger = Logger.getLogger(ProcrunServiceIntegrationTest.class);
    private final Calendar calendar = Calendar.getInstance();
    private final int year = calendar.get(Calendar.YEAR);
    private final File sourceDirectory = new File("src/test/resources/metdata/" + year);
    private final String oneDrivePath = System.getProperty("user.home") + "/OneDrive/metdata";
    private final File resultDirectory = new File("/tmp/metdata");
    private final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    @Before
    public void setUp() throws IOException, ParseException {
        
        if (resultDirectory.exists()) {
            FileUtils.deleteDirectory(resultDirectory);
            logger.info(resultDirectory + " has been cleaned.");
        } else {
             logger.info(resultDirectory + " is clean.");           
        }

        logger.info("Copy the sample files from OneDrive to " + sourceDirectory.getAbsolutePath());
        FileUtils.copyDirectory(new File(oneDrivePath), sourceDirectory);
        logger.info("The source file has been updated.");

        File[] sourceFiles = sourceDirectory.listFiles();

        logger.info("Remove lines which are still changable during the forecast.");
        for (File file : sourceFiles) {

            List<String> lines = FileUtils.readLines(file, "ASCII");

            int size = lines.size();

            for (int i = lines.size() - 1; i > 0; i--) {
                if (format.parse(lines.get(i).split(",")[0]).getTime() > (calendar.getTimeInMillis() - 120 * 60 * 1000)) {
                    lines.remove(i);
                }
            }

            StringBuilder builder = new StringBuilder();

            for (String line : lines) {
                builder.append(line).append("\n");
            }

            if (file.getName().startsWith("fcs3h")) {

                FileUtils.writeStringToFile(file, builder.substring(0, builder.length() - 1), "ASCII");
                logger.info("Totally " + (size - lines.size()) + " lines has been removed from the file " + file.getName() + ".");
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        FileUtils.deleteDirectory(resultDirectory);
        logger.info(resultDirectory + " has been cleaned.");
    }
    
    /**
     * Test of all methods.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void test() throws Exception {

        String[] args = new String[]{
            "-intervalMinutes", "1",
            "-configFilePath", "src/test/resources/props/config.properties",
            "-baseDataPath", oneDrivePath};

        ProcrunService.start(args);
        Thread.sleep(120000);
        ProcrunService.stop(args);

        File[] sourceFiles = sourceDirectory.listFiles();

        for (File file : sourceFiles) {

            logger.info("\nVerify the file: " + file.getName());
            List<String> sourceLines = FileUtils.readLines(file, "ASCII");
            List<String> targetLines = FileUtils.readLines(new File(resultDirectory + File.separator + file.getName()), "ASCII");

            for (int i = 1; i < targetLines.size(); i++) {

                String targetLine = targetLines.get(i);

                if (targetLine.trim().isEmpty()) {
                    continue;
                }

                String[] cells = targetLine.split(",");

                try {

                    if (cells.length != 11) {
                        throw new IllegalStateException("Invalid data lline length: " + targetLine + "in file " + file.getName());
                    }

                    if (file.getName().startsWith("fcs2h")) {
                        format.parse(cells[0]);
                        Double.parseDouble(cells[1]);
                        Double.parseDouble(cells[2]);
                        Double.parseDouble(cells[3]);
                        Double.parseDouble(cells[4]);
                        Double.parseDouble(cells[5]);
                        Integer.parseInt(cells[6]);
                        Integer.parseInt(cells[7]);
                        Integer.parseInt(cells[8]);
                        Double.parseDouble(cells[9]);
                        Double.parseDouble(cells[10]);
                    }

                    if (file.getName().startsWith("obs1h")) {
                        format.parse(cells[0]);
                        Double.parseDouble(cells[1]);
                        Integer.parseInt(cells[2]);
                        Double.parseDouble(cells[3]);
                        Double.parseDouble(cells[4]);
                        Double.parseDouble(cells[5]);
                        Double.parseDouble(cells[6]);
                        Integer.parseInt(cells[7]);
                        Integer.parseInt(cells[8]);
                        Double.parseDouble(cells[9]);
                        Double.parseDouble(cells[10]);
                    }

                } catch (IllegalStateException | ParseException | NumberFormatException ex) {
                    logger.error(ex);
                    fail("Invalid line found: " + targetLine + " in file " + file.getName());
                }
            }

            for (int i = sourceLines.size() - 1; i >= 0; i--) {

                String sourceLine = sourceLines.get(i);
                if (targetLines.remove(sourceLine)) {
                    sourceLines.remove(sourceLine);
                }
            }

            if (sourceLines.isEmpty()) {
                logger.info(file.getName() + " is OK.");
            } else {

                fail("No target line mathces the source lines: " + sourceLines + "in file " + file.getName());

            }
        }
    }
}
