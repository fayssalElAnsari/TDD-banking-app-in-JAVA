package main;

public class Account {

	protected float credit;
	protected float debit;
	
	public Account() {
		this.credit = 0;
		this.debit = 0;
		
	}
	
	public float getCredit() {
		return this.credit;
	}
	
	public float getDebit() {
		return this.debit;
	}
	
	/**
	 * adds credit
	 * @param toCredit the credit to be added 
	 */
	public void credit(float toCredit) {
		this.credit += toCredit;
	}

	/**
	 * add debit
	 * @param toDebit the debit to be added
	 */
	public void debit(float toDebit) {
		this.debit += toDebit;
		
	}
}
