package main;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import account.Account;
import account.SavingsAccount;

public class BankTest {
	protected Bank bank;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@BeforeEach
	public void setUp() throws Exception {
		this.bank = new Bank();
	}

	@Test
	@DisplayName("Open New Bank Test")
	public void openNewBankTest() {
		ArrayList<Account> accounts = this.bank.getAccounts();
		ArrayList<SavingsAccount> savingsAccounts = this.bank.getSavingsAccounts();
		assertTrue(accounts.size() == 0);
		assertTrue(savingsAccounts.size() == 0);
	}

	@Test
	@DisplayName("Open New Account Test")
	public void openNewAccountTest() {
		int oldSize = this.bank.getAccounts().size();
		this.bank.openAccount();
		int newSize = this.bank.getAccounts().size();
		assertTrue(newSize == oldSize + 1);
	}

	@Test
	@DisplayName("Open New Savings Account Test")
	public void openNewSavingsAccountTest() {
		int oldSize = this.bank.getAccounts().size();
		this.bank.openSavingsAccount();
		int newSize = this.bank.getAccounts().size();
		assertTrue(newSize == oldSize + 1);
	}
	
}
