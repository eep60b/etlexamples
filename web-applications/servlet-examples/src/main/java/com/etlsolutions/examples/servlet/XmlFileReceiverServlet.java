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
package com.etlsolutions.examples.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * The XmlFileReceiverServlet class demonstrates how to consume the request
 * content.
 *
 * @author Zhipeng Chang
 */
public class XmlFileReceiverServlet extends HttpServlet {

    private static final long serialVersionUID = 863702190241195441L;

    private final Logger logger = Logger.getLogger(XmlFileReceiverServlet.class);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request - The servlet request
     * @param response- The servlet response
     */
    @SuppressWarnings("NestedAssignment")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        int errorCode;
        try {
            BufferedReader contentReader = request.getReader();

            StringBuilder builder = new StringBuilder();
            String separater = "\n";
            int separaterLength = separater.length();
            String line;
            while ((line = contentReader.readLine()) != null) {
                builder.append(line).append(separater);
            }

            String content = new String(builder);

            int contentLength = content.length();

            if (contentLength > separaterLength) {
                content = content.substring(0, contentLength - separaterLength);
            }

            FileUtils.writeStringToFile(new File("C:\\Temp\\ps.xml"), content, request.getCharacterEncoding());
            errorCode = 200;
        } catch (Throwable th) {
            errorCode = 500;
            logger.error("Internal error", th);
        }

        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(errorCode);

        if (errorCode == 200) {
            doSuccessResponse(response);
        } else {
            doFailuresResponse(response, errorCode);
        }
    }

    private void doSuccessResponse(HttpServletResponse response) {

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Congratulation! You request has been successfully processed.</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Throwable th) {
            logger.error(th);
        }
    }

    private void doFailuresResponse(HttpServletResponse response, int errorCode) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Failed to connect: " + getErrorMessage(errorCode) + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Throwable th) {

            logger.error(th);
        }
    }

    private String getErrorMessage(int errorCode) {

        switch (errorCode) {
            case 404:
                return "page not found.";
            case 500:
                return "internal error";
            default:
                return "unknown error";
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
