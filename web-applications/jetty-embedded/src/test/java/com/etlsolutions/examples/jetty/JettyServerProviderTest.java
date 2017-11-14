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
package com.etlsolutions.examples.jetty;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class JettyServerProvider.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public class JettyServerProviderTest {

    private final JettyServerProvider instance = new JettyServerProvider();
    private final HttpClient client = new HttpClient();

    private Server server;
    private String serverUri;

    @Before
    public void setUp() throws Exception {
        ServerConnector serverConnector = instance.createServerConnector("src/test/resources/wars/test.war", "/");
        server = serverConnector.getServer();
        server.start();

        String host = serverConnector.getHost();
        host = host == null ? "localhost" : host;

        int port = serverConnector.getLocalPort();
        serverUri = String.format("http://%s:%d/", host, port);

        client.start();

    }

    @After
    public void tearDown() throws Exception {
        server.stop();
        client.stop();
    }

    /**
     * Test of createServerConnector method, of class JettyServerProvider.
     *
     * @throws InterruptedException
     * @throws TimeoutException
     * @throws ExecutionException
     */
    @Test
    public void testGetServer() throws InterruptedException, TimeoutException, ExecutionException {

        String result = "<html>\r\n"
                + "    <head>\r\n"
                + "        <title>Jetty Test</title>\r\n"
                + "        <meta charset=\"UTF-8\">\r\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                + "    </head>\r\n"
                + "    <body>\r\n"
                + "        <div>Hello Jetty Test</div>\r\n"
                + "    </body>\r\n"
                + "</html>";

        ContentResponse response = client.newRequest(serverUri).send();

        
        assertEquals(result, response.getContentAsString().trim());

    }

}
