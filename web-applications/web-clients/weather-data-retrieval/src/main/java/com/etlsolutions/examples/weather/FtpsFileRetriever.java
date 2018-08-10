package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestConfig;
import com.etlsolutions.examples.weather.data.RequestLocation;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;

/**
 * The FtpsFileRetriever class provides a method to retrieve data files via
 * FTPS.
 *
 * @author zc
 */
public final class FtpsFileRetriever {

    private final JSch jsch = new JSch();

    /**
     * Retrieve the data files via FTPS and copy them to the location defined in
     * the parameters object.
     *
     * @param parameters - The parameters used to copy files.
     * @throws SftpException if the data cannot be get through the SSH chanel.
     * @throws IOException if an IO error occurs.
     * @throws JSchException if the SSH chanel cannot be established.
     */
    public void copyFiles(ApplicationParameters parameters) throws SftpException, IOException, JSchException {

        Session session = jsch.getSession(parameters.getFtpsUsername(), parameters.getFtpsServerName(), 22);
        session.setConfig("StrictHostKeyChecking", "no");
        session.setPassword(parameters.getFtpsPassword());
        session.connect();
        ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
        sftpChannel.connect();
        Calendar calendar = Calendar.getInstance();
        try {
            for (RequestConfig requestConfig : parameters.getRequestConfigs()) {
                String filename =  requestConfig.getRequestMethod().getAbbreviation() + DATA_FILENAME_SEPARATOR + requestConfig.getRequestLocation().getName() + DATA_FILENAME_SEPARATOR + calendar.get(Calendar.YEAR) + parameters.getDataFileExtension();                
                String inputFilePath = parameters.getFtpsRemoteSourceDirectory() + "/" + filename;

                //Make an extra copy which can be picked up by the text editor in mobile devices.
                for (String directoryPath : parameters.getFtpsLocalTargetDirecotries()) {
                    InputStream inputStream = sftpChannel.get(inputFilePath);
System.out.println(directoryPath + File.separator + filename + TEXT_FILE_EXTENSION);
                    FileUtils.copyInputStreamToFile(inputStream, new File(directoryPath + File.separator + filename + TEXT_FILE_EXTENSION));
                }

            }
        } finally {
            sftpChannel.exit();
            session.disconnect();
        }
    }
}
