package com.etlsolutions.examples.weather;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public final class FtpsFileRetriever {

    private final JSch jsch = new JSch();
    
    public void copyFiles(ApplicationParameters parameters) throws SftpException, IOException, JSchException {
        
        Session session = jsch.getSession(parameters.getFtpsUsername(), parameters.getFtpsServerName(), 22);
        session.setConfig("StrictHostKeyChecking", "no");
        session.setPassword(parameters.getFtpsPassword());
        session.connect();
        ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
        sftpChannel.connect();

        File[] files = new File(parameters.getDataDirectoryPath()).listFiles();
        try {
            for (File file : files) {
                String filename = file.getName();
                if (file.isFile() && filename.toLowerCase().endsWith(parameters.getDataFileExtension())) {

                    InputStream inputStream = sftpChannel.get(parameters.getFtpsRemoteSourceDirectory() + "/" + filename);
                    FileUtils.copyInputStreamToFile(inputStream, new File(parameters.getFtpsLocalTargetDirecotry() + File.separator + filename));
                }
            }
        } finally {
            sftpChannel.exit();
            session.disconnect();
        }
    }
}