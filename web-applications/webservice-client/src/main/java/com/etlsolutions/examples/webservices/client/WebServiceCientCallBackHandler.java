/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.webservices.client;

import com.etlsolutions.examples.webservices.handler.AccountDetailsServiceCallbackHandler;
import com.etlsolutions.examples.webservices.handler.AccountDetailsServiceStub.AccountDetailsResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public class WebServiceCientCallBackHandler extends AccountDetailsServiceCallbackHandler
{

		private static final Logger logger_c = Logger.getLogger(WebServiceCientCallBackHandler.class);

		@Override
		public Object getClientData()
		{
			return super.getClientData();
		}

		@Override
		public void receiveResultaccountDetails(AccountDetailsResponse result_p)
		{
			super.receiveResultaccountDetails(result_p);
			WebServiceCientUtils.logAccountDetails(result_p.getAccountDetails());
		}

		@Override
		public void receiveErroraccountDetails(Exception ex_p)
		{
			super.receiveErroraccountDetails(ex_p);
			logger_c.error("An error occurred calling AccountDetails Service", ex_p);
		}
}