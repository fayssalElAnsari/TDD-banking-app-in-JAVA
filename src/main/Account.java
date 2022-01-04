package main;

public class Account {
	
	int maxHistorySize = 100;

	protected double[] credit;
	protected double[] debit;
	
	public Account() {
		this.credit = new double[maxHistorySize];
		this.debit = new double[maxHistorySize];
		for(int i = 0; i < maxHistorySize; i++) {
			credit[i] = 0;
		}
		
	}
	
	public double getCredit() {
		double totalCredit = 0;
		for(int i = 0; i < maxHistorySize; i++) {
			totalCredit += credit[i];
		}
		return totalCredit;
	}
	
	public double getDebit() {
		double totalDebit = 0;
		for(int i = 0; i < maxHistorySize; i++) {
			totalDebit += debit[i];
		}
		return totalDebit;
	}
	
	/**
	 * adds credit
	 * @param toCredit the credit to be added 
	 * @throws CreditingZeroException 
	 */
	public void credit(double toCredit) throws CreditingNegativeAmmountException, CreditingZeroException{
		
		if(toCredit == 0) {
			throw new CreditingZeroException("error");
		}
		if(toCredit <0) {
			throw new CreditingNegativeAmmountException("error");
		} else {
			int firstEmpty = 0;
			while((this.credit[firstEmpty] != 0)) {
				firstEmpty++;
				if(firstEmpty == maxHistorySize) {
					break;
				}
			}
			if(firstEmpty == maxHistorySize) {
				this.credit[0] = this.getCredit();
				for(int i = 1; i < maxHistorySize; i++) {
					this.credit[i] = 0;
				}
				firstEmpty = 1;
			}
			this.credit[firstEmpty] = toCredit;
		}
	}

	/**
	 * add debit
	 * @param toDebit the debit to be added
	 * @throws DebitingZeroException 
	 */
	public void debit(double toDebit) throws DebitingNegativeAmmountException, DebitingZeroException{
		if(toDebit == 0) {
			throw new DebitingZeroException("error");
		}
		if(toDebit < 0) {
			throw new DebitingNegativeAmmountException("error");
		} else {
			int firstEmpty = 0;
			while(this.debit[firstEmpty] != 0) {
				firstEmpty++;
				if(firstEmpty == maxHistorySize) {
					break;
				}
			}
			if(firstEmpty == maxHistorySize) {
				this.debit[0] = this.getDebit();
				for(int i = 1; i < maxHistorySize; i++) {
					this.debit[i] = 0;
				}
				firstEmpty = 1;
			}
			this.debit[firstEmpty] = toDebit;	
		}

		
	}

	public Double getBalance() {
		return getCredit() - getDebit();
	}
	
	public int getMaxHistorySize() {
		return this.maxHistorySize;
	}
}
