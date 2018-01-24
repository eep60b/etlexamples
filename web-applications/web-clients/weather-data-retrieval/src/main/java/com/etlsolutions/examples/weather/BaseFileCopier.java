package com.etlsolutions.examples.weather;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
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
     * @param baseFile
     * @param file
     */
    public void copy(File baseFile, File file) {

        Logger logger = Logger.getLogger(BaseFileCopier.class);
        try {
            if (baseFile.isFile()) {

                if (!file.isFile() || baseFile.lastModified() > file.lastModified()) {
                    
                    FileUtils.copyFile(baseFile, file);
                    logger.info("The base file: " + baseFile.getAbsolutePath() + " has been copied.");
                    
                } else {
                    logger.trace("The base file: " + baseFile.getAbsolutePath() + " has NOT been copied.");
                }
            } else {
                logger.trace("The base file: " + baseFile.getAbsolutePath() + " is not a valid file and is not going to be used.");
            }

        } catch (Throwable th) {
            
            Logger.getLogger(BaseFileCopier.class).warn("\nFailed to copy the base file: " + baseFile.getAbsolutePath() + " to: " + file.getAbsolutePath() + "\nThe base file is NOT used.", th);
        }
    }

}
