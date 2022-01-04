package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("Create Account Test")
	void createAccountTest() {
		assertEquals(newAccount.getCredit(), 0);
		assertEquals(newAccount.getDebit(), 0);
	}
	
	/**
	 * test out that when we credit into an account
	 * the variable credit is incremented by the same value
	 */
	@Test
	@DisplayName("Credit Into Account Test")
	void creditIntoAccountTest() {
		float toCredit = 10;
		float creditBefore = newAccount.getCredit();
		newAccount.credit(toCredit);
		assertEquals(newAccount.getCredit(), creditBefore + toCredit);
	}
	
	/**
	 * test out that when we debit into an account
	 * the variable debit is incremented by the same value
	 */
	@Test
	@DisplayName("Debit Into Account Test")
	void debitIntoAccountTest() {
		float toDebit = 10;
		float debitBefore = newAccount.getCredit();
		newAccount.debit(toDebit);
		assertEquals(newAccount.getDebit(), debitBefore + toDebit);
	}
	
	@Test
	@DisplayName("Credit Negative Ammount Throws Exception Test")
	void cantCreditNegativeAmmount() {
		float toCredit = -10;
		assertTrue(toCredit<0);
		Exception thrownException = assertThrows(
					CreditingNegativeAmmountException.class, 
					() -> 
					{
						newAccount.credit(toCredit);
					}
			);
		
		assertTrue(thrownException.getMessage().contains("can't credit negative ammount"));
	}
	
	@Test
	@DisplayName("Debit Negative Ammount Throws Exception Test")
	void cantDebitNegativeAmmount() {
		float toCredit = -10;
		assertTrue(toCredit<0);
		Exception thrownException = assertThrows(
					DebitingNegativeAmmountException.class, 
					() -> 
					{
						newAccount.credit(toCredit);
					}
			);
		
		assertTrue(thrownException.getMessage().contains("can't debit negative ammount"));
	}
	
}
