package com.etlsolutions.examples.webservices.client;

import com.etlsolutions.examples.webservices.handler.AccountDetailsServiceStub;
import com.etlsolutions.examples.webservices.handler.AccountDetailsServiceStub.AccountDetailsRequest;
import com.etlsolutions.examples.webservices.handler.AccountDetailsServiceStub.AccountDetailsResponse;
import java.rmi.RemoteException;

/**
 *
 * @author zc
 */
public class SynchronousWebServiceClientTest {

    public static void main(String[] args) throws RemoteException {
        AccountDetailsServiceStub servicesStub = new AccountDetailsServiceStub(WebServiceCientUtils.SERVICE_ENDPOINT);
       
        AccountDetailsRequest accountDetailsRequest = new AccountDetailsRequest();
        accountDetailsRequest.setAccountNumber("12345");

        AccountDetailsResponse accountDetailsResponse = servicesStub.accountDetails(accountDetailsRequest);
        WebServiceCientUtils.logAccountDetails(accountDetailsResponse.getAccountDetails());
    }
}
