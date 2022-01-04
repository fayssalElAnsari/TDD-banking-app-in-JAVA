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

	public void openAccount() {
		this.accounts.add(new Account());
		
	}

	public void openSavingsAccount(double interestRate) {
		this.savingsAccounts.add(new SavingsAccount(interestRate));
		
	}

	public void accountDeposit(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void savingsAccountDeposit(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void accountWithdraw(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void savingsAccountWithdraw(int i, int j) {
		// TODO Auto-generated method stub
		
	}

}
