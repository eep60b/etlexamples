package com.etlsolutions.examples.weather.usertests;

import com.etlsolutions.examples.weather.ApplicationParameters;
import com.etlsolutions.examples.weather.ApplicationParametersFactory;
import com.etlsolutions.examples.weather.FtpsFileRetriever;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.cli.ParseException;
import org.xml.sax.SAXException;

/**
 *
 * @author zc
 */
public class FtpsFileRetrieverRunner {

    public static void main(String[] args) throws ParseException, IOException, ParserConfigurationException, SAXException, SftpException, JSchException {
        
        String[] args1 = {"-useFtpsService", "true", "-ftpsLocalTargetDirectories", "target/test/FtpsFileRetrieverRunner1,target/test/FtpsFileRetrieverRunner2"};
        ApplicationParameters applicationParameters = ApplicationParametersFactory.getInstance().loadApplicationParameters(args1);
        
        FtpsFileRetriever retriever = new FtpsFileRetriever();
  
        retriever.copyFiles(applicationParameters);
    }
}
