package main;

public class SavingsAccount extends Account {
	
	
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

}
