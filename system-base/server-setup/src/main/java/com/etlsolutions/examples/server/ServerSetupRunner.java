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
package com.etlsolutions.examples.server;

import com.etlsolutions.examples.server.glassfish.GlassfishServerSetuper;
import com.etlsolutions.examples.server.tomcat.TomcatServerSetuper;
import com.etlsolutions.examples.server.weblogic.WeblogicServerSetuper;
import org.apache.log4j.Logger;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ServerSetupRunner {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(ServerSetupRunner.class);
        ServerConfigLoader loader = ServerConfigLoader.getInstance();

        try {

            logger.info("Start to setup the GlassFish sever......");
            ServerType type = loader.getServerType();

            switch (type) {
                case GLASSFISH:
                    GlassfishServerSetuper glassfishServerSetuper = new GlassfishServerSetuper();
                    glassfishServerSetuper.setup();
                    break;
                case TOMCAT:
                    TomcatServerSetuper tomcatServerSetuper = new TomcatServerSetuper();
                    tomcatServerSetuper.setup();
                    break;
                case WEBLOGIC:
                    WeblogicServerSetuper weblogicServerSetuper = new WeblogicServerSetuper();
                    weblogicServerSetuper.setup();
                    break;
            }

            throw new IllegalStateException("Invalid type.");

        } catch (Throwable th) {

            logger.fatal(th);
            logger.fatal("The server setup is failed.");
            throw new RuntimeException(th);
        }
    }
}
