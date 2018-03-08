package com.etlsolutions.examples.weather;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * The BaseFileCopier class provides a method to make a copy of the base data
 * files from saved location if the data files are out-of-date.
 *
 * @author zc
 */
public final class BaseFileCopier {

    private static final BaseFileCopier INSTANCE = new BaseFileCopier();

    private BaseFileCopier() {
    }

    public static BaseFileCopier getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param savedBaseFile
     * @param baseFile
     */
    public void copy(File savedBaseFile, File baseFile) {

        Logger logger = Logger.getLogger(BaseFileCopier.class);
        try {
            if (savedBaseFile.isFile()) {

                if (!baseFile.isFile() || savedBaseFile.lastModified() > baseFile.lastModified()) {

                    FileUtils.copyFile(savedBaseFile, baseFile);
                    logger.info("The base file: " + savedBaseFile.getAbsolutePath() + " has been copied.");

                } else {
                    logger.trace("The base file: " + savedBaseFile.getAbsolutePath() + " has NOT been copied.");
                }
            } else {
                logger.trace("The base file: " + savedBaseFile.getAbsolutePath() + " is not a valid file and is not going to be used.");
            }

        } catch (Throwable th) {

            Logger.getLogger(BaseFileCopier.class).warn("\nFailed to copy the base file: " + savedBaseFile.getAbsolutePath() + " to: " + baseFile.getAbsolutePath() + "\nThe base file is NOT used.", th);
        }
    }

}
