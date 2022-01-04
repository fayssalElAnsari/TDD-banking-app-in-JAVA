package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.MathFunc;

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
	 * @throws CreditingNegativeAmmountException 
	 */
	@Test
	@DisplayName("Credit Into Account Test")
	void creditIntoAccountTest() throws CreditingNegativeAmmountException {
		double toCredit = 10;
		double creditBefore = newAccount.getCredit();
		newAccount.credit(toCredit);
		assertEquals(newAccount.getCredit(), creditBefore + toCredit);
	}
	
	/**
	 * test out that when we debit into an account
	 * the variable debit is incremented by the same value
	 * @throws CreditingNegativeAmmountException 
	 * @throws DebitingNegativeAmmountException 
	 */
	@Test
	@DisplayName("Debit Into Account Test")
	void debitIntoAccountTest() throws DebitingNegativeAmmountException {
		double toDebit = 10;
		double debitBefore = newAccount.getCredit();
		newAccount.debit(toDebit);
		assertEquals(newAccount.getDebit(), debitBefore + toDebit);
	}
	
	@Test
	@DisplayName("Credit Negative Ammount Throws Exception Test")
	void cantCreditNegativeAmmount() {
		double toCredit = -10;
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
		double toDebit = -10;
		assertTrue(toDebit<0);
		Exception thrownException = assertThrows(
					DebitingNegativeAmmountException.class, 
					() -> 
					{
						newAccount.debit(toDebit);
					}
			);
		
		assertTrue(thrownException.getMessage().contains("can't debit negative ammount"));
	}
	
	@Test
	@DisplayName("Multiple Credits & Debits Test")
	void multipleOperationsTest() throws CreditingNegativeAmmountException, DebitingNegativeAmmountException {
		double expectedBalance = 0.0;
		double[] credits = {123.4, 234.3, 874.2};
		double[] debits = {145.7, 2378.4, 387.2};
		for(double credit: credits) {
			newAccount.credit(credit);
			expectedBalance += credit;
		}
		for(double debit: debits) {
			newAccount.debit(debit);
			expectedBalance -= debit;
		}	
		assertTrue(MathFunc.round(newAccount.getBalance(), 2) == MathFunc.round(expectedBalance, 2));
		
	}
	
	@Test
	@DisplayName("If No More Empty Space Combine Old Credits")
	void noMoreEmptySpaceWhileCreditTest() throws CreditingNegativeAmmountException, DebitingNegativeAmmountException {
		int maxHistorySize = newAccount.getMaxHistorySize();
		int currentHistoryIndex = 0;
		double toCredit = 10;
		while(currentHistoryIndex <= maxHistorySize) {
			newAccount.credit(toCredit);
			currentHistoryIndex++;
		}
		double oldCredit = this.newAccount.getCredit();
		this.newAccount.credit(toCredit);
		assertTrue(this.newAccount.getCredit() == oldCredit + toCredit);
	}
	
	@Test
	@DisplayName("If No More Empty Space Combine Old Debits")
	void noMoreEmptySpaceWhileDebitTest() throws CreditingNegativeAmmountException, DebitingNegativeAmmountException {
		int maxHistorySize = newAccount.getMaxHistorySize();
		int currentHistoryIndex = 0;
		double toDebit = 10;
		while(currentHistoryIndex <= maxHistorySize) {
			newAccount.debit(toDebit);
			currentHistoryIndex++;
		}
		double oldDebit = this.newAccount.getDebit();
		this.newAccount.credit(toDebit);
		assertTrue(this.newAccount.getDebit() == oldDebit + toDebit);
	}
	
}
