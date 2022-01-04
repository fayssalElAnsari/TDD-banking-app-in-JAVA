package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.MathFunc;

public class SavingsAccountTest extends AccountTest{
	protected SavingsAccount newSavingsAccount;
	double interestRate;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.newAccount = new SavingsAccount(4.5);
		interestRate = 3.2;
		this.newSavingsAccount = new SavingsAccount(interestRate);
	}
	
	@Test
	@DisplayName("Withdraw From Savings Account Test")
	public void withdrawFromAccountTest() throws WithdrawingZeroException, WithdrawingNegativeAmountException, 
		WithdrawPassedLimitException, DepositingNegativeAmountException, DepositingZeroException, DepositPassedLimitException, SavingsAccountBelowZeroBalanceException {
		double toWithdraw = 10;
		double withdrawBefore = newAccount.getWithdraw();
		newAccount.deposit(toWithdraw*10);
		newAccount.withdraw(toWithdraw);
		assertEquals(newAccount.getWithdraw(), withdrawBefore + toWithdraw);
	}
	
	@Test
	@DisplayName("Multiple Deposits & Withdraws Savings Account Test")
	public void multipleOperationsTest() throws DepositingNegativeAmountException, WithdrawingNegativeAmountException, 
	DepositingZeroException, WithdrawingZeroException, DepositPassedLimitException, WithdrawPassedLimitException, SavingsAccountBelowZeroBalanceException {
		double expectedBalance = 0.0;
		double[] deposits = {1230.4, 2340.3, 874.2};
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
	
//	@Test
//	@DisplayName("Balance Can't Get Below Zero Test")
//	public void balanceCantGetBelowZeroTeset() throws WithdrawingZeroException, WithdrawingNegativeAmountException, WithdrawPassedLimitException {
//		double withdrawBefore = newAccount.getWithdraw();
//		double balanceBefore = newAccount.getBalance();
//		double toWithdraw = balanceBefore + 0.1;
//		newAccount.withdraw(toWithdraw);
//		assertEquals(newAccount.getWithdraw(), withdrawBefore);
//		assertEquals(newAccount.getBalance(), balanceBefore);	
//	}
	
	@Test
	@DisplayName("Balance Can't Get Below Zero Test")
	public void balanceCantGetBelowZeroTeset() throws WithdrawingZeroException, WithdrawingNegativeAmountException, WithdrawPassedLimitException {
		double balanceBefore = newAccount.getBalance();
		double toWithdraw = balanceBefore + 0.1;
		Exception thrownException = assertThrows(
				SavingsAccountBelowZeroBalanceException.class,
				() -> {
					newAccount.withdraw(toWithdraw);
				}
			);
		assertTrue(thrownException.getMessage().contains("impossible to withdraw this amount"));
	}
	
	@Test
	@DisplayName("Interest Rate Is Correct Test")
	public void interestRateIsCorrectTest() {
		assertEquals(this.newSavingsAccount.getInterestRate(), interestRate);
	}
	
	@Test
	@DisplayName("Due Interest Deposit Test")
	public void dueInterestDepositTest() throws DepositingNegativeAmountException, DepositingZeroException, DepositPassedLimitException {
		this.newSavingsAccount.deposit(10000);
		double oldBalance = this.newSavingsAccount.getBalance();
		this.newSavingsAccount.interestDeposit();
		assertEquals(this.newSavingsAccount.getBalance(), oldBalance+oldBalance*this.interestRate);
	}
	
}
