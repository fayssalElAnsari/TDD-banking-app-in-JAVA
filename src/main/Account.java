package main;

public class Account {
	
	int maxHistorySize = 100;

	protected double[] deposit;
	protected double[] withdraw;
	
	public Account() {
		this.deposit = new double[maxHistorySize];
		this.withdraw = new double[maxHistorySize];
		for(int i = 0; i < maxHistorySize; i++) {
			deposit[i] = 0;
		}
		
	}
	
	public double getDeposit() {
		double totalDeposit = 0;
		for(int i = 0; i < maxHistorySize; i++) {
			totalDeposit += deposit[i];
		}
		return totalDeposit;
	}
	
	public double getWithdraw() {
		double totalWithdraw = 0;
		for(int i = 0; i < maxHistorySize; i++) {
			totalWithdraw += withdraw[i];
		}
		return totalWithdraw;
	}
	
	/**
	 * adds deposit
	 * @param toDeposit the deposit to be added 
	 * @throws DepositingZeroException 
	 */
	public void deposit(double toDeposit) throws DepositingNegativeAmmountException, DepositingZeroException{
		
		if(toDeposit == 0) {
			throw new DepositingZeroException("error");
		}
		if(toDeposit <0) {
			throw new DepositingNegativeAmmountException("error");
		} else {
			int firstEmpty = 0;
			while((this.deposit[firstEmpty] != 0)) {
				firstEmpty++;
				if(firstEmpty == maxHistorySize) {
					break;
				}
			}
			if(firstEmpty == maxHistorySize) {
				this.deposit[0] = this.getDeposit();
				for(int i = 1; i < maxHistorySize; i++) {
					this.deposit[i] = 0;
				}
				firstEmpty = 1;
			}
			this.deposit[firstEmpty] = toDeposit;
		}
	}

	/**
	 * add withdraw
	 * @param toWithdraw the withdraw to be added
	 * @throws WithdrawingZeroException 
	 * @throws DepositingNegativeAmmountException 
	 * @throws WithdrawingNegativeAmmountException 
	 */
	public void withdraw(double toWithdraw) throws WithdrawingNegativeAmmountException, WithdrawingZeroException{
		if(toWithdraw == 0) {
			throw new WithdrawingZeroException("error");
		}
		if(toWithdraw < 0) {
			throw new WithdrawingNegativeAmmountException("error");
		} else {
			int firstEmpty = 0;
			while(this.withdraw[firstEmpty] != 0) {
				firstEmpty++;
				if(firstEmpty == maxHistorySize) {
					break;
				}
			}
			if(firstEmpty == maxHistorySize) {
				this.withdraw[0] = this.getWithdraw();
				for(int i = 1; i < maxHistorySize; i++) {
					this.withdraw[i] = 0;
				}
				firstEmpty = 1;
			}
			this.withdraw[firstEmpty] = toWithdraw;	
		}

		
	}

	public Double getBalance() {
		return getDeposit() - getWithdraw();
	}
	
	public int getMaxHistorySize() {
		return this.maxHistorySize;
	}
}
