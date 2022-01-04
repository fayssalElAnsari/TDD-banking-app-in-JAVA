package main;

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
	 * @throws SavingsAccountBelowZeroBalanceException 
	 */
	@Override
	public void withdraw(double toWithdraw) throws WithdrawingNegativeAmountException, WithdrawingZeroException, WithdrawPassedLimitException, SavingsAccountBelowZeroBalanceException{
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
			throw new SavingsAccountBelowZeroBalanceException("error");
		}

	}
	
	public double getInterestRate() {
		return this.interestRate;
	}

	public void interestDeposit() throws DepositingNegativeAmountException, DepositingZeroException, DepositPassedLimitException {
		this.deposit(this.getBalance() * this.getInterestRate());
	}

}
