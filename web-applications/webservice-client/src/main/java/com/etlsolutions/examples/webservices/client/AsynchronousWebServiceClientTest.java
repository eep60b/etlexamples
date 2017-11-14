package com.etlsolutions.examples.webservices.client;

import com.etlsolutions.examples.webservices.handler.AccountDetailsServiceStub;
import com.etlsolutions.examples.webservices.handler.AccountDetailsServiceStub.AccountDetailsRequest;
import java.rmi.RemoteException;

/**
 *
 * @author zc
 */
public class AsynchronousWebServiceClientTest
{

	public static void main (String [] args) throws RemoteException, InterruptedException
	{
		AccountDetailsServiceStub servicesStub = new AccountDetailsServiceStub(WebServiceCientUtils.SERVICE_ENDPOINT);
		AccountDetailsRequest accountDetailsRequest = new AccountDetailsRequest();
		accountDetailsRequest.setAccountNumber("12345");
               
		WebServiceCientCallBackHandler callBackHandler = new WebServiceCientCallBackHandler();
		servicesStub.startaccountDetails(accountDetailsRequest, callBackHandler);

		Thread.sleep(5000);
	}
}