package main;

import java.util.ArrayList;
import java.util.List;

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

public class Bank {
	
	protected List<Account> accounts;
	protected List<SavingsAccount> savingsAccounts;
	
	public Bank() {
		this.accounts = new ArrayList<Account>();
		this.savingsAccounts = new ArrayList<SavingsAccount>();
	}

	public ArrayList<Account> getAccounts() {
		return (ArrayList<Account>) this.accounts;
	}

	public ArrayList<SavingsAccount> getSavingsAccounts() {
		return (ArrayList<SavingsAccount>) this.savingsAccounts;
	}

	public void openAccount() {
		this.accounts.add(new Account());
		
	}

	public void openSavingsAccount(double interestRate) {
		this.savingsAccounts.add(new SavingsAccount(interestRate));
		
	}

	public void accountDeposit(int i, double j) throws BankAccountException {
		if(i > this.accounts.size()-1) {
			throw new AccountDoesntExistException("error");
		}
		this.accounts.get(i).deposit(j);
		
	}

	public void savingsAccountDeposit(int i, double j) throws BankAccountException {
		if(i > this.savingsAccounts.size()-1) {
			throw new AccountDoesntExistException("error");
		}
		this.savingsAccounts.get(i).deposit(j);
		
	}

	public void accountWithdraw(int i, double j) throws BankAccountException {
		if(i > this.accounts.size()-1) {
			throw new AccountDoesntExistException("error");
		}
		this.accounts.get(i).withdraw(j);
		
	}

	public void savingsAccountWithdraw(int i, double j) throws BankAccountException {
		if(i > this.savingsAccounts.size() - 1) {
			throw new AccountDoesntExistException("error");
		}
		this.savingsAccounts.get(i).withdraw(j);
	}

	public void transfertAA(int fromAcc, int toAcc, double toSend) throws BankAccountException {
		try {
			this.accounts.get(fromAcc).withdraw(toSend);
			this.accounts.get(toAcc).deposit(toSend);
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				throw new AccountDoesntExistException("error");
			}
		}
		
		
	}

	public void transfertSA(int fromSAcc, int toAcc, double toSend) throws BankAccountException {
		try {
			this.savingsAccounts.get(fromSAcc).withdraw(toSend);
			this.accounts.get(toAcc).deposit(toSend);
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				throw new AccountDoesntExistException("error");
			}
		}
		
		
	}

}
