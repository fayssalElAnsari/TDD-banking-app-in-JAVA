package main;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import account.Account;
import account.SavingsAccount;

public class BankTest {
	protected Bank bank;
	private double interestRate;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@BeforeEach
	public void setUp() throws Exception {
		this.bank = new Bank();
		this.interestRate = 3.2;
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
		int oldSize = this.bank.getSavingsAccounts().size();
		this.bank.openSavingsAccount(this.interestRate);
		int newSize = this.bank.getSavingsAccounts().size();
		assertTrue(newSize == oldSize + 1);
	}
	
	@Test
	@DisplayName("Deposit Into Account Test")
	public void depositIntoAccountTest() {
		this.bank.openAccount();
		this.bank.accountDeposit(0, 10000);
	}
	
	@Test
	@DisplayName("Deposit Into Savings Account Test")
	public void depositIntoSavingsAccountTest() {
		this.bank.openSavingsAccount(this.interestRate);
		this.bank.savingsAccountDeposit(0, 10000);
	}
	
	@Test
	@DisplayName("Withdraw From Account Test")
	public void withdrawFromAccountTest() {
		this.bank.openAccount();
		this.bank.accountWithdraw(0, 10000);
	}
	
	@Test
	@DisplayName("Withdraw From Savings Account Test")
	public void withdrawFromSavingsAccountTest() {
		this.bank.openSavingsAccount(this.interestRate);
		this.bank.savingsAccountDeposit(0, 20000);
		this.bank.savingsAccountWithdraw(0, 10000);
	}
	
	@Test
	@DisplayName("Account Doesn't Exist Test")
	public void accountDoesntExistTest() {
		fail();
	}
	
	@Test
	@DisplayName("Savings Account Doesn't Exit Test")
	public void savingsAccountDoesntExistTest() {
		fail();
	}
	
	@Test
	@DisplayName("Transfer From Account To Account Test")
	public void transferFromAccountToAccountTest() {
		fail();
	}
	
	@Test
	@DisplayName("Transfer From Account To Savings Account Test")
	public void transferFromAccountToSavingsAccountTest() {
		fail();
	}
	
	@Test
	@DisplayName("Transfer From Savings Account To Account Test")
	public void transferFromSavingsAccountToAccountTest() {
		fail();
	}
	
	@Test
	@DisplayName("Transfer From Savings Account To Savings Account Test")
	public void transferFromSavingsAccountToSavingsAccountTest() {
		fail();
	}
	
}
