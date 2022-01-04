package main;

public class Account {

	protected double credit;
	protected double debit;
	
	public Account() {
		this.credit = 0;
		this.debit = 0;
		
	}
	
	public double getCredit() {
		return this.credit;
	}
	
	public double getDebit() {
		return this.debit;
	}
	
	/**
	 * adds credit
	 * @param toCredit the credit to be added 
	 */
	public void credit(double toCredit) throws CreditingNegativeAmmountException{
		if(toCredit <0) {
			throw new CreditingNegativeAmmountException("error");
		} else {
			this.credit += toCredit;
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
			this.debit += toDebit;	
		}

		
	}

	public Double getBalance() {
		return credit - debit;
	}
}
