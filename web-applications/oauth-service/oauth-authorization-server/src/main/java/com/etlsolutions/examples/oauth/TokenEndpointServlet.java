/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.oauth;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zc
 */
@WebServlet(name = "TokenEndpointServlet", urlPatterns = {"/TokenEndpointServlet"})
public class TokenEndpointServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

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

        //TODO: The GET method is not useful for this servlet so a proper response is needed.
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
//        OAuthTokenRequest oauthRequest = null;
//
//        OAuthIssuer oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
//
//        try {
//            oauthRequest = new OAuthTokenRequest(request);
//
//            validateClient(oauthRequest);
//
//            String authzCode = oauthRequest.getCode();
//
//            // some code
//            String accessToken = oauthIssuerImpl.accessToken();
//            String refreshToken = oauthIssuerImpl.refreshToken();
//
//            // some code
//            OAuthResponse r = OAuthASResponse
//                    .tokenResponse(HttpServletResponse.SC_OK)
//                    .setAccessToken(accessToken)
//                    .setExpiresIn("3600")
//                    .setRefreshToken(refreshToken)
//                    .buildJSONMessage();
//
//            response.setStatus(r.getResponseStatus());
//            PrintWriter pw = response.getWriter();
//            pw.print(r.getBody());
//            pw.flush();
//            pw.close();
//            //if something goes wrong
//        } catch (OAuthProblemException ex) {
//
//            OAuthResponse r = OAuthResponse
//                    .errorResponse(401)
//                    .error(ex)
//                    .buildJSONMessage();
//
//            response.setStatus(r.getResponseStatus());
//
//            PrintWriter pw = response.getWriter();
//            pw.print(r.getBody());
//            pw.flush();
//            pw.close();
//
//            response.sendError(401);
//        }
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
