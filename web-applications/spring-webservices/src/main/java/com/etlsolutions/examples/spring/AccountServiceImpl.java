package com.etlsolutions.examples.spring;

import com.etlsolutions.examples.spring.webservices.Account;
import com.etlsolutions.examples.spring.webservices.EnumAccountStatus;
import org.springframework.stereotype.Service;

/**
 * The Class AccountService.
 */
@Service
public class AccountServiceImpl implements AccountService
{

	/**
	 * Gets the account details.
	 *
	 * @param accountNumber the account number
	 * @return the account details
	 */
        @Override
	public Account getAccountDetails(String accountNumber)
	{

		/* hard coded account data - in reality this data would be retrieved
		 * from a database or back end system of some sort */
		Account account = new Account();
		account.setAccountNumber("12345");
		account.setAccountStatus(EnumAccountStatus.ACTIVE);
		account.setAccountName("Joe Bloggs");
		account.setAccountBalance(3400);

		return account;
	}
}
