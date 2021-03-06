package account;

import java.util.ArrayList;
import java.util.List;

import exception.BankAccountException;
import exception.DepositPassedLimitException;
import exception.DepositingNegativeAmountException;
import exception.DepositingZeroException;
import exception.SavingsAccountNegativeBalanceException;
import exception.WithdrawPassedLimitException;
import exception.WithdrawingNegativeAmountException;
import exception.WithdrawingZeroException;

public class Account {
	
	private static final double depositLimit = 100000;
	private static final double withdrawLimit = 100000;

	protected List<Double> deposits;
	protected List<Double> withdraws;
	
	public Account() {
		this.deposits = new ArrayList<Double>();
		this.withdraws = new ArrayList<Double>();
	}
	
	public double getDeposit() {
		double totalDeposit = 0;
		if(this.deposits.size() > 0) {
			for(double deposit: this.deposits) {
				totalDeposit += deposit;
			}	
		}
		return totalDeposit;
	}
	
	public double getWithdraw() {
		double totalWithdraw = 0;
		if(this.withdraws.size() > 0) {
			for(double withdraw: this.withdraws) {
				totalWithdraw += withdraw;
			}
		}
		return totalWithdraw;
	}
	
	/**
	 * adds deposit
	 * @param toDeposit the deposit to be added 
	 * @throws DepositingZeroException 
	 * @throws DepositPassedLimitException 
	 */
	public void deposit(double toDeposit) throws BankAccountException {
		if(toDeposit > this.getDepositLimit()) {
			throw new DepositPassedLimitException("error");
		}
		if(toDeposit == 0) {
			throw new DepositingZeroException("error");
		}
		if(toDeposit <0) {
			throw new DepositingNegativeAmountException("error");
		} else {
			this.deposits.add(toDeposit);
		}
	}

	/**
	 * add withdraw
	 * @param toWithdraw the withdraw to be added
	 * @throws WithdrawingZeroException 
	 * @throws DepositingNegativeAmountException 
	 * @throws WithdrawingNegativeAmountException 
	 * @throws WithdrawPassedLimitException 
	 * @throws SavingsAccountNegativeBalanceException 
	 */
	public void withdraw(double toWithdraw) throws BankAccountException {
		if(toWithdraw > this.getDepositLimit()) {
			throw new WithdrawPassedLimitException("error");
		}
		if(toWithdraw == 0) {
			throw new WithdrawingZeroException("error");
		}
		if(toWithdraw < 0) {
			throw new WithdrawingNegativeAmountException("error");
		} else {
			this.withdraws.add(toWithdraw);	
		}

		
	}

	public Double getBalance() {
		return getDeposit() - getWithdraw();
	}

	public double getDepositLimit() {
		return Account.depositLimit;
	}
	
	public double getWithdrawLimit() {
		return Account.withdrawLimit;
	}
	
}
