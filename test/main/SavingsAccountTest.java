package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest extends AccountTest{
	
	@BeforeEach
	public void setUp() throws Exception {
		this.newAccount = new SavingsAccount();
	}
	
	@Test
	@DisplayName("Balance Can't Get Below Zero Test")
	public void balanceCantGetBelowZeroTeset() throws WithdrawingZeroException, WithdrawingNegativeAmountException, WithdrawPassedLimitException {
		System.out.println(this.newAccount);
		double withdrawBefore = newAccount.getWithdraw();
		double balanceBefore = newAccount.getBalance();
		double toWithdraw = balanceBefore + 0.1;
		newAccount.withdraw(toWithdraw);
		assertEquals(newAccount.getWithdraw(), withdrawBefore);
		assertEquals(newAccount.getBalance(), balanceBefore);
		
	}
	
	
	
}
