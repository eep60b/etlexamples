/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.etlsolutions.examples.utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class CommandLineUtilities.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class CommandLineUtilitiesTest {

    @Before
    public void setUp() {
    }

    /**
     * Test of processCommand method.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testProcessCommand() throws Exception {
        assertTrue(CommandLineUtilities.processCommand("java", "-version").startsWith("java version"));
    }

    /**
     * Test of processCommand method.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testProcessCommand_dos() throws Exception {
        assertEquals("ECHO is on.\r\n", CommandLineUtilities.processCommand("cmd.exe", "/C", "echo"));
    }

    /**
     * Test of processCommand method.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testJarSgnerCommand() throws Exception {

        String result = CommandLineUtilities.processCommand("jarsigner", "-verify", "src/test/resources/jarverifier/jms-1.1.jar");
        assertTrue(result.startsWith("jar verified."));
        assertTrue(result.contains("Warning"));
        assertTrue(result.contains("This jar contains entries whose signer certificate has expired."));
    }

    /**
     * Test of processCommand method.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testBatFile() throws Exception {
        FileUtils.deleteDirectory(new File("target/domain4"));
        String result = CommandLineUtilities.processCommand("cmd", "/c", "C:\\Programs\\glassfish\\glassfish4\\bin\\asadmin --user admin --passwordfile src/test/resources/com/etlsolutions/examples/utility/pwd.txt create-domain --domaindir target --adminport 4852 --domainproperties domain.instancePort=8084:http.ssl.port=8447:orb.listener.port=3704:jms.port=7680 domain4");
        assertTrue(result.startsWith("Using port 4852 for Admin.\r\nUsing port 8084 for HTTP Instance.\r\nUsing port 7680 for JMS.\r\nUsing port 3704 for IIOP.\r\nUsing port 8447 for HTTP_SSL.\r\n"
                + "Using default port 3820 for IIOP_SSL.\r\nUsing default port 3920 for IIOP_MUTUALAUTH.\r\nUsing default port 8686 for JMX_ADMIN.\r\nUsing default port 6666 for OSGI_SHELL.\r\n"
                + "Using default port 9009 for JAVA_DEBUGGER."));
        assertTrue(result.endsWith("Domain domain4 created.\r\nDomain domain4 admin port is 4852.\r\nDomain domain4 admin user is \"admin\".\r\nCommand create-domain executed successfully.\r\n"));
    }

    /**
     * Test of processCommand method. This is the simplest case to test the
     * SCHTASKS command (Windows only).
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testProcessCommand_schTasks_query() throws Exception {

        assertTrue(CommandLineUtilities.processCommand("Schtasks", "/Query", "/?").endsWith("SCHTASKS /Query /FO TABLE /NH /V\r\n"));
    }

    /**
     * Test of processCommand method. This test creates the correct scheduled
     * task at the system level then deletes it. Run NetBeans as administrator
     * otherwise the test will fail.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testProcessCommand_schTasks_create_delete_task_1() throws Exception {

        assertEquals("SUCCESS: The scheduled task \"ETL Task Scheduler abc_701\" has successfully been created.\r\n", CommandLineUtilities.processCommand("cmd", "/c", "SchTasks /Create /F /RU SYSTEM /SC DAILY /TN \"ETL Task Scheduler abc_701\" /TR \"\\\"C:\\Program Files\\DataHub Extract\\RunExtract.exe\\\"\" /ST 09:35"));
        String[] deleteCommand = {"schtasks", "/delete", "/F", "/TN", "ETL Task Scheduler abc_701"};
        assertEquals("SUCCESS: The scheduled task \"ETL Task Scheduler abc_701\" was successfully deleted.\r\n", CommandLineUtilities.processCommand(deleteCommand));
    }

    /**
     * Test of processCommand method. This test creates the correct scheduled
     * task at the system level then deletes it. Run NetBeans as administrator
     * otherwise the test will fail.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testProcessCommand_schTasks_create_delete_task_2() throws Exception {

        String[] createCommand = {"schtasks", "/CREATE", "/F", "/RU", "SYSTEM", "/TN",
            "ETL Task Scheduler datahub-test_12345", "/TR", "\\\"C:\\Program Files\\DataHub Extract\\RunExtract.exe\\\"",
            "/SC", "DAILY", "/ST", "21:00:00"};
        assertEquals("SUCCESS: The scheduled task \"ETL Task Scheduler datahub-test_12345\" has successfully been created.\r\n", CommandLineUtilities.processCommand(createCommand));

        String[] deleteCommand = {"schtasks", "/delete", "/F", "/TN", "ETL Task Scheduler datahub-test_12345"};
        assertEquals("SUCCESS: The scheduled task \"ETL Task Scheduler datahub-test_12345\" was successfully deleted.\r\n", CommandLineUtilities.processCommand(deleteCommand));
    }
}
