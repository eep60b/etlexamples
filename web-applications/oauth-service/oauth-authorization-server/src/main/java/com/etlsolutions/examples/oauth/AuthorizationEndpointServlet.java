package com.etlsolutions.examples.oauth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;

/**
 *
 * @author zc
 */
@WebServlet(name = "AuthorizationEndpointServlet", urlPatterns = {"/AuthorizationEndpointServlet"})
public class AuthorizationEndpointServlet extends HttpServlet {

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

        try {
            //dynamically recognize an OAuth profile based on request characteristic (params,
            // method, content type etc.), perform validation
            OAuthIssuerImpl oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
            OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);
            //build response according to response_type
            String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
            OAuthASResponse.OAuthAuthorizationResponseBuilder builder = OAuthASResponse
                    .authorizationResponse(request, HttpServletResponse.SC_FOUND);
            if (responseType.equals(ResponseType.CODE.toString())) {
                builder.setCode(oauthIssuerImpl.authorizationCode());
            }
            if (responseType.equals(ResponseType.TOKEN.toString())) {
                builder.setAccessToken(oauthIssuerImpl.accessToken());
                builder.setExpiresIn(3600l);
            }

            String redirectUri = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);

            OAuthResponse resp = builder.location(redirectUri).buildQueryMessage();

            response.sendRedirect(resp.getLocationUri());

            //if something goes wrong
        } catch (OAuthProblemException ex) {
            try {
                Response.ResponseBuilder responseBuilder = Response.status(HttpServletResponse.SC_FOUND);
                String redirectUri = ex.getRedirectUri();
                final OAuthResponse resp = OAuthASResponse
                        .errorResponse(HttpServletResponse.SC_FOUND)
                        .error(ex)
                        .location(redirectUri)
                        .buildQueryMessage();
                if (OAuthUtils.isEmpty(redirectUri)) {
                    throw new WebApplicationException(
                            responseBuilder.entity("OAuth callback url needs to be provided by client!!!").build());
                }

                response.sendRedirect(resp.getLocationUri());
            } catch (OAuthSystemException ex1) {
                throw new WebApplicationException(ex1);
            }
        } catch (OAuthSystemException ex) {
            throw new WebApplicationException(ex);
        }
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
        //TODO: This method should call doGet and issue an warning since the parameters will be ignored.
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