package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

	protected Account newAccount;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		newAccount = new Account();
	}

	/**
	 * verifie that when the account is created the credit
	 * and debit are 0
	 */
	@Test
	void createAccountTest() {
		assertEquals(newAccount.getCredit(), 0);
		assertEquals(newAccount.getDebit(), 0);
	}
	
	/**
	 * test out that when we deposit into an account
	 * the variable credit is incremented by the same value
	 */
	@Test
	void creditIntoAccountTest() {
		float money = 10;
		float moneyBefore = newAccount.getCredit();
		newAccount.credit(money);
		assertEquals(newAccount.getCredit(), moneyBefore + money);
	}
	
}
