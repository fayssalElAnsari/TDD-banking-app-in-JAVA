package main;

import java.util.ArrayList;
import java.util.List;

import account.Account;
import account.SavingsAccount;

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

}
