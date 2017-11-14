package com.etlsolutions.examples.spring;

import com.etlsolutions.examples.spring.webservices.Account;


/**
 * The Interface AccountService.
 */
public interface AccountService
{

	/**
	 * Gets the account details.
	 *
	 * @param accountNumber the account number
	 * @return the account details
	 */
	public Account getAccountDetails(String accountNumber);
}
