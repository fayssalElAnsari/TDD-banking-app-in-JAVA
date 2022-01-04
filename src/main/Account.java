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
	 */
	public void credit(double toCredit) throws CreditingNegativeAmmountException{
		if(toCredit <0) {
			throw new CreditingNegativeAmmountException("error");
		} else {
			int firstEmpty = 0;
			while((this.credit[firstEmpty] != 0)) {
				firstEmpty++;
			}
			this.credit[firstEmpty] = toCredit;
		}
	}

	/**
	 * add debit
	 * @param toDebit the debit to be added
	 */
	public void debit(double toDebit) throws DebitingNegativeAmmountException{
		if(toDebit < 0) {
			throw new DebitingNegativeAmmountException("error");
		} else {
			int firstEmpty = 0;
			while(this.debit[firstEmpty] != 0) {
				firstEmpty++;
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
