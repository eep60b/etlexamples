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

import java.lang.management.ManagementFactory;
import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class JettyServerProvider {

    /**
     * Deploy a war file to a newly created server and get a ServerConnector
     * object which has information of server, port number, host name etc.
     *
     * @param warFilPath - The path of war file which will deployed in this
     * server.
     * @param contextPath - The context path of the war file which will be
     * deployed.
     * @return the newly created ServerConnector object.
     */
    public ServerConnector createServerConnector(String warFilPath, String contextPath) {
        
        // Create a basic jetty server object that will listen on port 8080. Note that if you set this to port 0 then
        // a randomly available port will be assigned that you can either look in the logs for the port,
        // or programmatically obtain it for use in test cases.
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(0); // let connector pick an unused port #
        server.addConnector(connector);

        // Setup JMX
        MBeanContainer mbContainer = new MBeanContainer(ManagementFactory.getPlatformMBeanServer());
        server.addBean(mbContainer);

        // The WebAppContext is the entity that controls the environment in which a web application lives and
        // breathes. In this example the context path is being set to "/" so it is suitable for serving root context
        // requests and then we see it setting the location of the war. A whole host of other configurations are
        // available, ranging from configuring to support annotation scanning in the webapp (through
        // PlusConfiguration) to choosing where the webapp will unpack itself.
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath(contextPath);
        webapp.setWar(warFilPath);

        // A WebAppContext is a ContextHandler as well so it needs to be set to the server so it is aware of where to
        // send the appropriate requests.
        server.setHandler(webapp);

        // Configure a LoginService
        // Since this example is for our test webapp, we need to setup a LoginService so this shows how to create a
        // very simple hashmap based one. The name of the LoginService needs to correspond to what is configured in
        // the webapp's web.xml and since it has a lifecycle of its own we register it as a bean with the Jetty
        // server object so it can be started and stopped according to the lifecycle of the server itself.
        //      HashLoginService loginService = new HashLoginService();
        //      loginService.setName("Test Realm");
        //      loginService.setConfig("src/test/resources/realm.properties");
        //      server.addBean(loginService);
        // Start things up! By using the server.join() the server thread will join with the current thread.
        // See "http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.html#join()" for more details.
        return connector;
    }
}
