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
	 * verifie that when the account is created the deposit
	 * and withdraw are 0
	 */
	@Test
	@DisplayName("Create Account Test")
	void createAccountTest() {
		assertEquals(newAccount.getDeposit(), 0);
		assertEquals(newAccount.getWithdraw(), 0);
	}
	
	/**
	 * test out that when we deposit into an account
	 * the variable deposit is incremented by the same value
	 * @throws DepositingNegativeAmmountException 
	 * @throws DepositingZeroException 
	 */
	@Test
	@DisplayName("Deposit Into Account Test")
	void depositIntoAccountTest() throws DepositingNegativeAmmountException, DepositingZeroException {
		double toDeposit = 10;
		double depositBefore = newAccount.getDeposit();
		newAccount.deposit(toDeposit);
		assertEquals(newAccount.getDeposit(), depositBefore + toDeposit);
	}
	
	/**
	 * test out that when we withdraw into an account
	 * the variable withdraw is incremented by the same value
	 * @throws DepositingNegativeAmmountException 
	 * @throws WithdrawingNegativeAmmountException 
	 * @throws WithdrawingZeroException 
	 */
	@Test
	@DisplayName("Withdraw Into Account Test")
	void withdrawIntoAccountTest() throws WithdrawingZeroException, WithdrawingNegativeAmmountException {
		double toWithdraw = 10;
		double withdrawBefore = newAccount.getDeposit();
		newAccount.withdraw(toWithdraw);
		assertEquals(newAccount.getWithdraw(), withdrawBefore + toWithdraw);
	}
	
	@Test
	@DisplayName("Deposit Negative Ammount Throws Exception Test")
	void cantDepositNegativeAmmount() {
		double toDeposit = -10;
		assertTrue(toDeposit<0);
		Exception thrownException = assertThrows(
					DepositingNegativeAmmountException.class, 
					() -> 
					{
						newAccount.deposit(toDeposit);
					}
			);
		
		assertTrue(thrownException.getMessage().contains("can't deposit negative ammount"));
	}
	
	@Test
	@DisplayName("Withdraw Negative Ammount Throws Exception Test")
	void cantWithdrawNegativeAmmount() {
		double toWithdraw = -10;
		assertTrue(toWithdraw < 0);
		Exception thrownException = assertThrows(
					WithdrawingNegativeAmmountException.class, 
					() -> 
					{
						newAccount.withdraw(toWithdraw);
					}
			);
		
		assertTrue(thrownException.getMessage().contains("can't withdraw negative ammount"));
	}
	
	@Test
	@DisplayName("Multiple Deposits & Withdraws Test")
	void multipleOperationsTest() throws DepositingNegativeAmmountException, WithdrawingNegativeAmmountException, DepositingZeroException, WithdrawingZeroException {
		double expectedBalance = 0.0;
		double[] deposits = {123.4, 234.3, 874.2};
		double[] withdraws = {145.7, 2378.4, 387.2};
		for(double deposit: deposits) {
			newAccount.deposit(deposit);
			expectedBalance += deposit;
		}
		for(double withdraw: withdraws) {
			newAccount.withdraw(withdraw);
			expectedBalance -= withdraw;
		}	
		assertTrue(MathFunc.round(newAccount.getBalance(), 2) == MathFunc.round(expectedBalance, 2));
		
	}
	
	@Test
	@DisplayName("If No More Empty Space Combine Old Deposits")
	void noMoreEmptySpaceWhileDepositTest() throws DepositingNegativeAmmountException, WithdrawingNegativeAmmountException, DepositingZeroException {
		int maxHistorySize = newAccount.getMaxHistorySize();
		int currentHistoryIndex = 0;
		double toDeposit = 10;
		while(currentHistoryIndex <= maxHistorySize) {
			newAccount.deposit(toDeposit);
			currentHistoryIndex++;
		}
		double oldDeposit = this.newAccount.getDeposit();
		this.newAccount.deposit(toDeposit);
		assertTrue(this.newAccount.getDeposit() == oldDeposit + toDeposit);
	}
	
	@Test
	@DisplayName("If No More Empty Space Combine Old Withdraws")
	void noMoreEmptySpaceWhileWithdrawTest() throws DepositingNegativeAmmountException, WithdrawingNegativeAmmountException, WithdrawingZeroException {
		int maxHistorySize = newAccount.getMaxHistorySize();
		int currentHistoryIndex = 0;
		double toWithdraw = 20;
		while(currentHistoryIndex <= maxHistorySize) {
			newAccount.withdraw(toWithdraw);
			currentHistoryIndex++;
		}
		double oldWithdraw = this.newAccount.getWithdraw();
		this.newAccount.withdraw(toWithdraw);
		assertTrue(this.newAccount.getWithdraw() == oldWithdraw + toWithdraw);
	}
	
	@Test
	@DisplayName("Can't Deposit 0 Test")
	void cantDepositZeroTest() throws DepositingZeroException {
		double toDeposit = 0;
		assertTrue(toDeposit == 0);
		
		Exception thrownException = assertThrows(
				DepositingZeroException.class, 
				() -> 
				{
					newAccount.deposit(toDeposit);
				}
		);
	
	assertTrue(thrownException.getMessage().contains("can't deposit 0 ammount"));
		
	}
	
	@Test
	@DisplayName("Can't Withdraw 0 Test")
	void cantWithdrawZeroTest() throws WithdrawingZeroException {
		double toWithdraw = 0;
		assertTrue(toWithdraw == 0);
		
		Exception thrownException = assertThrows(
				WithdrawingZeroException.class, 
				() -> 
				{
					newAccount.withdraw(toWithdraw);
				}
		);
	
	assertTrue(thrownException.getMessage().contains("can't withdraw 0 ammount"));
		
	}
	

	
}
