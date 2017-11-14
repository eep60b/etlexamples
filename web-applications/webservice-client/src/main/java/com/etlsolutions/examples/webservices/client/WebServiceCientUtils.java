
package com.etlsolutions.examples.webservices.client;

import com.etlsolutions.examples.webservices.handler.AccountDetailsServiceCallbackHandler;
import com.etlsolutions.examples.webservices.handler.AccountDetailsServiceStub.Account;
import org.apache.log4j.Logger;

public class WebServiceCientUtils extends AccountDetailsServiceCallbackHandler
{

		private static final Logger logger_c = Logger.getLogger(WebServiceCientUtils.class);
		protected final static String SERVICE_ENDPOINT = "http://localhost:9548/spring-webservices/endpoints/AccountDetailsService.wsdl";
		private static final String NEW_LINE = "\n";


		protected static void logAccountDetails(Account account_p)
		{
			StringBuffer sb = new StringBuffer();
			sb.append(NEW_LINE);
			sb.append("Account Number: ").append(account_p.getAccountNumber()).append(NEW_LINE);
			sb.append("Account Name: ").append(account_p.getAccountName()).append(NEW_LINE);
			sb.append("Account Status: ").append(account_p.getAccountStatus()).append(NEW_LINE);
			sb.append("Account Balance: ").append(account_p.getAccountBalance()).append(NEW_LINE);
			logger_c.debug(sb);
		}
}
