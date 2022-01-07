package main;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import account.Account;
import account.SavingsAccount;
import exception.AccountDoesntExistException;
import exception.BankAccountException;
import exception.DepositPassedLimitException;
import exception.DepositingNegativeAmountException;
import exception.DepositingZeroException;
import exception.SavingsAccountNegativeBalanceException;
import exception.WithdrawPassedLimitException;
import exception.WithdrawingNegativeAmountException;
import exception.WithdrawingZeroException;

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
	public void depositIntoAccountTest() throws BankAccountException {
		double toDeposit = 10000;
		this.bank.openAccount();
		this.bank.accountDeposit(0, toDeposit);
		assertTrue(this.bank.accounts.get(0).getDeposit() == toDeposit);
	}
	
	@Test
	@DisplayName("Deposit Into Savings Account Test")
	public void depositIntoSavingsAccountTest() throws BankAccountException {
		double toDeposit = 10000;
		this.bank.openSavingsAccount(this.interestRate);
		this.bank.savingsAccountDeposit(0, 10000);
		assertTrue(this.bank.savingsAccounts.get(0).getDeposit() == toDeposit);
	}
	
	@Test
	@DisplayName("Withdraw From Account Test")
	public void withdrawFromAccountTest() throws BankAccountException {
		double toWithdraw = 10000;
		this.bank.openAccount();
		this.bank.accountWithdraw(0, toWithdraw);
		assertTrue(this.bank.accounts.get(0).getWithdraw() == toWithdraw);
	}
	
	@Test
	@DisplayName("Withdraw From Savings Account Test")
	public void withdrawFromSavingsAccountTest() throws BankAccountException {
		double toWithdraw = 10000;
		this.bank.openSavingsAccount(this.interestRate);
		this.bank.savingsAccountDeposit(0, 20000);
		this.bank.savingsAccountWithdraw(0, toWithdraw);
		assertTrue(this.bank.savingsAccounts.get(0).getWithdraw() == toWithdraw);
	}
	
	@Test
	@DisplayName("Account Doesn't Exist Test")
	public void accountDoesntExistTest() throws BankAccountException {
		Exception thrownException = assertThrows( 	
					AccountDoesntExistException.class,
					() -> {
						this.bank.accountDeposit(0, 10000);
					}
				);
	}
	
	@Test
	@DisplayName("Savings Account Doesn't Exit Test")
	public void savingsAccountDoesntExistTest() {
		Exception thrownException = assertThrows( 
				AccountDoesntExistException.class,
				() -> {
					this.bank.savingsAccountDeposit(0, 10000);
				}
			);
	}
	
	@Test
	@DisplayName("Transfer From Account To Account Test")
	public void transferFromAccountToAccountTest() throws BankAccountException {
		double toSend = 10000;
		double sendingAccountDeposit = toSend*2;
		this.bank.openAccount();
		this.bank.openAccount();
		this.bank.accountDeposit(0, sendingAccountDeposit);
		this.bank.transfertAA(0, 1, toSend);
		assertTrue(this.bank.getAccounts().get(0).getDeposit() == sendingAccountDeposit-toSend);
		assertTrue(this.bank.getAccounts().get(1).getDeposit() == toSend);
	}
	
	@Test
	@DisplayName("Transfer From Savings Account To Account Test")
	public void transferFromSavingsAccountToAccountTest() throws BankAccountException {
		double toSend = 10000;
		double sendingAccountDeposit = toSend*2;
		this.bank.openSavingsAccount(sendingAccountDeposit);
		this.bank.openAccount();
		this.bank.accountDeposit(0, sendingAccountDeposit);
		this.bank.transfertSA(0, 1, toSend);
		assertTrue(this.bank.getSavingsAccounts().get(0).getDeposit() == sendingAccountDeposit-toSend);
		assertTrue(this.bank.getAccounts().get(0).getDeposit() == toSend);
	}
	
	@Test
	@DisplayName("Transfert One Of Accounts Doesn't Exist Test")
	public void transfertOneOfAccountsDoesntExitTest() throws BankAccountException {
		double toSend = 10000;
		double sendingAccountDeposit = toSend*2;
		this.bank.openAccount();
		this.bank.accountDeposit(0, sendingAccountDeposit);
		
		Exception thrownException = assertThrows( 
				AccountDoesntExistException.class,
				() -> {
					this.bank.transfertAA(0, 1, toSend);
				}
			);
	}
	
//	@Test
//	@DisplayName("Transfer From Account To Savings Account Test")
//	public void transferFromAccountToSavingsAccountTest() {
//		fail();
//	}
	
	
//	@Test
//	@DisplayName("Transfer From Savings Account To Savings Account Test")
//	public void transferFromSavingsAccountToSavingsAccountTest() {
//		fail();
//	}
	
}
