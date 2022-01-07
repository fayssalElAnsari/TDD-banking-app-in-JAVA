package account;

import exception.BankAccountException;
import exception.DepositPassedLimitException;
import exception.DepositingNegativeAmountException;
import exception.DepositingZeroException;
import exception.SavingsAccountNegativeBalanceException;
import exception.WithdrawPassedLimitException;
import exception.WithdrawingNegativeAmountException;
import exception.WithdrawingZeroException;

public class SavingsAccount extends Account {
	
	protected double interestRate = 0.0;
	
	public SavingsAccount(double interestRate) {
		super();
		this.interestRate = interestRate;
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
	@Override
	public void withdraw(double toWithdraw) throws BankAccountException {
		if(toWithdraw > this.getDepositLimit()) {
			throw new WithdrawPassedLimitException("error");
		}
		if(toWithdraw == 0) {
			throw new WithdrawingZeroException("error");
		}
		if(toWithdraw < 0) {
			throw new WithdrawingNegativeAmountException("error");
		} 
		if(this.getBalance() - toWithdraw >= 0){
			this.withdraws.add(toWithdraw);	
		} else {
			throw new SavingsAccountNegativeBalanceException("error");
		}

	}
	
	public double getInterestRate() {
		return this.interestRate;
	}

	public void interestDeposit() throws BankAccountException {
		this.deposit(this.getBalance() * this.getInterestRate());
	}

}
